package LTO;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindVehicleFrame extends frame {
    private CustomTextField OwnerName_Field;
    private JPanel detailsPanel;
    private String currentOwner; // To hold the current owner's name

    public FindVehicleFrame() {
        super("Find Vehicle");
        bodyPanel.setBackground(Color.WHITE);
        createSearchPanel();
    }

    private void createSearchPanel() {
        bodyPanel.removeAll();

        // Header
        JLabel headerLabel = new JLabel("FIND VEHICLE", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setBounds(500, 20, 500, 40); // Centered horizontally
        bodyPanel.add(headerLabel);

        // Search Bar
        JLabel ownerNameLabel = new JLabel("OWNER'S NAME");
        ownerNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        ownerNameLabel.setBounds(400, 100, 300, 30); // Centered horizontally
        bodyPanel.add(ownerNameLabel);

        OwnerName_Field = CustomTextField.createTextField(400, 140, 600, 40); // Centered horizontally
        bodyPanel.add(OwnerName_Field);

        CustomButton searchButton = CustomButton.createRedButton("SEARCH", 1050, 140, 150, 40, 20); // Positioned to the right of the search bar
        searchButton.addActionListener(e -> searchVehicle());
        bodyPanel.add(searchButton);

        // Details Panel
        JScrollPane scrollPane = new JScrollPane();
        detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBackground(Color.WHITE);
        scrollPane.setViewportView(detailsPanel);
        scrollPane.setBounds(300, 200, 900, 400); // Centered horizontally
        bodyPanel.add(scrollPane);

        // Main Menu Button
        CustomButton mainMenuButton = CustomButton.createRedButton("MAIN MENU", 50, 650, 200, 50, 20);
        mainMenuButton.addActionListener(e -> {
            new AdminFrame();
            dispose();
        });
        bodyPanel.add(mainMenuButton);

        // Violation Button
        CustomButton violationButton = CustomButton.createRedButton("VIOLATION", 1050, 650, 200, 50, 20); // Bottom-right corner
        violationButton.addActionListener(e -> openViolationPanel());
        bodyPanel.add(violationButton);

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }

    private void searchVehicle() {
        String ownerNameInput = OwnerName_Field.getText().trim().toLowerCase();
        detailsPanel.removeAll(); // Clear previous details
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("LTO/vehicle_registration_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name of Vehicle Owner: ")) {
                    currentOwner = line.replace("Name of Vehicle Owner: ", "").trim();
                    if (currentOwner.toLowerCase().contains(ownerNameInput)) {
                        found = true;
                        displayOwnerDetails(reader);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading vehicle details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "No matching vehicle details found.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
        }

        detailsPanel.revalidate();
        detailsPanel.repaint();
    }

    private void displayOwnerDetails(BufferedReader reader) throws IOException {
        String[] relevantFields = {
                "Name of Vehicle Owner", "Address", "Contact Information", "Identification Number",
                "Date of Birth", "Email", "Vehicle Identification Number", "Registration Number",
                "Make and Model", "Body Type", "Color", "Weight", "Insurance Provider",
                "Insurance Validity Period", "Policy Number", "Vehicle Type", "Brand", "Dimensions"
        };

        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Name of Vehicle Owner: ")) {
                // Stop parsing if another owner's data is encountered
                break;
            }

            for (String field : relevantFields) {
                if (line.startsWith(field)) {
                    JLabel detailLabel = new JLabel(line);
                    detailLabel.setFont(new Font("Serif", Font.PLAIN, 18));
                    detailLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center-align the text
                    detailsPanel.add(detailLabel);
                }
            }
        }
    }

    private void openViolationPanel() {
        new ViolationFrame(currentOwner); // Pass the current owner's name to the ViolationFrame
        dispose();
    }
}
