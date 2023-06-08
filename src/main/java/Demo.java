
/*
 * Filename: Demo.java
 * Student Name: Shu Han Han
 * Student Number: 041060762
 * Course & Section #: 23S_CST8288_033
 * Assignment: Lab #2
 * Date: June 07, 2023
 * Professor: Siju Philip
 * Declaration: This is my own original work and is free from Plagiarism.
 */

import businesslayer.RecipientBusinessLogic;
import transferobjects.RecipientDTO;

import java.util.List;

/**
 * The demo requirements.
 *
 * @author Shu Han Han
 * @version 1.0
 * @since 20.0.1
 */
public class Demo {

    /**
     * The recipient business logic layer.
     */
    private final RecipientBusinessLogic businessLogic;

    /**
     * Initializes the {@link RecipientBusinessLogic recipient business logic layer} when instantiating the {@link Demo demo} class.
     */
    public Demo() {
        businessLogic = new RecipientBusinessLogic();
    }

    /**
     * Runs the demo.
     */
    public void run() {
        // Prints the recipients table's column class names, column type names, column names, and all the entries.
        printRecipientColumnClassNames();
        printRecipientColumnTypeNames();
        printRecipientColumnNames();
        printDashes(230);
        System.out.println("Original Recipient Table:");
        printAllRecipientEntries();
        printDashes(230);

        // Creates a new recipient entry
        final RecipientDTO newRecipient = RecipientDTO.builder()
                .name("Hank")
                .year(1988)
                .city("Taipei")
                .category("No")
                .build();
        businessLogic.createRecipient(newRecipient);

        // Prints all the recipients table's entries
        System.out.println("After Created a New Entry:");
        printAllRecipientEntries();
        printDashes(230);
        // Prints the latest created recipient entry in the Recipients table
        System.out.println("The Latest Created Recipient Entry:");
        printLatestCreatedRecipientEntry();
        printDashes(230);

        // Updates the latest created recipient entry
        final RecipientDTO updatedRecipient = businessLogic.getLatestCreatedRecipient();
        updatedRecipient.setName("ABC");
        updatedRecipient.setYear(99);
        updatedRecipient.setCity("Ottawa");
        updatedRecipient.setCategory("-");
        businessLogic.updateRecipient(updatedRecipient);

        // Prints all the recipients table's entries
        System.out.println("After Updated a Recipient Entry:");
        printAllRecipientEntries();
        printDashes(230);
        // Prints the latest updated recipient entry in the Recipients table
        System.out.println("The Latest Updated Recipient Entry:");
        printLatestCreatedRecipientEntry();
        printDashes(230);

        // Deletes the latest created entry
        businessLogic.deleteLatestCreatedRecipient();

        // Prints all the recipients table's entries
        System.out.println("After Deleted the Latest Created Entry:");
        printAllRecipientEntries();
        printDashes(230);
    }

    /**
     * Prints a number of dashes.
     *
     * @param dashes the number of dashes wished to be printed
     */
    private static void printDashes(int dashes) {
        for (int i = 1; i <= dashes; i++) {
            System.out.printf("-");
        }
        System.out.println();
    }

    /**
     * Prints the recipient table's column names.
     */
    public void printRecipientColumnNames() {
        List<String> columnNames = businessLogic.getAllRecipientColumnNames();
        System.out.printf("%-40s", "Column Names: ");
        for (String columnName : columnNames) {
            System.out.printf("%-40s", columnName);
        }
        System.out.println();
    }

    /**
     * Prints the recipient table's column type names.
     */
    public void printRecipientColumnTypeNames() {
        List<String> columnTypeNames = businessLogic.getAllRecipientColumnTypeNames();
        System.out.printf("%-40s", "Column Type Names: ");
        for (String columnTypeName : columnTypeNames) {
            System.out.printf("%-40s", columnTypeName);
        }
        System.out.println();
    }

    /**
     * Prints the recipient table's column class names.
     */
    public void printRecipientColumnClassNames() {
        List<String> columnClassNames = businessLogic.getAllRecipientColumnClassNames();
        System.out.printf("%-40s", "Column Class Names: ");
        for (String columnClassName : columnClassNames) {
            System.out.printf("%-40s", columnClassName);
        }
        System.out.println();
    }

    /**
     * Prints all the recipient table's entries.
     */
    public void printAllRecipientEntries() {
        List<RecipientDTO> recipients = businessLogic.getAllRecipients();
        for (RecipientDTO recipient : recipients) {
            System.out.printf("%-40s", "");
            System.out.printf("%-40d", recipient.getAwardId());
            System.out.printf("%-40s", recipient.getName());
            System.out.printf("%-40d", recipient.getYear());
            System.out.printf("%-40s", recipient.getCity());
            System.out.printf("%-40s", recipient.getCategory());
            System.out.println();
        }
    }

    /**
     * Prints the latest created recipient entry in the Recipients table.
     */
    public void printLatestCreatedRecipientEntry() {
        RecipientDTO latestRecipient = businessLogic.getLatestCreatedRecipient();
        System.out.printf("%-40s", "");
        System.out.printf("%-40d", latestRecipient.getAwardId());
        System.out.printf("%-40s", latestRecipient.getName());
        System.out.printf("%-40d", latestRecipient.getYear());
        System.out.printf("%-40s", latestRecipient.getCity());
        System.out.printf("%-40s", latestRecipient.getCategory());
        System.out.println();
    }

}
