package LTO;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ViolationFrame extends frame {
    private ArrayList<JCheckBox> violationCheckboxes;
    private String ownerName;

    public ViolationFrame(String ownerName) {
        super("Violation");
        this.ownerName = ownerName;
        bodyPanel.setBackground(Color.WHITE);
        createViolationPanel();
    }

    private void createViolationPanel() {
        bodyPanel.removeAll();

        JLabel headerLabel = new JLabel("VIOLATION", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setBounds(600, 20, 300, 40);
        bodyPanel.add(headerLabel);

        String[] violations = {
                "Not wearing a seatbelt", "Reckless Driving", "DUI", "Not Wearing A Helmet",
                "Illegal Parking", "Distracted Driving", "Disregarding Traffic Sign",
                "Smoking inside the vehicle", "Overloading", "Illegal turn",
                "Operating a defective vehicle"
        };

        violationCheckboxes = new ArrayList<>();
        int x = 100, y = 80, colWidth = 300;

        for (int i = 0; i < violations.length; i++) {
            JCheckBox violationCheckBox = new JCheckBox(violations[i]);
            violationCheckBox.setFont(new Font("Serif", Font.PLAIN, 20));
            violationCheckBox.setBackground(Color.WHITE);
            violationCheckBox.setBounds(x, y, colWidth, 30);
            bodyPanel.add(violationCheckBox);
            violationCheckboxes.add(violationCheckBox);

            y += 40;
            if (i == 5) {
                x = 500;
                y = 80;
            }
        }

        CustomButton saveButton = CustomButton.createRedButton("SAVE VIOLATIONS", 550, 650, 200, 50, 20);
        saveButton.addActionListener(e -> saveViolations());
        bodyPanel.add(saveButton);

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }

    private void saveViolations() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/KuyaBani/IdeaProjects/LTO/LTO/violations.txt", true))) {
            // Write owner's name and violations in a structured format
            StringBuilder record = new StringBuilder();
            record.append(ownerName).append("|"); // Owner name as the key

            boolean hasViolations = false;
            for (JCheckBox checkBox : violationCheckboxes) {
                if (checkBox.isSelected()) {
                    if (hasViolations) {
                        record.append(","); // Separate multiple violations
                    }
                    record.append(checkBox.getText());
                    hasViolations = true;
                }
            }

            // Check if any violation was selected
            if (hasViolations) {
                writer.write(record.toString());
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Violations saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No violations selected.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

            dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving violations: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
