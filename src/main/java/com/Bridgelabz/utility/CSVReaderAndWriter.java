package com.Bridgelabz.utility;

import com.Bridgelabz.models.Person;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CSVReaderAndWriter {

    public void writeToCSVFile(List<Person> personList, String filePath) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(filePath))) {
            StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(personList);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }

    public List<Person> readFromCSV(List<Person> personList, String filePath) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(filePath));
            CSVReader csvReader = new CSVReader(reader);
            String[] persons = csvReader.readNext();
            while ((persons = csvReader.readNext()) != null) {
                personList.add(new Person(persons[1], persons[0], persons[2], persons[4], persons[3], persons[5]));

            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return personList;
    }
}



