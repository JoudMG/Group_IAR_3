package RandJLawFirm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;

public class EmployeeJUnitTest {

    public EmployeeJUnitTest() {
    }
    
    private ArrayList<Employee> expectedEmployeesArray = new ArrayList<>();

    @Before
    public void setUp() {
        // Create Expected Employees Array
        expectedEmployeesArray.add(new Employee("0001", "Nora", "Ahmad", "0526372862", true));
        expectedEmployeesArray.add(new Employee("0002", "Farah", "Handom", "0567692392", false));
        expectedEmployeesArray.add(new Employee("0003", "Sara", "Mohammed", "0553789983", false));
        expectedEmployeesArray.add(new Employee("0004", "Lama", "Ali", "0555378387", false));
        expectedEmployeesArray.add(new Employee("0005", "Noor", "Saad", "0505778838", false));
        expectedEmployeesArray.add(new Employee("0006", "Jood", "Musharraf", "0505393384", false));
        expectedEmployeesArray.add(new Employee("0007", "Rozana", "Sendii", "0534552838", false));
    }

    @Test
    public void testisEmployeeID() {
        System.out.println("isEmployeeID");
        String instance = "1233";
        assertFalse(Employee.isEmployeeID(instance)); // It is Not an Existing Employee ID
    }

    @Test
    public void testGetManager() {
        System.out.println("getManager");
        Employee expectedManager = new Employee("0001", "Nora", "Ahmad", "0526372862", true);
        assertEquals(expectedManager, Employee.getManager());
    }

    @Test
    public void testAllEmployees() {
        System.out.println("AllEmployees");
        Employee.AllEmployees(); // Fill Employees Array in Employee Class
        assertArrayEquals(Employee.getEmployees().toArray(), expectedEmployeesArray.toArray());

    }

    @Test
    public void testIsEmployeeID() {
        System.out.println("isEmployeeID");
        // Test That Only Return (True) When The ID is Pre-defined in The System as Employee
        assertFalse(Employee.isEmployeeID("1000"));// Should Return False Since No Employee Have This ID
        assertTrue(Employee.isEmployeeID("0001"));// Should Return True Since It Is Exist That Employee Have This ID
        assertTrue(Employee.isEmployeeID("0002"));// Should Return True Since It Is Exist That Employee Have This ID
    }

    @After
    public void tearDown() {
        expectedEmployeesArray.clear();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
