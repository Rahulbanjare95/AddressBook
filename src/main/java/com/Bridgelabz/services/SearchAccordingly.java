package com.Bridgelabz.services;
import com.Bridgelabz.models.Person;

import java.util.*;
import java.util.stream.Collectors;

public class SearchAccordingly {
    static Scanner sc =  new Scanner(System.in);
   public static void viewCityStateWise(ArrayList<Person>personInfo) {
       boolean flag =false;
       Map<String,Person> citywithPerson=new HashMap<>();
       Map<String,Person> statewithPerson=new HashMap<>();
       for (Person p:personInfo) {
           citywithPerson.put(p.getCity(),p);
           statewithPerson.put(p.getCity(),p);
       }
       System.out.println("Enter the city name to view");
       String viewByCity=sc.nextLine();
       System.out.println("Enter the state name to view");
       String viewByState=sc.nextLine();
//       for (Map.Entry<String,Person> state:statewithPerson.entrySet()){
//           if(viewByState.equals(state.getKey())){
//               for (Map.Entry<String,Person>city:citywithPerson.entrySet()){
//                   if(viewByCity.equals(city.getKey())){
//                       System.out.println(city.getValue());
//                       flag=true;
//                   }
//               }
//           }
//       }
//       if(!flag){
//           System.out.println("Enter matching city with state");
//       }
//   }
        List<Map.Entry<String, Person>> matchedCity= citywithPerson.entrySet().stream().
                filter(i ->viewByCity.equals(i.getValue())).collect(Collectors.toList());
        System.out.println(matchedCity);

        List<Map.Entry<String, Person>> matchedState= statewithPerson.entrySet().stream().
                filter(j ->viewByState.equals(j.getValue())).collect(Collectors.toList());
        System.out.println(matchedState);
    }

    public static void searchPersonByCity(ArrayList<Person> personInfo) {
        boolean flag =false;
        Map<String,Person> citywithPerson=new HashMap<String,Person>();
        for (Person p:personInfo) {
            citywithPerson.put(p.getCity(),p);
        }
        System.out.println("Enter city name to get person from");
        String citysearch=sc.nextLine();
        System.out.println("Enter person name to search in = "+citysearch);
        String personname=sc.nextLine();
        for (Map.Entry<String,Person>city:citywithPerson.entrySet()){
            if(citysearch.equalsIgnoreCase(city.getKey())){
                if((city.getValue().getFirstName().equalsIgnoreCase(personname))){
                    System.out.println(city.getValue());
                    flag=true;
                }
            }
        }
        if(!flag){
            System.out.println("No matching city and person");
        }
   }
}