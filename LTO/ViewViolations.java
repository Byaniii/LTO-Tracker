package LTO;

import java.awt.*;
import javax.swing.*;

public class ViewViolations extends frame { // Extend from the frame class
    public ViewViolations() {
        super("View Violations"); // Call the frame constructor with a title

        // Customize the bodyPanel to add violations-specific components
        bodyPanel.setLayout(new BorderLayout());
        bodyPanel.setBackground(Color.WHITE);

        // Example: Add a label to display violations information
        JLabel violationsLabel = new JLabel("Violations Information Here", SwingConstants.CENTER);
        violationsLabel.setFont(new Font("Serif", Font.BOLD, 24));
        bodyPanel.add(violationsLabel, BorderLayout.CENTER);

        setVisible(true); // Make the frame visible
    }
}
