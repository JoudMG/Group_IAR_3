package RandJLawFirm;

import java.util.ArrayList;

public class Employee {

    private String ID;
    private String Fname;
    private String Lname;
    private String Phone;
    private Boolean isManager;
    private static ArrayList<Employee> Employees = new ArrayList<>();

    public Employee(String ID, String Fname, String Lname, String Phone, Boolean isManager) {
        this.ID = ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Phone = Phone;
        this.isManager = isManager;
    }

    public Employee(String ID) {
        this.ID = ID;
    }

    // All Employees are Pre-defined in the System, to ensure that ONLY Employees Can Signup & Login
    public static void AllEmployees() {
        if (Employees.isEmpty()) {
            Employees.add(new Employee("0001", "Nora", "Ahmad", "0526372862", true));
            Employees.add(new Employee("0002", "Farah", "Handom", "0567692392", false));
            Employees.add(new Employee("0003", "Sara", "Mohammed", "0553789983", false));
            Employees.add(new Employee("0004", "Lama", "Ali", "0555378387", false));
            Employees.add(new Employee("0005", "Noor", "Saad", "0505778838", false));
            Employees.add(new Employee("0006", "Jood", "Musharraf", "0505393384", false));
            Employees.add(new Employee("0007", "Rozana", "Sendii", "0534552838", false));
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(Boolean isManager) {
        this.isManager = isManager;
    }

    public static ArrayList<Employee> getEmployees() {
        return Employees;
    }

    public static void setEmployees(ArrayList<Employee> Employees) {
        Employees = Employees;
    }

    // Check If User That Want to Sign Up Is Employee or Not
    public static Boolean isEmployeeID(String id) {
        for (int i = 0; i < Employee.Employees.size(); i++) {
            if (Employee.Employees.get(i).getID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }


}

