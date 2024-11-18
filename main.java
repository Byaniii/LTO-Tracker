
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class main {
    public static void main(String[] args) {
        frame newFrame = new frame("LTO Tracker");

        // Resize LOGO
        ImageIcon Icon = new ImageIcon("logo.png");
        Image resizedImage = Icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Center LOGO
        JLabel logoLabel = new JLabel(resizedIcon);
        logoLabel.setBounds(633, 39, 250, 250);
        newFrame.bodyPanel.add(logoLabel);

        // Title text: "LTO TRACKER"
        JLabel centerText = new JLabel("LTO TRACKER");
        centerText.setForeground(Color.WHITE);
        centerText.setFont(new Font("Serif", Font.BOLD, 35));
        centerText.setBounds(630, 289, 700, 48);
        newFrame.bodyPanel.add(centerText);

        // Subtitle text: "KEEPING OUR ROADS SAFE"
        JLabel subtitleLabel = new JLabel("\"KEEPING OUR ROADS SAFE\"", SwingConstants.CENTER);
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setFont(new Font("Serif", Font.BOLD, 40));
        subtitleLabel.setBounds(455, 364, 590, 53);
        newFrame.bodyPanel.add(subtitleLabel);

        CustomButton adminButton = newFrame.addButtonToBodyPanel("ADMIN", 400, 450, 300, 80);
        adminButton.addActionListener(e -> {
            AdminLogin();
        });

        CustomButton userButton = newFrame.addButtonToBodyPanel("USER", 800, 450, 300, 80);
        userButton.addActionListener(e -> {
            AdminLogin();
        });
    }

    private static void AdminLogin() {
        frame newFrame = new frame("Login");
        newFrame.bodyPanel.setBackground(Color.white);

        //Centered Admin text
        JLabel Admin_Label = new JLabel("ADMIN");
        Admin_Label.setBounds(670, 80, 200, 70);
        Admin_Label.setFont(new Font("Serif", Font.BOLD, 40));
        Admin_Label.setForeground(Color.red);
        newFrame.bodyPanel.add(Admin_Label);

        //Username text
        JLabel Username_Label = new JLabel("USERNAME");
        Username_Label.setFont(new Font("Serif", Font.BOLD, 24));
        Username_Label.setBounds(300, 220, 300, 30);
        newFrame.bodyPanel.add(Username_Label);

        //Text field for Username
        CustomTextField Username_Field = CustomTextField.createTextField(470, 213, 550, 50);
        newFrame.bodyPanel.add(Username_Field);

        //Password Text
        JLabel Password_Label = new JLabel("PASSWORD");
        Password_Label.setFont(new Font("Serif", Font.BOLD, 24));
        Password_Label.setBounds(297, 313, 300, 30);
        newFrame.bodyPanel.add(Password_Label);

        //Text field for Password
        CustomTextField Password_Field = CustomTextField.createTextField(470, 306, 550, 50);
        newFrame.bodyPanel.add(Password_Field);

        //Sample Login button for testing lang
        CustomButton Login_Button = newFrame.addButtonToBodyPanel("LOGIN", 878, 385, 143, 37);
        Login_Button.setForeground(Color.white);
        Login_Button.setFont(new Font("Arial", Font.BOLD,20));
        Login_Button.setBackground(Color.red);
        Login_Button.setBorder(null);

        Login_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose();
            }
        });
    }
}
