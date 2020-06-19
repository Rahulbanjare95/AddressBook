package com.Bridgelabz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortAddressBook {
    public static  void sortByFirstName(ArrayList<Person>p){
        Collections.sort(p,Person.nameSort);
        for (Person psort:p){
            System.out.println(psort);
        }
    }
    public static void sortByCity(ArrayList<Person>p){
        Collections.sort(p,Person.citySort);
        for (Person psort:p){
            System.out.println(psort);
        }

    }


}
