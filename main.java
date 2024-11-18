
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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
        JPasswordField Password_Field = new JPasswordField();
        Password_Field.setBounds(470, 306, 550, 50);
        Password_Field.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        newFrame.bodyPanel.add(Password_Field);

        //Sample Login button for testing lang
        CustomButton Login_Button = CustomButton.createRedButton("LOGIN", 878, 385, 143, 37, 20);
        newFrame.bodyPanel.add(Login_Button);

        Login_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = Username_Field.getText();
                String password = new String(Password_Field.getPassword());

                if (username.isEmpty() && password.isEmpty()) {
                    JOptionPane.showMessageDialog(newFrame, "Please fill out both fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(newFrame, "Please enter your username.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(newFrame, "Please enter your password.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (username.equals("admin") && password.equals("123")) {
                    AdminFrame adminFrame = new AdminFrame();
                    newFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(newFrame, "Invalid username or password.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}





