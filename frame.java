import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame {

    public JPanel bodyPanel;

    public frame(String title) {
        // Set up the frame with a given title
        super(title);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        bodyPanel = new JPanel();
        bodyPanel.setLayout(null);
        bodyPanel.setBounds(0, 0, 800, 600);
        add(bodyPanel);
    }

    // Method to create a login panel for Admin/User
    public void createLoginPanel(String loginType) {
        bodyPanel.removeAll(); // Clear any existing components
        bodyPanel.setBackground(Color.white);

        // Login Title Label
        JLabel loginTypeLabel = new JLabel(loginType.toUpperCase() + " LOGIN");
        loginTypeLabel.setBounds(300, 50, 300, 70);
        loginTypeLabel.setFont(new Font("Serif", Font.BOLD, 40));
        loginTypeLabel.setForeground(Color.red);
        bodyPanel.add(loginTypeLabel);

        // Username Label
        JLabel usernameLabel = new JLabel("USERNAME");
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 24));
        usernameLabel.setBounds(150, 150, 300, 30);
        bodyPanel.add(usernameLabel);

        // Text Field for Username
        CustomTextField usernameField = CustomTextField.createTextField(300, 150, 300, 40);
        bodyPanel.add(usernameField);

        // Password Label
        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 24));
        passwordLabel.setBounds(150, 220, 300, 30);
        bodyPanel.add(passwordLabel);

        // Text Field for Password
        CustomTextField passwordField = CustomTextField.createTextField(300, 220, 300, 40);
        bodyPanel.add(passwordField);

        // Login Button
        CustomButton loginButton = new CustomButton("LOGIN");
        loginButton.setBounds(300, 300, 150, 50);
        loginButton.setForeground(Color.white);
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setBackground(Color.red);
        bodyPanel.add(loginButton);

        // Add action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                // Simple login validation for demonstration purposes
                if (loginType.equalsIgnoreCase("admin") && username.equals("admin") && password.equals("adminPass")) {
                    // Open Admin Panel
                    new AdminFrame().setVisible(true);
                    dispose(); // Close the current login frame
                } else if (loginType.equalsIgnoreCase("user") && username.equals("user") && password.equals("userPass")) {
                    // Open User Panel
                    frame userFrame = new frame("User Panel");
                    userFrame.setSize(600, 400);
                    JLabel userWelcomeLabel = new JLabel("Welcome, User!");
                    userWelcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));
                    userWelcomeLabel.setBounds(200, 50, 300, 40);
                    userFrame.bodyPanel.add(userWelcomeLabel);
                    userFrame.setVisible(true);
                    dispose(); // Close the current login frame
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                }
            }
        });

        bodyPanel.repaint();
        bodyPanel.revalidate();
    }

    public CustomButton addButtonToBodyPanel(String text, int x, int y, int width, int height) {
        CustomButton button = new CustomButton(text);
        button.setBounds(x, y, width, height);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(Color.BLUE);
        button.setBorder(null);
        bodyPanel.add(button);
        bodyPanel.repaint();
        bodyPanel.revalidate();
        return button;
    }
}
