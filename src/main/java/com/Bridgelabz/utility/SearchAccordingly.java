package com.Bridgelabz.utility;
import com.Bridgelabz.models.Person;

import java.util.*;
import java.util.stream.Collectors;

public class SearchAccordingly {

   public static void viewCityStateWise(ArrayList<Person>personInfo) {
       Scanner scanner =  new Scanner(System.in);
       System.out.println("Enter State ");
       String state = scanner.nextLine();
       System.out.println("Enter city ");
       String city = scanner.nextLine();

    List<Person> cityAndStateList = personInfo.stream().filter(info -> info.getCity().equals(city)
            && info.getState().equals(state)).collect(Collectors.toList());
    cityAndStateList.forEach(person -> System.out.println("Person :"+person.getFirstName()+" "+person.getLastName()));
    if (cityAndStateList.size() == 0)
        System.out.println("No records found");
   }
    public static void viewPersonByCityOrState(ArrayList<Person> personInfo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter state ");
        String state = scanner.nextLine();
        System.out.println("Enter City");
        String city = scanner.nextLine();
        List<Person> cityList = personInfo.stream()
                .filter(info -> info.getCity().equals(city))
                .collect(Collectors.toList());
        cityList.forEach(personInCity -> System.out.println(personInCity.getFirstName()+" "+personInCity.getLastName()
                +" "+" State: "+personInCity.getState()));
        if (cityList.size() == 0)
            System.out.println("Person Not present");
        List<Person> stateList = personInfo.stream().filter(info -> info.getState().equals(city)).collect(Collectors.toList());
        stateList.forEach(person -> System.out.println(person.getFirstName()+" "+person.getLastName()+" "+" city: "+person.getCity()));

    }
}