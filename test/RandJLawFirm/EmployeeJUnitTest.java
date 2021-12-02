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

    ArrayList<Employee> expectedEmployeesArray = new ArrayList<>();

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
        Employee expectedManager1 = new Employee("0001", "Nora", "Ahmad", "0526372862", true);

        System.out.println(expectedManager + "  " + Employee.getManager());
//        assertEquals(expectedManager, Employee.getManager());
        assertEquals(expectedManager, is(expectedManager1));
    }

    @Test
    public void testAllEmployees() {
        System.out.println("AllEmployees()");
        Employee.AllEmployees(); // Fill Employees Array
//        Object[] testEmployeeArray = Employee.getEmployees().toArray(); // Invoke Filled Array
//        Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedEmployeesArray.toArray(), Employee.getEmployees()));
//        assertThat(Employee.getEmployees(), amePropertyValuesAs(expectedEmployeesArray.toArray()));
//        assertTrue(Employee.getEmployees().equals(expectedEmployeesArray));
        assertTrue( "check equality",Employee.getEmployees().toArray().equals(expectedEmployeesArray.toArray())  );
//        assertEquals(new HashSet<Employee>(Employee.getEmployees()),
//                new HashSet<Employee>(expectedEmployeesArray));
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
