/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r.g.firm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class User_database {

    public String ID;
    public String password;
    public String confirm_password;
    public String email;
    public ArrayList<User_database> UserDb = new ArrayList<>();
    public File database = new File("UserDataBase.txt");

    public User_database() {
        ID = "0100";
        password = "Stitch123";
        confirm_password = "Stitch124";
        email = "Adam@hotmail.com ";

    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<User_database> getUserDb() {
        return UserDb;
    }

    public File getDatabase() {
        return database;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserDb(ArrayList<User_database> UserDb) {
        this.UserDb = UserDb;
    }

    public void setDatabase(File database) {
        this.database = database;
    }

    public User_database(String ID, String pass, String copass, String email) {
        this.ID = ID;
        this.password = pass;
        this.confirm_password = copass;
        this.email = email;
    }

    public ArrayList<User_database> ReadInforamtion() {
        ArrayList<User_database> c = new ArrayList<>();
        try {
            Scanner read = new Scanner(database);
            String line;
            String[] data;
            while (read.hasNextLine()) {
                line = read.nextLine();
                data = line.split(" # ");
                User_database ub = new User_database(data[0], data[1], data[2], data[3]);
                c.add(ub);
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when the system read the user inforamtion.");
        }
        return c;
    }

    public void SaveInforamtion(User_database uB) {
        try {
            UserDb = ReadInforamtion();
            boolean flag = false;
            PrintWriter writer = new PrintWriter(database);
            for (int i = 0; i < UserDb.size(); i++) {
                String[] c = UserDb.get(i).toString().split(" # ");
                String[] c2 = uB.toString().split(" # ");
                if (c[0].equals(c2[0])) {
                    writer.println(uB.toString());
                    flag = true;
                } else {
                    writer.println(
                            UserDb.get(i).toString());
                }
            }
            if (!flag) {
                writer.println(uB.toString());
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public int[] Register() {
        int checkID = 0, checkemail = 0, checkpassword = 0, checkcopassword = 0;

        int[] Userarray = new int[4];
        try {
            UserDb = ReadInforamtion();
            for (int i = 0; i < UserDb.size(); i++) {
                if (UserDb.get(i).getID().equalsIgnoreCase(this.getID())) {
                    checkID = 1;
                }
                if (UserDb.get(i).getEmail().equalsIgnoreCase(this.getEmail())) {
                    checkemail = 1;
                }
            }
            if (this.getPassword().length() < 8) {
                checkpassword = 1;
            }
            if (!this.getPassword().matches(this.getConfirm_password())) {
                checkcopassword = 1;

            }
            Userarray[0] = checkID;
            Userarray[1] = checkemail;
            Userarray[2] = checkpassword;
            Userarray[3] = checkcopassword;

        } catch (Exception ex) {
            System.out.println("An error occurred when the system tried to Register this User.");
        }
        return Userarray;
    }
}
