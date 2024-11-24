package LTO;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewViolationFrame extends JFrame {
    public ViewViolationFrame(String ownerName) {
        setTitle("View Violations");
        setSize(600, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Header
        JLabel headerLabel = new JLabel("Violations for: " + ownerName, SwingConstants.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(headerLabel, BorderLayout.NORTH);

        // Violations Panel
        JPanel violationsPanel = new JPanel();
        violationsPanel.setLayout(new BoxLayout(violationsPanel, BoxLayout.Y_AXIS));
        violationsPanel.setBackground(Color.WHITE);

        try (BufferedReader reader = new BufferedReader(new FileReader("violations.txt"))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith(ownerName + "|")) {
                    found = true;
                    String[] violations = line.split("\\|")[1].split(",");
                    for (String violation : violations) {
                        JLabel violationLabel = new JLabel("- " + violation.trim());
                        violationLabel.setFont(new Font("Serif", Font.PLAIN, 18));
                        violationsPanel.add(violationLabel);
                    }
                    break;
                }
            }

            if (!found) {
                violationsPanel.add(new JLabel("No violations found for this owner."));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading violations: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Scrollable Panel
        JScrollPane scrollPane = new JScrollPane(violationsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);

        // Close Button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
