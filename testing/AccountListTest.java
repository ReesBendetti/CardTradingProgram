package testing;
import static org.junit.Assume.assumeTrue;
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
        //git troubles testing
    User account  = AccountList.getInstance().loginUser("cardcollector512", "SunriseMoondrop");
	assertNotNull(account);
	}
    @Test
    public void testLoginAdmin() {
        Admin account  = AccountList.getInstance().loginAdmin("Mark9002314", "incrediblepassword54321");
        assertNotNull(account);
        }
    @Test
    public void testGettingUserbyId() {
    User user = AccountList.getInstance().getUserById(UUID.fromString("c9b00037-1066-4063-ad70-9a1d67d13906"));
    assertNotNull(user, "user id for Mark");
    }
    @Test
    public void testInvalidgetUserId() {
        User invalidUser = AccountList.getInstance().getUserById(UUID.fromString("10c2dc81-da02-4dfa-a5bb-41a7c960971a"));
            assertNull(invalidUser, "not a real admin");
    }
    @Test
    public void testGettingAdminbyId() {
        Admin admin = AccountList.getInstance().getAdminById(UUID.fromString("c7aed6b1-a4e9-4d46-a63f-f301ba5fba62"));
        assertNotNull(admin, "admin id for Mark");
        }
    @Test
    public void testInvalidgetAdminId() {
        Admin invalidAdmin = AccountList.getInstance().getAdminById(UUID.fromString("37330d7c-741a-4fa1-a92b-283b67a76ca4"));
    assertNull(invalidAdmin, "not a real admin");
}
    @Test
    public void testGettingUserCards() {
    ArrayList<User> user = AccountList.getInstance().getUsers();
    assertEquals(user.size(), 4);
    }
    @Test
    public void testGettingAdmin() {
    ArrayList<Admin> admin = AccountList.getInstance().getAdmin("Mark9002314");
    assertEquals(admin.size(), 3);
    }
    @Test
    public void testEditingUser() {
        boolean user = AccountList.getInstance().editUser("mark", "12345", "afakeemail@realdomain.edu");
        assumeTrue("was edited", user);
    
    }
    
}



