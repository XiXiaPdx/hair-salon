import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

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
      // @Test
      // public void getAllStylists_true(){
      //   Stylist newStylist1 = new Stylist("Mary");
      //   Stylist newStylist2 = new Stylist("Bob");
      //   newStylist1.save();
      //   newStylist2.save();
      //   assertTrue(newStylist2.equals(Stylist.all().get(1)));
      // }
      // @Test
      // public void getStylsitId_true(){
      //   Stylist newStylist1 = new Stylist("Mary");
      //   newStylist1.save();
      //   assertTrue(newStylist1.getStylistId()>0);
      // }
      // @Test
      // public void findStylist_true(){
      //   Stylist newStylist1 = new Stylist("Mary");
      //   newStylist1.save();
      //   assertTrue(newStylist1.equals(Stylist.find(newStylist1.getStylistId())));
      // }
      // @Test
      // public void deleteStylist_null(){
      //   Stylist newStylist1 = new Stylist("Mary");
      //   newStylist1.save();
      //   int id = newStylist1.getStylistId();
      //   newStylist1.delete();
      //   assertEquals(null, Stylist.find(id));
      // }
      // @Test
      // public void updateStylistName_Sara(){
      //   Stylist newStylist1 = new Stylist("Mary");
      //   newStylist1.save();
      //   newStylist1.updateStylistName("Sara");
      //   assertEquals("Sara", Stylist.find(newStylist1.getStylistId()).getStylistName());
      // }



    }
