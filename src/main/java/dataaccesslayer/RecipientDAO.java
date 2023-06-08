package dataaccesslayer;

/*
 * Filename: RecipientDAO.java
 * Student Name: Shu Han Han
 * Student Number: 041060762
 * Course & Section #: 23S_CST8288_033
 * Assignment: Lab #2
 * Date: June 07, 2023
 * Professor: Siju Philip
 * Declaration: This is my own original work and is free from Plagiarism.
 */

import transferobjects.RecipientDTO;

import java.util.List;

/**
 * The data access object (DAO) to the Recipients Table in MySQL database.
 *
 * @author Shu Han Han
 * @version 1.0
 * @since 20.0.1
 */
public interface RecipientDAO {

    /**
     * Gets all the recipient entries in the Recipients table.
     *
     * @return all the recipient entries from the Recipients table in a list
     */
    List<RecipientDTO> getAllRecipients();

    /**
     * Gets the first recipient entry order by AwardId desc in the Recipients table.
     *
     * @return the first recipient entry order by AwardId desc in the Recipients table
     */
    RecipientDTO getFirstRecipientByOrderByAwardIdDesc();

    /**
     * Gets all the recipient column names in the Recipients table.
     *
     * @return all the recipient column names from the Recipients table in a list
     */
    List<String> getAllRecipientColumnNames();

    /**
     * Gets all the recipient column type names in the Recipients table.
     *
     * @return all the recipient column type names from the Recipients table in a list
     */
    List<String> getAllRecipientColumnTypeNames();

    /**
     * Gets all the recipient column's Java class name from the Recipients table.
     *
     * @return all the recipient column's Java class name from the Recipients table in a list
     */
    List<String> getAllRecipientColumnClassNames();

    /**
     * Creates a recipient entry in the Recipients table.
     *
     * @param recipient the recipient dto used to create an entry in the Recipients table
     * @return true if succeeded; otherwise, false
     */
    boolean createRecipient(RecipientDTO recipient);

    /**
     * Updates a recipient entry in the Recipients table.
     *
     * @param recipient the recipient dto used to update an entry in the Recipients table
     * @return true if succeeded; otherwise, false
     */
    boolean updateRecipient(RecipientDTO recipient);

    /**
     * Deletes a recipient entry in the Recipients table.
     *
     * @param recipient the recipient dto used to delete an entry in the Recipients table
     * @return true if succeeded; otherwise, false
     */
    boolean deleteRecipient(RecipientDTO recipient);

    /**
     * Deletes a recipient entry in the Recipients table.
     *
     * @param id the recipient's AwardId used to delete an entry in the Recipients table
     * @return true if succeeded; otherwise, false
     */
    boolean deleteRecipientById(Integer id);
}
