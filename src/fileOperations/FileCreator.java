package fileOperations;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    public static String location = "src/textFiles/";

    public static void fileCraetor(String fileName){
        String fileFullData = location + fileName;

        try {
            File file = new File(fileFullData);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
