import java.util.ArrayList;
import java.util.UUID;

public class AccountList {
    private ArrayList<User> users;
    private ArrayList<Admin> admins;
    private static AccountList accountList;

    public User loginUser(String username, String password) {
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(username) && user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        
        return null;
    }

    public Admin loginAdmin(String username, String password) {
        for (Admin admin : admins) {
            if (admin.getUserName().equalsIgnoreCase(username) && admin.getPassword().equalsIgnoreCase(password)) {
                return admin;
            }
        }
        
        return null;
    }

    private AccountList() {
        users = DataLoader.getUsers();
        admins = DataLoader.getAdmin();
    }

    public static AccountList getInstance() {
        AccountList accountList = new AccountList();
        return accountList;
    }

    public User addUser(String username, String password, String email) {
        for(int i = 0; i<users.size();i++) {
            if(users.get(i).getUserName().equalsIgnoreCase(username)) {
                return null;
            }
        }
        User user = new User(username, password, email);
        return user;
    }

    public boolean addAdmin(UUID id, String username, String password, String email) {
        admins.add(new Admin(id, username, password, email));
        return true;
    }

    public ArrayList<User> getUser(String username) {
        return users;
    }
    public ArrayList<User> getUsers() {
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

    public void save(){
        DataWriter.saveAccounts();
        DataWriter.saveAdmins();
    }
}
