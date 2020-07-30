package com.Bridgelabz.main;

import com.Bridgelabz.main.exceptions.AddressBookException;
import com.Bridgelabz.models.Person;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AddressBook{
    public static ArrayList<Person> personInfoArrayList=new ArrayList<Person>();
    JSONObject obj = new JSONObject();
    private final static Scanner sc = new Scanner(System.in);
    public ArrayList<Person> addPersonInfo(Person details) {
        personInfoArrayList.add(details);
        return personInfoArrayList;
    }

    public void writeToJson(String filePath) throws IOException {
        for (Person person : personInfoArrayList) {
            obj.put("FirstName", person.getFirstName());
            obj.put("LastName", person.getLastName());
            obj.put("Phone", person.getPhoneNumber());
        }
        FileWriter file = new FileWriter(filePath);
        file.write(obj.toJSONString());
        file.flush();
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
        personInfoArrayList.forEach(p -> System.out.println(p));
    }
    public void deleteUsingName(){
        System.out.println("Enter first name of the person you want to delete");
        String nameinput=sc.nextLine();
        boolean flag=false;
        for(int index=0;index<personInfoArrayList.size();index++){
            if((personInfoArrayList.get(index).getFirstName().equalsIgnoreCase(nameinput))){
                personInfoArrayList.remove(index);
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("Name not found in addressbook");
        }
    }

   }


