package LTO;

import javax.swing.*;
import java.awt.*;

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

        // Logo and title
        ImageIcon icon = new ImageIcon("logo.png");
        JLabel logoLabel = new JLabel(icon);
        topPanel.add(logoLabel);

        JLabel titleLabel = new JLabel("LTO TRACKER - " + viewType);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        topPanel.add(titleLabel);

        add(topPanel, BorderLayout.NORTH);

        // Body panel
        bodyPanel = new JPanel();
        bodyPanel.setBackground(Color.WHITE);
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS));
        add(bodyPanel, BorderLayout.CENTER);

        // Load the appropriate view based on viewType
        switch (viewType) {
            case "Profile":
                loadProfileView();
                break;
            case "Vehicle Profile":
                loadVehicleProfileView();
                break;
            case "Violations":
                loadViolationsView();
                break;
            default:
                showError("Invalid view type");
        }

        // Add a "Back" button
        JButton backButton = new JButton("BACK");
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.setFont(new Font("Serif", Font.BOLD, 30));
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> {
            dispose(); // Close the current frame
            new UserFrame(username); // Reopen the UserFrame
        });

        bodyPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Add spacing
        bodyPanel.add(backButton);

        setVisible(true);
    }

    private void loadProfileView() {
        JLabel label = new JLabel("Profile Information Here");
        label.setFont(new Font("Serif", Font.BOLD, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        bodyPanel.add(label);
    }

    private void loadVehicleProfileView() {
        JLabel label = new JLabel("Vehicle Profile Information Here");
        label.setFont(new Font("Serif", Font.BOLD, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        bodyPanel.add(label);
    }

    private void loadViolationsView() {
        JLabel label = new JLabel("Violations Information Here");
        label.setFont(new Font("Serif", Font.BOLD, 40));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        bodyPanel.add(label);
    }

    private void showError(String message) {
        JLabel errorLabel = new JLabel(message);
        errorLabel.setFont(new Font("Serif", Font.BOLD, 40));
        errorLabel.setForeground(Color.RED);
        errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        bodyPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        bodyPanel.add(errorLabel);
    }
}
