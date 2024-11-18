package LTO;

import java.awt.*;
import javax.swing.*;

public class ViewVehicleProfile extends frame { // Extend from the frame class
    public ViewVehicleProfile() {
        super("View Vehicle Profile"); // Call the frame constructor with a title

        // Customize the bodyPanel to add vehicle profile-specific components
        bodyPanel.setLayout(new BorderLayout());
        bodyPanel.setBackground(Color.WHITE);

        // Example: Add a label to display vehicle profile information
        JLabel vehicleLabel = new JLabel("Vehicle Profile Information Here", SwingConstants.CENTER);
        vehicleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        bodyPanel.add(vehicleLabel, BorderLayout.CENTER);

        setVisible(true); // Make the frame visible
    }
}
