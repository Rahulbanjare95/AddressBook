package com.Bridgelabz.utility;

import java.util.Scanner;

public class UserInputs {

    Scanner scanner = new Scanner(System.in);
    public int editMenu(){
        System.out.println("Enter the number to edit desired fields\n"
                + "\t1: city\n"
                + "\t2: State\n"
                + "\t3: Phone\n"
                + "\t4: Zip Code\n"
                + "\t5. Save And Exit\n");
        return scanner.nextInt();
    }
    public int sortMenu(){
        System.out.println("Enter the number to Sort by fields\n"
                + "\t1: FirstName\n"
                + "\t2: State\n"
                + "\t3: Phone\n"
                + "\t4: Zip Code\n"
                + "\t5. Exit\n");
        return scanner.nextInt();

    }
}
