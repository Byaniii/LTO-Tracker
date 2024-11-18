package LTO;

import java.awt.*;
import javax.swing.JLabel;

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

    }

    private void Register() {
        bodyPanel.removeAll();
        JLabel titleLabel = new JLabel("Vehicle Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setBounds(600, 50, 400, 40);
        bodyPanel.add(titleLabel);

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

        CustomButton nextButton = CustomButton.createRedButton("NEXT", 1200,570,150,50,30);
        nextButton.addActionListener(e -> {
            Register_Next();
        });
        bodyPanel.add(nextButton); //
        bodyPanel.revalidate();
        bodyPanel.repaint();


    }



    private void Register_Next() {
        bodyPanel.removeAll();

        // Title Label
        JLabel titleLabel = new JLabel("Vehicle Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setBounds(600, 40, 315, 39);
        bodyPanel.add(titleLabel);

        // Vehicle Identification Number
        JLabel VehicleIdentificationNumber_Label = new JLabel("Vehicle Identification Number");
        VehicleIdentificationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleIdentificationNumber_Label.setBounds(250, 87, 400, 29);
        bodyPanel.add(VehicleIdentificationNumber_Label);

        CustomTextField VehicleIdentificationNumber_Field = CustomTextField.createTextField(250, 127, 420, 30);
        bodyPanel.add(VehicleIdentificationNumber_Field);

        // Registration Number
        JLabel RegistrationNumber_Label = new JLabel("Registration Number");
        RegistrationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        RegistrationNumber_Label.setBounds(250, 169, 234, 29);
        bodyPanel.add(RegistrationNumber_Label);

        CustomTextField RegistrationNumber_Field = CustomTextField.createTextField(250, 204, 420, 30);
        bodyPanel.add(RegistrationNumber_Field);

        // Make and Model
        JLabel MakeAndModel_Label = new JLabel("Make and Model");
        MakeAndModel_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        MakeAndModel_Label.setBounds(250, 245, 188, 29);
        bodyPanel.add(MakeAndModel_Label);

        CustomTextField MakeAndModel_Field = CustomTextField.createTextField(250, 280, 420, 30);
        bodyPanel.add(MakeAndModel_Field);

        // Body Type
        JLabel BodyType_Label = new JLabel("Body Type");
        BodyType_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        BodyType_Label.setBounds(250, 322, 121, 29);
        bodyPanel.add(BodyType_Label);

        CustomTextField BodyType_Field = CustomTextField.createTextField(250, 358, 420, 30);
        bodyPanel.add(BodyType_Field);

        // Color
        JLabel Color_Label = new JLabel("Color");
        Color_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Color_Label.setBounds(250, 399, 234, 29);
        bodyPanel.add(Color_Label);

        CustomTextField Color_Field = CustomTextField.createTextField(250, 435, 420, 30);
        bodyPanel.add(Color_Field);

        // Weight
        JLabel Weight_Label = new JLabel("Weight");
        Weight_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Weight_Label.setBounds(250, 476, 234, 29);
        bodyPanel.add(Weight_Label);

        CustomTextField Weight_Field = CustomTextField.createTextField(250, 512, 420, 30);
        bodyPanel.add(Weight_Field);

        // Insurance Provider
        JLabel InsuranceProvider_Label = new JLabel("Insurance Provider");
        InsuranceProvider_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        InsuranceProvider_Label.setBounds(850, 87, 300, 30);
        bodyPanel.add(InsuranceProvider_Label);

        CustomTextField InsuranceProvider_Field = CustomTextField.createTextField(850, 127, 420, 30);
        bodyPanel.add(InsuranceProvider_Field);

        // Insurance Validity Period
        JLabel InsuranceValidityPeriod_Label = new JLabel("Insurance Validity Period");
        InsuranceValidityPeriod_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        InsuranceValidityPeriod_Label.setBounds(850, 169, 300, 30);
        bodyPanel.add(InsuranceValidityPeriod_Label);

        CustomTextField InsuranceValidityPeriod_Field = CustomTextField.createTextField(850, 204, 420, 30);
        bodyPanel.add(InsuranceValidityPeriod_Field);

        // Policy Number
        JLabel PolicyNumber_Label = new JLabel("Policy Number");
        PolicyNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        PolicyNumber_Label.setBounds(850, 245, 300, 30);
        bodyPanel.add(PolicyNumber_Label);

        CustomTextField PolicyNumber_Field = CustomTextField.createTextField(850, 280, 420, 30);
        bodyPanel.add(PolicyNumber_Field);

        // Vehicle Type
        JLabel VehicleType_Label = new JLabel("Vehicle Type");
        VehicleType_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleType_Label.setBounds(850, 322, 300, 30);
        bodyPanel.add(VehicleType_Label);

        CustomTextField VehicleType_Field = CustomTextField.createTextField(850, 358, 420, 30);
        bodyPanel.add(VehicleType_Field);

        // Brand
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

        // Finish Button
        CustomButton finishButton = CustomButton.createRedButton("FINISH", 1195, 604, 150, 50, 24);
        bodyPanel.add(finishButton);

        // Refresh the panel
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }










}