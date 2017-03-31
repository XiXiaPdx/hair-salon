import org.sql2o.*;
import java.util.List;
import java.util.Arrays;

public class Stylist {
  private String s_name;
  private int id;

  public Stylist(String name){
    this.s_name=name;
  }
  public String getStylistName(){
    return s_name;
  }
  public List<Client> getYourClients(){
    try (Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM clients WHERE client_stylist_id=:id;";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Client.class);
    }

  }

}
