import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountList {
    private ArrayList<User> users;
    private ArrayList<Admin> admins;
    private static AccountList accountList;

    private AccountList() {
        users = DataLoader.getUsers();
        admins = DataLoader.getAdmin();
    }

    public static AccountList getInstance() {
        AccountList accountList = new AccountList();
        return accountList;
    }

    public boolean addUser(UUID id, String username, String password, String email, int coins, ArrayList<Card> cardCollection) {
        users.add(new User(id, username, password, email, coins, cardCollection));
        return true;
    }

    public boolean addAdmin(UUID id, String username, String password, String email) {
        admins.add(new Admin(id, username, password, email));
        return true;
    }

    public ArrayList<User> getUser(String username) {
        return null;
    }

    public User getUserById(UUID id){
    }

    public Admin getAdminById(UUID id){
        
    }

    public boolean removeUser (String username) {
        return false;
    }

    public ArrayList<User> getAdmin(String username) {
        return null;
    }

    public boolean removeAdmin (String username) {
        return false;
    }

    public boolean editUser(User user, String username, String password, String email) {
        return true;
    }
}
