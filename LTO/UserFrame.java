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

        // Retrieve the vehicle owner's name
        String ownerName = getVehicleOwnerName(email);

        // Body panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));

        // Welcome message
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
            button.addActionListener(new ButtonClickListener(text, email)); // Pass email to the listener
            bodyPanel.add(button);
            bodyPanel.add(Box.createRigidArea(new Dimension(0, 60))); // Add more spacing between buttons
        }

        add(bodyPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private String getVehicleOwnerName(String email) {
        String ownerName = "User"; // Default name
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\vival\\IdeaProjects\\LTO-Tracker\\LTO\\vehicle_registration_data.txt"))) {
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
        button.setForeground(Color.WHITE);
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
