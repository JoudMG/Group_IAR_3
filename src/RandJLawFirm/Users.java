package RandJLawFirm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {

    public String ID;
    public String password;
    public String email;
    public ArrayList<Users> UserDb = new ArrayList<>();
    public File database = new File("UserDataBase.txt");

    public Users(String ID, String password, String email) {
        this.ID = ID;
        this.password = password;
        this.email = email;
    }

    public void ReadInformations() throws FileNotFoundException {

        if (UserDb.isEmpty()) {// if not empty, thats mean it alredy enter this method
            File UserFile = new File("UserDataBase.txt");
            Scanner scan = new Scanner(UserFile);
            while (scan.hasNextLine()) {
                // add existing application users to arraylist
                UserDb.add(new Users(scan.nextLine(), scan.nextLine(), scan.nextLine()));

            }
        }
    }

    public String getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void RegisterUser(Users newUser) throws FileNotFoundException, IOException {

        // Appened new information on existing file
        try (FileWriter UsersFile = new FileWriter("UserDataBase.txt", true);
                // BufferedWriter and Printer declaration
                BufferedWriter bufferWriter = new BufferedWriter(UsersFile);
                PrintWriter printer = new PrintWriter(bufferWriter)) {
            // add new user informations
            printer.println(newUser.getID());
            printer.println(newUser.getPassword());
            printer.println(newUser.getEmail());

        } catch (IOException e) {

        }

    }

    public Boolean isIDExist(String ID) {

        for (int i = 0; i < UserDb.size(); i++) {
            if (UserDb.get(i).getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

}
