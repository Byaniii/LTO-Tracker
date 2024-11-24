package LTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserFrame extends JFrame {
    private String email; // Store user email to retain data

    public UserFrame(String email) {
        this.email = email;

        // Frame setup
        setTitle("LTO Tracker - User Panel");
        setSize(1500, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel with title
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.RED);
        topPanel.setPreferredSize(new Dimension(1500, 110));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Logo and title
        ImageIcon icon = new ImageIcon("LTO/logo.png");
        JLabel logoLabel = new JLabel(icon);
        topPanel.add(logoLabel);

        JLabel titleLabel = new JLabel("LTO TRACKER");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        topPanel.add(titleLabel);

        add(topPanel, BorderLayout.NORTH);

        // Body panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));

        // Welcome message
        String ownerName = getVehicleOwnerName(email); // Retrieve vehicle owner name
        JLabel welcomeLabel = new JLabel("Welcome, " + ownerName + "!");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 60));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        bodyPanel.add(welcomeLabel);

        // Buttons
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Add spacing
        String[] buttonTexts = {"Profile", "Violations", "Vehicle Profile"};
        for (String text : buttonTexts) {
            JButton button = createButton(text);
            button.addActionListener(new ButtonClickListener(text)); // Pass button text to listener
            bodyPanel.add(button);
            bodyPanel.add(Box.createRigidArea(new Dimension(0, 60))); // Add more spacing between buttons
        }

        // Back button
        CustomButton backButton = CustomButton.createRedButton("LOGOUT", 50, 50, 150, 50, 30);
        backButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        backButton.addActionListener(e -> {
            dispose(); // Close the current UserFrame
            main.main(null); // Reopen the main frame (home page)
        });

        // Footer panel to hold the back button
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align to the left
        footerPanel.setBackground(Color.WHITE); // Match background color
        footerPanel.add(backButton);

        add(bodyPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH); // Add footer at the bottom

        setVisible(true);
    }

    private String getVehicleOwnerName(String email) {
        String ownerName = "User"; // Default name
        String potentialOwnerName = null; // To temporarily store the owner name
        try (BufferedReader reader = new BufferedReader(new FileReader("LTO/vehicle_registration_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name of Vehicle Owner: ")) {
                    // Store the potential owner name
                    potentialOwnerName = line.replace("Name of Vehicle Owner: ", "").trim();
                    System.out.println("DEBUG: Found potentialOwnerName -> " + potentialOwnerName);
                } else if (line.contains("Email: " + email) && potentialOwnerName != null) {
                    // If the email matches, use the stored potentialOwnerName
                    ownerName = potentialOwnerName;
                    System.out.println("DEBUG: Email match found. ownerName set to -> " + ownerName);
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("DEBUG: Error reading vehicle_registration_data.txt -> " + e.getMessage());
        }
        return ownerName;
    }


    private String getDateOfBirth(String email) {
        String dateOfBirth = ""; // Default to empty
        try (BufferedReader reader = new BufferedReader(new FileReader("LTO/vehicle_registration_data.txt"))) {
            String line;
            boolean isMatchingUser = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Email: " + email)) {
                    isMatchingUser = true; // Email matches
                } else if (isMatchingUser && line.startsWith("Date of Birth: ")) {
                    dateOfBirth = line.replace("Date of Birth: ", "").trim();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dateOfBirth;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(400, 120)); // Increased size of the buttons
        button.setFont(new Font("Serif", Font.BOLD, 60)); // Increased font size
        button.setBackground(Color.RED); // Set background color to red
        button.setOpaque(true); // Ensure the background color is visible
        button.setBorderPainted(false); // Remove the default button border
        button.setForeground(Color.WHITE); // Set text color to white for better contrast
        button.setFocusPainted(false); // Remove focus border
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    // Inner class to handle button clicks
    private class ButtonClickListener implements ActionListener {
        private final String buttonText;

        public ButtonClickListener(String buttonText) {
            this.buttonText = buttonText;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String ownerName = getVehicleOwnerName(email);
            String dateOfBirth = getDateOfBirth(email);

            if (buttonText.equalsIgnoreCase("Violations")) {
                new ViewDetails("Violations", ownerName, dateOfBirth, UserFrame.this).loadViolationsView(ownerName);
            } else if (buttonText.equalsIgnoreCase("Vehicle Profile")) {
                new ViewDetails("Vehicle Profile", ownerName, dateOfBirth, UserFrame.this).loadVehicleProfileView(ownerName);
            } else {
                new ViewDetails(buttonText, ownerName, dateOfBirth, UserFrame.this);
            }

            setVisible(false); // Hide the UserFrame temporarily
        }
    }

}

