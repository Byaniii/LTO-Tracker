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
        bodyPanel.removeAll(); // Clear the panel

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

        RegisterVehicle.addActionListener(e -> Register());

        CustomButton FindVehicle = CustomButton.createRedButton("FIND VEHICLE", 532, 318, 400, 63, 25);
        bodyPanel.add(FindVehicle);

        CustomButton Violation = CustomButton.createRedButton("VIOLATION", 532, 414, 400, 63, 25);
        bodyPanel.add(Violation);

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }

    private void Register() {
        bodyPanel.removeAll(); // Clear the panel

        JLabel titleLabel = new JLabel("Vehicle Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setBounds(600, 50, 400, 40);
        bodyPanel.add(titleLabel);

        // First Part of the Registration Form
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

        // New Email field
        JLabel Email_Label = new JLabel("Email");
        Email_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Email_Label.setBounds(200, 510, 300, 30);
        bodyPanel.add(Email_Label);

        CustomTextField Email_Field = CustomTextField.createTextField(200, 540, 420, 40);
        bodyPanel.add(Email_Field);

        CustomButton nextButton = CustomButton.createRedButton("NEXT", 1200, 570, 150, 50, 30);
        nextButton.addActionListener(e -> {
            // Check if any fields are empty
            if (VehicleOwner_Field.getText().isEmpty() || Address_Field.getText().isEmpty() ||
                    ContactInformation_Field.getText().isEmpty() || IdentificationNumber_Field.getText().isEmpty() ||
                    DateOfBirth_Field.getText().isEmpty() || Email_Field.getText().isEmpty()) {

                // Show a dialog if any field is empty
                JOptionPane.showMessageDialog(this, "All fields must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Collect data from text fields
                List<String> data = new ArrayList<>();
                data.add("Name of Vehicle Owner: " + VehicleOwner_Field.getText());
                data.add("Address: " + Address_Field.getText());
                data.add("Contact Information: " + ContactInformation_Field.getText());
                data.add("Identification Number: " + IdentificationNumber_Field.getText());
                data.add("Date of Birth: " + DateOfBirth_Field.getText());
                data.add("Email: " + Email_Field.getText()); // Added Email data

                // Save the data using FileHandler
                FileHandler.saveData(data);
                JOptionPane.showMessageDialog(this, "Vehicle registration data saved successfully!");

                // Proceed to the next registration form
                Register_Next();
            }
        });
        bodyPanel.add(nextButton);

        // Add a "Back" button
        CustomButton backButton = CustomButton.createRedButton("BACK", 50, 570, 150, 50, 30);
        backButton.addActionListener(e -> adminPanel()); // Go back to the admin panel
        bodyPanel.add(backButton);

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }


    private void Register_Next() {
        bodyPanel.removeAll(); // Clear the panel

        JLabel titleLabel = new JLabel("Vehicle Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setBounds(600, 40, 315, 39);
        bodyPanel.add(titleLabel);

        // Second Part of the Registration Form
        JLabel VehicleIdentificationNumber_Label = new JLabel("Vehicle Identification Number");
        VehicleIdentificationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleIdentificationNumber_Label.setBounds(250, 87, 400, 29);
        bodyPanel.add(VehicleIdentificationNumber_Label);

        CustomTextField VehicleIdentificationNumber_Field = CustomTextField.createTextField(250, 127, 420, 30);
        bodyPanel.add(VehicleIdentificationNumber_Field);

        JLabel RegistrationNumber_Label = new JLabel("Registration Number");
        RegistrationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        RegistrationNumber_Label.setBounds(250, 169, 234, 29);
        bodyPanel.add(RegistrationNumber_Label);

        CustomTextField RegistrationNumber_Field = CustomTextField.createTextField(250, 204, 420, 30);
        bodyPanel.add(RegistrationNumber_Field);

        JLabel MakeAndModel_Label = new JLabel("Make and Model");
        MakeAndModel_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        MakeAndModel_Label.setBounds(250, 245, 188, 29);
        bodyPanel.add(MakeAndModel_Label);

        CustomTextField MakeAndModel_Field = CustomTextField.createTextField(250, 280, 420, 30);
        bodyPanel.add(MakeAndModel_Field);

        JLabel BodyType_Label = new JLabel("Body Type");
        BodyType_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        BodyType_Label.setBounds(250, 322, 121, 29);
        bodyPanel.add(BodyType_Label);

        CustomTextField BodyType_Field = CustomTextField.createTextField(250, 358, 420, 30);
        bodyPanel.add(BodyType_Field);

        JLabel Color_Label = new JLabel("Color");
        Color_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Color_Label.setBounds(250, 399, 234, 29);
        bodyPanel.add(Color_Label);

        CustomTextField Color_Field = CustomTextField.createTextField(250, 435, 420, 30);
        bodyPanel.add(Color_Field);

        JLabel Weight_Label = new JLabel("Weight");
        Weight_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Weight_Label.setBounds(250, 476, 234, 29);
        bodyPanel.add(Weight_Label);

        CustomTextField Weight_Field = CustomTextField.createTextField(250, 512, 420, 30);
        bodyPanel.add(Weight_Field);

        JLabel InsuranceProvider_Label = new JLabel("Insurance Provider");
        InsuranceProvider_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        InsuranceProvider_Label.setBounds(850, 87, 300, 30);
        bodyPanel.add(InsuranceProvider_Label);

        CustomTextField InsuranceProvider_Field = CustomTextField.createTextField(850, 127, 420, 30);
        bodyPanel.add(InsuranceProvider_Field);

        JLabel InsuranceValidityPeriod_Label = new JLabel("Insurance Validity Period");
        InsuranceValidityPeriod_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        InsuranceValidityPeriod_Label.setBounds(850, 169, 300, 30);
        bodyPanel.add(InsuranceValidityPeriod_Label);

        CustomTextField InsuranceValidityPeriod_Field = CustomTextField.createTextField(850, 204, 420, 30);
        bodyPanel.add(InsuranceValidityPeriod_Field);

        JLabel PolicyNumber_Label = new JLabel("Policy Number");
        PolicyNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        PolicyNumber_Label.setBounds(850, 245, 300, 30);
        bodyPanel.add(PolicyNumber_Label);

        CustomTextField PolicyNumber_Field = CustomTextField.createTextField(850, 280, 420, 30);
        bodyPanel.add(PolicyNumber_Field);

        JLabel VehicleType_Label = new JLabel("Vehicle Type");
        VehicleType_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleType_Label.setBounds(850, 322, 300, 30);
        bodyPanel.add(VehicleType_Label);

        CustomTextField VehicleType_Field = CustomTextField.createTextField(850, 358, 420, 30);
        bodyPanel.add(VehicleType_Field);

        JLabel Brand_Label = new JLabel("Brand");
        Brand_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Brand_Label.setBounds(850, 399, 300, 30);
        bodyPanel.add(Brand_Label);

        CustomTextField Brand_Field = CustomTextField.createTextField(850, 435, 420, 30);
        bodyPanel.add(Brand_Field);

        JLabel Dimensions_Label = new JLabel("Dimensions");
        Dimensions_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Dimensions_Label.setBounds(850, 476, 300, 30);
        bodyPanel.add(Dimensions_Label);

        CustomTextField Dimensions_Field = CustomTextField.createTextField(850, 512, 420, 30);
        bodyPanel.add(Dimensions_Field);

        CustomButton finishButton = CustomButton.createRedButton("FINISH", 1195, 604, 150, 50, 24);
        finishButton.addActionListener(e -> {
            // Check if any fields are empty
            if (VehicleIdentificationNumber_Field.getText().isEmpty() || RegistrationNumber_Field.getText().isEmpty() ||
                    MakeAndModel_Field.getText().isEmpty() || BodyType_Field.getText().isEmpty() ||
                    Color_Field.getText().isEmpty() || Weight_Field.getText().isEmpty() ||
                    InsuranceProvider_Field.getText().isEmpty() || InsuranceValidityPeriod_Field.getText().isEmpty() ||
                    PolicyNumber_Field.getText().isEmpty() || VehicleType_Field.getText().isEmpty() ||
                    Brand_Field.getText().isEmpty() || Dimensions_Field.getText().isEmpty()) {

                // Show a dialog if any field is empty
                JOptionPane.showMessageDialog(this, "All fields must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Collect data from text fields
                List<String> data = new ArrayList<>();
                data.add("Vehicle Identification Number: " + VehicleIdentificationNumber_Field.getText());
                data.add("Registration Number: " + RegistrationNumber_Field.getText());
                data.add("Make and Model: " + MakeAndModel_Field.getText());
                data.add("Body Type: " + BodyType_Field.getText());
                data.add("Color: " + Color_Field.getText());
                data.add("Weight: " + Weight_Field.getText());
                data.add("Insurance Provider: " + InsuranceProvider_Field.getText());
                data.add("Insurance Validity Period: " + InsuranceValidityPeriod_Field.getText());
                data.add("Policy Number: " + PolicyNumber_Field.getText());
                data.add("Vehicle Type: " + VehicleType_Field.getText());
                data.add("Brand: " + Brand_Field.getText());
                data.add("Dimensions: " + Dimensions_Field.getText());

                // Save the data using FileHandler
                FileHandler.saveData(data);
                JOptionPane.showMessageDialog(this, "All vehicle data saved successfully!");
                adminPanel(); // Return to the admin panel after saving
            }
        });
        bodyPanel.add(finishButton);

        // Add a "Back" button
        CustomButton backButton = CustomButton.createRedButton("BACK", 50, 604, 150, 50, 24);
        backButton.addActionListener(e -> Register()); // Go back to the first part of the registration form
        bodyPanel.add(backButton);

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }
}
