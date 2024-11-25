package LTO;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewViolationFrame extends frame {

    public ViewViolationFrame(String ownerName) {
        super("View Violations");

        // Customize the bodyPanel to display violations
        bodyPanel.setLayout(null);
        bodyPanel.setBackground(Color.WHITE);

        // Header
        JLabel headerLabel = new JLabel("Violations for (" + ownerName + ")", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 36));
        headerLabel.setBounds(400, 30, 700, 50);
        bodyPanel.add(headerLabel);

        // Violations Panel
        JPanel violationsPanel = new JPanel();
        violationsPanel.setLayout(new BoxLayout(violationsPanel, BoxLayout.Y_AXIS));
        violationsPanel.setBackground(Color.WHITE);
        violationsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        violationsPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Padding around content

        try (BufferedReader reader = new BufferedReader(new FileReader("violations.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(ownerName + "|")) {
                    found = true;
                    String[] violations = line.split("\\|")[1].split(",");
                    for (String violation : violations) {
                        JLabel violationLabel = new JLabel(violation.trim());
                        violationLabel.setFont(new Font("Serif", Font.PLAIN, 20));
                        violationLabel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align left
                        violationsPanel.add(violationLabel);
                        violationsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
                    }
                    break;
                }
            }

            if (!found) {
                JLabel noViolationsLabel = new JLabel("No violations found for this owner.");
                noViolationsLabel.setFont(new Font("Serif", Font.PLAIN, 20));
                noViolationsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                violationsPanel.add(noViolationsLabel);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading violations: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Wrap the Violations Panel in a Scrollable Pane
        JScrollPane scrollPane = new JScrollPane(violationsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(300, 100, 900, 550); // Adjust dimensions
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)); // Optional: Add border for clarity
        bodyPanel.add(scrollPane);

        // Search Again Button
        CustomButton searchAgainButton = CustomButton.createRedButton("SEARCH AGAIN", 600, 700, 300, 50, 20);
        searchAgainButton.addActionListener(e -> {
            new FindVehicleFrame(); // Redirect to the search frame
            dispose();
        });
        bodyPanel.add(searchAgainButton);

        revalidate();
        repaint();


    }
}
