/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


/**
 *
 * @author Nora1
 */
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
     private static void initSystem() {
        // init variables
        in = new Scanner(System.in);

        reservations = new ArrayList<>();

        try {
            // load resturants file
            resturants = FileHelper.loadResturants();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
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

  
    }
    

