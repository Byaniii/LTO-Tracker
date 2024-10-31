import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login implements ActionListener {

    private static JFrame welcomeFrame;
    private static JFrame loginFrame;
    private static JFrame adminDashboardFrame;

    public static void main(String[] args) {
        createWelcomeFrame();
    }

    // Method to create the welcome frame
    private static void createWelcomeFrame() {
        welcomeFrame = new JFrame("Welcome");
        welcomeFrame.setSize(1500, 900);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLayout(null); // Use null layout for positioning
        welcomeFrame.setResizable(false);

        // Create the main background panel with a dark blue color
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 1500, 900);
        mainPanel.setBackground(new Color(0x041427)); // Set background color to dark blue
        mainPanel.setLayout(null); // Allows absolute positioning within the panel

        // Add top panel
        JPanel topPanel = createTopPanel();
        mainPanel.add(topPanel);

        // Centered "LTO TRACKER" text
        JLabel centerText = new JLabel("LTO TRACKER", SwingConstants.CENTER);
        centerText.setForeground(Color.WHITE);
        centerText.setFont(new Font("Serif", Font.BOLD, 32));
        centerText.setBounds((1500 - 400) / 2, 300, 400, 40); // Position in center
        mainPanel.add(centerText);

        // Subtitle text: "KEEPING OUR ROADS SAFE"
        JLabel subtitleLabel = new JLabel("\"KEEPING OUR ROADS SAFE\"", SwingConstants.CENTER);
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        subtitleLabel.setBounds((1500 - 400) / 2, 360, 400, 30);
        mainPanel.add(subtitleLabel);

        // Add admin and user buttons
        JButton adminButton = createAdminButton();
        mainPanel.add(adminButton);

        JButton userButton = createUserButton();
        mainPanel.add(userButton);

        welcomeFrame.add(mainPanel);
        welcomeFrame.setVisible(true);
    }

    // Method to create the top panel
    private static JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1500, 120));
        topPanel.setBackground(Color.RED);
        topPanel.setLayout(null);

        // Load and add the top-left logo to the top panel
        ImageIcon topLeftLogo = new ImageIcon("LOGO.png");
        JLabel logoLabel = new JLabel(topLeftLogo);
        logoLabel.setBounds(10, 10, topLeftLogo.getIconWidth(), topLeftLogo.getIconHeight());
        topPanel.add(logoLabel);

        // Add "LTO TRACKER" text to the top panel
        JLabel titleLabel = new JLabel("LTO TRACKER");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(120, 30, 200, 50); // Position to the right of the logo
        topPanel.add(titleLabel);

        return topPanel;
    }

    // Method to create the Admin button
    private static JButton createAdminButton() {
        JButton adminButton = new JButton("ADMIN");
        adminButton.setFont(new Font("Serif", Font.BOLD, 18));
        adminButton.setBackground(Color.WHITE);
        adminButton.setForeground(Color.BLACK);
        adminButton.setFocusPainted(false);
        adminButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        adminButton.setBounds((1500 / 2) - 200, 450, 150, 50); // Place it to the left of center

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLoginFrame();
            }
        });

        return adminButton;
    }

    // Method to create the User button
    private static JButton createUserButton() {
        JButton userButton = new JButton("USER");
        userButton.setFont(new Font("Serif", Font.BOLD, 18));
        userButton.setBackground(Color.WHITE);
        userButton.setForeground(Color.BLACK);
        userButton.setFocusPainted(false);
        userButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        userButton.setBounds((1500 / 2) + 50, 450, 150, 50); // Place it to the right of center

        return userButton;
    }

    // Method to create the login frame
    private static void createLoginFrame() {
        loginFrame = new JFrame("ADMIN LOGIN");
        loginFrame.setSize(500, 500);
        loginFrame.setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginFrame.add(loginPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username Label and Field
        JLabel userLabel = new JLabel("Username");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(userLabel, gbc);

        JTextField userTextField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginPanel.add(userTextField, gbc);

        // Password Label and Field
        JLabel passwordLabel = new JLabel("Password");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginPanel.add(passwordLabel, gbc);

        JPasswordField passwordTextField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginPanel.add(passwordTextField, gbc);

        // Login Button with action to verify and open admin dashboard
        JButton loginButton = new JButton("LOGIN");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userTextField.getText();
                String password = new String(passwordTextField.getPassword());

                // Validate credentials
                if (username.equals("yanyan") && password.equals("3211")) {
                    welcomeFrame.dispose();
                    loginFrame.dispose();
                    createAdminDashboardFrame();
                }
            }
        });

        loginFrame.setVisible(true);
    }

    // Method to create the main admin dashboard frame after successful login
    private static void createAdminDashboardFrame() {
        adminDashboardFrame = new JFrame("Admin Dashboard");
        adminDashboardFrame.setSize(1500, 900);
        adminDashboardFrame.setLocationRelativeTo(null);
        adminDashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel with dark blue background
        JPanel mainAdminPanel = new JPanel(new BorderLayout());
        mainAdminPanel.setBackground(new Color(0x041427)); // Set background color to dark blue

        // Add top panel to main admin panel
        JPanel topPanel = createTopPanel();
        topPanel.setBackground(Color.RED); // Ensure top panel has red background
        mainAdminPanel.add(topPanel, BorderLayout.NORTH);

        // Add mainAdminPanel to adminDashboardFrame
        adminDashboardFrame.add(mainAdminPanel);
        adminDashboardFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This can be used for general ActionListener logic if needed
    }
}
