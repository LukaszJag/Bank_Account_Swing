package textFiles;

import fileOperations.FileCreator;
import fileOperations.WriteToFile;
import javax.swing.*;
import java.io.FileWriter;
import java.util.ArrayList;

public class AccountFileHandler {


    public static void openAccount(String[] data){

        String fileName = data[0] + "-" + data[1] + ".txt";
        FileCreator.fileCraetor(fileName);
        writeToAccount(fileName, data);
    }

    public static void writeToAccount(String fileName, String[] data){

        WriteToFile.writeToFile(fileName,data);

    }

    public static void deposit(String name, String lastName, double amount, String typeOfMoney )
    {


    }

    public static void searchUser(String name, String lastName){

    }

}
