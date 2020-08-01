package com.Bridgelabz.services;
import com.Bridgelabz.models.Person;

import java.util.ArrayList;
import java.util.Comparator;

public class SortAddressBook {

    public static  void sortByFirstName(ArrayList<Person>personInfo){
        personInfo.sort(Comparator.comparing(Person::getFirstName));
        printAllSorted(personInfo,element->true);
    }
    public static void sortByCity(ArrayList<Person>personInfo){
        personInfo.sort(Comparator.comparing(Person::getCity));
        printAllSorted(personInfo,element->true);
    }
    public static void sortByZip(ArrayList<Person>personInfo) {
        personInfo.sort(Comparator.comparing(Person::getZipCode));
        printAllSorted(personInfo,element->true);
    }
    public static void sortByState(ArrayList<Person>personInfo){
        personInfo.sort(Comparator.comparing(Person::getState));
        printAllSorted(personInfo,element->true);
    }
    public static void printAllSorted(ArrayList<Person> people, Checker c){
        people.stream().filter(c::test).forEachOrdered(System.out::println);
    }
}
interface Checker {
    boolean test(Person p);
}