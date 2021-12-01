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

/**
 *
 * @author HP
 */
public class Transaction {

    private String caseNumber;
    private String caseTitle;
    private String caseDoc;
    private String status;
    public static int FoundCaseIndex;
    static ArrayList<Transaction> transactions = new ArrayList<>();
    private static File TransactionFile = new File("TransactionFile.txt");

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
        lines.subList(TransactionIndexNumber, TransactionIndexNumber+4).clear();
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

    public static int SearchTransactio(String CaseNumber) {

        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getCaseNumber().equals(CaseNumber)) {
                FoundCaseIndex = i;
                return i;
            }
        }
        return -1;

    }
}
