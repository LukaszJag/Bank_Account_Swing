package textFiles;

import GUI.DepositMoney;
import fileOperations.DepositToFile;
import fileOperations.FileCreator;
import fileOperations.WriteToFile;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountFileHandler {


    public static void openAccount(String[] data) {

        String fileName = data[0] + "-" + data[1] + ".txt";
        FileCreator.createAndWriteToFile(fileName, data);

    }

    public static void writeToAccount(String fileName, String[] data) {

        WriteToFile.writeToFile(fileName, data);

    }

    public static void deposit(String name, String lastName, double amount, String typeOfMoney) {
        DepositToFile.depositMoney(name, lastName, amount, typeOfMoney);

    }

    public static void openAccountToFile(String name, String lastName) {
        WriteToFile.writeToFileAppend(name + "-" + lastName, "AllNameAndLastName.txt");
    }


    public static boolean searchUser(String name, String lastName) {
        String line = "";
        String[] arrayNameAndLastName;
        File file = new File("src/textFiles/AllNameAndLastName.txt");


        try {

            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {

                line = fileReader.nextLine();
                arrayNameAndLastName = line.split("-", 0);
                if (arrayNameAndLastName[0].equals(name)) {
                    if (arrayNameAndLastName[1].equals(lastName)) {
                        return true;
                    }
                }


            }

            System.out.println();
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        }

        return false;

    }

    public static void setBalance(String name, String lastName, double amount, String typeOfMoney) {
        String pathAndNameOfFile = "src/textFiles/" + name + "-" + lastName + ".txt";
        File file = new File(pathAndNameOfFile);
        String[] array = new String[20];
        double tmp = 0;
        try {
            Scanner fileReader = new Scanner(file);
            int counter = 0;
            while (fileReader.hasNextLine()) {
                array[counter] = fileReader.nextLine();
                counter++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (typeOfMoney.equals("Euro")) {
            tmp = Double.parseDouble(array[3]) + amount;
            array[3] = String.valueOf(tmp);
        }
        if (typeOfMoney.equals("Dollar")) {
            tmp = Double.parseDouble(array[4]) + amount;
            array[4] = String.valueOf(tmp);
        }
        if (typeOfMoney.equals("Zloty")) {
            tmp = Double.parseDouble(array[5]) + amount;
            array[5] = String.valueOf(tmp);
        }


        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(pathAndNameOfFile, false);
            for (int i = 0; i < array.length; i++) {
                myWriter.write(array[i] + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean isActive(String name, String lastName){
        boolean isActive= false;

        return isActive;
    }

    public static void closeAccount(String name, String lastName) {
        String pathAndNameOfFile = "src/textFiles/" + name + "-" + lastName + ".txt";
        File file = new File(pathAndNameOfFile);
        String[] array = new String[20];
        double tmp = 0;
        try {
            Scanner fileReader = new Scanner(file);
            int counter = 0;
            while (fileReader.hasNextLine()) {
                array[counter] = fileReader.nextLine();
                counter++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        array[2] = "frozen";

        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(pathAndNameOfFile, false);
            for (int i = 0; i < array.length; i++) {
                myWriter.write(array[i] + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean unBalance(String name, String lastName, double amount, String typeOfMoney) {
        String pathAndNameOfFile = "src/textFiles/" + name + "-" + lastName + ".txt";
        File file = new File(pathAndNameOfFile);
        String[] array = new String[20];
        double tmp = 0;
        try {
            Scanner fileReader = new Scanner(file);
            int counter = 0;
            while (fileReader.hasNextLine()) {
                array[counter] = fileReader.nextLine();
                counter++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (typeOfMoney.equals("Euro")) {
            tmp = Double.parseDouble(array[3]) - amount;
            if (tmp < 0) {
                return false;
            }
            array[3] = String.valueOf(tmp);
        }
        if (typeOfMoney.equals("Dollar")) {
            tmp = Double.parseDouble(array[4]) - amount;
            if (tmp < 0) {
                return false;
            }
            array[4] = String.valueOf(tmp);
        }
        if (typeOfMoney.equals("Zloty")) {
            tmp = Double.parseDouble(array[5]) - amount;
            if (tmp < 0) {
                return false;
            }
            array[5] = String.valueOf(tmp);
        }


        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(pathAndNameOfFile, false);
            for (int i = 0; i < array.length; i++) {
                myWriter.write(array[i] + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }

}

