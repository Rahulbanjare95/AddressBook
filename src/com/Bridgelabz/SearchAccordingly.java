package com.Bridgelabz;
import java.util.*;

public class SearchAccordingly {
    static Scanner sc =  new Scanner(System.in);
   public static void viewCityStateWise(ArrayList<Person>personInfo) {
       boolean flag =false;
       Map<String,Person> citywithPerson=new HashMap<String,Person>();
       Map<String,Person> statewithPerson=new HashMap<String,Person>();
       for (Person p:personInfo) {
           citywithPerson.put(p.getCity(),p);
           statewithPerson.put(p.getCity(),p);
       }
       System.out.println("Enter the city name to view");
       String viewByCity=sc.nextLine();
       System.out.println("Enter the state name to view");
       String viewByState=sc.nextLine();
       for (Map.Entry<String,Person> state:statewithPerson.entrySet()){
           if(viewByState.equals(state.getKey())){
               for (Map.Entry<String,Person>city:citywithPerson.entrySet()){
                   if(viewByCity.equals(city.getKey())){
                       System.out.println(city.getValue());
                       flag=true;
                   }
               }
           }
       }
       if(!flag){
           System.out.println("Enter matching city with state");
       }
   }
//        List<String> matchedCity=cityMapping.entrySet().stream().
//                filter(i ->citySearch.equals(i.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
//        System.out.println(matchedCity);
//
//        List<String> matchedState=stateMapping.entrySet().stream().
//                filter(j ->stateSearch.equals(j.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
//        System.out.println(matchedCity);
//    }

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