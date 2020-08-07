package com.Bridgelabz.services;

import com.Bridgelabz.models.Person;
import com.Bridgelabz.databaseUtility.DataBaseConnection;
import com.Bridgelabz.utility.UserInputs;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookDatabase {

    public PreparedStatement preparedStatement;
    Scanner scanner = new Scanner(System.in);
    UserInputs userInputs = new UserInputs();
    private String firstName, lastName, city, state, phone, zipcode;

    public void addRecordsTODatabase() {
        System.out.println("enter firstName");
        firstName = scanner.nextLine();
        System.out.println("enter lastName");
        lastName = scanner.nextLine();
        System.out.println("enter city");
        city = scanner.nextLine();
        System.out.println("enter state");
        state = scanner.nextLine();
        System.out.println("enter zipcode");
        zipcode = scanner.nextLine();
        System.out.println("enter phone");
        phone = scanner.nextLine();

        String insertQuery = "INSERT INTO person(first_name,last_name,city,state,zipcode,phone)" +
                "VALUES(?,?,?,?,?,?)";
        try (Connection connection = DataBaseConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, state);
            preparedStatement.setString(5, zipcode);
            preparedStatement.setString(6, phone);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Data inserted successfully");
    }

    public void editDetailsInDatabase() {
        System.out.println("Enter First Name");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name");
        String lastName = scanner.nextLine();

        boolean flag = true;
        while (flag) {
            int options = userInputs.editMenu();
            switch (options) {
                case 1:
                    System.out.println("Enter new city");
                    String newCity = scanner.nextLine();
                    this.editContactDetails(firstName, lastName, "city", newCity);
                    break;
                case 2:
                    System.out.println("Enter new state");
                    String newState = scanner.nextLine();
                    this.editContactDetails(firstName, lastName, "state", newState);
                    break;
                case 3:
                    System.out.println("Enter new zipcode");
                    String newZipCode = scanner.nextLine();
                    this.editContactDetails(firstName, lastName, "zipcode", newZipCode);
                    break;
                case 4:
                    System.out.println("Enter new Phone number");
                    String newPhoneNumber = scanner.nextLine();
                    this.editContactDetails(firstName, lastName, "phone", newPhoneNumber);
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter valid option");
            }

        }
    }


    public void editContactDetails(String firstName, String lastName, String fieldToUpdate, String newValue) {

        String updateQuery = "UPDATE person SET " + fieldToUpdate + " = '" + newValue +
                "' WHERE first_name = '" + firstName + "' AND last_name = '" + lastName + "'";
        try (Connection connection = DataBaseConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.executeUpdate();
            System.out.println("Details updated");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteRecord() {
        System.out.println("Enter First Name");
        String firstName = scanner.nextLine();
        System.out.println("Enter Last Name");
        String lastName = scanner.nextLine();
        String deleteQuery = "DELETE FROM person Where first_name = '" + firstName + "' AND last_name = '" + lastName + "'";
        try (Connection connection = DataBaseConnection.getConnection()) {
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Deleted record");
    }

    public void getRecords() {
        ArrayList<Person> personData = new ArrayList<>();
        String query = "SELECT * FROM person";
        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zipcode = resultSet.getString("zipcode");
                String phone = resultSet.getString("phone");
                System.out.println(id + " " + firstName + " " + last_name + " " + city + " " + state + " " +
                        zipcode + " " + phone);
                personData.add(new Person(firstName, last_name, city, state, zipcode, phone));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private  void getResultBasedOnQuery(String query) throws SQLException {
        ArrayList<Person> personData = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zipcode = resultSet.getString("zipcode");
                String phone = resultSet.getString("phone");
                System.out.println(id + " " + firstName + " " + last_name + " " + city + " " + state + " " +
                        zipcode + " " + phone);
                personData.add(new Person(firstName, last_name, city, state, zipcode, phone));
            }

        }
    }

    public void sortDatabase() throws SQLException {
        int counter = 0;
        String query = "";

        while ( counter == 0){
            int options = userInputs.sortMenu();
            switch (options){
                case 1:
                    query = "SELECT * FROM person ORDER BY first_name ASC";
                    this.getResultBasedOnQuery(query);
                    break;
                case 2:
                    query = "SELECT * FROM person ORDER BY state ASC";
                    this.getResultBasedOnQuery(query);
                    break;
                case 3:
                    query = "SELECT * FROM person ORDER BY phone ASC";
                    this.getResultBasedOnQuery(query);
                    break;
                case 4:
                    query = "SELECT * FROM person ORDER BY zipcode ASC";
                    this.getResultBasedOnQuery(query);
                    break;
                case 5:
                    counter = 1;
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("enter valid input");

            }
        }

    }


}
