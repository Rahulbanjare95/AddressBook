package com.Bridgelabz;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {
    ArrayList<Person>al = new ArrayList<Person>();
    public void addPerson(){
        Scanner sc= new Scanner(System.in);
        String n = sc.nextLine();

        System.out.println("Enter new FirstName");
        String firstname=sc.nextLine();
        System.out.println("Enter new LastName");
        String lastname=sc.nextLine();
        System.out.println("Enter new City");
        String city=sc.nextLine();
        System.out.println("Enter new State");
        String state=sc.nextLine();
        System.out.println("Enter new ZipCode");
        int zipcode=sc.nextInt();
        System.out.println("Enter new PhoneNumber");
        String phoneNumber=sc.nextLine();

        System.out.println("Added new Person");

        Person p =new Person(firstname,lastname,city,state,zipcode,phoneNumber);
        al.add(p);
    }
    public void display(){

        System.out.println(al);
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome to AddressBook ");

        AddressBookMain m = new AddressBookMain();
        m.addPerson();
        m.display();






    }
}
