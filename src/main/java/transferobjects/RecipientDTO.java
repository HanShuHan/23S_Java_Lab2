package transferobjects;

/*
 * Filename: RecipientsDTO.java
 * Student Name: Shu Han Han
 * Student Number: 041060762
 * Course & Section #: 23S_CST8288_033
 * Assignment: Lab #2
 * Date: June 07, 2023
 * Professor: Siju Philip
 * Declaration: This is my own original work and is free from Plagiarism.
 */

import businesslayer.StringSize;
import lombok.Builder;
import lombok.NonNull;

/**
 * The Recipients DTO.
 *
 * @author Shu Han Han
 * @version 1.0
 * @since 20.0.1
 */
@Builder
public class RecipientDTO {

    /**
     * The recipient's AwardId.
     */
    private Integer awardId;

    /**
     * The recipient's Name.
     */
    @NonNull
    @StringSize(max = 40)
    private String name;

    /**
     * The recipient's Year.
     */
    @NonNull
    private Integer year;

    /**
     * The recipient's City.
     */
    @NonNull
    @StringSize(max = 30)
    private String city;

    /**
     * The recipient's Category.
     */
    @NonNull
    @StringSize(max = 40)
    private String category;

    /**
     * The getter of awardId.
     *
     * @return the recipient's AwardId
     */
    public Integer getAwardId() {
        return awardId;
    }

    /**
     * The setter for awardId.
     *
     * @param awardId the recipient's AwardId
     */
    public void setAwardId(Integer awardId) {
        this.awardId = awardId;
    }

    /**
     * The getter of name.
     *
     * @return the recipient's Name
     */
    public String getName() {
        return name;
    }

    /**
     * The setter for name.
     *
     * @param name the recipient's Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The getter of year.
     *
     * @return the recipient's Year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * The setter for year.
     *
     * @param year the recipient's Year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * The getter of city.
     *
     * @return the recipient's City
     */
    public String getCity() {
        return city;
    }

    /**
     * The setter for city.
     *
     * @param city the recipient's City
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * The getter of category.
     *
     * @return the recipient's Category
     */
    public String getCategory() {
        return category;
    }

    /**
     * The setter for category.
     *
     * @param category the recipient's Category
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
