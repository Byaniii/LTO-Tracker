package LTO;

import javax.swing.*;
import java.awt.*;

public class VehicleDetailsFrame extends JFrame {
    public VehicleDetailsFrame(String vehicleData) {
        // Set up the frame
        setTitle("Vehicle Details");
        setSize(1400, 900); // Frame size
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(30, 30)); // Added padding around the layout

        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.RED);
        headerPanel.setPreferredSize(new Dimension(1400, 100));
        JLabel headerLabel = new JLabel("VEHICLE", SwingConstants.CENTER);
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 40));
        headerLabel.setToolTipText("Header: Vehicle Details"); // Accessibility
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Body panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BoxLayout(bodyPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for flexible height
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Adjust left and right padding

        String[] details = vehicleData.split("\n");
        for (String detail : details) {
            if (!detail.trim().isEmpty()) {
                JLabel label = new JLabel(detail.trim());
                label.setFont(new Font("Serif", Font.PLAIN, 24)); // Larger font for better readability
                label.setAlignmentX(Component.LEFT_ALIGNMENT);
                bodyPanel.add(label);
                bodyPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Add space between labels
            }
        }

        add(bodyPanel, BorderLayout.CENTER);

        // Footer panel with buttons
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10)); // Align buttons to the right

        // "Main Menu" button
        CustomButton mainMenuButton = new CustomButton("MAIN MENU");
        mainMenuButton.setPreferredSize(new Dimension(200, 60)); // Button size
        mainMenuButton.setFont(new Font("Serif", Font.BOLD, 24)); // Bold font
        mainMenuButton.setBackground(Color.RED);
        mainMenuButton.setForeground(Color.WHITE);
        mainMenuButton.setToolTipText("Go back to the Main Menu"); // Accessibility
        mainMenuButton.addActionListener(e -> {
            new AdminFrame();
            dispose();
        });

        footerPanel.add(mainMenuButton);

        // "Search Again" button
        CustomButton searchAgainButton = new CustomButton("SEARCH AGAIN");
        searchAgainButton.setPreferredSize(new Dimension(250, 60)); // Button size
        searchAgainButton.setFont(new Font("Serif", Font.BOLD, 24)); // Bold font
        searchAgainButton.setBackground(Color.RED);
        searchAgainButton.setForeground(Color.WHITE);
        searchAgainButton.setToolTipText("Search for another vehicle"); // Accessibility
        searchAgainButton.addActionListener(e -> {
            new FindVehicleFrame();
            dispose();
        });

        footerPanel.add(searchAgainButton);

        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true); // Moved to the end

    }
}
