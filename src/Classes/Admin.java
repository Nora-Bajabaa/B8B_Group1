
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
    public boolean deleteResturant(int resturantId, ArrayList<Resturant> resturants) {

        for (int i = 0; i < resturants.size(); i++) {

            if (resturants.get(i).getId() == resturantId) {

                System.out.println("Resturant " + resturants.get(i).getName() + " deleted\n\n");
                resturants.remove(i);
                return true;
            }
        }

        System.out.println("Resturant " + resturantId + " Not found");
        return false;
    }

    @Override
    public User login(String email, String password) {
        return new Admin(1, "0569813231", "email@gmail.com", "123456", "admin");
    }

    
}
