import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdminFrame extends frame {
    public AdminFrame() {
        super("Vehicle Registration");
        bodyPanel.setBackground(Color.WHITE); // Set background color for the content pane
        addComponentsToBodyPanel();
    }

    private void addComponentsToBodyPanel() {
        JLabel titleLabel = new JLabel("Vehicle Registration");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setBounds(600, 50, 400, 40);
        bodyPanel.add(titleLabel);

        JLabel VehicleOwner_Label = new JLabel("Name of Vehicle Owner");
        VehicleOwner_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleOwner_Label.setBounds(200, 110, 300, 30);
        bodyPanel.add(VehicleOwner_Label);

        JTextField VehicleOwner_Field = new JTextField();
        VehicleOwner_Field.setBounds(200, 140, 420, 40);
        VehicleOwner_Field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bodyPanel.add(VehicleOwner_Field);

        JLabel Address_Label = new JLabel("Address");
        Address_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Address_Label.setBounds(200, 190, 300, 30);
        bodyPanel.add(Address_Label);

        JTextField Address_Field = new JTextField();
        Address_Field.setBounds(200, 220, 420, 40);
        Address_Field.setBorder(BorderFactory.createLineBorder(Color.black));
        bodyPanel.add(Address_Field);

        JLabel ContactInformation_Label = new JLabel("Contact Information");
        ContactInformation_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        ContactInformation_Label.setBounds(200, 270, 300, 30);
        bodyPanel.add(ContactInformation_Label);

        JTextField ContactInformation_Field = new JTextField();
        ContactInformation_Field.setBounds(200, 300, 420, 40);
        ContactInformation_Field.setBorder(BorderFactory.createLineBorder(Color.black));
        bodyPanel.add(ContactInformation_Field);

        JLabel IdentificationNumber_Label = new JLabel("Identification Number");
        IdentificationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        IdentificationNumber_Label.setBounds(200, 350, 300, 30);
        bodyPanel.add(IdentificationNumber_Label);

        JTextField IdentificationNumber_Field = new JTextField();
        IdentificationNumber_Field.setBounds(200, 380, 420, 40);
        IdentificationNumber_Field.setBorder(BorderFactory.createLineBorder(Color.black));
        bodyPanel.add(IdentificationNumber_Field);

        JLabel DateOfBirth_Label = new JLabel("Date of Birth");
        DateOfBirth_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        DateOfBirth_Label.setBounds(200, 430, 300, 30);
        bodyPanel.add(DateOfBirth_Label);

        JTextField DateOfBirth_Field = new JTextField();
        DateOfBirth_Field.setBounds(200, 460, 420, 40);
        DateOfBirth_Field.setBorder(BorderFactory.createLineBorder(Color.black));
        bodyPanel.add(DateOfBirth_Field);


    }
}