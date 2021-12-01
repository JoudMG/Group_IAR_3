package RandJLawFirm;

import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    private String FirstName;
    private String LastName;
    private String SSN;
    private String Email;
    private String Phone;
    private String BankIBAN;
    private char Gender;
    public static ArrayList<Client> Clients = new ArrayList<>();
    private static File ClientFile = new File("ClientsFile.txt");

    public Client(String FirstName, String LastName, String SSN, String Email, String Phone, String BankIBAN, char Gender) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.SSN = SSN;
        this.Email = Email;
        this.Phone = Phone;
        this.BankIBAN = BankIBAN;
        this.Gender = Gender;
    }

    public static void ReadInformations() throws FileNotFoundException {

        if (Clients.isEmpty() && ClientFile.exists()) {// if not empty, thats mean it alredy enter this method
            Scanner scan = new Scanner(ClientFile);
            while (scan.hasNextLine()) {
                // add existing clients to arraylist
                Clients.add(new Client(scan.nextLine(), scan.nextLine(), scan.nextLine(),
                        scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine().charAt(0)));

            }

        }
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public String getSSN() {
        return SSN;
    }

    public String getEmail() {
        return Email;
    }

    public String getBankIBAN() {
        return BankIBAN;
    }

    public char getGender() {
        return Gender;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setBankIBAN(String BankIBAN) {
        this.BankIBAN = BankIBAN;
    }

    public void setGender(char Gender) {
        this.Gender = Gender;
    }

    public static void AddClient(Client newClient) throws FileNotFoundException, IOException {

        // Appened new information on existing file
        try (FileWriter ClientsFile = new FileWriter("ClientsFile.txt", true);
                // BufferedWriter and Printer declaration
                BufferedWriter bufferWriter = new BufferedWriter(ClientsFile);
                PrintWriter printer = new PrintWriter(bufferWriter)) {
            // add new client informations
            printer.println(newClient.getFirstName());
            printer.println(newClient.getLastName());
            printer.println(newClient.getSSN());
            printer.println(newClient.getEmail());
            printer.println(newClient.getPhone());
            printer.println(newClient.getBankIBAN());
            printer.println(newClient.getGender());
        } catch (IOException e) {

        }

    }

    public static void ModifyClientInformationOnDB(int lineNumber, String data) throws IOException {
        // get all file content as lines into a list of string
        List<String> lines = Files.readAllLines(ClientFile.toPath(), StandardCharsets.UTF_8);
        // modify specific line with passed data (new value)
        lines.set(lineNumber - 1, data);
        // set changes to file 
        Files.write(ClientFile.toPath(), lines, StandardCharsets.UTF_8);
    }

    public static void DeleteClientInformationOnDB(int ClientIndexNumber) throws IOException {
        // get all file content as lines into a list of string
        List<String> lines = Files.readAllLines(ClientFile.toPath(), StandardCharsets.UTF_8);
        // Delete lines that contains client information 
        // each client has 7 lines
        lines.subList(ClientIndexNumber, ClientIndexNumber+7).clear();
        // set changes to file 
        Files.write(ClientFile.toPath(), lines, StandardCharsets.UTF_8);
    }

}
