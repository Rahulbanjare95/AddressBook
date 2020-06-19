package com.Bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchAccordingly {

    static Scanner sc =  new Scanner(System.in);
    public static void searchCityStateWise(Map<String, String> stateMapping, Map<String, String> cityMapping,
                                           String stateSearch, String citySearch) {
        List<String> matchedCity=cityMapping.entrySet().stream().
                filter(i ->citySearch.equals(i.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(matchedCity);

        List<String> matchedState=stateMapping.entrySet().stream().
                filter(j ->stateSearch.equals(j.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(matchedCity);
    }
    public void searchPersonByCity(ArrayList<Person> p){
        ArrayList<Person> personMatch=new ArrayList<Person>();
        System.out.println("Enter name you want to search");
        String tofind;
        int counter=0;
        tofind =sc.nextLine();
        for (Person pmatch:p) {

            if(pmatch.getCity().equals(tofind));
            {
                personMatch.add(pmatch);
                counter=1;
            }
        }
        if(counter==1){
            for (Person pmatch:personMatch) {
                System.out.println(pmatch);
            }
        }
        else
        {
            System.out.println("No match found");
        }

    }
    public static void searchPersonByState(ArrayList<Person>p){
        ArrayList<Person> personMatch=new ArrayList<Person>();
        System.out.println("Enter name you want to search");
        String tofindState;
        int counter=0;
        tofindState=sc.nextLine();
        for (Person pmatch:p) {

            if(pmatch.getState().equals(tofindState));
            {
                personMatch.add(pmatch);
                counter=1;
            }
        }
        if(counter==1){
            for (Person pmatch:personMatch) {
                System.out.println(pmatch);
            }
        }
        else
        {
            System.out.println("No match found");
        }


    }
}