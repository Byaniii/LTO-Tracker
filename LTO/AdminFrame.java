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
    private CustomTextField VehicleIdentificationNumber_Field;
    private CustomTextField RegistrationNumber_Field;
    private CustomTextField MakeAndModel_Field;
    private CustomTextField BodyType_Field;
    private CustomTextField Color_Field;
    private CustomTextField Weight_Field;
    private CustomTextField InsuranceProvider_Field;
    private CustomTextField InsuranceValidityPeriod_Field;
    private CustomTextField PolicyNumber_Field;
    private CustomTextField VehicleType_Field;
    private CustomTextField Brand_Field;
    private CustomTextField Dimensions_Field;

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
        FindVehicle.addActionListener(e -> {
            dispose(); // Close the AdminFrame
            new FindVehicleFrame(); // Open the FindVehicleFrame
        });
        bodyPanel.add(FindVehicle);


        // LOGOUT button
        CustomButton logoutButton = CustomButton.createRedButton("LOGOUT", 50, 50, 400, 120, 28); // Match size and style
        logoutButton.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
        logoutButton.addActionListener(e -> {
            dispose(); // Close the current AdminFrame
            main.main(null); // Redirect to the main frame (home page)
        });

        // Footer panel to hold the logout button
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align to the left
        footerPanel.setBackground(Color.WHITE); // Match background color
        footerPanel.add(logoutButton);

        add(footerPanel, BorderLayout.SOUTH); // Add footer panel to the main frame

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }

    private void Register() {
        bodyPanel.removeAll(); // Clear the panel

        JLabel titleLabel = new JLabel("Vehicle Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setBounds(600, 20, 400, 40);
        bodyPanel.add(titleLabel);

        // Adjust the y-positioning for each label and text field
        int yPosition = 80;
        int labelHeight = 30;
        int fieldHeight = 40;
        int spacing = 20;

        // First Part of the Registration Form
        JLabel VehicleOwner_Label = new JLabel("Name of Vehicle Owner");
        VehicleOwner_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleOwner_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(VehicleOwner_Label);

        VehicleOwner_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(VehicleOwner_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        JLabel Address_Label = new JLabel("Address");
        Address_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Address_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(Address_Label);

        Address_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(Address_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        JLabel ContactInformation_Label = new JLabel("Contact Information");
        ContactInformation_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        ContactInformation_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(ContactInformation_Label);

        ContactInformation_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(ContactInformation_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        JLabel IdentificationNumber_Label = new JLabel("Identification Number");
        IdentificationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        IdentificationNumber_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(IdentificationNumber_Label);

        IdentificationNumber_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(IdentificationNumber_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        JLabel DateOfBirth_Label = new JLabel("Date of Birth");
        DateOfBirth_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        DateOfBirth_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(DateOfBirth_Label);

        DateOfBirth_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(DateOfBirth_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        JLabel Email_Label = new JLabel("Email");
        Email_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Email_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(Email_Label);

        Email_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(Email_Field);

        // Add next and back buttons
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

                Register_Next(); // Proceed to the next form
            }
        });
        bodyPanel.add(nextButton);

        CustomButton backButton = CustomButton.createRedButton("BACK", 1000, 570, 150, 50, 30);
        backButton.addActionListener(e -> adminPanel());
        bodyPanel.add(backButton);

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }

    private void Register_Next() {
        bodyPanel.removeAll();

        JLabel titleLabel = new JLabel("Vehicle Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setBounds(600, 20, 400, 40);
        bodyPanel.add(titleLabel);

        // Initialize and add fields for vehicle details
        int yPosition = 80; // Starting y-position
        int labelHeight = 30;
        int fieldHeight = 40;
        int spacing = 20;

        // Vehicle Identification Number
        JLabel VehicleIdentificationNumber_Label = new JLabel("Vehicle Identification Number");
        VehicleIdentificationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleIdentificationNumber_Label.setBounds(250, yPosition, 400, labelHeight);
        bodyPanel.add(VehicleIdentificationNumber_Label);

        VehicleIdentificationNumber_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(VehicleIdentificationNumber_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        // Registration Number
        JLabel RegistrationNumber_Label = new JLabel("Registration Number");
        RegistrationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        RegistrationNumber_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(RegistrationNumber_Label);

        RegistrationNumber_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(RegistrationNumber_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        // Make and Model
        JLabel MakeAndModel_Label = new JLabel("Make and Model");
        MakeAndModel_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        MakeAndModel_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(MakeAndModel_Label);

        MakeAndModel_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(MakeAndModel_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        // Body Type
        JLabel BodyType_Label = new JLabel("Body Type");
        BodyType_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        BodyType_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(BodyType_Label);

        BodyType_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(BodyType_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        // Color
        JLabel Color_Label = new JLabel("Color");
        Color_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Color_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(Color_Label);

        Color_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(Color_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        // Weight
        JLabel Weight_Label = new JLabel("Weight");
        Weight_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Weight_Label.setBounds(250, yPosition, 300, labelHeight);
        bodyPanel.add(Weight_Label);

        Weight_Field = CustomTextField.createTextField(250, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(Weight_Field);

        yPosition = 80; // Reset y-position for the right side of the form

        // Insurance Provider
        JLabel InsuranceProvider_Label = new JLabel("Insurance Provider");
        InsuranceProvider_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        InsuranceProvider_Label.setBounds(850, yPosition, 300, labelHeight);
        bodyPanel.add(InsuranceProvider_Label);

        InsuranceProvider_Field = CustomTextField.createTextField(850, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(InsuranceProvider_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        // Insurance Validity Period
        JLabel InsuranceValidityPeriod_Label = new JLabel("Insurance Validity Period");
        InsuranceValidityPeriod_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        InsuranceValidityPeriod_Label.setBounds(850, yPosition, 300, labelHeight);
        bodyPanel.add(InsuranceValidityPeriod_Label);

        InsuranceValidityPeriod_Field = CustomTextField.createTextField(850, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(InsuranceValidityPeriod_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        // Policy Number
        JLabel PolicyNumber_Label = new JLabel("Policy Number");
        PolicyNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        PolicyNumber_Label.setBounds(850, yPosition, 300, labelHeight);
        bodyPanel.add(PolicyNumber_Label);

        PolicyNumber_Field = CustomTextField.createTextField(850, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(PolicyNumber_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        // Vehicle Type
        JLabel VehicleType_Label = new JLabel("Vehicle Type");
        VehicleType_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleType_Label.setBounds(850, yPosition, 300, labelHeight);
        bodyPanel.add(VehicleType_Label);

        VehicleType_Field = CustomTextField.createTextField(850, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(VehicleType_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        // Brand
        JLabel Brand_Label = new JLabel("Brand");
        Brand_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Brand_Label.setBounds(850, yPosition, 300, labelHeight);
        bodyPanel.add(Brand_Label);

        Brand_Field = CustomTextField.createTextField(850, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(Brand_Field);

        yPosition += labelHeight + fieldHeight + spacing;

        // Dimensions
        JLabel Dimensions_Label = new JLabel("Dimensions");
        Dimensions_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Dimensions_Label.setBounds(850, yPosition, 300, labelHeight);
        bodyPanel.add(Dimensions_Label);

        Dimensions_Field = CustomTextField.createTextField(850, yPosition + labelHeight, 420, fieldHeight);
        bodyPanel.add(Dimensions_Field);

        // Add a "Finish" button
        CustomButton finishButton = CustomButton.createRedButton("FINISH", 1195, 650, 150, 50, 24);
        finishButton.addActionListener(e -> {
            if (VehicleIdentificationNumber_Field.getText().isEmpty() || RegistrationNumber_Field.getText().isEmpty() ||
                    MakeAndModel_Field.getText().isEmpty() || BodyType_Field.getText().isEmpty() ||
                    Color_Field.getText().isEmpty() || Weight_Field.getText().isEmpty() ||
                    InsuranceProvider_Field.getText().isEmpty() || InsuranceValidityPeriod_Field.getText().isEmpty() ||
                    PolicyNumber_Field.getText().isEmpty() || VehicleType_Field.getText().isEmpty() ||
                    Brand_Field.getText().isEmpty() || Dimensions_Field.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                List<String> vehicleData = new ArrayList<>();
                vehicleData.add("Vehicle Identification Number: " + VehicleIdentificationNumber_Field.getText());
                vehicleData.add("Registration Number: " + RegistrationNumber_Field.getText());
                vehicleData.add("Make and Model: " + MakeAndModel_Field.getText());
                vehicleData.add("Body Type: " + BodyType_Field.getText());
                vehicleData.add("Color: " + Color_Field.getText());
                vehicleData.add("Weight: " + Weight_Field.getText());
                vehicleData.add("Insurance Provider: " + InsuranceProvider_Field.getText());
                vehicleData.add("Insurance Validity Period: " + InsuranceValidityPeriod_Field.getText());
                vehicleData.add("Policy Number: " + PolicyNumber_Field.getText());
                vehicleData.add("Vehicle Type: " + VehicleType_Field.getText());
                vehicleData.add("Brand: " + Brand_Field.getText());
                vehicleData.add("Dimensions: " + Dimensions_Field.getText());

                FileHandler.saveData(vehicleData);
                JOptionPane.showMessageDialog(this, "All vehicle data saved successfully!");
                adminPanel();
            }
        });
        bodyPanel.add(finishButton);

        CustomButton backButton = CustomButton.createRedButton("BACK", 108, 650, 150, 50, 24);
        backButton.addActionListener(e -> Register());
        bodyPanel.add(backButton);

        bodyPanel.revalidate();
        bodyPanel.repaint();
    }
}
