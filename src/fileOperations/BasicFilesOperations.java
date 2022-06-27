package fileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class BasicFilesOperations {

    private static String fileLocation = "src/textFiles/";
    private static String fileName = "accountData.txt";
    private static String fullFilePathAndName = fileLocation + fileName;

    public void readData(){
        int line = 0;
        String currentLine = "";

        try{
            File file = new File(fullFilePathAndName);
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()){
                line ++;
                currentLine = reader.nextLine();
                System.out.println(currentLine);

            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public static void writeToFile(){
        String lineToFile;
        Scanner input = new Scanner(System.in);

        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(fullFilePathAndName, true);
            System.out.println("Now you write in: " + fileName + " file");
            System.out.println("To save and exit input: x");

            lineToFile = input.nextLine();
            System.out.println("First line:" +"\n" + lineToFile);
            while (lineToFile.charAt(0) != 'x') {

                myWriter.write(lineToFile + "\n");
                lineToFile = input.nextLine();
                System.out.println(lineToFile);
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
