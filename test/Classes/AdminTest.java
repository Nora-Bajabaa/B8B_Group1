
package Classes;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdminTest {

    public AdminTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addResturant method, of class Admin.
     */
    @Test
    public void testAddResturant() {
        System.out.println("addResturant");
        int id = 1;
        String name = "food";
        String type = "food";
        String location = "food";
        String phone = "123456789";
        Admin instance = new Admin();

        Resturant expResult = new Resturant(id, name, type, location, phone);
        Resturant result = instance.addResturant(id, name, type, location, phone);
        
        assertEquals(expResult.getId(), result.getId());
    }

    /**
     * Test of deleteResturant method, of class Admin.
     */
    @Test
    public void testDeleteResturant() {
        System.out.println("deleteResturant");

        int id = 1;
        String name = "food";
        String type = "food";
        String location = "food";
        String phone = "123456789";

        ArrayList<Resturant> resturants = new ArrayList<>();
        resturants.add(new Resturant(id, name, type, location, phone));

        Admin instance = new Admin();
        boolean expResult = true;
        int resturantId = 1;
        
        boolean result = instance.deleteResturant(resturantId, resturants);
        assertEquals(expResult, result);
  
}
   }
