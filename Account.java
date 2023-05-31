import java.util.UUID;

public class Account {
    private UUID id;
    private String username;
    private String password;
    private String email;

    public Account(UUID id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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
}
