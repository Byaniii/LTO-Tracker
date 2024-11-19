package LTO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {
        frame newFrame = new frame("LTO Tracker");
        newFrame.setResizable(false);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        // Admin button
        CustomButton adminButton = newFrame.addButtonToBodyPanel("ADMIN", 400, 450, 300, 80);
        adminButton.addActionListener(e -> {
            newFrame.dispose();
            Login("Admin");
        });

        // User button
        CustomButton userButton = newFrame.addButtonToBodyPanel("USER", 800, 450, 300, 80);
        userButton.addActionListener(e -> {
            newFrame.dispose();
            Login("User");
        });
    }

    private static void Login(String userType) {
        frame newFrame = new frame("Login");
        newFrame.setResizable(false);
        newFrame.setSize(1200, 780);
        newFrame.setLocationRelativeTo(null);
        newFrame.bodyPanel.setBackground(Color.WHITE);

        // Title
        JLabel userLabel = new JLabel(userType + " Login");
        userLabel.setFont(new Font("Serif", Font.BOLD, 40));
        userLabel.setForeground(Color.RED);
        userLabel.setBounds(550, 80, 300, 50);
        newFrame.bodyPanel.add(userLabel);

        // Username and password fields
        JLabel usernameLabel = new JLabel("USERNAME");
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 24));
        usernameLabel.setBounds(250, 220, 300, 30);
        newFrame.bodyPanel.add(usernameLabel);

        CustomTextField usernameField = CustomTextField.createTextField(420, 213, 550, 50);
        newFrame.bodyPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 24));
        passwordLabel.setBounds(247, 313, 300, 30);
        newFrame.bodyPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(420, 306, 550, 50);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        newFrame.bodyPanel.add(passwordField);

        // Login button
        CustomButton loginButton = CustomButton.createRedButton("LOGIN", 828, 385, 143, 37, 20);
        newFrame.bodyPanel.add(loginButton);

        // Back button to return to the home page
        CustomButton backButton = CustomButton.createRedButton("BACK", 420, 385, 143, 37, 20);
        backButton.addActionListener(e -> {
            newFrame.dispose(); // Close the login frame
            main.main(null); // Reopen the home page
        });
        newFrame.bodyPanel.add(backButton);

        // Login button action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.isEmpty() && password.isEmpty()) {
                    JOptionPane.showMessageDialog(newFrame, "Please fill out both fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(newFrame, "Please enter your username.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(newFrame, "Please enter your password.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean isValid;
                    if (userType.equals("Admin")) {
                        isValid = FindHandler.verifyAdmin(username, password);
                    } else {
                        isValid = FindHandler.verifyUser(username, password);
                    }

                    if (isValid) {
                        newFrame.dispose();
                        if (userType.equals("Admin")) {
                            new AdminFrame(); // Open AdminFrame for admin
                        } else {
                            new UserFrame(username); // Open UserFrame for user
                        }
                    } else {
                        JOptionPane.showMessageDialog(newFrame, "Invalid username or password.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
