package com.Bridgelabz.services;

import com.Bridgelabz.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchAddressBook {

    public static void viewCityStateWise(ArrayList<Person> personInfo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter State ");
        String state = scanner.nextLine();
        System.out.println("Enter city ");
        String city = scanner.nextLine();

        List<Person> cityAndStateList = personInfo.stream().filter(info -> info.getCity().equals(city)
                && info.getState().equals(state)).collect(Collectors.toList());
        cityAndStateList.forEach(person -> System.out.println("Person :" + person.getFirstName() + " " + person.getLastName()));
        if (cityAndStateList.size() == 0)
            System.out.println("No records found");
    }
}