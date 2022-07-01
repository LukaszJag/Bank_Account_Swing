package textFiles;

import fileOperations.BasicFilesOperations;

public class AccountFileHandler {

    private BasicFilesOperations filesOperations = new BasicFilesOperations();

    public String getName(){

        return "Name doesn't exist";
    }

    public static void openAccount(String[] data){
        String lineToFile = "";

        lineToFile = lineToFile + data[0] + "#" + data [1] + "#" + "active" + "#";

        String [] money = {"euro", "dollars", "zloty"};

        for (int i = 0; i < 3; i++) {
            lineToFile = lineToFile + data[i+2] + "#" + money[i] +"#";
        }

        BasicFilesOperations.writeToFile(lineToFile);
    }

    public double getbalance(char typeOfMoney){


        return -1;
    }

    public static void deposit(String name, String lastName, double amount, String typeOfMoney )
    {


    }

    public int searchUser(String name, String lastName){
        int line = -1;


        return line;
    }
    public void withdraw(String name, String lastName, double amount, String typeOfMoney )
    {
       /*
        find user and add withdraw to his account
       */
    }
    public void setBalance(String name, String lastName, double amount, char typeOfMoney)
    {
        /*
        find user and add set ballance to his account
       */
    }
}
