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
        headerLabel.setFont(new Font("Serif", Font.BOLD, 40));
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
        mainMenuButton.setFont(new Font("Serif", Font.BOLD, 30));
        mainMenuButton.setBackground(Color.RED); // Set red background
        mainMenuButton.setForeground(Color.WHITE); // White font color
        mainMenuButton.setOpaque(true); // Ensure background color is visible
        mainMenuButton.setBorderPainted(false); // Remove default border
        mainMenuButton.setFocusPainted(false);
        mainMenuButton.addActionListener(e -> {
            new UserFrame(username); // Navigate back to UserFrame
            dispose();
        });
        footerPanel.add(mainMenuButton);

        add(footerPanel, BorderLayout.SOUTH);

        // Load the Profile Details
        loadProfileView();
        setVisible(true);
    }

    private void loadProfileView() {
        bodyPanel.removeAll(); // Clear previous data

        // Header in Body
        JLabel profileHeader = new JLabel("Profile Information:");
        profileHeader.setFont(new Font("Serif", Font.BOLD, 30));
        profileHeader.setBounds(50, 20, 500, 40); // Positioning
        bodyPanel.add(profileHeader);

        // File path for reading data
        String filePath = "LTO/vehicle_registration_data.txt";

        // Allowed fields for display
        String[] allowedFields = {
                "Name of Vehicle Owner",
                "Address",
                "Contact Information",
                "Identification Number",
                "Date of Birth"
        };

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int y = 80; // Starting y-coordinate for details

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Skip empty lines

                int colonIndex = line.indexOf(":");
                if (colonIndex != -1) {
                    String key = line.substring(0, colonIndex).trim();
                    String value = line.substring(colonIndex + 1).trim();

                    // Display only allowed fields
                    for (String allowedField : allowedFields) {
                        if (key.equalsIgnoreCase(allowedField)) {
                            JLabel keyLabel = new JLabel(key + ":");
                            keyLabel.setFont(new Font("Serif", Font.BOLD, 20));
                            keyLabel.setBounds(50, y, 300, 30); // Adjust positioning
                            bodyPanel.add(keyLabel);

                            JTextField valueField = new JTextField(value);
                            valueField.setFont(new Font("Serif", Font.PLAIN, 20));
                            valueField.setBounds(400, y, 800, 30); // Align value fields
                            valueField.setEditable(false); // Read-only
                            bodyPanel.add(valueField);

                            y += 50; // Increment y-coordinate for the next field
                            break; // Exit loop after adding the field
                        }
                    }
                }
            }
        } catch (IOException e) {
            JLabel errorLabel = new JLabel("Error reading file: " + e.getMessage());
            errorLabel.setFont(new Font("Serif", Font.BOLD, 20));
            errorLabel.setForeground(Color.RED);
            errorLabel.setBounds(50, 100, 800, 30); // Position the error label
            bodyPanel.add(errorLabel);
        }

        // Refresh the panel
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }
}
