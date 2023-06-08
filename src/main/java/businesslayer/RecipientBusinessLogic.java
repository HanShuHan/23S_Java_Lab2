package businesslayer;

/*
 * Filename: RecipientsBusinessLogic.java
 * Student Name: Shu Han Han
 * Student Number: 041060762
 * Course & Section #: 23S_CST8288_033
 * Assignment: Lab #2
 * Date: June 07, 2023
 * Professor: Siju Philip
 * Declaration: This is my own original work and is free from Plagiarism.
 */

import dataaccesslayer.RecipientDAO;
import dataaccesslayer.RecipientDAOImpl;
import lombok.NonNull;
import transferobjects.RecipientDTO;

import java.util.List;

/**
 * The recipient business logic.
 *
 * @author Shu Han Han
 * @version 1.0
 * @since 20.0.1
 */
public class RecipientBusinessLogic {

    /**
     * The recipient DAO used to access the Recipient table.
     */
    private final RecipientDAO recipientDAO;

    /**
     * Initializes the recipient DAO when the business logic class constructed.
     */
    public RecipientBusinessLogic() {
        this.recipientDAO = new RecipientDAOImpl();
    }

    /**
     * Gets all the recipient entries in the Recipients table.
     *
     * @return all the recipient entries from the Recipients table in a list
     */
    public List<RecipientDTO> getAllRecipients() {
        return recipientDAO.getAllRecipients();
    }

    /**
     * Gets all the recipient column names in the Recipients table.
     *
     * @return all the recipient column names from the Recipients table in a list
     */
    public List<String> getAllRecipientColumnNames() {
        return recipientDAO.getAllRecipientColumnNames();
    }

    /**
     * Gets all the recipient column type names in the Recipients table.
     *
     * @return all the recipient column type names from the Recipients table in a list
     */
    public List<String> getAllRecipientColumnTypeNames() {
        return recipientDAO.getAllRecipientColumnTypeNames();
    }

    /**
     * Gets all the recipient column's Java class name from the Recipients table.
     *
     * @return all the recipient column's Java class name from the Recipients table in a list
     */
    public List<String> getAllRecipientColumnClassNames() {
        return recipientDAO.getAllRecipientColumnClassNames();
    }

    /**
     * Creates a recipient entry in the Recipients table.
     *
     * @param recipient the recipient dto used to create an entry in the Recipients table
     * @return true if succeeded; otherwise, false
     */
    public boolean createRecipient(@NonNull final RecipientDTO recipient) {
        Validator.validate(recipient);
        return recipientDAO.createRecipient(recipient);
    }

    /**
     * Updates a recipient entry in the Recipients table.
     *
     * @param recipient the recipient dto used to update an entry in the Recipients table
     * @return true if succeeded; otherwise, false
     */
    public boolean updateRecipient(@NonNull final RecipientDTO recipient) {
        // Validates the recipient
        if (recipient.getAwardId() == null) {
            throw new IllegalArgumentException("The updated recipient's AwardId cannot be null.");
        }
        Validator.validate(recipient);

        return recipientDAO.updateRecipient(recipient);
    }

    /**
     * Retrieves the latest created recipient entry in the Recipients table.
     *
     * @return the latest created recipient entry in the Recipients table.
     */
    public RecipientDTO getLatestCreatedRecipient() {
        return recipientDAO.getFirstRecipientByOrderByAwardIdDesc();
    }

    /**
     * Deletes the latest created recipient entry in the Recipients table.
     *
     * @return true if succeeded; otherwise, false
     */
    public boolean deleteLatestCreatedRecipient() {
        RecipientDTO theLatestCreatedRecipientDTO = recipientDAO.getFirstRecipientByOrderByAwardIdDesc();
        return recipientDAO.deleteRecipient(theLatestCreatedRecipientDTO);
    }

}
