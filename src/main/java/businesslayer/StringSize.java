package businesslayer;

/*
 * Filename: Size.java
 * Student Name: Shu Han Han
 * Student Number: 041060762
 * Course & Section #: 23S_CST8288_033
 * Assignment: Lab #2
 * Date: June 07, 2023
 * Professor: Siju Philip
 * Declaration: This is my own original work and is free from Plagiarism.
 */

import java.lang.annotation.*;

/**
 * String size restriction annotation.
 *
 * @author Shu Han Han
 * @version 1.0
 * @since 20.0.1
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringSize {
    String message() default "String length is not valid.";
    int min() default 0;
    int max() default Integer.MAX_VALUE;
}
