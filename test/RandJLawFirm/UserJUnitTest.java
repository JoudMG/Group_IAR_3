package RandJLawFirm;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserJUnitTest {

    public UserJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testIsStrongPassword() {
        System.out.println("isStrongPassword");
        String password = "SecretPass11";
        boolean expResult = true;
        boolean result = User.isStrongPassword(password);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsValidEmail() {
        System.out.println("isValidEmail");
        String email = "Test@Gmail.com";
        boolean expResult = true;
        boolean result = User.isValidEmail(email);
        assertEquals(expResult, result);
    }

}
