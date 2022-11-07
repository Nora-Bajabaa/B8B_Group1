package FileHelper;

import Classes.Customer;
import Classes.Reservation;
import Classes.Resturant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHelper {

    static Scanner read;
    static PrintWriter write;

    public static ArrayList<Resturant> loadResturants() throws FileNotFoundException {
        ArrayList<Resturant> res = new ArrayList<>();

        read = new Scanner(new File("resturants.txt"));

        while (read.hasNext()) {
            String line[] = read.nextLine().split(", ");

            res.add(new Resturant(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4]));
        }

        return res;
    }

    public static void printReservation(Reservation r, Customer c) {
        try {
            String newFileName = r.getId() + "_" + c.getName() + "_" + r.getResturant().getId() + "_" + r.getDate().getTime();
            write = new PrintWriter(newFileName + ".txt");

            write.println("Reservation NO: " + r.getId());

            write.println("------- Resturant Information -------");
            write.println("Resturant Name: " + r.getResturant().getName());
            write.println("Resturant Location: " + r.getResturant().getLocation());
            write.println("Resturant Phone Number: " + r.getResturant().getPhoneNumber());
            write.println("---------------------------------------");

            write.println("------- Reservation Information -------");
            write.println("Reservation Date: " + r.getDate());
            write.println("Number Of People: " + r.getNumOfPeople());
            write.println("Table Number: " + r.getTableNumber());
            write.println("Number Of Reserved Hours: " + r.getHours());
            write.println("---------------------------------------");

            write.println("------- Customer Information -------");
            write.println("Customer Name: " + c.getName());
            write.println("Customer Phone Number:" + c.getPhoneNumber());

            write.flush();
            write.close();
        } catch (FileNotFoundException ex) {

        }
    }

}
