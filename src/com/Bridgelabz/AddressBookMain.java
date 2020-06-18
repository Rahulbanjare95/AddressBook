package com.Bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain{
    ArrayList<Person>personInfoArrayList=new ArrayList<Person>();
    private final static Scanner sc = new Scanner(System.in);
    public void addPersonInfo(){
        System.out.println("Press First name");
        String firstName=sc.nextLine();
        System.out.println("Press Last name");
        String lastName=sc.nextLine();
        System.out.println("Press City");
        String city=sc.nextLine();
        System.out.println("Press State");
        String state=sc.nextLine();
        System.out.println("Press zipCode");
        String zipCode=sc.nextLine();
        System.out.println("Press PhoneNumber");
        String phoneNumber=sc.nextLine();
        Person p = new Person(firstName,lastName,city,state,zipCode,phoneNumber);
        personInfoArrayList.add(p);

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
            System.out.println("Press 1 for editing city");
            System.out.println("Press 2 for editing state");
            System.out.println("Press 3 for editing zipCode");
            System.out.println("Press 4 for editing phone number");
            System.out.println("Press 5 to Exit");
            int selector=sc.nextInt();
            sc.nextLine();
            switch (selector) {
                case 1:
                    System.out.println("enter new city");
                    String city=sc.nextLine();
                    editPersonArray.setCity(city);
                    break;
                case 2:
                    System.out.println("enter new state");
                    String state=sc.nextLine();
                    editPersonArray.setState(state);
                    break;
                case 3:
                    System.out.println("enter new zipCode");
                    String zipCode=sc.nextLine();
                    editPersonArray.setZipCode(zipCode);
                    break;
                case 4:
                    System.out.println("enter new phone number");
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
        System.out.println("Enter the first name of the person you want to delete");
        String nameinput=sc.nextLine();
        for(Person p:personInfoArrayList)
        {
            if(p.getFirstName().equals(nameinput))
            {
                personInfoArrayList.remove(p);
            }
            else
                System.out.println("No name found");
        }
    }

    public static void main(String[] args)
    {
        boolean counter=false;
        AddressBookMain ad=new AddressBookMain();
        do{
            System.out.println("Press 1 - Add Person Information");
            System.out.println("Press 2 - Edit Person Information");
            System.out.println("Press 3 - Delete Person by name");
            System.out.println("Press 4 - Exit");
            int option=sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    ad.addPersonInfo();
                    ad.displayAddressBook();
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
                    System.out.println(ad);
                    counter=true;
                    break;

            }
        }while (!counter);
        ad.displayAddressBook();

    }
}

