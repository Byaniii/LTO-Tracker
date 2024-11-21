package LTO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViolationFrame extends frame {
    private ArrayList<JCheckBox> violationCheckboxes;

    public ViolationFrame() {
        super("Violation");
        bodyPanel.setBackground(Color.WHITE);
        createViolationPanel();
    }

    private void createViolationPanel() {
        setResizable(false);
        bodyPanel.removeAll();

        // Header
        JLabel headerLabel = new JLabel("VIOLATION", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setBounds(600, 20, 300, 40);
        bodyPanel.add(headerLabel);

        // Violations List
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

            y += 40; // Space between rows
            if (i == 5) { // Start second column
                x = 500;
                y = 80;
            }
        }

        // Main Menu Button (Bottom-Left)
        CustomButton mainMenuButton = CustomButton.createRedButton("MAIN MENU", 100, 650, 200, 50, 20);
        mainMenuButton.addActionListener(e -> {
            new AdminFrame();
            dispose();
        });
        bodyPanel.add(mainMenuButton);

        // Enter Violation Button (Bottom-Right)
        CustomButton enterViolationButton = CustomButton.createRedButton("ENTER VIOLATION", 1000, 650, 200, 50, 20);
        enterViolationButton.addActionListener(e -> enterViolations());
        bodyPanel.add(enterViolationButton);

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }

    private void enterViolations() {
        StringBuilder selectedViolations = new StringBuilder("Selected Violations:\n");
        boolean hasSelection = false;

        for (JCheckBox checkBox : violationCheckboxes) {
            if (checkBox.isSelected()) {
                selectedViolations.append("- ").append(checkBox.getText()).append("\n");
                hasSelection = true;
            }
        }

        if (hasSelection) {
            JOptionPane.showMessageDialog(this, selectedViolations.toString(), "Violations", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No violations selected.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
