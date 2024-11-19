package LTO;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FindHandler {
    private static final String ADMIN_FILE = "LTO/admin_credentials.txt";
    private static final String USER_FILE = "LTO/user_credentials.txt";

    // Method to load credentials from the appropriate file
    private static Map<String, String> loadCredentials(String fileName) {
        Map<String, String> credentials = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    credentials.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }

    // Method to verify admin login credentials
    public static boolean verifyAdmin(String username, String password) {
        Map<String, String> adminCredentials = loadCredentials(ADMIN_FILE);
        return adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password);
    }

    // Method to verify user login credentials
    public static boolean verifyUser(String username, String password) {
        Map<String, String> userCredentials = loadCredentials(USER_FILE);
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }
}
