package businesslayer;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import transferobjects.RecipientDTO;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/*
 * Filename: RecipientBusinessLogicTest.java
 * Student Name: Shu Han Han
 * Student Number: 041060762
 * Course & Section #: 23S_CST8288_033
 * Assignment: Lab #2
 * Date: June 07, 2023
 * Professor: Siju Philip
 * Declaration: This is my own original work and is free from Plagiarism.
 */

class RecipientBusinessLogicTest {

    private static RecipientBusinessLogic recipientBusinessLogic;

    @BeforeAll
    static void setUp() {
        recipientBusinessLogic = new RecipientBusinessLogic();
    }

    @AfterAll
    static void tearDown() {
        recipientBusinessLogic = null;
    }

    @Test
    void getAllRecipients() {
        final List<RecipientDTO> recipientList = recipientBusinessLogic.getAllRecipients();
        assertThat("Did not return all the recipients from the Recipients table", recipientList, hasSize(65));
    }

    @Test
    void getAllRecipientColumnNames() {
        final List<String> recipientColumnNamesList = recipientBusinessLogic.getAllRecipientColumnNames();
        assertThat("Did not return all the recipient column names from the Recipients table", recipientColumnNamesList, hasSize(5));
    }

    @Test
    void getAllRecipientColumnTypeNames() {
        final List<String> recipientColumnTypeNamesList = recipientBusinessLogic.getAllRecipientColumnTypeNames();
        assertThat("Did not return all the recipient column type names from the Recipients table", recipientColumnTypeNamesList, hasSize(5));
    }

    @Test
    void getAllRecipientColumnClassNames() {
        final List<String> recipientColumnClassNamesList = recipientBusinessLogic.getAllRecipientColumnClassNames();
        assertThat("Did not return all the recipient column class names from the Recipients table", recipientColumnClassNamesList, hasSize(5));
    }

    @Test
    void createRecipient() {
        final RecipientDTO recipientsDTO = RecipientDTO.builder()
                .name("Hank")
                .year(1988)
                .city("Taipei")
                .category("No")
                .build();

        final boolean isCreated = recipientBusinessLogic.createRecipient(recipientsDTO);
        assertThat("Failed to create a new entry into the Recipients table", isCreated, is(true));
    }

    @Test
    void deleteLatestCreatedRecipient() {
        final boolean isDeleted = recipientBusinessLogic.deleteLatestCreatedRecipient();
        assertThat("Failed to delete the latest created entry in the Recipients table", isDeleted, is(true));
    }
}