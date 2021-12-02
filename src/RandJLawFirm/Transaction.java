/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandJLawFirm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Transaction {

    private String caseNumber;
    private String caseTitle;
    private String caseDoc;
    private String status;
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static File TransactionFile = new File("TransactionFile.txt");
    
    // This Attribute is ONLY Used in Runtime To Save Found Case Index By SearchCase Class
    // So we Can Share This Value with Other Classes
    private static int FoundCaseIndex;

    public Transaction(String caseNumber, String caseTitle, String caseDoc, String status) {
        this.caseNumber = caseNumber;
        this.caseTitle = caseTitle;
        this.caseDoc = caseDoc;
        this.status = status;
    }

    public static void ReadTranInformations() throws FileNotFoundException {

        if (transactions.isEmpty() && TransactionFile.exists()) {
            Scanner scan = new Scanner(TransactionFile);
            while (scan.hasNextLine()) {
                transactions.add(new Transaction(scan.nextLine(), scan.nextLine(), scan.nextLine(), scan.nextLine()));
            }
        }
    }

    public static void AddTrans(Transaction newTrans) throws FileNotFoundException, IOException {

        try (FileWriter transFile = new FileWriter("TransactionFile.txt", true);
                BufferedWriter bufferWriter = new BufferedWriter(transFile);
                PrintWriter printer = new PrintWriter(bufferWriter)) {

            printer.println(newTrans.getCaseNumber());
            printer.println(newTrans.getCaseTitle());
            printer.println(newTrans.getCaseDoc());
            printer.println(newTrans.getStatus());
        } catch (IOException e) {

        }
    }

    public static void ModifyTrans(int lineNumber, String data) throws FileNotFoundException, IOException {

        // get all file content as lines into a list of string
        List<String> lines = Files.readAllLines(TransactionFile.toPath(), StandardCharsets.UTF_8);
        // modify specific line with passed data (new value)
        lines.set(lineNumber - 1, data);
        // set changes to file 
        Files.write(TransactionFile.toPath(), lines, StandardCharsets.UTF_8);

    }

    public static void DeleteTrans(int TransactionIndexNumber) throws IOException {
        // get all file content as lines into a list of string
        List<String> lines = Files.readAllLines(TransactionFile.toPath(), StandardCharsets.UTF_8);
        // Delete lines that contains client information 
        // each client has 4 lines
        lines.subList(TransactionIndexNumber, TransactionIndexNumber + 4).clear();
        // set changes to file 
        Files.write(TransactionFile.toPath(), lines, StandardCharsets.UTF_8);
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public void setCaseDoc(String caseDoc) {
        this.caseDoc = caseDoc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public String getStatus() {
        return status;
    }

    public String getCaseDoc() {
        return caseDoc;
    }

    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static File getTransactionFile() {
        return TransactionFile;
    }

    public static Boolean isCaseNumberVaild(String ID) {
        if (ID == null) {
            return false;
        }
        try {
            Integer id = Integer.parseInt(ID);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int getFoundCaseIndex() {
        return FoundCaseIndex;
    }

    public static void setFoundCaseIndex(int FoundCaseIndex) {
        Transaction.FoundCaseIndex = FoundCaseIndex;
    }
    

    public static String GenerateTransactionsReport() throws FileNotFoundException {
        String Report = "";

        Report += "=============================================================================\n";
        Report += "------------------------------ R & J LAW FIRM -------------------------------\n";
        Report += "=============================================================================\n\n";
        Report += "---------------------------- TRANSACTIONS REPORT ----------------------------\n";
        java.util.Date date = new java.util.Date();
        Report += "\n    Date :  " + date + "          \n";
        Report += "=============================================================================\n";

        // fill arraylist
        Transaction.ReadTranInformations();
        for (int i = 0; i < Transaction.getTransactions().size(); i++) {
            Report += "----- TRANSACTION ( " + (i + 1) + " ) -----------------------------------------------------\n";
            Report += "      Case Number:             " + Transaction.getTransactions().get(i).getCaseNumber()
                    + "            Case Title:   " + Transaction.getTransactions().get(i).getCaseTitle() + "\n";
            File CaseFile = new File(Transaction.getTransactions().get(i).getCaseDoc());
            Report += "      Case Document:       " + CaseFile.getName()
                    + "\n      Case Status:    " + Transaction.getTransactions().get(i).getStatus() + "\n";
            Report += "=============================================================================\n";
        }
        Report += "\n                             TOTAL TRANSACTIONS  :  " + (transactions.size()) + "\n";

        Report += "\n----------------- TRANSACTIONS REPORT GENERATED SUCCESSFULLY-----------------\n";
        Report += "=============================================================================\n";

        return Report;

    }

    public static int SearchTransaction(String CaseNumber) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getCaseNumber().equals(CaseNumber)) {
                FoundCaseIndex = i;
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
