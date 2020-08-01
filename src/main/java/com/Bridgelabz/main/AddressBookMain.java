package com.Bridgelabz.main;
import com.Bridgelabz.models.Person;
import com.Bridgelabz.services.AddressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain{
    public static ArrayList<Person> personInfoArrayList=new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        AddressBook ad=new AddressBook();

        while (true) {
            System.out.println("Press 1 - Add Person Information");
            System.out.println("Press 2 - Edit Person Information");
            System.out.println("Press 3 - Delete Person by name");
            System.out.println("Press 4 - Sort by firstName");
            System.out.println("Press 5 - Sort by City");
            System.out.println("Press 6 - Sort by State");
            System.out.println("Press 7 - Sort by zipCode");
            System.out.println("Press 8 - View by City State");
            System.out.println("Press 9 - Save to JSON");
            System.out.println("Press 10 - Save to CSV");
            System.out.println("Press 11 - read  CSV");
            System.out.println("Press 12 - Save to GSON");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    ad.addPersonInfo(personInfoArrayList);
                    ad.displayAddressBook(personInfoArrayList);
                    break;
                case 2:
                    ad.displayAddressBook(personInfoArrayList);
                    ad.editperson(personInfoArrayList);
                    ad.displayAddressBook(personInfoArrayList);
                    break;
                case 3:
                    ad.deleteUsingName(personInfoArrayList);
                    ad.displayAddressBook(personInfoArrayList);
                    break;
                case 4:
                    System.out.println("Sorting by firstName");
                    ad.sortByFirstName(personInfoArrayList);
                    break;
                case 5:
                    System.out.println("Sorting by city");
                    ad.sortByCity(personInfoArrayList);
                    break;
                case 6:
                    System.out.println("Sorting by state");
                    ad.sortByState(personInfoArrayList);
                    break;
                case 7:
                    System.out.println("Sorting by ZipCode");
                    ad.sortByZipCode(personInfoArrayList);
                    break;

                case 8:
                    System.out.println("View by City And State");
                    ad.viewPersonByCityAndState(personInfoArrayList);
                    break;
                case 9:
                    System.out.println("Save to JSON");
                    ad.writeJSON(personInfoArrayList);
                    break;
                case 10:
                    System.out.println("Save to CSV");
                    ad.writeCsv(personInfoArrayList);
                    break;
                case 11:
                    System.out.println("Read CSV");
                    ad.writeCsv(personInfoArrayList);
                    ad.readCSV(personInfoArrayList);
                case 12:
                    System.out.println("Save to JSON with GSON Library");
                    ad.writeJSONUsingGSON(personInfoArrayList);
                default:
                    System.out.println("Enter correct choice");
                    break;
            }
        }
    }
}