package testing;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountListTest {
    @Test
    public void testLoginUser() {
    User account  = AccountList.getInstance().loginUser("cardcollector512", "SunriseMoondrop")
	assertNotNull(account);
	}
    @Test
    public void testLoginAdmin() {
        Admin account  = AccountList.getInstance().loginAdmin("Mark9002314", "incrediblepassword54321")
        assertNotNull(account);
        }
    @Test
    public void testGettingUserbyId() {
    User user = AccountList.getInstance().getUserById(UUID.fromString("c9b00037-1066-4063-ad70-9a1d67d13906"));
    assertNotNull(user, "user id for Mark");
    }
    @Test
    public void testGettingAdminbyId() {
        Admin admin = AccountList.getInstance().getAdminById(UUID.fromString("c7aed6b1-a4e9-4d46-a63f-f301ba5fba62"));
        assertNotNull(admin, "admin id for Mark");
        }
    @Test
    public void testGettingUserCards() {
    ArrayList<User> user = AccountList.getInstance().getUser("mark");
    assertEquals(user.size(), 3);

    }
    
}

