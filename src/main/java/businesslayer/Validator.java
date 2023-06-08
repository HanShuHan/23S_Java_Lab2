package businesslayer;

/*
 * Filename: Validator.java
 * Student Name: Shu Han Han
 * Student Number: 041060762
 * Course & Section #: 23S_CST8288_033
 * Assignment: Lab #2
 * Date: June 07, 2023
 * Professor: Siju Philip
 * Declaration: This is my own original work and is free from Plagiarism.
 */

import java.lang.reflect.Field;

/**
 * Class field annotation validator.
 *
 * @author Shu Han Han
 * @version 1.0
 * @since 20.0.1
 */
public class Validator {

    /**
     * The private constructor prevents the utility class from being instantiated.
     */
    private Validator() {
    }

    /**
     * Validates the object's fields.
     *
     * @param o the object to be validated
     */
    public static void validate(Object o) {
        final Class<?> clazz = o.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(StringSize.class)) {
                //
                StringSize annotation = field.getAnnotation(StringSize.class);
                final int min = annotation.min();
                final int max = annotation.max();
                //
                field.setAccessible(true);
                try {
                    String str = (String) field.get(o);
                    if (str.length() < min) {
                        final String errorMessage = String.format("String length of %s is less than %d.", field.getName(), min);
                        throw new IllegalArgumentException(errorMessage);
                    }
                    if (str.length() > max) {
                        final String errorMessage = String.format("String length of %s is greater than %d.", field.getName(), max);
                        throw new IllegalArgumentException(errorMessage);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
