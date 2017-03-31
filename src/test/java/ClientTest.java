import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();
  @Test
  public void clientCreated_true () {
    Client newClient = new Client("Mary", 1);
    assertTrue(newClient instanceof Client);
  }
  @Test
  public void getClientName_mary () {
    Client newClient = new Client("Mary", 1);
    assertEquals("Mary", newClient.getClientName());
  }
  @Test
  public void getStylistId_1 () {
    Client newClient = new Client("Mary", 1);
    assertEquals(1, newClient.getStylistId());
  }


}
