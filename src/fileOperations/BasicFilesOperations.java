package fileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class BasicFilesOperations {

    private static String fileLocation = "src/textFiles/";
    private static String fileName = "accountsData.txt";
    private static String fullFilePathAndName = fileLocation + fileName;

    public static ArrayList readAllLines() {
        ArrayList lines = new ArrayList();
        String line = "";

        try {
            File file = new File(fullFilePathAndName);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {

                line = reader.nextLine();
                lines.add(line);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return lines;

    }


    public static void writeToFile(String line) {
        String lineToFile;

        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(fullFilePathAndName, true);
            myWriter.write("\n" + line);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
