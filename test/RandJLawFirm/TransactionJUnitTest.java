/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RandJLawFirm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransactionJUnitTest {

    private static File TestFile;
    private static Scanner Reader;

    public TransactionJUnitTest() {
    }

    @Before
    public void setUp() throws FileNotFoundException {
        TestFile = new File("TestFile.txt");
        Reader = new Scanner(TestFile);
    }

    @After
    public void tearDown() throws IOException {
        // Clear File Content
        Files.newBufferedWriter(Paths.get("TestFile.txt"));
    }

    @Test
    public void testReadTranInformations() throws FileNotFoundException {
        System.out.println("ReadTranInformations");
        Transaction.ReadTranInformations();//Method Read Information from File to Create and Fill the ArrayList
        assertNotNull(Transaction.getTransactions());//Check That ArrayList Created
    }

    @Test
    public void testIsCaseNumberVaild() {
        System.out.println("isCaseNumberVaild");
        String instance = "99176";
        Boolean result = Transaction.isCaseNumberVaild(instance);
        Boolean expected = true;
        assertEquals(expected, result);
    }

    @Test
    public void testAddTransaction() throws IOException {
        System.out.println("AddTransaction");
        Transaction Temp = new Transaction("1934", "Family Case", "Case Document12 .pdf", "Completed");
        Transaction.AddTransaction("TestFile.txt", Temp); // save Object Info. On File
        // Read File Content to Ensure The Method Write Object On File
        String FileContent = "";
        while (Reader.hasNextLine()) {
            FileContent += Reader.nextLine();
        }
        String Expected = "1934" + "Family Case" + "Case Document12 .pdf" + "Completed";
        assertEquals(Expected, FileContent);
    }

    @Test
    public void testGenerateTransactionsReport() throws FileNotFoundException {
        System.out.println("GenerateTransactionsReport");
        assertNotNull(Transaction.GenerateTransactionsReport());
    }
}
