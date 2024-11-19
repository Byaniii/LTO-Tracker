package LTO;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindVehicleFrame extends JFrame {
    private CustomTextField VehiclePlateNumber_Field;
    private CustomTextField OwnerName_Field;
    private CustomTextField RegistrationNumber_Field;

    public FindVehicleFrame() {
        setTitle("Find Vehicle");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // Header
        JLabel headerLabel = new JLabel("FIND VEHICLE", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Serif", Font.BOLD, 30));
        headerLabel.setBounds(150, 20, 500, 40);
        add(headerLabel);

        // Vehicle Plate Number
        JLabel plateNumberLabel = new JLabel("VEHICLE PLATE NUMBER");
        plateNumberLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        plateNumberLabel.setBounds(100, 100, 300, 30);
        add(plateNumberLabel);

        VehiclePlateNumber_Field = CustomTextField.createTextField(100, 130, 600, 40);
        add(VehiclePlateNumber_Field);

        // Owner's Name
        JLabel ownerNameLabel = new JLabel("OWNER'S NAME");
        ownerNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        ownerNameLabel.setBounds(100, 200, 300, 30);
        add(ownerNameLabel);

        OwnerName_Field = CustomTextField.createTextField(100, 230, 600, 40);
        add(OwnerName_Field);

        // Registration Number
        JLabel registrationNumberLabel = new JLabel("REGISTRATION NUMBER");
        registrationNumberLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        registrationNumberLabel.setBounds(100, 300, 300, 30);
        add(registrationNumberLabel);

        RegistrationNumber_Field = CustomTextField.createTextField(100, 330, 600, 40);
        add(RegistrationNumber_Field);

        // Note
        JLabel noteLabel = new JLabel("NOTE: You may use any of the following methods to search for vehicle", SwingConstants.CENTER);
        noteLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        noteLabel.setForeground(Color.RED);
        noteLabel.setBounds(50, 400, 700, 30);
        add(noteLabel);

        // "Main Menu" button
        CustomButton mainMenuButton = CustomButton.createRedButton("MAIN MENU", 50, 500, 150, 50, 20);
        mainMenuButton.addActionListener(e -> {
            new AdminFrame();
            dispose();
        });
        add(mainMenuButton);

        // "Search" button
        CustomButton searchButton = CustomButton.createRedButton("SEARCH", 600, 500, 150, 50, 20);
        searchButton.addActionListener(e -> searchVehicle());
        add(searchButton);

        setVisible(true);
    }

    private void searchVehicle() {
        String plateNumber = VehiclePlateNumber_Field.getText().toLowerCase().trim();
        String ownerName = OwnerName_Field.getText().toLowerCase().trim();
        String registrationNumber = RegistrationNumber_Field.getText().toLowerCase().trim();

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\vival\\IdeaProjects\\LTO-Tracker\\LTO\\vehicle_registration_data.txt"))) {
            String line;
            StringBuilder vehicleData = new StringBuilder();
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(plateNumber) || line.toLowerCase().contains(ownerName) || line.toLowerCase().contains(registrationNumber)) {
                    found = true;
                    vehicleData.append(line).append("\n");
                    // Collect next lines for details
                    for (int i = 0; i < 17; i++) {
                        vehicleData.append(reader.readLine()).append("\n");
                    }
                    break;
                }
            }

            if (found) {
                new VehicleDetailsFrame(vehicleData.toString()); // Open the details frame
                dispose(); // Close the FindVehicleFrame
            } else {
                JOptionPane.showMessageDialog(this, "No matching vehicle details found.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading the file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
