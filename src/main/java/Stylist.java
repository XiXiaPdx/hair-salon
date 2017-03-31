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
  public int getStylistId(){
    return id;
  }
  public List<Client> getYourClients(){
    try (Connection con = DB.sql2o.open()){
      String sql = "SELECT * FROM clients WHERE client_stylist_id=:id;";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Client.class);
    }
  }
  public void save(){
    try(Connection con = DB.sql2o.open()) {
    String sql = "INSERT INTO stylists (s_name) VALUES (:s_name);";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("s_name", this.s_name)
      .executeUpdate()
      .getKey();
    }
  }
  public static List<Stylist>  all(){
    try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM stylists;";
    return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }
  @Override
  public boolean equals (Object otherStylist){
    if(!(otherStylist instanceof Stylist)){
      return false;
    } else {
      Stylist newStylist = (Stylist) otherStylist;
      return this.getStylistName().equals(newStylist.getStylistName()) && this.getStylistId() == newStylist.getStylistId();
    }
  }
}
