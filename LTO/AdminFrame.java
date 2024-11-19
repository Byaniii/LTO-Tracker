package LTO;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class AdminFrame extends frame {
    // Declare the fields as class members
    private CustomTextField VehicleOwner_Field;
    private CustomTextField Address_Field;
    private CustomTextField ContactInformation_Field;
    private CustomTextField IdentificationNumber_Field;
    private CustomTextField DateOfBirth_Field;
    private CustomTextField Email_Field;

    public AdminFrame() {
        super("Vehicle Registration");
        bodyPanel.setBackground(Color.WHITE);
        adminPanel();
    }

    public void adminPanel() {
        bodyPanel.removeAll();

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
        bodyPanel.removeAll();

        JLabel titleLabel = new JLabel("Vehicle Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setBounds(600, 50, 400, 40);
        bodyPanel.add(titleLabel);

        // Initialize and add fields
        VehicleOwner_Field = CustomTextField.createTextField(200, 140, 420, 40);
        Address_Field = CustomTextField.createTextField(200, 220, 420, 40);
        ContactInformation_Field = CustomTextField.createTextField(200, 300, 420, 40);
        IdentificationNumber_Field = CustomTextField.createTextField(200, 380, 420, 40);
        DateOfBirth_Field = CustomTextField.createTextField(200, 460, 420, 40);
        Email_Field = CustomTextField.createTextField(200, 540, 420, 40);

        // Add labels and fields to the panel
        JLabel VehicleOwner_Label = new JLabel("Name of Vehicle Owner");
        VehicleOwner_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleOwner_Label.setBounds(200, 110, 300, 30);
        bodyPanel.add(VehicleOwner_Label);
        bodyPanel.add(VehicleOwner_Field);

        JLabel Address_Label = new JLabel("Address");
        Address_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Address_Label.setBounds(200, 190, 300, 30);
        bodyPanel.add(Address_Label);
        bodyPanel.add(Address_Field);

        JLabel ContactInformation_Label = new JLabel("Contact Information");
        ContactInformation_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        ContactInformation_Label.setBounds(200, 270, 300, 30);
        bodyPanel.add(ContactInformation_Label);
        bodyPanel.add(ContactInformation_Field);

        JLabel IdentificationNumber_Label = new JLabel("Identification Number");
        IdentificationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        IdentificationNumber_Label.setBounds(200, 350, 300, 30);
        bodyPanel.add(IdentificationNumber_Label);
        bodyPanel.add(IdentificationNumber_Field);

        JLabel DateOfBirth_Label = new JLabel("Date of Birth");
        DateOfBirth_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        DateOfBirth_Label.setBounds(200, 430, 300, 30);
        bodyPanel.add(DateOfBirth_Label);
        bodyPanel.add(DateOfBirth_Field);

        JLabel Email_Label = new JLabel("Email");
        Email_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Email_Label.setBounds(200, 510, 300, 30);
        bodyPanel.add(Email_Label);
        bodyPanel.add(Email_Field);

        // Add next button and action listener
        CustomButton nextButton = CustomButton.createRedButton("NEXT", 1200, 570, 150, 50, 30);
        nextButton.addActionListener(e -> {
            if (VehicleOwner_Field.getText().isEmpty() || Address_Field.getText().isEmpty() ||
                    ContactInformation_Field.getText().isEmpty() || IdentificationNumber_Field.getText().isEmpty() ||
                    DateOfBirth_Field.getText().isEmpty() || Email_Field.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                List<String> data = new ArrayList<>();
                data.add("Name of Vehicle Owner: " + VehicleOwner_Field.getText());
                data.add("Address: " + Address_Field.getText());
                data.add("Contact Information: " + ContactInformation_Field.getText());
                data.add("Identification Number: " + IdentificationNumber_Field.getText());
                data.add("Date of Birth: " + DateOfBirth_Field.getText());
                data.add("Email: " + Email_Field.getText());

                FileHandler.saveData(data);

                // Generate and save user credentials
                String email = Email_Field.getText();
                String dateOfBirth = DateOfBirth_Field.getText();
                String password = dateOfBirth; // Using date of birth as the password
                List<String> credentials = new ArrayList<>();
                credentials.add(email + "," + password);
                FileHandler.saveUserCredentials(credentials);

                JOptionPane.showMessageDialog(this, "Vehicle registration data saved successfully! " +
                        "User credentials generated:\nUsername: " + email + "\nPassword: " + password);

                adminPanel();
            }
        });
        bodyPanel.add(nextButton);

        // Add back button
        CustomButton backButton = CustomButton.createRedButton("BACK", 50, 570, 150, 50, 30);
        backButton.addActionListener(e -> adminPanel());
        bodyPanel.add(backButton);

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }
}
