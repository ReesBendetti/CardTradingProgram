import java.util.UUID;

public class Account {
    private String username;
    private String password;
    private String email;
    private UUID id;

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
