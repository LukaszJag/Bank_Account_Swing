package fileOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public static void readFileLineByLine(String pathAndName){

        File file = new File(pathAndName);

        try {

            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()){
                System.out.println(fileReader.nextLine());
            }
            System.out.println();
        } catch (FileNotFoundException e) {

            throw new RuntimeException(e);

        }

    }
}
