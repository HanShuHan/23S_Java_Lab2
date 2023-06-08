package dataaccesslayer;

/*
 * Filename: RecipientDAOImpl.java
 * Student Name: Shu Han Han
 * Student Number: 041060762
 * Course & Section #: 23S_CST8288_033
 * Assignment: Lab #2
 * Date: June 07, 2023
 * Professor: Siju Philip
 * Declaration: This is my own original work and is free from Plagiarism.
 */

import lombok.NonNull;
import transferobjects.RecipientDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The implementation class of the {@link RecipientDAO recipient DAO}.
 *
 * @author Shu Han Han
 * @version 1.0
 * @since 20.0.1
 */
public class RecipientDAOImpl implements RecipientDAO {

    @Override
    public List<RecipientDTO> getAllRecipients() {
        final String sqlStatement = "SELECT * FROM Recipients"; // The SQL query statement
        final List<RecipientDTO> recipientsDTOList = new ArrayList<>();

        try (final Connection connection = new DataSource().createConnection();
             final PreparedStatement statement = connection.prepareStatement(sqlStatement);
             final ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                final Integer awardId = resultSet.getInt("AwardId");
                final String name = resultSet.getString("Name");
                final Integer year = resultSet.getInt("Year");
                final String city = resultSet.getString("City");
                final String category = resultSet.getString("Category");

                final RecipientDTO dto = RecipientDTO.builder()
                        .awardId(awardId)
                        .name(name)
                        .year(year)
                        .city(city)
                        .category(category)
                        .build();
                recipientsDTOList.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recipientsDTOList;
    }

    @Override
    public RecipientDTO getFirstRecipientByOrderByAwardIdDesc() {
        final String sqlStatement = "SELECT * FROM Recipients ORDER BY AwardID DESC LIMIT 1"; // The SQL query statement
        RecipientDTO recipientsDTO = null;

        try (final Connection connection = new DataSource().createConnection();
             final PreparedStatement statement = connection.prepareStatement(sqlStatement);
             final ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()) {
                final Integer awardId = resultSet.getInt("AwardId");
                final String name = resultSet.getString("Name");
                final Integer year = resultSet.getInt("Year");
                final String city = resultSet.getString("City");
                final String category = resultSet.getString("Category");

                recipientsDTO = RecipientDTO.builder()
                        .awardId(awardId)
                        .name(name)
                        .year(year)
                        .city(city)
                        .category(category)
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recipientsDTO;
    }

    @Override
    public List<String> getAllRecipientColumnNames() {
        final String sqlStatement = "SELECT * FROM Recipients LIMIT 1"; // The SQL query statement
        final List<String> recipientColumnNames = new ArrayList<>();

        try (final Connection connection = new DataSource().createConnection();
             final PreparedStatement statement = connection.prepareStatement(sqlStatement);
             final ResultSet resultSet = statement.executeQuery();
        ) {
            final ResultSetMetaData metaData = resultSet.getMetaData();
            final int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                recipientColumnNames.add(columnName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recipientColumnNames;
    }

    @Override
    public List<String> getAllRecipientColumnTypeNames() {
        final String sqlStatement = "SELECT * FROM Recipients LIMIT 1"; // The SQL query statement
        final List<String> recipientColumnTypeNames = new ArrayList<>();

        try (final Connection connection = new DataSource().createConnection();
             final PreparedStatement statement = connection.prepareStatement(sqlStatement);
             final ResultSet resultSet = statement.executeQuery();
        ) {
            final ResultSetMetaData metaData = resultSet.getMetaData();
            final int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnTypeName = metaData.getColumnTypeName(i);
                recipientColumnTypeNames.add(columnTypeName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recipientColumnTypeNames;
    }

    @Override
    public List<String> getAllRecipientColumnClassNames() {
        final String sqlStatement = "SELECT * FROM Recipients LIMIT 1"; // The SQL query statement
        final List<String> recipientColumnClassNames = new ArrayList<>();

        try (final Connection connection = new DataSource().createConnection();
             final PreparedStatement statement = connection.prepareStatement(sqlStatement);
             final ResultSet resultSet = statement.executeQuery();
        ) {
            final ResultSetMetaData metaData = resultSet.getMetaData();
            final int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                String columnClassName = metaData.getColumnClassName(i);
                recipientColumnClassNames.add(columnClassName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recipientColumnClassNames;
    }

    @Override
    public boolean createRecipient(@NonNull final RecipientDTO recipient) {
        final String sqlStatement = "INSERT INTO Recipients (Name, Year, City, Category) VALUES (?, ?, ?, ?);";  // The SQL insert statement
        final int rowsCreated;

        try (final Connection connection = new DataSource().createConnection();
             final PreparedStatement statement = connection.prepareStatement(sqlStatement);
        ) {
            statement.setString(1, recipient.getName());
            statement.setInt(2, recipient.getYear());
            statement.setString(3, recipient.getCity());
            statement.setString(4, recipient.getCategory());
            rowsCreated = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowsCreated > 0 ? true : false;
    }

    @Override
    public boolean updateRecipient(@NonNull RecipientDTO recipient) {
        if (recipient.getAwardId() == null) {
            throw new IllegalArgumentException("The updated recipient's AwardId cannot be null.");
        }

        final String sqlStatement = "UPDATE Recipients SET Name = ?, Year = ?, City = ?, Category = ? WHERE AwardID = ?";  // The SQL update statement
        final int rowsUpdated;

        try (final Connection connection = new DataSource().createConnection();
             final PreparedStatement statement = connection.prepareStatement(sqlStatement);
        ) {
            statement.setString(1, recipient.getName());
            statement.setInt(2, recipient.getYear());
            statement.setString(3, recipient.getCity());
            statement.setString(4, recipient.getCategory());
            statement.setInt(5, recipient.getAwardId());
            rowsUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowsUpdated > 0 ? true : false;
    }

    @Override
    public boolean deleteRecipient(@NonNull final RecipientDTO recipient) {
        return deleteRecipientById(recipient.getAwardId());
    }

    @Override
    public boolean deleteRecipientById(@NonNull Integer id) {
        final String sqlStatement = "DELETE FROM Recipients WHERE AwardID = ?;"; // The SQL delete statement
        final int rowsDeleted;

        try (final Connection connection = new DataSource().createConnection();
             final PreparedStatement statement = connection.prepareStatement(sqlStatement);
        ) {
            statement.setInt(1, id);
            rowsDeleted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowsDeleted > 0 ? true : false;
    }
}
