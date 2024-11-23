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
        try {
            // Define the file path
            String filePath = "violations.txt"; // Use relative or absolute path as needed

            // Debugging message to verify file path
            System.out.println("Attempting to write to file: " + filePath);

            // Ensure the parent directory exists (for absolute paths)
            java.io.File file = new java.io.File(filePath);
            java.io.File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs(); // Create directories if they don't exist
            }

            // Write owner's name and violations in a structured format
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
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

                System.out.println("Record saved successfully: " + record);
                dispose();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace to debug the issue
            JOptionPane.showMessageDialog(this, "Error saving violations: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
