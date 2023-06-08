
/*
 * Filename: Test.java
 * Student Name: Shu Han Han
 * Student Number: 041060762
 * Course & Section #: 23S_CST8288_033
 * Assignment: Lab #2
 * Date: June 07, 2023
 * Professor: Siju Philip
 * Declaration: This is my own original work and is free from Plagiarism.
 */

import businesslayer.RecipientBusinessLogic;
import dataaccesslayer.RecipientDAO;
import dataaccesslayer.RecipientDAOImpl;
import transferobjects.RecipientDTO;

/**
 * Todo:
 *
 * @author Shu Han Han
 * @version 1.0
 * @see
 * @since 20.0.1
 */
public class Test {
    public static void main(String[] args) {
        boolean success = false;
        RecipientDAO dao = new RecipientDAOImpl();
        RecipientDTO recipient = RecipientDTO.builder()
                .awardId(null)
                .name("123")
                .year(11)
                .city("TP")
                .category("No")
                .build();
        recipient = null;
//        dao.createRecipient(null);
//        dao.updateRecipient(recipient);
//        dao.deleteRecipientById(null);

        RecipientBusinessLogic businessLogic = new RecipientBusinessLogic();
        recipient = businessLogic.getLatestCreatedRecipient();
        System.out.println(recipient.getAwardId());
//        success = businessLogic.updateRecipient(recipient);
//        System.out.println(success);
    }
}
