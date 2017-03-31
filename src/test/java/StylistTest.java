import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;

public class StylistTest {

  @Rule
    public DatabaseRule database = new DatabaseRule();
      @Test
      public void stylistCreated_true () {
        Stylist newStylist = new Stylist("Mary");
        assertTrue(newStylist instanceof Stylist);
      }
      @Test
      public void getStylistName_mary () {
        Stylist newStylist = new Stylist("Mary");
        assertEquals("Mary", newStylist.getStylistName());
      }

      @Test
      public void getClientsofStylist_True(){
        Stylist newStylist = new Stylist("Mary");
        newStylist.save();
        Client newClient1 = new Client("Mary", newStylist.getStylistId());
        Client newClient2 = new Client("Bob", newStylist.getStylistId());
        newClient1.save();
        newClient2.save();
        Client [] clientList = new Client [] {newClient1, newClient2};
        assertTrue(newStylist.getYourClients().containsAll(Arrays.asList(clientList)));
      }
      @Test
      public void getAllStylists_true(){
        Stylist newStylist1 = new Stylist("Mary");
        Stylist newStylist2 = new Stylist("Bob");
        newStylist1.save();
        newStylist2.save();
        assertTrue(newStylist2.equals(Stylist.all().get(1)));
      }
      @Test
      public void getStylsitId_true(){
        Stylist newStylist1 = new Stylist("Mary");
        newStylist1.save();
        assertTrue(newStylist1.getStylistId()>0);
      }
      @Test
      public void findStylist_true(){
        Stylist newStylist1 = new Stylist("Mary");
        newStylist1.save();
        assertTrue(newStylist1.equals(Stylist.find(newStylist1.getStylistId())));
      }
      @Test
      public void deleteStylist_null(){
        Stylist newStylist = new Stylist("Mary");
        newStylist.save();
        Client newClient1 = new Client("Mary", newStylist.getStylistId());
        Client newClient2 = new Client("Bob", newStylist.getStylistId());
        newClient1.save();
        int clientId = newClient1.getClientId();
        newClient2.save();
        int id = newStylist.getStylistId();
        newStylist.delete();
        assertEquals(null, Stylist.find(id));
        assertEquals(-1, Client.find(clientId).getClientStylistId());
      }
      @Test
      public void updateStylistName_Sara(){
        Stylist newStylist1 = new Stylist("Mary");
        newStylist1.save();
        newStylist1.updateStylistName("Sara");
        assertEquals("Sara", Stylist.find(newStylist1.getStylistId()).getStylistName());
      }



    }
