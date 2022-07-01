package textFiles;

import GUI.DepositMoney;
import fileOperations.DepositToFile;
import fileOperations.FileCreator;
import fileOperations.WriteToFile;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountFileHandler {


    public static void openAccount(String[] data){

        String fileName = data[0] + "-" + data[1] + ".txt";
        FileCreator.createAndWriteToFile(fileName,data);

    }

    public static void writeToAccount(String fileName, String[] data){

        WriteToFile.writeToFile(fileName,data);

    }

    public static void deposit(String name, String lastName, double amount, String typeOfMoney )
    {
        DepositToFile.depositMoney(name,lastName,amount, typeOfMoney);

    }
    public static void openAccountToFile(String name, String lastName){
        WriteToFile.writeToFileAppend(name + "-" + lastName, "AllNameAndLastName.txt");
    }


    public static boolean searchUser (String name, String lastName) {
        File file = new File(name, lastName);

        try {

            Scanner fileReader = new Scanner(file);

            while(fileReader.hasNextLine()){
                System.out.println(fileReader.nextLine());
            }

            System.out.println();
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        }

        return false;

    }

}
