package diary;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private static final String FILE_NAME = "diary.txt";

    public static void saveEntry(String entry) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true); // Append mode
            writer.write(entry + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving entry: " + e.getMessage());
        }
    }
}

