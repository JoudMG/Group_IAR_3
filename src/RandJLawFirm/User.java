package RandJLawFirm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class User extends Employee {

    private String password;
    private static ArrayList<User> UserDb = new ArrayList<>();
    private static File database = new File("UserDataBase.txt");
    private static String CurrentUserID;

    public User(String ID, String password, String email) {
        super(ID,email);
        this.password = password;
    }

    public User(String ID, String password) {
        super(ID);
        this.password = password;
    }

    public User() {
        super(null);
    }

    static void ReadInformations() throws FileNotFoundException {
        if (UserDb.isEmpty()) {
            Scanner scan = new Scanner(database);
            while (scan.hasNextLine()) {
                UserDb.add(new User(scan.nextLine(), scan.nextLine(), scan.nextLine()));
            }
        }
    }

    public static void RegisterUser(User newUser) throws FileNotFoundException, IOException {

        // Appened new information on existing file
        try (FileWriter UsersFile = new FileWriter("UserDataBase.txt", true);
                // BufferedWriter and Printer declaration
                BufferedWriter bufferWriter = new BufferedWriter(UsersFile);
                PrintWriter printer = new PrintWriter(bufferWriter)) {
            // add new user informations
            printer.println(newUser.getID());
            printer.println(newUser.getPassword());
            printer.println(newUser.getEmail());
            CurrentUserID = newUser.getID();

        } catch (IOException e) {
        }
    }

    public static Boolean isIDExist(String ID) {

        for (int i = 0; i < UserDb.size(); i++) {
            if (UserDb.get(i).getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean isStrongPassword(String password) {

        char ch;
        boolean capitalFlag = false;
        boolean numberFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            }
            if (numberFlag && capitalFlag && (password.length() > 7)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isValidEmail(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }
        return true;

    }

    public static boolean checkLogInInformation(String ID, String Password) throws FileNotFoundException {
        User.ReadInformations();
        Boolean Found = false;

        for (int i = 0; i < User.UserDb.size(); i++) {
            if (User.UserDb.get(i).getID().equals(ID) && User.UserDb.get(i).getPassword().equals(Password)) {
                Found = true;
                CurrentUserID = ID;
                break;
            }
        }
        return Found;
    }

    public static String GenerateUserReport() throws FileNotFoundException {
        String Report = "";

        Report += "=============================================================================\n";
        Report += "------------------------------ R & J LAW FIRM -------------------------------\n";
        Report += "=============================================================================\n\n";
        Report += "------------------------------- USER REPORT ---------------------------------\n";
        java.util.Date date = new java.util.Date();
        Report += "\n    Date :  " + date + "          \n";
        Report += "=============================================================================\n";

        // fill  arraylist
        User.ReadInformations();
        Employee CurrentEmployee = null;
        for (int i = 0; i < User.UserDb.size(); i++) {
            for (int j = 0; j < Employee.getEmployees().size(); j++) {
                if (Employee.getEmployees().get(j).getID().equals(User.UserDb.get(i).getID())) {
                    CurrentEmployee = Employee.getEmployees().get(j);
                    break;
                }
            }
            Report += "----- USER ( " + (i + 1) + " ) ------------------------------------------------------------\n";
            Report += "      ID:   " + User.UserDb.get(i).getID() + "                  Email:   " + User.UserDb.get(i).getEmail() + "\n";
            Report += "      First Name:   " + CurrentEmployee.getFirstName() + "\n";
            Report += "      Last Name:    " + CurrentEmployee.getLastName() + "\n";
            Report += "      Phone Number: " + CurrentEmployee.getPhone() + "\n";
            if (CurrentEmployee.getIsManager()) {
                Report += "      Position:     " + "Manager\n";
            } else {
                Report += "      Position:     " + "Employee\n";
            }
            Report += "=============================================================================\n";
        }

        Report += "\n                                TOTAL USERS  :  " + (UserDb.size()) + "\n";

        Report += "\n-------------------- USERS REPORT GENERATED SUCCESSFULLY---------------------\n";
        Report += "=============================================================================\n";

        return Report;
    }

    public static String getCurrentUserID() {
        return CurrentUserID;
    }

    public String getID() {
        return super.getID();
    }


    public String getPassword() {
        return password;
    }

    public static ArrayList<User> getUserDb() {
        return UserDb;
    }

    public static File getDatabase() {
        return database;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void setUserDb(ArrayList<User> UserDb) {
        User.UserDb = UserDb;
    }

    public static void setDatabase(File database) {
        User.database = database;
    }

    public static void setCurrentUserID(String CurrentUserID) {
        User.CurrentUserID = CurrentUserID;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
