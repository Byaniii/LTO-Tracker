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
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Body panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridLayout(9, 2, 20, 20));
        bodyPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 20)); // Shift text to the right

        String[] details = vehicleData.split("\n");
        for (String detail : details) {
            JLabel label = new JLabel(detail);
            label.setFont(new Font("Serif", Font.BOLD, 20)); // Bold and bigger font
            bodyPanel.add(label);
        }

        add(bodyPanel, BorderLayout.CENTER);

        // Footer panel with buttons
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout(20, 0)); // Added horizontal spacing between buttons

        // "Main Menu" button positioned to the bottom left
        CustomButton mainMenuButton = new CustomButton("MAIN MENU");
        mainMenuButton.setPreferredSize(new Dimension(200, 60)); // Button size
        mainMenuButton.setFont(new Font("Serif", Font.BOLD, 24)); // Bold font
        mainMenuButton.setBackground(Color.RED);
        mainMenuButton.setForeground(Color.WHITE);
        mainMenuButton.addActionListener(e -> {
            new AdminFrame();
            dispose();
        });

        // Move button slightly up and left
        JPanel mainMenuButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mainMenuButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10)); // Adjust position
        mainMenuButtonPanel.add(mainMenuButton);
        footerPanel.add(mainMenuButtonPanel, BorderLayout.WEST);

        // "Search Again" button positioned to the bottom right
        CustomButton searchAgainButton = new CustomButton("SEARCH AGAIN");
        searchAgainButton.setPreferredSize(new Dimension(250, 60)); // Button size
        searchAgainButton.setFont(new Font("Serif", Font.BOLD, 24)); // Bold font
        searchAgainButton.setBackground(Color.RED);
        searchAgainButton.setForeground(Color.WHITE);
        searchAgainButton.addActionListener(e -> {
            new FindVehicleFrame();
            dispose();
        });

        // Move button slightly up and right
        JPanel searchAgainButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchAgainButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 30)); // Adjust position
        searchAgainButtonPanel.add(searchAgainButton);
        footerPanel.add(searchAgainButtonPanel, BorderLayout.EAST);

        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
