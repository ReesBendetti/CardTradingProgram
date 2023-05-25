

import java.util.ArrayList;

import json.User;

public class AccountList {
    private ArrayList<User> users;
    private static AccountList accountList;

    private AccountList() {
        
    }

    public static AccountList getInstance() {
        if (accountList == null) {
            accountList = new AccountList();
        }
        return accountList;
    }

    public boolean addUser(String username, String password, String email) {
        
    }

    public boolean removeUser (String username) {

    }

    public User getUser(String username) {

    }

    public boolean editUser(User user, String username, String password, String email) {

    }
}
