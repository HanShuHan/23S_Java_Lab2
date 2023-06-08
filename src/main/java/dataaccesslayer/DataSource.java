package dataaccesslayer;

/*
 * Filename: DataSource.java
 * Student Name: Shu Han Han
 * Student Number: 041060762
 * Course & Section #: 23S_CST8288_033
 * Assignment: Lab #2
 * Date: June 07, 2023
 * Professor: Siju Philip
 * Declaration: This is my own original work and is free from Plagiarism.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * The Data Source class, in which we use JDBC Driver Manager to build a connection to a database.
 *
 * @author Shu Han Han
 * @version 1.0
 * @since 20.0.1
 */
public class DataSource {

    /**
     * The connection to a database.
     */
    private Connection connection;

    /**
     * The default constructor.
     */
    public DataSource() {
    }

    /**
     * Creates a new connection to a database.
     * If a connection is already built, it returns the connection.
     *
     * @return the built connection
     */
    public Connection createConnection() {
        if (connection == null) {
            Properties properties = new Properties();
            try { // Loads the JDBC properties setting
                properties.load(Files.newInputStream(Path.of("src/main/resources/database.properties")));
            } catch (IOException e) {
                throw new RuntimeException("Error happened when loading database properties file", e);
            }
            try {
                connection = DriverManager.getConnection(properties.getProperty("url"), properties);
            } catch (SQLException e) {
                throw new RuntimeException("Error happened when creating a SQL connection", e);
            }
        }
        return connection;
    }
}
