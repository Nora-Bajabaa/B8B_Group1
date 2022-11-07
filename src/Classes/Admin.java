
package Classes;
import java.util.ArrayList;

public class Admin extends User{
    
    private String role;

    public Admin() {
    }

    public Admin(int id, String phoneNumber, String email, String password, String role) {
        super(id, phoneNumber, email, password);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Resturant addResturant(int id, String name, String type, String location, String phone) {
        return new Resturant(id, name, type, location, phone);
    }
    
}
