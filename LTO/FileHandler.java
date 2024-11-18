package LTO;

import java.io.*;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "LTO/vehicle_registration_data.txt";

    // Method to save data to a file
    public static void saveData(List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
