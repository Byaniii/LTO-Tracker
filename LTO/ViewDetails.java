package LTO;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewDetails extends JFrame {
    private JPanel bodyPanel;

    public ViewDetails(String viewType, String username, String dateOfBirth, UserFrame userFrame) {
        setTitle("LTO Tracker - " + viewType);
        setSize(1400, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.RED);
        headerPanel.setPreferredSize(new Dimension(1400, 100));
        JLabel headerLabel = new JLabel("PROFILE DETAILS", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 40));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Body Panel
        bodyPanel = new JPanel();
        bodyPanel.setLayout(null); // Manual positioning for precise control
        bodyPanel.setBackground(Color.WHITE);
        add(bodyPanel, BorderLayout.CENTER);

        // Footer Panel with Buttons
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.WHITE);
        footerPanel.setPreferredSize(new Dimension(1400, 100));
        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // "Main Menu" Button
        JButton mainMenuButton = new JButton("MAIN MENU");
        mainMenuButton.setPreferredSize(new Dimension(250, 60)); // Consistent button size
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 30));
        mainMenuButton.setBackground(Color.RED); // Set red background
        mainMenuButton.setForeground(Color.WHITE); // White font color
        mainMenuButton.setOpaque(true); // Ensure background color is visible
        mainMenuButton.setBorderPainted(false); // Remove default border
        mainMenuButton.setFocusPainted(false);
        mainMenuButton.addActionListener(e -> {
            userFrame.setVisible(true); // Re-show the UserFrame
            dispose(); // Close the current ViewDetails frame
        });
        footerPanel.add(mainMenuButton);

        add(footerPanel, BorderLayout.SOUTH);

        // Load the profile view
        loadProfileView(username, dateOfBirth);
        setVisible(true);
    }

    private void loadProfileView(String username, String dateOfBirth) {
        bodyPanel.removeAll(); // Clear previous data

        // Header in Body
        JLabel profileHeader = new JLabel("Profile Information:");
        profileHeader.setFont(new Font("Serif", Font.BOLD, 30));
        profileHeader.setBounds(50, 20, 500, 40);
        bodyPanel.add(profileHeader);

        // File path for reading data
        String filePath = "LTO/vehicle_registration_data.txt";

        // Allowed fields for display (up to Date of Birth)
        String[] allowedFields = {
                "Name of Vehicle Owner",
                "Address",
                "Contact Information",
                "Identification Number",
                "Date of Birth"
        };

        boolean isMatchingUser = false; // Flag to track if user is matched

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int y = 80; // Starting y-coordinate for details

            System.out.println("DEBUG: Start reading file...");

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Skip empty lines

                System.out.println("DEBUG: Line read -> " + line);

                int colonIndex = line.indexOf(":");
                if (colonIndex != -1) {
                    String key = line.substring(0, colonIndex).trim();
                    String value = line.substring(colonIndex + 1).trim();

                    // Check if the current section matches the username and DOB
                    if (key.equalsIgnoreCase("Name of Vehicle Owner") && value.equalsIgnoreCase(username.trim())) {
                        isMatchingUser = true; // Set flag for matching name
                        System.out.println("DEBUG: Name match found for -> " + value);
                    } else if (isMatchingUser && key.equalsIgnoreCase("Date of Birth")) {
                        if (!value.equalsIgnoreCase(dateOfBirth.trim())) {
                            isMatchingUser = false; // Reset flag if DOB does not match
                            break; // Exit since the profile does not match
                        }
                    }

                    // If matching user, display allowed fields
                    if (isMatchingUser) {
                        for (String allowedField : allowedFields) {
                            if (key.equalsIgnoreCase(allowedField)) {
                                JLabel keyLabel = new JLabel(key + ":");
                                keyLabel.setFont(new Font("Serif", Font.BOLD, 20));
                                keyLabel.setBounds(50, y, 300, 30);
                                bodyPanel.add(keyLabel);

                                JTextField valueField = new JTextField(value);
                                valueField.setFont(new Font("Serif", Font.PLAIN, 20));
                                valueField.setBounds(400, y, 800, 30);
                                valueField.setEditable(false);
                                bodyPanel.add(valueField);

                                y += 50; // Increment y-coordinate for the next field

                                // Stop after Date of Birth is added
                                if (key.equalsIgnoreCase("Date of Birth")) {
                                    break;
                                }
                            }
                        }
                    }
                }

                // Stop processing further once the user's section is complete
                if (isMatchingUser && line.trim().isEmpty()) {
                    break;
                }
            }
        } catch (IOException e) {
            JLabel errorLabel = new JLabel("Error reading file: " + e.getMessage());
            errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
            errorLabel.setForeground(Color.RED);
            errorLabel.setBounds(50, 100, 800, 30);
            bodyPanel.add(errorLabel);
        }

        // Refresh the panel
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }




    public void loadViolationsView(String ownerName) {
        bodyPanel.removeAll(); // Clear previous data

        // Header in Body
        JLabel headerLabel = new JLabel("Violations:");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setBounds(50, 20, 500, 40);
        bodyPanel.add(headerLabel);

        // Extract the first name from ownerName
        String firstName = ownerName.split(" ")[0].trim().toLowerCase();

        // File path for reading violations
        String filePath = "violations.txt";
        int y = 80; // Starting y-coordinate for listing violations

        System.out.println("DEBUG: Searching for violations for ownerName -> " + ownerName);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                System.out.println("DEBUG: Read line -> " + line);

                // Check for matches based on the first name
                String[] parts = line.split("\\|");
                if (parts.length > 1 && parts[0].toLowerCase().contains(firstName)) {
                    found = true;
                    System.out.println("DEBUG: Match found for -> " + parts[0]);

                    // Extract and display violations
                    String[] violations = parts[1].split(",");
                    for (String violation : violations) {
                        JLabel violationLabel = new JLabel(violation.trim());
                        violationLabel.setFont(new Font("Serif", Font.PLAIN, 20));
                        violationLabel.setBounds(50, y, 800, 30);
                        bodyPanel.add(violationLabel);
                        y += 40; // Increment y-coordinate for the next violation
                    }
                    break; // Exit loop after displaying violations for the owner
                }
            }

            if (!found) {
                System.out.println("DEBUG: No violations found for -> " + ownerName);
                JLabel noViolationsLabel = new JLabel("No violations found for this owner.");
                noViolationsLabel.setFont(new Font("Serif", Font.PLAIN, 20));
                noViolationsLabel.setBounds(50, y, 800, 30);
                bodyPanel.add(noViolationsLabel);
            }
        } catch (IOException e) {
            System.err.println("DEBUG: Error reading file -> " + e.getMessage());
            JLabel errorLabel = new JLabel("Error reading file: " + e.getMessage());
            errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
            errorLabel.setForeground(Color.RED);
            errorLabel.setBounds(50, y, 800, 30);
            bodyPanel.add(errorLabel);
        }

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }



    public void loadVehicleProfileView(String ownerName) {
        bodyPanel.removeAll(); // Clear previous data

        // Header in Body
        JLabel headerLabel = new JLabel("Vehicle Profile:");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setBounds(50, 20, 500, 40);
        bodyPanel.add(headerLabel);

        // File path for reading data
        String filePath = "LTO/vehicle_registration_data.txt";

        // Fields to be displayed
        String[] vehicleFields = {
                "Vehicle Identification Number",
                "Registration Number",
                "Make and Model",
                "Body Type",
                "Color",
                "Weight",
                "Insurance Provider",
                "Insurance Validity Period",
                "Policy Number",
                "Vehicle Type",
                "Brand",
                "Dimensions"
        };

        boolean isMatchingUser = false; // Flag to track if user matches
        int y = 80; // Starting y-coordinate for details
        String key = ""; // Declare key outside the loop

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("DEBUG: Searching vehicle profile for owner -> " + ownerName);

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Skip empty lines

                // Check if the line matches the owner's name
                if (line.startsWith("Name of Vehicle Owner: ")) {
                    String currentOwner = line.replace("Name of Vehicle Owner: ", "").trim();
                    isMatchingUser = currentOwner.equalsIgnoreCase(ownerName.trim());
                    System.out.println("DEBUG: Owner match found -> " + currentOwner);
                    continue;
                }

                // If the owner matches, display the relevant fields
                if (isMatchingUser) {
                    int colonIndex = line.indexOf(":");
                    if (colonIndex != -1) {
                        key = line.substring(0, colonIndex).trim();
                        String value = line.substring(colonIndex + 1).trim();

                        // Check if the current key is a vehicle field to display
                        for (String field : vehicleFields) {
                            if (key.equalsIgnoreCase(field)) {
                                JLabel keyLabel = new JLabel(key + ":");
                                keyLabel.setFont(new Font("Serif", Font.BOLD, 20));
                                keyLabel.setBounds(50, y, 300, 30);
                                bodyPanel.add(keyLabel);

                                JTextField valueField = new JTextField(value);
                                valueField.setFont(new Font("Serif", Font.PLAIN, 20));
                                valueField.setBounds(400, y, 800, 30);
                                valueField.setEditable(false);
                                bodyPanel.add(valueField);

                                y += 50; // Increment y-coordinate for the next field
                                break;
                            }
                        }
                    }

                    // Stop once "Dimensions" field is processed
                    if (key.equalsIgnoreCase("Dimensions")) {
                        isMatchingUser = false; // Reset flag for next user
                        break;
                    }
                }
            }
        } catch (IOException e) {
            JLabel errorLabel = new JLabel("Error reading file: " + e.getMessage());
            errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
            errorLabel.setForeground(Color.RED);
            errorLabel.setBounds(50, y, 800, 30);
            bodyPanel.add(errorLabel);
        }

        bodyPanel.revalidate();
        bodyPanel.repaint();

    }






}
