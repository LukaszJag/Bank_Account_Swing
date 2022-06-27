package textFiles;

import fileOperations.BasicFilesOperations;

public class AccountFileHandler {

    private BasicFilesOperations filesOperations = new BasicFilesOperations();

    public String getName(){

        return "Name doesn't exist";
    }

    public void openAccount(String[] data){

    }

    public double getbalance(char typeOfMoney){


        return -1;
    }

    public void deposit(String name, String lastName, double amount, char typeOfMoney )
    {
       /*
        find user and add deposit to his account
       */
    }
    public void withdraw(String name, String lastName, double amount, char typeOfMoney )
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
