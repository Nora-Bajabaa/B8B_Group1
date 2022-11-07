
package Classes;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CustomerTest {

    public CustomerTest() {
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
     * Test of cancelReservation method, of class Customer.
     */
    @Test
    public void testCancelReservation() {
        System.out.println("cancelReservation");
        int reservationId = 1;

        Customer instance = new Customer("wafaa", 1, "0512345678", "email@gmail.com", "123456");
        instance.getReservations().add(new Reservation(1, null, 1, 1, 1, null, "Active"));
                
        boolean expResult = true;
        boolean result = instance.cancelReservation(reservationId);
        assertEquals(expResult, result);

    }

    /**
     * Test of makeReservation method, of class Customer.
     */
    @Test
    public void testMakeReservation() {
        System.out.println("makeReservation");
        
        Customer instance = new Customer("wafaa", 1, "0512345678", "email@gmail.com", "123456");
        
        int expResult = 1;
        
        Reservation result = instance.makeReservation(1, 1, 1, "11/11/2022", null);
        
        assertEquals(expResult, result.getId());
        
    }

}