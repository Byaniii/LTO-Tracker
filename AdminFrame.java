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

        CustomButton nextButton = CustomButton.createButton("NEXT", 1200, 570, 150, 50);
        nextButton.setBackground(Color.red);
        nextButton.setForeground(Color.white);
        nextButton.setBorder(null);
        bodyPanel.add(nextButton); //
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }
}