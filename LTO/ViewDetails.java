package LTO;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewDetails extends JFrame {
    private JPanel bodyPanel;

    public ViewDetails(String viewType, String username) {
        setTitle("LTO Tracker - " + viewType);
        setSize(1500, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel with title
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.RED);
        topPanel.setPreferredSize(new Dimension(1500, 100));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Title
        JLabel titleLabel = new JLabel("LTO TRACKER - " + viewType);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        topPanel.add(titleLabel);

        add(topPanel, BorderLayout.NORTH);

        // Body panel
        bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setLayout(null); // Using null layout for precise positioning
        add(bodyPanel, BorderLayout.CENTER);

        // Load the appropriate view based on viewType
        if ("Profile".equalsIgnoreCase(viewType)) {
            loadProfileView();
        }

        // Add a "Back" button
        JButton backButton = new JButton("BACK");
        backButton.setBounds(600, 750, 200, 50);
        backButton.setFont(new Font("Serif", Font.BOLD, 30));
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.addActionListener(e -> dispose());

        bodyPanel.add(backButton);

        setVisible(true);
    }

    private void loadProfileView() {
        bodyPanel.removeAll(); // Clear the panel

        // Header
        JLabel headerLabel = new JLabel("PROFILE INFORMATION");
        headerLabel.setFont(new Font("Serif", Font.BOLD, 40));
        headerLabel.setBounds(500, 20, 500, 50);
        bodyPanel.add(headerLabel);

        // File path (adjust as needed)
        String filePath = "LTO/vehicle_registration_data.txt";

        // List of fields to display
        String[] allowedFields = {
                "Name of Vehicle Owner",
                "Address",
                "Contact Information",
                "Identification Number",
                "Date of Birth"
        };

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int y = 100; // Starting y-coordinate for placing elements

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Skip empty lines

                // Split line into key and value
                int colonIndex = line.indexOf(":");
                if (colonIndex != -1) {
                    String key = line.substring(0, colonIndex).trim();
                    String value = line.substring(colonIndex + 1).trim();

                    // Display only allowed fields
                    for (String allowedField : allowedFields) {
                        if (key.equalsIgnoreCase(allowedField)) {
                            // Add key as label
                            JLabel keyLabel = new JLabel(key + ":");
                            keyLabel.setFont(new Font("Serif", Font.BOLD, 20));
                            keyLabel.setBounds(300, y, 300, 30);
                            bodyPanel.add(keyLabel);

                            // Add value as a text field
                            JTextField valueField = new JTextField(value);
                            valueField.setFont(new Font("Serif", Font.PLAIN, 20));
                            valueField.setBounds(600, y, 600, 30);
                            valueField.setEditable(false); // Make it read-only
                            bodyPanel.add(valueField);

                            y += 50; // Increment y-coordinate for the next row
                            break; // Exit the loop once the field is added
                        }
                    }
                }
            }
        } catch (IOException e) {
            JLabel errorLabel = new JLabel("Error reading file: " + e.getMessage());
            errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
            errorLabel.setForeground(Color.RED);
            errorLabel.setBounds(500, 100, 500, 50);
            bodyPanel.add(errorLabel);
        }

        // Refresh the panel
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }
}
