package com.Bridgelabz.databaseUtility;

import com.Bridgelabz.services.AddressBookDatabase;

import java.sql.SQLException;
import java.util.Scanner;

public class DataBaseOperations {

    AddressBookDatabase addressBookDatabase= new AddressBookDatabase();
    Scanner scanner = new Scanner(System.in);
    public void operations() throws SQLException {
        System.out.println("Enter the number to do your operation\n"
                + "\t1: Display records\n"
                + "\t2: Add new Person in Database\n"
                + "\t3: Edit a record in Database\n"
                + "\t4: Delete a record in Database\n"
                + "\t5. Sort \n"
                + "\t6. Exit \n");

        int flag = 0;
        while( flag==0){
            int options = scanner.nextInt();
            switch ( options){
                case 1:
                    addressBookDatabase.getRecords();
                    break;
                case 2:
                    addressBookDatabase.addRecordsTODatabase();
                    break;
                case 3:
                    addressBookDatabase.editDetailsInDatabase();
                    break;
                case 4:
                    addressBookDatabase.deleteRecord();
                    break;
                case 5:
                    addressBookDatabase.sortDatabase();
                    addressBookDatabase.getRecords();
                    break;
                case 6:
                    flag = 1;
                    break;
            }
        }
    }


}
