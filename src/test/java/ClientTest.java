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
    assertEquals(1, newClient.getClientStylistId());
  }
  @Test
  public void getAllClients_true(){
    Client newClient1 = new Client("Mary", 1);
    Client newClient2 = new Client("Bob", 2);
    newClient1.save();
    newClient2.save();
    assertTrue(newClient2.equals(Client.all().get(1)));
  }
  @Test
  public void getCardId_true(){
    Client newClient1 = new Client("Mary", 1);
    newClient1.save();
    assertTrue(newClient1.getClientId()>0);
  }
  @Test
  public void findCard_true(){
    Client newClient1 = new Client("Mary", 1);
    newClient1.save();
    assertTrue(newClient1.equals(Client.find(newClient1.getClientId())));
  }
  @Test
  public void deleteClient_null(){
    Client newClient1 = new Client("Mary", 1);
    newClient1.save();
    int id = newClient1.getClientId();
    newClient1.delete();
    assertEquals(null, Client.find(id));
  }



}
