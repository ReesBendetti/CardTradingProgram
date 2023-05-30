

import java.util.ArrayList;

public class AccountList {
    private ArrayList<User> users;
    private static AccountList accountList;

    private AccountList() {
        users = new ArrayList<>();
    }

    public static AccountList getInstance() {
        if (accountList == null) {
            accountList = new AccountList();
        }
        return accountList;
    }

    public boolean addUser(String username, String password, String email) {
        return true;
    }

    public boolean removeUser (String username) {
        return false;
    }

    public User getUser(String username) {
        return null;
    }

    public boolean editUser(User user, String username, String password, String email) {
        return true;
    }
}
