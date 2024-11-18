package LTO;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class AdminFrame extends frame {
    public AdminFrame() {
        super("Vehicle Registration");
        bodyPanel.setBackground(Color.WHITE); // Set background color for the content pane
        adminPanel();
    }

    public void adminPanel() {
        JLabel Admin_Label = new JLabel("ADMIN PANEL");
        Admin_Label.setBounds(643, 48, 500, 36);
        Admin_Label.setFont(new Font("Serif", Font.BOLD, 25));
        Admin_Label.setForeground(Color.RED);
        bodyPanel.add(Admin_Label);

        JLabel WelcomeLabel = new JLabel("Welcome, Admin!");
        WelcomeLabel.setBounds(568, 111, 500, 36);
        WelcomeLabel.setFont(new Font("Serif", Font.BOLD, 40));
        bodyPanel.add(WelcomeLabel);

        CustomButton RegisterVehicle = CustomButton.createRedButton("REGISTER VEHICLE", 532, 222, 400, 63, 25);
        bodyPanel.add(RegisterVehicle);

        RegisterVehicle.addActionListener(e -> {
            Register();
        });

        CustomButton FindVehicle = CustomButton.createRedButton("FIND VEHICLE", 532, 318, 400, 63, 25);
        bodyPanel.add(FindVehicle);

        CustomButton Violation = CustomButton.createRedButton("VIOLATION", 532, 414, 400, 63, 25);
        bodyPanel.add(Violation);

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }

    private void Register() {
        bodyPanel.removeAll();

        // Title Label
        JLabel titleLabel = new JLabel("Vehicle Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setBounds(600, 50, 400, 40);
        bodyPanel.add(titleLabel);

        // Labels and Text Fields for Vehicle Registration
        JLabel VehicleOwner_Label = new JLabel("Name of Vehicle Owner");
        VehicleOwner_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleOwner_Label.setBounds(200, 110, 300, 30);
        bodyPanel.add(VehicleOwner_Label);

        CustomTextField VehicleOwner_Field = CustomTextField.createTextField(200, 140, 420, 40);
        bodyPanel.add(VehicleOwner_Field);

        JLabel Address_Label = new JLabel("Address");
        Address_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Address_Label.setBounds(200, 190, 300, 30);
        bodyPanel.add(Address_Label);

        CustomTextField Address_Field = CustomTextField.createTextField(200, 220, 420, 40);
        bodyPanel.add(Address_Field);

        JLabel ContactInformation_Label = new JLabel("Contact Information");
        ContactInformation_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        ContactInformation_Label.setBounds(200, 270, 300, 30);
        bodyPanel.add(ContactInformation_Label);

        CustomTextField ContactInformation_Field = CustomTextField.createTextField(200, 300, 420, 40);
        bodyPanel.add(ContactInformation_Field);

        JLabel IdentificationNumber_Label = new JLabel("Identification Number");
        IdentificationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        IdentificationNumber_Label.setBounds(200, 350, 300, 30);
        bodyPanel.add(IdentificationNumber_Label);

        CustomTextField IdentificationNumber_Field = CustomTextField.createTextField(200, 380, 420, 40);
        bodyPanel.add(IdentificationNumber_Field);

        JLabel DateOfBirth_Label = new JLabel("Date of Birth");
        DateOfBirth_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        DateOfBirth_Label.setBounds(200, 430, 300, 30);
        bodyPanel.add(DateOfBirth_Label);

        CustomTextField DateOfBirth_Field = CustomTextField.createTextField(200, 460, 420, 40);
        bodyPanel.add(DateOfBirth_Field);

        // "Next" Button
        CustomButton nextButton = CustomButton.createRedButton("NEXT", 1200, 570, 150, 50, 25);
        bodyPanel.add(nextButton);

        // Action Listener for the "Next" Button
        nextButton.addActionListener(e -> {
            // Check if any fields are empty
            if (VehicleOwner_Field.getText().isEmpty() ||
                    Address_Field.getText().isEmpty() ||
                    ContactInformation_Field.getText().isEmpty() ||
                    IdentificationNumber_Field.getText().isEmpty() ||
                    DateOfBirth_Field.getText().isEmpty()) {

                // Show a dialog if any field is empty
                JOptionPane.showMessageDialog(this, "All fields must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Collect data and save it
                String vehicleOwner = VehicleOwner_Field.getText();
                String address = Address_Field.getText();
                String contactInformation = ContactInformation_Field.getText();
                String identificationNumber = IdentificationNumber_Field.getText();
                String dateOfBirth = DateOfBirth_Field.getText();

                // Store data in a list
                List<String> data = new ArrayList<>();
                data.add("Name of Vehicle Owner: " + vehicleOwner);
                data.add("Address: " + address);
                data.add("Contact Information: " + contactInformation);
                data.add("Identification Number: " + identificationNumber);
                data.add("Date of Birth: " + dateOfBirth);

                // Save the data using FileHandler
                FileHandler.saveData(data);
                JOptionPane.showMessageDialog(this, "Vehicle registration data saved successfully!");

                // Optionally, clear the fields after saving
                VehicleOwner_Field.setText("");
                Address_Field.setText("");
                ContactInformation_Field.setText("");
                IdentificationNumber_Field.setText("");
                DateOfBirth_Field.setText("");
            }
        });

        // Refresh the panel
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }
}
