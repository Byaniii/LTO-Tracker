package LTO;

import java.awt.*;
import javax.swing.*;

public class ViewProfile extends frame { // Extend from the frame class
    public ViewProfile() {
        super("View Profile"); // Call the frame constructor with a title

        // Customize the bodyPanel to add profile-specific components
        bodyPanel.setLayout(new BorderLayout());
        bodyPanel.setBackground(Color.WHITE);

        // Example: Add a label to display profile information
        JLabel profileLabel = new JLabel("Profile Information Here", SwingConstants.CENTER);
        profileLabel.setFont(new Font("Serif", Font.BOLD, 24));
        bodyPanel.add(profileLabel, BorderLayout.CENTER);

        setVisible(true); // Make the frame visible
    }
}
