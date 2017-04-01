import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/login.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/login", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String userName = request.queryParams("userName");
      request.session().attribute("userName", userName);
      if (userName.equals("Perry")){
        String url = String.format("/stylists");
        response.redirect(url);
        // model.put("template", "templates/index.vtl");
        // model.put("stylists", Stylist.all());
        // model.put("clients", Client.all());
      } else {
        model.put("template", "templates/login.vtl");
      }
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/logout", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      request.session().removeAttribute("userName");
      model.put("template", "templates/login.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get ("/stylists/:stylistId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist thisStylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
      model.put("clients", thisStylist.getYourClients());
      model.put("stylist", thisStylist );
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:stylistId/clients/:clientId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Client thisClient = Client.find(Integer.parseInt(request.params(":clientId")));
      model.put("stylists", Stylist.all());
      model.put("client", thisClient);
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("clients", Client.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Client.all());
      model.put("template", "templates/clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String newStylistName = request.queryParams("stylistName");
      Stylist newStylist = new Stylist(newStylistName);
      newStylist.save();
      String url = String.format("/stylists");
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String newName = request.queryParams("stylistNameChange");
      Stylist thisStylist =Stylist.find(Integer.parseInt(request.params(":stylistId")));
      thisStylist.updateStylistName(newName);
      String url = String.format("/stylists/"+thisStylist.getStylistId());
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistId/clients/add", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String newClientName = request.queryParams("addClient");
      Stylist thisStylist =Stylist.find(Integer.parseInt(request.params(":stylistId")));
      Client newClient = new Client (newClientName, thisStylist.getStylistId());
      newClient.save();
      String url = String.format("/stylists/"+thisStylist.getStylistId());
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistId/clients/:clientId", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String newName = request.queryParams("clientNameChange");
      Client thisClient = Client.find(Integer.parseInt(request.params(":clientId")));
      thisClient.updateClientName(newName);
      Stylist thisStylist =Stylist.find(Integer.parseInt(request.params(":stylistId")));
      thisClient.updateClientName(newName);
      String url = String.format("/stylists/"+thisStylist.getStylistId()+"/clients/"+thisClient.getClientId());
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/stylists/:stylistId/clients/:clientId/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist thisStylist =Stylist.find(Integer.parseInt(request.params(":stylistId")));
      Client thisClient = Client.find(Integer.parseInt(request.params(":clientId")));
      thisClient.delete();
      String url = String.format("/stylists/"+thisStylist.getStylistId());
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/clients/:clientId/assign", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int newClientStylistId = Integer.parseInt(request.queryParams("assignStylist"));
      Client thisClient = Client.find(Integer.parseInt(request.params(":clientId")));
      thisClient.updateClientStylistId(newClientStylistId);
      String url = String.format("/stylists/"+newClientStylistId);
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:stylistId/delete", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist thisStylist =Stylist.find(Integer.parseInt(request.params(":stylistId")));
      thisStylist.delete();
      String url = String.format("/stylists");
      response.redirect(url);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());




  }
  }
