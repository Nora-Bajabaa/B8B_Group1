package mytablesystem;

import Classes.Customer;
import Classes.Admin;
import Classes.Reservation;
import Classes.Resturant;
import FileHelper.FileHelper;
import java.io.FileNotFoundException;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;


public class MyTableSystem {
public static Customer customer;
    static Admin admin;
    public static ArrayList<Resturant> resturants;
    public static ArrayList<Reservation> reservations;

static Scanner in;
    public static void main(String[] args) {
        // TODO code application logic here
      initSystem();
                while (true) {
            displayMainMenu();
            int mainChoice = in.nextInt();

            if (mainChoice == 3) {
                System.out.println("Thank you :)");
                System.exit(0);
            }

            if (mainChoice == 1) {
                adminProcess();
                return;
            }

            if (mainChoice == 2) {
                customerProcess();
                return;
            }

            System.out.println("Wrong Choice Try again !!!");
            System.out.println("\n");
        }
                
    }
    private static void adminProcess() {
        admin = new Admin();

        while (true) {
            displayAdminMenu();
            System.out.print("choose what do you want to do as Admin: ");
            int adminChoice = in.nextInt();

            if (adminChoice < 1 && adminChoice > 3) {
                System.out.println("Wrong choice try again!!");
                System.out.println("\n");
                continue;
            }

            if (adminChoice == 3) {
                System.out.println("Logged out! See you soon :)");
                System.exit(0);
            }

            if (adminChoice == 1) {
                addResturant();
                System.out.println("\n");
            }

            if (adminChoice == 2) {
                deleteResturant();
            }

        }
    }

    
     private static void initSystem() {
        // init variables
        in = new Scanner(System.in);

        reservations = new ArrayList<>();

        try {
            // load resturants file
            resturants = FileHelper.loadResturants();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyTableSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  static void displayMainMenu() {
        System.out.println("-------------------MY TABLE---------------");
        System.out.println("1- Admin");
        System.out.println("2- Customer");
        System.out.println("3- exit");  
        System.out.println("------------------------------------------");
        System.out.print("Kindly choose from the menu: ");
    }
    static void displayAdminMenu() {
        System.out.println("\n------------------MY TABLE----------------");
        System.out.println("1- Add Resturant");
        System.out.println("2- Delete Resturant");
        System.out.println("3- Exit");
    }
     static void displayCustomerMenu() {
        System.out.println("\n------------------MY TABLE----------------");
        System.out.println("1- Register");
        System.out.println("2- View Resturant");
        System.out.println("3- Make Reservations");
        System.out.println("4- Cancel Reservation");
        System.out.println("5- Exit");
    }
     private static void registerCustomer() {
        if (customer != null) {
            System.out.println("You already registerd :)");
            System.out.println("");
            return;
        }
        System.out.println("Enter your Information:");
        System.out.print("Name: ");
        String name = in.next();
        System.out.print("Phone Number: ");
        String phoneNumber = in.next();

        System.out.print("Email: ");
        String email = in.next();

        System.out.print("Password: ");
        String password = in.next();

        customer = new Customer(name, 1, phoneNumber, email, password);
        System.out.println("Customer " + name + " registered");
        System.out.println("");
    }
 
     private static void addResturant() {
        System.out.println("Enter Resturat Information Please");

        System.out.print("Name: ");
        String name = in.next();

        System.out.print("Type: ");
        String type = in.next();

        System.out.print("Location: ");
        String location = in.next();

        System.out.print("Phone Number: ");
        String phoneNumber = in.next();

        Resturant r = admin.addResturant(resturants.size() + 1, name, type, location, phoneNumber);
        resturants.add(r);

        System.out.println("New Resturant Added");

    }
      private static void deleteResturant() {
        System.out.print("Please Enter Resturant Id: ");
        int id = in.nextInt();
        admin.deleteResturant(id, resturants);
    }
       private static void customerProcess() {

        while (true) {
            displayCustomerMenu();
            System.out.print("kindly choose from the menu: ");
            int customerChoice = in.nextInt();

            if (customerChoice < 1 && customerChoice > 5) {
                System.out.println("Wrong choice try again!!");
                System.out.println("\n");
                continue;
            }

            if (customerChoice == 5) {
                System.out.println("Logged out! See you soon :)");
                System.exit(0);
            }

            if (customerChoice == 1) {
                registerCustomer();
            }

            if (customerChoice == 2) {
                viewResturant();
            }

            if (customerChoice == 3) {
                makeResrvation();
            }

            if (customerChoice == 4) {
                cancelResrvation();
            }
        }

    }

      private static void viewResturant() {
        if (resturants.isEmpty()) {
            System.out.println("There is no avaiable resturants :(");
            System.out.println("");
            return;
        }
        

        System.out.println("Avaialable Resturants:");

        for (Resturant resturant : resturants) {
            System.out.println(resturant.getId() + ": " + resturant.getName());
            System.out.println("Type: " + resturant.getType());
            System.out.println("Phone Numebr: " + resturant.getPhoneNumber());
            System.out.println("Location: " + resturant.getLocation());
            System.out.println("--------------------------------------------------");
        }

        System.out.println("");

    }

      private static void makeResrvation() {

        if (customer == null) {
            System.out.println("Sorry! you need to register first :(");
            System.out.println("");
            return;
        }

        viewResturant();

        System.out.print("Kindly enter resturant number: ");
        int resId = in.nextInt();

        try {
            Resturant r = resturants.get(resId - 1);

            System.out.print("Enter number Of People: ");
            int numOfPeople = in.nextInt();

            System.out.print("Enter table number: ");
            int tableNumber = in.nextInt();

            System.out.print("Enter number Of hours: ");
            int numOfHours = in.nextInt();

            System.out.print("Enter Date of Reservation(dd/MM/yyyy): ");
            String date = in.next();

            Reservation res = customer.makeReservation(numOfPeople, tableNumber, numOfHours, date, r);

            if (res != null) {
                FileHelper.printReservation(res, customer);
            }

        } catch (Exception e) {
            System.out.println("Wrong coice!! try again later");
            System.out.println("");
        }
        
    }

  private static void cancelResrvation() {
        if (customer == null) {
            System.out.println("Sorry! you need to register first :(");
            System.out.println("");
            return;
        }
        
        customer.printReservaionList();
        
        System.out.print("Please enter reservation id: ");
        int resId = in.nextInt();
        
        customer.cancelReservation(resId);
    }

}

    
    

