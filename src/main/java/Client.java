import org.sql2o.*;
import java.util.List;

public class Client {
  private String c_name;
  private int client_stylist_id;
  private int id;

  public Client(String name, int yourStylistId) {
    this.c_name = name;
    client_stylist_id = yourStylistId;
  }
  public String getClientName(){
    return c_name;
  }
  public int getClientStylistId(){
    return client_stylist_id;
  }
  public int getClientId(){
    return id;
  }
  public void save(){
    try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO clients (c_name, client_stylist_id) VALUES (:c_name, :client_stylist_id);";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("c_name", this.c_name)
      .addParameter("client_stylist_id", this.client_stylist_id)
      .executeUpdate()
      .getKey();
  }
}
public static List<Client> all (){
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients;";
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals (Object otherClient){
    if(!(otherClient instanceof Client)){
      return false;
    } else{
      Client newClient = (Client) otherClient;
      return this.getClientName().equals(newClient.getClientName()) && this.getClientId() == newClient.getClientId();
    }
  }



}
