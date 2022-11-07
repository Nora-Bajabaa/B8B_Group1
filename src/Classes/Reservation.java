
package Classes;

import java.util.Date;
public class Reservation {
    
    private int id;
    private Date date;
    private int hours;
    private int numOfPeople;
    private int TableNumber;
    private Resturant resturant;
    private String status;

    public Reservation(int id, Date date, int hours, int numOfPeople, int TableNumber, Resturant resturant, String status) {
        this.id = id;
        this.date = date;
        this.hours = hours;
        this.numOfPeople = numOfPeople;
        this.TableNumber = TableNumber;
        this.resturant = resturant;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public int getTableNumber() {
        return TableNumber;
    }

    public void setTableNumber(int TableNumber) {
        this.TableNumber = TableNumber;
    }

    public Resturant getResturant() {
        return resturant;
    }

    public void setResturant(Resturant resturant) {
        this.resturant = resturant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}


