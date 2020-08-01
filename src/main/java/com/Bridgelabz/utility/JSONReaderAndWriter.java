package com.Bridgelabz.utility;

import com.Bridgelabz.models.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.List;

public class JSONReaderAndWriter {

    public void writeAFile(List<Person>personList, String jsonFilePath) {
        JSONArray jsonArray = new JSONArray();
        personList.forEach(person -> {
            JSONObject personInformation = new JSONObject();
            personInformation.put("First Name", person.getFirstName());
            personInformation.put("Last Name", person.getLastName());
            personInformation.put("City", person.getCity());
            personInformation.put("State",person.getState());
            personInformation.put("Zip Code", person.getZipCode());
            personInformation.put("Phone Number", person.getPhoneNumber());
            JSONObject personObject =new JSONObject();
            personObject.put("person",personInformation);
            jsonArray.add(personObject);

        });
        try {
            FileWriter fileWriter = new FileWriter(jsonFilePath);
            fileWriter.write(jsonFilePath);
            fileWriter.append(jsonArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
