package LTO;

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
        newFrame.setResizable(false);
        newFrame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        // Resize LOGO
        ImageIcon Icon = new ImageIcon("LTO/logo.png");
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
        subtitleLabel.setBounds(455, 364, 610, 53);
        newFrame.bodyPanel.add(subtitleLabel);

        CustomButton adminButton = newFrame.addButtonToBodyPanel("ADMIN", 400, 450, 300, 80);
        adminButton.addActionListener(e -> {
            newFrame.dispose();
            Login("Admin");
        });

        CustomButton userButton = newFrame.addButtonToBodyPanel("USER", 800, 450, 300, 80);
        userButton.addActionListener(e -> {
            newFrame.dispose();
            Login("User");
        });

    }

    private static void Login(String WhichUser) {
        frame newFrame = new frame("Login");
        newFrame.setResizable(false);
        newFrame.setSize(1200, 780); // Set the size of the frame
        newFrame.setLocationRelativeTo(null); // Center the frame on the screen
        newFrame.bodyPanel.setBackground(Color.WHITE);

        // Centered title text
        JLabel Admin_Label = new JLabel(WhichUser);
        Admin_Label.setBounds(550, 80, 200, 70); // Moved slightly to the left
        Admin_Label.setFont(new Font("Serif", Font.BOLD, 40));
        Admin_Label.setForeground(Color.RED);
        newFrame.bodyPanel.add(Admin_Label);

        // Username text and field
        JLabel Username_Label = new JLabel("USERNAME");
        Username_Label.setFont(new Font("Serif", Font.BOLD, 24));
        Username_Label.setBounds(250, 220, 300, 30); // Moved to the left
        newFrame.bodyPanel.add(Username_Label);

        CustomTextField Username_Field = CustomTextField.createTextField(420, 213, 550, 50); // Moved to the left
        newFrame.bodyPanel.add(Username_Field);

        // Password text and field
        JLabel Password_Label = new JLabel("PASSWORD");
        Password_Label.setFont(new Font("Serif", Font.BOLD, 24));
        Password_Label.setBounds(247, 313, 300, 30); // Moved to the left
        newFrame.bodyPanel.add(Password_Label);

        JPasswordField Password_Field = new JPasswordField();
        Password_Field.setBounds(420, 306, 550, 50); // Moved to the left
        Password_Field.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        newFrame.bodyPanel.add(Password_Field);

        // Login button
        CustomButton Login_Button = CustomButton.createRedButton("LOGIN", 828, 385, 143, 37, 20); // Moved to the left
        newFrame.bodyPanel.add(Login_Button);

        // "Back" button to return to the home page
        CustomButton Back_Button = CustomButton.createRedButton("BACK", 420, 385, 143, 37, 20); // Positioned to the left
        Back_Button.addActionListener(e -> {
            newFrame.dispose(); // Close the login frame
            main.main(null); // Reopen the home page
        });
        newFrame.bodyPanel.add(Back_Button);

        // Action listener for the login button
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
                    new AdminFrame(); // Open the AdminFrame for admin users
                    newFrame.dispose(); // Close the login frame
                } else if (username.equals("user") && password.equals("123")) {
                    new UserFrame(username); // Open the UserFrame for regular users
                    newFrame.dispose(); // Close the login frame
                } else {
                    JOptionPane.showMessageDialog(newFrame, "Invalid username or password.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}




