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
  public static Stylist find (int id){
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id=:id;";
      Stylist newStylist = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
        return newStylist;
    }
  }
  public void  delete(){
    try (Connection con = DB.sql2o.open()) {
      String unassignClients = "UPDATE clients SET client_stylist_id=:client_stylist_id WHERE client_stylist_id=:id;";
      con.createQuery(unassignClients)
       .addParameter("id", this.id)
       .addParameter("client_stylist_id", -1)
       .executeUpdate();
      String sql = "DELETE FROM stylists WHERE id=:id;";
       con.createQuery(sql)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }
  public void  deleteAllCients(){
    try (Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE client_stylist_id=:id;";
       con.createQuery(sql)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }
  public void  updateStylistName(String newName){
    try (Connection con = DB.sql2o.open()) {
      String sql = "UPDATE stylists SET s_name=:s_name WHERE id=:id;";
       con.createQuery(sql)
        .addParameter("id", this.id)
        .addParameter("s_name", newName)
        .executeUpdate();
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
