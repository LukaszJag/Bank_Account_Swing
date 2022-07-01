package textFiles;

import fileOperations.BasicFilesOperations;

import javax.swing.*;
import java.util.ArrayList;

public class AccountFileHandler {

    private BasicFilesOperations filesOperations = new BasicFilesOperations();

    public static void openAccount(String[] data){
        String lineToFile = "";

        lineToFile = lineToFile + data[0] + "#" + data [1] + "#" + "active" + "#";

        String [] money = {"euro", "dollars", "zloty"};

        for (int i = 0; i < 3; i++) {
            lineToFile = lineToFile + data[i+2] + "#" + money[i] +"#";
        }

        BasicFilesOperations.writeToFile(lineToFile);
    }


    public static void deposit(String name, String lastName, double amount, String typeOfMoney )
    {
        if(searchUser(name, lastName) == -1){
            JOptionPane.showMessageDialog(null,"Account doesn't exist");
        }else{
            int line = searchUser(name, lastName);
            System.out.println(line);

        }

    }

    public static int searchUser(String name, String lastName){
        int line = -1;
        int counter = -1;
        boolean nameFound = false;
        boolean lastNameFound = false;
        boolean getMatch = false;
        String stringLine;
        String[] arrayStringLine;

        ArrayList allAccountText = BasicFilesOperations.readAllLines();
        ArrayList onlyNameAndLastName;

        for (int i = 0; i < allAccountText.size(); i++) {
            counter++;

            stringLine = (String) allAccountText.get(i);
            arrayStringLine = stringLine.split("#",0);
            if(arrayStringLine[0].equals(name)){
                nameFound = true;
            }

            if(arrayStringLine[1].equals(lastName)){
                lastNameFound = true;
            }

            if ((lastNameFound == true) &&(lastNameFound == true)){
                getMatch = true;
                line = counter;
            }

        }

        return line;
    }

}
