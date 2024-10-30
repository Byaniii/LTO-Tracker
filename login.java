import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login implements ActionListener {
    public static void main(String[] args) {
        JFrame newFrame = new JFrame("Welcome");
        newFrame.setSize(1500, 900);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setLayout(null); // Use null layout for positioning
        newFrame.setResizable(false);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main background panel with a dark blue color
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 1500, 900); // Make it cover the whole frame
        mainPanel.setBackground(new Color(0x041427)); // Set background color to dark blue
        mainPanel.setLayout(null); // Allows absolute positioning within the panel

        // Create a top panel with a red background
        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 1500, 120); // Top panel height is set to 90
        topPanel.setBackground(Color.RED);
        topPanel.setLayout(null); // Use null layout for positioning within this panel

        // Load and add the top-left logo to the top panel
        ImageIcon topLeftLogo = new ImageIcon("LOGO.png");
        JLabel logoLabel = new JLabel(topLeftLogo);
        logoLabel.setBounds(10, 10, topLeftLogo.getIconWidth(), topLeftLogo.getIconHeight());
        topPanel.add(logoLabel); // Add topLeftLogo to the top panel

        // Add "LTO TRACKER" text to the top panel
        JLabel titleLabel = new JLabel("LTO TRACKER");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(120, 30, 200, 50); // Position to the right of the logo
        topPanel.add(titleLabel);

        // Add the top panel to the main panel
        mainPanel.add(topPanel);

        // Add "LTO TRACKER" text in the center
        JLabel centerText = new JLabel("LTO TRACKER", SwingConstants.CENTER);
        centerText.setForeground(Color.WHITE);
        centerText.setFont(new Font("Serif", Font.BOLD, 32));

        // Increase width to fit the full text
        int textWidth = 400; // Adjusted width to ensure the text fits
        int textHeight = 40; // approximate height of the text box
        int x = (1500 - textWidth) / 2;
        int y = (500 - textHeight) / 2 + 200; // adjust '200' to position it under the logo

        centerText.setBounds(x, y, textWidth, textHeight);
        mainPanel.add(centerText);

        mainPanel.add(centerText);

        // Subtitle text: "KEEPING OUR ROADS SAFE"
        JLabel subtitleLabel = new JLabel("\"KEEPING OUR ROADS SAFE\"", SwingConstants.CENTER);
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setFont(new Font("Serif", Font.BOLD, 24));

        // Position subtitle below "LTO TRACKER"
        int subtitleWidth = 400;
        int subtitleHeight = 30;
        int subtitleX = (1500 - subtitleWidth) / 2;
        int subtitleY = y + textHeight + 20; // Position slightly below the "LTO TRACKER" text

        subtitleLabel.setBounds(subtitleX, subtitleY, subtitleWidth, subtitleHeight);
        mainPanel.add(subtitleLabel);

        // Admin button
        JButton adminButton = new JButton("ADMIN");
        adminButton.setFont(new Font("Serif", Font.BOLD, 18));
        adminButton.setBackground(Color.WHITE);
        adminButton.setForeground(Color.BLACK);
        adminButton.setFocusPainted(false);
        adminButton.setFont(new Font("Serif", Font.BOLD, 18));
        adminButton.setBackground(Color.WHITE); // Button background color
        adminButton.setForeground(Color.BLACK); // Text color
        adminButton.setFocusPainted(false); // Removes the default focus border
        adminButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Adds a black border

        // Position the admin button below subtitle
        int buttonWidth = 150;
        int buttonHeight = 50;
        int adminButtonX = (1500 / 2) - buttonWidth - 20; // Place it to the left of center
        int adminButtonY = subtitleY + subtitleHeight + 30;

        adminButton.setBounds(adminButtonX, adminButtonY, buttonWidth, buttonHeight);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create new Frame for Admin
                JFrame adminFrame = new JFrame("ADMIN");
                adminFrame.setSize(500, 500);
                adminFrame.setLocationRelativeTo(null);

                // Create new Panel for Admin
                JPanel adminPanel = new JPanel();
                adminPanel.setLayout(null);
                adminFrame.add(adminPanel);

                // Adds the User Text
                JLabel userLabel = new JLabel("Username");
                userLabel.setHorizontalAlignment(SwingConstants.LEFT); // Align text to the left
                userLabel.setBounds(10, 10, 100, 40); // Position it near the left side with some padding
                adminPanel.add(userLabel);

                // Add text button for username
                JTextField userTextField = new JTextField();
                userTextField.setBounds(100,20,165,25);
                adminPanel.add(userTextField);

                // Add Password Text
                JLabel passwordLabel = new JLabel("Password");
                passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
                passwordLabel.setBounds(10, 50, 100, 25);
                adminPanel.add(passwordLabel);
                adminFrame.setVisible(true);

                // Add Password Text Field
                JTextField passwordTextField = new JTextField();
                passwordTextField.setBounds(100,50,165,25);
                adminPanel.add(passwordTextField);

                // Add Log In Button
                JButton loginButton = new JButton("LOGIN");
                loginButton.setBounds(10,80,80,25);
                adminPanel.add(loginButton);
            }
        });
        mainPanel.add(adminButton);

        // User button
        JButton userButton = new JButton("USER");
        userButton.setFont(new Font("Serif", Font.BOLD, 18));
        userButton.setBackground(Color.WHITE);
        userButton.setForeground(Color.BLACK);
        userButton.setFocusPainted(false);
        userButton.setFont(new Font("Serif", Font.BOLD, 18));
        userButton.setBackground(Color.WHITE);
        userButton.setForeground(Color.BLACK);
        userButton.setFocusPainted(false);
        userButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Position the user button to the right of the admin button
        int userButtonX = (1500 / 2) + 20; // Place it to the right of center
        userButton.setBounds(userButtonX, adminButtonY, buttonWidth, buttonHeight);
        mainPanel.add(userButton);


        // Add the main panel to the new frame
        newFrame.add(mainPanel);

        // Make the new frame visible
        newFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}