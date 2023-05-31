import java.util.ArrayList;
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
        return users;
    }

    public ArrayList<Admin> getAdmin(String username) {
        return admins;
    }

    public User getUserById(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        
        return null;
    }

    public Admin getAdminById(UUID id) {
        for (Admin admin : admins) {
            if (admin.getId().equals(id)) {
                return admin;
            }
        }
        
        return null;
    }

    public void removeUser (String username) {
        
    }

    public void removeAdmin (String username) {
        
    }

    public boolean editUser(User user, String username, String password, String email) {
        return true;
    }
}
