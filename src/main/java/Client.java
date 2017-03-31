import org.sql2o.*;

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
  public int getStylistId(){
    return client_stylist_id;
  }

}
