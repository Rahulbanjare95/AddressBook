package com.Bridgelabz;

    import java.util.ArrayList;
    import java.util.Scanner;


public class AddressBookMain {
    Scanner sc = new Scanner(System.in);
    ArrayList<Person> arrayListPerson = new ArrayList<Person>();
    Person p = new Person("", "", "", "", "", "");
    int choice = 0;
    // Person p;

    public void addPerson() {
        System.out.println("Enter new FirstName");
        String firstname = sc.nextLine();
        p.setFirstName(firstname);

        System.out.println("Enter new LastName");
        String lastname = sc.nextLine();
        p.setLastName(lastname);
        System.out.println("Enter new City");
        String city = sc.nextLine();
        p.setCity(city);
        System.out.println("Enter new State");
        String state = sc.nextLine();
        p.setState(state);
        System.out.println("Enter new ZipCode");
        String zipcode = sc.nextLine();
        p.setZipCode(zipcode);
        System.out.println("Enter new PhoneNumber");
        String phoneNumber = sc.nextLine();
        p.setPhoneNumber(phoneNumber);
        System.out.println("Added new Person");


        arrayListPerson.add(p);

    }

    public void display() {
        for (Person person : arrayListPerson) {

            System.out.println(arrayListPerson);
        }

    }

    public void editPerson() {

        //Person editdetails = new Person(" ", " ", " ", " ", " ", "");
        System.out.println("Enter the phone number to match and edit");
        String newNumber = sc.nextLine();

        //for (Person person : arrayListPerson) {
        if (arrayListPerson.get(0).getPhoneNumber().equals(newNumber)) {
            System.out.println("Enter  1 to edit city ");
            System.out.println("Enter  2 to edit State ");
            System.out.println("Enter  3 to edit Zip ");
            System.out.println("Enter  4 to edit Phone Number ");
            System.out.println("Enter  5 to EXIT ");
            System.out.println("Enter  your choice ");
            int choice = sc.nextInt();
            System.out.println("you choose - " + choice);
            boolean cont=true;
            while (cont==true) {
                switch (choice) {
                    case 1:
                        System.out.println("Enter new City");
                        String newCity = sc.nextLine();
                        p.setCity(newCity);
                        cont=false;
                        break;

                    case 2:
                        System.out.println("Enter new State");
                        String newState = sc.nextLine();
                        p.setState(newState);
                        cont=false;
                        break;
                    case 3:
                        System.out.println("Enter new ZipCode");
                        String newZipCode = sc.nextLine();
                        p.setZipCode(newZipCode);
                        cont=false;
                        break;
                    case 4:
                        System.out.println("Enter new PhoneNumber");
                        String newPhoneNumber = sc.nextLine();
                        p.setPhoneNumber(newPhoneNumber);
                        cont=false;
                        break;

                    case 5:
                        System.out.println("exit ");
                        cont=false;
                        break;
                    default:
                        System.out.println("Enter the choice in given range");
                        break;
                }
            }
            arrayListPerson.add(p);

        }
    }


        public static void main(String args[])

        {
            // write your code here
            System.out.println("Welcome to AddressBook ");
            AddressBookMain m = new AddressBookMain();
            Scanner s = new Scanner(System.in);
            System.out.println("Enter the options ");
/*
        System.out.println("Enter 1 to create addressbook");
        System.out.println("Enter 2 to edit addressbook");
        System.out.println("Enter 3 to sort addressbook alphabetically");
        System.out.println("Enter 4 to view addressbook by City and State");
        System.out.println("Enter 5 to sort by city or State");
        System.out.println("Enter 6 to  search person by city");
        System.out.println("Enter 7 to quit");
        int option=s.nextInt();
        switch (option){
            case 1:
                System.out.println("Enter Person details");
                m.addPerson();
                m.display();
                break;
            case 2:
                System.out.println("Enter the choice to edit");
                m.editPerson();
                m.display();
                break;
            case 3:
                System.out.println("Sorting alphabetically");
                break;
            case 4:
                System.out.println("View By city and state");
                break;
            case  5:
                System.out.println("Sort by city or state");
                break;
            case 6:
                System.out.println("Search a person by city");
                break;
            case 7:
                System.out.println("Quitiing");
                break;
        }*/
            m.addPerson();
            m.display();
            m.editPerson();
            m.display();


        }
    }
