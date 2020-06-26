package com.Bridgelabz;
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
        for (Person p:people) {
            if (c.test(p)){
                System.out.println(p);
            }
        }
    }
}
interface Checker {
    boolean test(Person p);
}