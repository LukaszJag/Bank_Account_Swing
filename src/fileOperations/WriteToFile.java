package fileOperations;

import java.io.IOException;

public class WriteToFile {

    private  static String location = "src/textFile/";
    public static void writeToFile(String nameOfFile, String[] lines) {

        String PathAndNameOfFile = location + nameOfFile;

        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(PathAndNameOfFile, true);
            for(int i = 0; i < lines.length; i++) {
                myWriter.write(lines[i] + "\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
