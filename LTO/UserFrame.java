package LTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class UserFrame extends JFrame {
    public UserFrame(String email) {
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
            button.addActionListener((ActionListener) new ButtonClickListener(text, email)); // Pass email to the listener
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
        try (BufferedReader reader = new BufferedReader(new FileReader("LTO/vehicle_registration_data.txt"))) {
            String line;
            String potentialOwnerName = ""; // To store the potential name before we find the email

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name of Vehicle Owner: ")) {
                    potentialOwnerName = line.replace("Name of Vehicle Owner: ", "").trim();
                } else if (line.contains("Email: " + email)) {
                    ownerName = potentialOwnerName;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ownerName;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(400, 120)); // Increased size of the buttons
        button.setFont(new Font("Serif", Font.BOLD, 60)); // Increased font size
        button.setBackground(Color.RED);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    // Inner class to handle button clicks
    private class ButtonClickListener implements ActionListener {
        private final String buttonText;
        private final String email;

        public ButtonClickListener(String buttonText, String email) {
            this.buttonText = buttonText;
            this.email = email;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new ViewDetails(buttonText, email); // Pass email to ViewDetails
        }
    }
}
