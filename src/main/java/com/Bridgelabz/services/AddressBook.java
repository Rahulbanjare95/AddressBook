package com.Bridgelabz.services;

import com.Bridgelabz.databaseUtility.DataBaseConnection;
import com.Bridgelabz.models.Person;
import com.Bridgelabz.utility.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private final static Scanner sc = new Scanner(System.in);
    JsonWriter jsonReaderAndWriter = new JsonWriter();
    CSVReaderAndWriter csvReaderAndWriter = new CSVReaderAndWriter();
    AddressBookDatabase addressBookDatabase = new AddressBookDatabase();
    String JSON_SIMPLE_PATH = "addressbookSimple.json";
    String CSV_FILE_PATH = "personCSVList.csv";
    String GSON_LIBRARY_JSON_PATH = "personListGSON.json";

    public ArrayList<Person> addPersonInfo(ArrayList<Person> personInfoArrayList) {
        String firstName, lastName, city, state, zipCode, phoneNumber;
        System.out.println("Add First name");
        firstName = sc.nextLine();
        System.out.println("Add Last name");
        lastName = sc.nextLine();
        boolean isPresent = personInfoArrayList.stream().anyMatch(personName -> (personName.getFirstName() + " "
                + personName.getLastName()).equalsIgnoreCase((String) firstName + " " + lastName));
        if (isPresent) {
            System.out.println("Name already exists");
        } else {
            System.out.println("Add City");
            city = sc.nextLine();
            System.out.println("Add State");
            state = sc.nextLine();
            System.out.println("Add zipCode");
            zipCode = sc.nextLine();
            System.out.println("Add PhoneNumber");
            phoneNumber = sc.nextLine();
            Person personAdded = new Person(firstName, lastName, city, state, zipCode, phoneNumber);
            personInfoArrayList.add(personAdded);
        }
        return personInfoArrayList;
    }

    public void editperson(ArrayList<Person> personInfoArrayList) {

        System.out.println("Enter the phonenumber to select Person and edit ");
        String num = sc.nextLine();
        Person personDetail = personInfoArrayList.stream().filter(phoneNumber -> (phoneNumber.getPhoneNumber().equals(num)))
                .findAny().orElse(null);
        if (personDetail != null) {

            boolean counter = false;
            do {
                System.out.println("Press 1 - Edit city");
                System.out.println("Press 2 - Edit state");
                System.out.println("Press 3 - Edit zipCode");
                System.out.println("Press 4 - Edit PhoneNumber");
                System.out.println("Press 5 to Exit");
                int selector = sc.nextInt();
                sc.nextLine();
                switch (selector) {
                    case 1:
                        System.out.println("add new city");
                        String city = sc.nextLine();
                        personDetail.setCity(city);
                        break;
                    case 2:
                        System.out.println("add new state");
                        String state = sc.nextLine();
                        personDetail.setState(state);
                        break;
                    case 3:
                        System.out.println("add new zipCode");
                        String zipCode = sc.nextLine();
                        personDetail.setZipCode(zipCode);
                        break;
                    case 4:
                        System.out.println("add new phone number");
                        String phoneNumber = sc.nextLine();
                        personDetail.setPhoneNumber(phoneNumber);
                        break;
                    case 5:
                        counter = true;
                        break;
                }
            } while (!counter);
        } else
            System.out.println("Person not present");
    }

    public void displayAddressBook(ArrayList<Person> personInfoArrayList) {
        personInfoArrayList.forEach(System.out::println);
    }

    public ArrayList<Person> deleteUsingName(ArrayList<Person> personInfoArrayList) {
        System.out.println("Enter first name of the person you want to delete");
        String nameinput = sc.nextLine();
        boolean flag = false;
        for (int index = 0; index < personInfoArrayList.size(); index++) {
            if ((personInfoArrayList.get(index).getFirstName().equalsIgnoreCase(nameinput))) {
                personInfoArrayList.remove(index);
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Name not found in addressbook");
        }
        return personInfoArrayList;
    }

    public void sortByFirstName(ArrayList<Person> personInfoArrayList) {
        SortAddressBook.sortByFirstName(personInfoArrayList);
    }

    public void sortByCity(ArrayList<Person> personInfoArrayList) {
        SortAddressBook.sortByCity(personInfoArrayList);
    }

    public void sortByState(ArrayList<Person> personInfoArrayList) {
        SortAddressBook.sortByState(personInfoArrayList);
    }

    public void sortByZipCode(ArrayList<Person> personInfoArrayList) {
        SortAddressBook.sortByZip(personInfoArrayList);
    }

    public void viewPersonByCityAndState(ArrayList<Person> personInfoArrayList) {
        SearchAddressBook.viewCityStateWise(personInfoArrayList);
    }

    public void writeJSON(ArrayList<Person> personInfoArrayList) {
        jsonReaderAndWriter.writeAFile(personInfoArrayList, JSON_SIMPLE_PATH);
    }

    public void readJSON(ArrayList<Person> personArrayList) {
        jsonReaderAndWriter.readWithGson(personArrayList, GSON_LIBRARY_JSON_PATH);
    }

    public void writeCsv(ArrayList<Person> personInfoArrayList) {
        csvReaderAndWriter.writeToCSVFile(personInfoArrayList, CSV_FILE_PATH);
    }

    public void readCSV(ArrayList<Person> personInfoArrayList) {
        csvReaderAndWriter.readFromCSV(personInfoArrayList, CSV_FILE_PATH);

    }

    public void writeJSONUsingGSON(ArrayList<Person> peronInfoArrayList) {
        jsonReaderAndWriter.writeAGSONfile(peronInfoArrayList, GSON_LIBRARY_JSON_PATH);
    }

    public void readFromFile(ArrayList<Person> personInfoArrayList) {
        jsonReaderAndWriter.readFromFile(JSON_SIMPLE_PATH);
    }

    public ArrayList<Person> getRecords(String Query) {
        ArrayList<Person> personData = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Query);) {
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String zipcode = resultSet.getString("zipcode");
                String phone = resultSet.getString("phone");
                System.out.println(id+"firstName" +firstName+ "lastName"+last_name+"city"+city+"state"+state+"zipcode"+
                        zipcode+"phone"+phone);
                personData.add(new Person(firstName, last_name, city, state, zipcode, phone));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return personData;
    }
    public int getNumberOfRows(){
        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select count(*) from person");
            resultSet.next();
            return resultSet.getInt("count(*)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int insertDataInDatabase(String Query){
        try (Connection connection = DataBaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            return statement.executeUpdate(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean updateDatabase(String Query){
        try(Connection connection = DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(Query);){
            while (resultSet.next()){

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ;
        return false;
    }
}