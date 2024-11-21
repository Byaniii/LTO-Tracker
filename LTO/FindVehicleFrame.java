package LTO;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindVehicleFrame extends JFrame {
    private CustomTextField VehiclePlateNumber_Field;
    private CustomTextField OwnerName_Field;
    private CustomTextField RegistrationNumber_Field;

    public FindVehicleFrame() {
        setTitle("Find Vehicle");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Header
        JLabel headerLabel = new JLabel("FIND VEHICLE", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setBounds(150, 20, 500, 40);
        add(headerLabel);

        // Vehicle Plate Number
        JLabel plateNumberLabel = new JLabel("VEHICLE PLATE NUMBER");
        plateNumberLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        plateNumberLabel.setBounds(100, 100, 300, 30);
        add(plateNumberLabel);

        VehiclePlateNumber_Field = CustomTextField.createTextField(100, 130, 600, 40);
        add(VehiclePlateNumber_Field);

        // Owner's Name
        JLabel ownerNameLabel = new JLabel("OWNER'S NAME");
        ownerNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        ownerNameLabel.setBounds(100, 200, 300, 30);
        add(ownerNameLabel);

        OwnerName_Field = CustomTextField.createTextField(100, 230, 600, 40);
        add(OwnerName_Field);

        // Registration Number
        JLabel registrationNumberLabel = new JLabel("REGISTRATION NUMBER");
        registrationNumberLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        registrationNumberLabel.setBounds(100, 300, 300, 30);
        add(registrationNumberLabel);

        RegistrationNumber_Field = CustomTextField.createTextField(100, 330, 600, 40);
        add(RegistrationNumber_Field);

        // Note
        JLabel noteLabel = new JLabel("NOTE: You may use any of the following methods to search for vehicle", SwingConstants.CENTER);
        noteLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        noteLabel.setForeground(Color.RED);
        noteLabel.setBounds(50, 400, 700, 30);
        add(noteLabel);

        // "Main Menu" button
        CustomButton mainMenuButton = CustomButton.createRedButton("MAIN MENU", 50, 500, 150, 50, 20);
        mainMenuButton.addActionListener(e -> {
            new AdminFrame();
            dispose();
        });
        add(mainMenuButton);

        // "Search" button
        CustomButton searchButton = CustomButton.createRedButton("SEARCH", 600, 500, 150, 50, 20);
        searchButton.addActionListener(e -> searchVehicle());
        add(searchButton);

        setVisible(true);
    }

    private void searchVehicle() {
        String ownerNameInput = OwnerName_Field.getText().trim().toLowerCase();
        boolean found = false;
        StringBuilder vehicleData = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("LTO/vehicle_registration_data.txt"))) {
            String line;
            String currentOwner = ""; // To store the current owner being checked
            boolean captureLines = false;
            int linesCaptured = 0;

            while ((line = reader.readLine()) != null) {
                // Check if the line contains the owner's name
                if (line.startsWith("Name of Vehicle Owner: ")) {
                    currentOwner = line.replace("Name of Vehicle Owner: ", "").trim();
                    String[] nameParts = currentOwner.toLowerCase().split("\\s+");

                    // Reset capturing and check for match using Levenshtein
                    captureLines = false;
                    linesCaptured = 0;

                    for (String part : nameParts) {
                        if (levenshteinDistance(part, ownerNameInput) <= 3) { // Match with Levenshtein distance
                            captureLines = true;
                            found = true;
                            vehicleData.setLength(0); // Clear data for new match
                            vehicleData.append(line).append("\n");
                            break;
                        }
                    }
                    continue; // Skip further processing for this line
                }

                // If capturing lines, append the current line
                if (captureLines && linesCaptured < 18) {
                    vehicleData.append(line).append("\n");
                    linesCaptured++;
                }

                // Stop capturing after capturing 18 lines
                if (linesCaptured >= 18) {
                    captureLines = false; // Reset capturing
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading vehicle details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Display results or show a "no match" message
        if (found) {
            new VehicleDetailsFrame(vehicleData.toString());
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No matching vehicle details found.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Helper method for Levenshtein Distance
    private int levenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1)
                    );
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

}
