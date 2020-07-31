package com.Bridgelabz.main;

import com.Bridgelabz.models.Person;
import com.Bridgelabz.utilities.SearchAccordingly;
import com.Bridgelabz.utilities.SortAddressBook;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class AddressBook{
    static ArrayList<Person> personInfoArrayList=new ArrayList<Person>();
    private final static Scanner sc = new Scanner(System.in);
    private static Person person;

    public ArrayList<Person> addPersonInfo(){
        int check=0;
        String firstName = null;
        String lastName,city,state,zipCode,phoneNumber;
        while(check==0) {
            System.out.print("add first name : ");
            firstName = sc.nextLine();
            if (checkExists(firstName)) {
                System.out.println(" firstname already exist cannot be added ");
            }
            else {
                check=1;
            }
        }

        System.out.println("Add Last name");
        lastName=sc.nextLine();
        System.out.println("Add City");
        city=sc.nextLine();
        System.out.println("Add State");
        state=sc.nextLine();
        System.out.println("Add zipCode");
        zipCode=sc.nextLine();
        System.out.println("Add PhoneNumber");
        phoneNumber=sc.nextLine();
        Person personAdded = new Person(firstName,lastName,city,state,zipCode,phoneNumber);
        personInfoArrayList.add(personAdded);
        return personInfoArrayList;
    } public ArrayList<Person> addPersonInformation(Person details) {
        personInfoArrayList.add(details);
        return personInfoArrayList;
    }
    public void writeToJson(String filePath) throws IOException {
        JSONObject obj = null;
        for (Person person : personInfoArrayList) {
            obj.put("FirstName", person.getFirstName());
            obj.put("LastName", person.getLastName());
            obj.put("Phone", person.getPhoneNumber());
        }
        FileWriter file = new FileWriter(filePath);
        file.write(obj.toJSONString());
        file.flush();
    }
    public void writeToGson(String filePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter(filePath);
        gson.toJson(personInfoArrayList, fileWriter);
        fileWriter.close();
    }

    public Map<String,String> cityHashTable(){
        Map<String,String> cityHashTable=new Hashtable<>();
        for (Person p: personInfoArrayList) {
            cityHashTable.put(p.getFirstName(),p.getCity());
        }
        return  cityHashTable;
    }
    public Map<String,String> stateHashTable(){
        Map<String,String> stateHashTable=new Hashtable<>();
        for (Person p :personInfoArrayList) {
            stateHashTable.put(p.getFirstName(),p.getState());
        }
        return stateHashTable;
    }
    public boolean checkExists(String namecheck)
    {
        int flag=0;
        for (Person p: personInfoArrayList)
        {
            if (p.getFirstName().equals(namecheck))
            {
                flag=1;
                break;
            }
        }
        if (flag==1)
        {
            return true;
        }
        return false;
    }

    public void editperson()
    {
        Person editPersonArray=new Person("","","","","","");
        System.out.println("Enter the phonenumber to select Person and edit ");
        String num=sc.nextLine();
        for(Person person:personInfoArrayList)
        {
            if(person.getPhoneNumber().equals(num))
            {
                editPersonArray=person;
            }
        }
        boolean counter=false;
        do{
            System.out.println("Press 1 - Edit city");
            System.out.println("Press 2 - Edit state");
            System.out.println("Press 3 - Edit zipCode");
            System.out.println("Press 4 - Edit PhoneNumber");
            System.out.println("Press 5 to Exit");
            int selector=sc.nextInt();
            sc.nextLine();
            switch (selector) {
                case 1:
                    System.out.println("add new city");
                    String city=sc.nextLine();
                    editPersonArray.setCity(city);
                    break;
                case 2:
                    System.out.println("add new state");
                    String state=sc.nextLine();
                    editPersonArray.setState(state);
                    break;
                case 3:
                    System.out.println("add new zipCode");
                    String zipCode=sc.nextLine();
                    editPersonArray.setZipCode(zipCode);
                    break;
                case 4:
                    System.out.println("add new phone number");
                    String phoneNumber=sc.nextLine();
                    editPersonArray.setPhoneNumber(phoneNumber);
                    break;
                case 5:
                    counter=true;
                    break;
            }

        }while(!counter);

    }
    public void displayAddressBook()
    {
        for(Person p:personInfoArrayList) {
            System.out.println(p);
        }
    }
    public void deleteUsingName(){
        System.out.println("Enter first name of the person you want to delete");
        String nameinput=sc.nextLine();
        for(Person p:personInfoArrayList)
        {
            if(p.getFirstName().equals(nameinput))
            {
                System.out.println("Match found ! Now deleting");
                personInfoArrayList.remove(p);
            }
            else
                System.out.println("No name found");
        }
    }
    public static void main(String[] args) throws IOException {
        boolean counter=false;
        AddressBook ad=new AddressBook();
        SearchAccordingly searchacc=new SearchAccordingly();
        SortAddressBook sab=new SortAddressBook();
        do{
            System.out.println("Press 1 - Add Person Information");
            System.out.println("Press 2 - Edit Person Information");
            System.out.println("Press 3 - Delete Person by name");
            System.out.println("Press 4 - Sort by firstname");
            System.out.println("Press 5 - Sort by City");
            System.out.println("Press 6 - Sort by State");
            System.out.println("Press 7 - Sort by zipCode");
            System.out.println("Press 8 - View by City State");
            System.out.println("Press 9 - Exit");
            int option=sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    ad.addPersonInfo();
                    ad.displayAddressBook();
                    ad.writeToJson("address.json");
                    ad.writeToGson("book.json");
                    break;
                case 2:
                    ad.displayAddressBook();
                    ad.editperson();
                    ad.displayAddressBook();
                    break;
                case 3:
                    ad.deleteUsingName();
                    ad.displayAddressBook();
                    break;
                case 4:
                    System.out.println("Sorting by firstname");
                    SortAddressBook.sortByFirstName(personInfoArrayList);
                    break;
                case 5:
                    System.out.println("Sorting by city");
                    SortAddressBook.sortByCity(personInfoArrayList);
                    break;
                case 6:
                    System.out.println("Sorting by state");
                    SortAddressBook.sortByState(personInfoArrayList);
                    break;
                case 7:
                    System.out.println("Sorting by ZipCode");
                    SortAddressBook.sortByZip(personInfoArrayList);
                    break;

                case 8:
                    System.out.println("Searching by City");
                    searchacc.searchPersonByCity(personInfoArrayList);
                    break;
                case 9:
                    counter=true;
                    break;
            }
        }while (!counter);
        ad.displayAddressBook();
    }
}