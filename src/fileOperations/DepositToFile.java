package fileOperations;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class DepositToFile {

    public static String location = "src/textFiles/";

    public static void depositMoney(String name, String lastName, double amountOfMoney, String typeOfMoney){
        String nameOfFile = name + "-" + lastName + ".txt";
        String PathAndNameOfFile = location + nameOfFile;

    }
}
