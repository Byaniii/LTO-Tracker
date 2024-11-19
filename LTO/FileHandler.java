package LTO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileHandler {
    private static final String VEHICLE_DATA_FILE = "LTO/vehicle_registration_data.txt";
    private static final String USER_CREDENTIALS_FILE = "LTO/user_credentials.txt";

    // Method to save vehicle data
    public static void saveData(List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(VEHICLE_DATA_FILE, true))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to save user credentials
    public static void saveUserCredentials(List<String> credentials) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_CREDENTIALS_FILE, true))) {
            for (String credential : credentials) {
                writer.write(credential);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
