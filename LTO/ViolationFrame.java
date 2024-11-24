package LTO;

import javax.swing.*;
import java.awt.*;
import java.io.*;
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

        // Load existing violations for the owner
        java.util.Set<String> existingViolations = new java.util.HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("violations.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(ownerName + "|")) {
                    String[] parts = line.split("\\|");
                    if (parts.length > 1) {
                        for (String violation : parts[1].split(",")) {
                            existingViolations.add(violation.trim());
                        }
                    }
                    break; // Exit loop once the owner's record is found
                }
            }
        } catch (IOException e) {
            // File not found or other errors, handle silently
        }

        // Create checkboxes and check them if they are in the existing violations
        violationCheckboxes = new ArrayList<>();
        int x = 100, y = 80, colWidth = 300;

        for (int i = 0; i < violations.length; i++) {
            JCheckBox violationCheckBox = new JCheckBox(violations[i]);
            violationCheckBox.setFont(new Font("Serif", Font.PLAIN, 20));
            violationCheckBox.setBackground(Color.WHITE);
            violationCheckBox.setBounds(x, y, colWidth, 30);

            // Check the box if the violation is in the existing violations
            if (existingViolations.contains(violations[i])) {
                violationCheckBox.setSelected(true);
            }

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
            // Define file path
            String filePath = "violations.txt";

            // Read the current file content
            java.util.List<String> fileContent = new ArrayList<>();
            boolean ownerFound = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Check if the line corresponds to the current owner
                    if (line.startsWith(ownerName + "|")) {
                        ownerFound = true;

                        // Create a Set to store only checked violations
                        java.util.Set<String> violationSet = new java.util.HashSet<>();
                        for (JCheckBox checkBox : violationCheckboxes) {
                            if (checkBox.isSelected()) {
                                violationSet.add(checkBox.getText());
                            }
                        }

                        // Rebuild the line with updated violations (only checked ones)
                        if (!violationSet.isEmpty()) {
                            StringBuilder updatedLine = new StringBuilder();
                            updatedLine.append(ownerName).append("|");
                            updatedLine.append(String.join(",", violationSet));
                            fileContent.add(updatedLine.toString());
                        }
                        // If all violations are unchecked, do not add an entry for the owner
                    } else {
                        fileContent.add(line); // Keep other entries intact
                    }
                }
            } catch (IOException e) {
                // If the file doesn't exist, that's fine; we'll create a new one
            }

            // If the owner was not found and there are selected violations, add a new entry
            if (!ownerFound) {
                StringBuilder newEntry = new StringBuilder();
                newEntry.append(ownerName).append("|");

                boolean hasViolations = false;
                for (JCheckBox checkBox : violationCheckboxes) {
                    if (checkBox.isSelected()) {
                        if (hasViolations) {
                            newEntry.append(",");
                        }
                        newEntry.append(checkBox.getText());
                        hasViolations = true;
                    }
                }

                if (hasViolations) {
                    fileContent.add(newEntry.toString());
                }
            }

            // Write back the updated file content
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
                for (String line : fileContent) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            JOptionPane.showMessageDialog(this, "Violations saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new FindVehicleFrame();

        } catch (IOException e) {
            e.printStackTrace(); // Debugging
            JOptionPane.showMessageDialog(this, "Error saving violations: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
