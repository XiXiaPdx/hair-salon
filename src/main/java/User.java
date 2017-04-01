import org.sql2o.*;
import java.util.List;
import java.util.Arrays;

public class User {
  private String name;
  private int id;

  public User(String name){
    this.name = name;
  }
  public String getUserName(){
    return name;
  }

  public boolean authenticate (){
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM users WHERE name=:name;";
      User newUser = con.createQuery(sql)
        .addParameter("name", this.getUserName())
        .executeAndFetchFirst(User.class);
        if (newUser != null) {
          return true;
        } else {
          return false;
        }
    }
  }
}
