

package Classes;
import Classes.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Customer extends User {
       private String name;
    private ArrayList<Reservation> reservations;

    public Customer(String name, int id, String phoneNumber, String email, String password) {
        super(id, phoneNumber, email, password);
        this.name = name;
        this.reservations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
     public Reservation makeReservation(int numOfPeople, int tableNumber, int numOfHours, String date, Resturant r) {

        try {
            Reservation res = new Reservation(reservations.size() + 1, new SimpleDateFormat("dd/MM/yyyy").parse(date),
                    numOfHours, numOfPeople, tableNumber, r, "Active");

            reservations.add(res);

            System.out.println("Reservation make, enjoy :)");
            return res;
        } catch (ParseException ex) {
            System.out.println("Invalid date format");
            return null;
        }

    }

    public void printReservaionList() {
        if (reservations.isEmpty()) {
            System.out.println("Sorry, You don't have any reservation");
            System.out.println("");
            return;
        }

        System.out.println("Avaialble Reservations");
        
        for (Reservation reservation : reservations) {
            System.out.println("Reservation Id: " + reservation.getId());
            System.out.println("Resturant Name: " + reservation.getResturant().getName());
            System.out.println("Reservation Date: " + reservation.getDate());
            System.out.println("Reservation Statsu: " + reservation.getStatus());
            System.out.println("-------------------------------------------");

        }
    }

    @Override
    public User login(String email, String password) {
        return null;
    }

}


