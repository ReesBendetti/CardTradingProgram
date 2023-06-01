import java.util.UUID;

public class Account {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private boolean isAnAdmin;

    public Account(UUID id, String username, String password, String email, boolean isAnAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isAnAdmin = isAnAdmin;
    }

    public Account(String username, String password, String email, boolean isAnAdmin) {
        id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.email = email;
        this.isAnAdmin = isAnAdmin;
    }

    public UUID getId(){
        return id;
    }

    public String getUserName(){
        return username;
    }

    public String getEmail(){
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String toString() {
        return username;
    }

    public boolean isAdmin(){
        return isAnAdmin;
    }
}
