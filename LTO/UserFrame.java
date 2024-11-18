package LTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UserFrame extends JFrame {
    public UserFrame(String username) {
        // Frame setup
        setTitle("LTO Tracker - User Panel");
        setSize(1500, 900); // Same size as AdminFrame
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
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 60));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing
        bodyPanel.add(welcomeLabel);

        // Buttons
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Add spacing

        String[] buttonTexts = {"VIEW PROFILE", "VIEW VIOLATIONS", "VIEW VEHICLE PROFILE"};
        for (String text : buttonTexts) {
            JButton button = createButton(text);
            button.addActionListener(new ButtonClickListener(text)); // Add action listener
            bodyPanel.add(button);
            bodyPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Add more spacing between buttons
        }

        add(bodyPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(400, 120)); // Increased size of the buttons
        button.setFont(new Font("Serif", Font.BOLD, 40)); // Increased font size
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    // Inner class to handle button clicks
    // Inner class to handle button clicks
    private class ButtonClickListener implements ActionListener {
        private String buttonText;

        public ButtonClickListener(String buttonText) {
            this.buttonText = buttonText;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (buttonText) {
                case "VIEW PROFILE":
                    dispose();
                    new ViewProfile(); // Open the ViewProfile frame
                    break;
                case "VIEW VIOLATIONS":
                    dispose();
                    new ViewViolations(); // Open the ViewViolations frame
                    break;
                case "VIEW VEHICLE PROFILE":
                    dispose();
                    new ViewVehicleProfile(); // Open the ViewVehicleProfile frame
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Unknown action!");
                    break;
            }
        }
    }
}
