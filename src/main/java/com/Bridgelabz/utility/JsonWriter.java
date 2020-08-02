package com.Bridgelabz.utility;

import com.Bridgelabz.models.Person;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonWriter {


    public void writeAFile(List<Person> personList, String jsonFilePath) {
        JSONArray jsonArray = new JSONArray();
        personList.forEach(person -> {
            JSONObject personInformation = new JSONObject();
            personInformation.put("First Name", person.getFirstName());
            personInformation.put("Last Name", person.getLastName());
            personInformation.put("City", person.getCity());
            personInformation.put("State", person.getState());
            personInformation.put("Zip Code", person.getZipCode());
            personInformation.put("Phone Number", person.getPhoneNumber());
            JSONObject personObject = new JSONObject();
            personObject.put("person", personInformation);
            jsonArray.add(personObject);

        });
        try {
            FileWriter fileWriter = new FileWriter(jsonFilePath);
            fileWriter.append(jsonArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> readFromFile(String jsonFilePath) {
        JSONParser jsonParser = new JSONParser();
        ArrayList<Person> personList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(jsonFilePath);
            Object parser = jsonParser.parse(fileReader);
            JSONArray personListArray = (JSONArray) parser;
            personListArray.forEach(person -> personList.add(parsePersonObject((JSONObject) person)));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return personList;
    }

    private Person parsePersonObject(JSONObject personJson) {
        JSONObject personObj = (JSONObject) personJson.get("person");
        return new Person((String) personObj.get("First Name"),
                (String) personObj.get("Last Name"), (String) personObj.get("City"),
                (String) personObj.get("State"), (String) personObj.get("Zip Code"),
                (String) personObj.get("Phone Number"));
    }

    public void writeAGSONfile(List<Person> personList, String jsonFilePath) {
        String personInformation = new Gson().toJson(personList);
        try {
            FileWriter fileWriter = new FileWriter(jsonFilePath);
            fileWriter.write(personInformation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readWithGson(List<Person> personList, String jsonFilePath) {
        try {
            Person[] personDetails = new Gson().fromJson(new FileReader(jsonFilePath), Person[].class);
            personList.addAll(Arrays.asList(personDetails));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
