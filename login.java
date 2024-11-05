import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//PULL
public class login implements ActionListener {

    private static JFrame welcomeFrame;
    private static JFrame loginFrame;
    private static JFrame adminDashboardFrame;
    private static JButton resetButton; // reset button
    private static JLabel errorLabel; //added para sa error message

    public static void main(String[] args) {
        createWelcomeFrame();
    }

    // Method to create the welcome frame
    private static void createWelcomeFrame() {
        welcomeFrame = new JFrame("Welcome");
        welcomeFrame.setSize(1500, 900);
        welcomeFrame.setLocationRelativeTo(null);
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setLayout(new BorderLayout()); // Use BorderLayout for structured layout
        welcomeFrame.setResizable(false);

        // Create the main background panel with a dark blue color
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(0x041427)); // Set background color to dark blue
        mainPanel.setLayout(null); // Allows absolute positioning within the panel

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

        // Add top panel with logo and title to the top of the main welcome frame
        JPanel topPanel = createTopPanel();
        welcomeFrame.add(topPanel, BorderLayout.NORTH);
        welcomeFrame.add(mainPanel, BorderLayout.CENTER);

        welcomeFrame.setVisible(true);
    }

    // Method to create the top panel with logo and title
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
        adminButton.setBackground(Color.BLACK);
        adminButton.setFocusPainted(false);
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
        userButton.setFocusPainted(false);
        userButton.setBounds((1500 / 2) + 50, 450, 150, 50); // Place it to the right of center

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add function to open user dashboard
            }

        });


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


        //reset
        resetButton = new JButton("RESET");
        gbc.gridx = 0;
        loginPanel.add(resetButton, gbc);

        //error labels
        errorLabel = new JLabel();
        errorLabel.setForeground(Color.red);
        gbc.gridx = 1;
        gbc.gridy = 3;
        loginPanel.add(errorLabel, gbc);

        //reconstruct loginbutton para sa validation
        loginButton.addActionListener(e -> {
            String username = userTextField.getText();
            String password = new String(passwordTextField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                errorLabel.setText("Please enter both fields.");
            } else if (username.equals("yanyan") && password.equals("3211")) {
                welcomeFrame.dispose();
                loginFrame.dispose();
                createAdminDashboardFrame(username);
            } else {
                errorLabel.setText("Incorrect username or password.");
            }
        });

        //reset button para mawala mga text sa fields and error message
        resetButton.addActionListener(e -> {
            userTextField.setText("");
            passwordTextField.setText("");
            errorLabel.setText("");
        });



        loginFrame.setVisible(true);
    }

    // Method to create the main admin dashboard frame after successful login
    private static void createAdminDashboardFrame(String username) {
        adminDashboardFrame = new JFrame("Admin Dashboard");
        adminDashboardFrame.setSize(1500, 900);
        adminDashboardFrame.setLocationRelativeTo(null);
        adminDashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with a white background
        JPanel mainAdminPanel = new JPanel(new BorderLayout());
        mainAdminPanel.setBackground(Color.WHITE);

        // Add the red top panel with logo and title
        JPanel topPanel = createTopPanel();
        mainAdminPanel.add(topPanel, BorderLayout.NORTH);

        // Center panel for the admin content, using BoxLayout for vertical alignment
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical stacking

        // "ADMIN PANEL" Title
        JLabel adminTitle = new JLabel("ADMIN PANEL");
        adminTitle.setFont(new Font("Serif", Font.BOLD, 32));
        adminTitle.setForeground(new Color(0xD32F2F)); // Red color
        adminTitle.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align
        centerPanel.add(adminTitle);
        centerPanel.add(Box.createVerticalStrut(20)); // Add vertical spacing

        // Welcome message with user's name
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!");
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align
        centerPanel.add(welcomeLabel);
        centerPanel.add(Box.createVerticalStrut(60)); // Increase vertical spacing before buttons

        // Add "REGISTER VEHICLE" button
        JButton registerButton = createDashboardButton("REGISTER VEHICLE");
        centerPanel.add(registerButton);
        centerPanel.add(Box.createVerticalStrut(20)); // Add vertical spacing
        registerButton.addActionListener(e -> {

            RegisterVehicleDashboard();

        });

        // Add "FIND VEHICLE" button
        JButton findButton = createDashboardButton("FIND VEHICLE");
        centerPanel.add(findButton);
        centerPanel.add(Box.createVerticalStrut(20)); // Add vertical spacing
        findButton.addActionListener(e -> {
            //add function to open find vehicle dashboard
            JFrame findVehicleFrame = new JFrame("Find Vehicle");
            findVehicleFrame.setSize(1500, 900);
            findVehicleFrame.setLocationRelativeTo(null);
            findVehicleFrame.setVisible(true);
            
        });

        // Add "VIOLATION" button
        JButton violationButton = createDashboardButton("VIOLATION");
        centerPanel.add(violationButton);

        // Center-align buttons
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        findButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        violationButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add the center panel to main admin panel
        mainAdminPanel.add(centerPanel, BorderLayout.CENTER);

        // Add the main admin panel to the frame
        adminDashboardFrame.add(mainAdminPanel);
        adminDashboardFrame.setVisible(true);
    }


    private static void RegisterVehicleDashboard() {
        JFrame registerFrame = new JFrame("Register Vehicle");
        registerFrame.dispose();
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(null);
        registerFrame.setSize(1500, 900);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.add(mainPanel);

        JPanel topPanel = createTopPanel();
        registerFrame.add(topPanel, BorderLayout.NORTH);
        registerFrame.add(mainPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Vehicle Registration");
        titleLabel.setFont(new Font("Sefif", Font.BOLD, 32));
        titleLabel.setBounds(600, 50, 400, 40);
        mainPanel.add(titleLabel);

        JLabel VehicleOwner_Label = new JLabel("Name of Vehicle Owner");
        VehicleOwner_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        VehicleOwner_Label.setBounds(200, 110, 300, 30);
        mainPanel.add(VehicleOwner_Label);

        JTextField VehicleOwner_Field = new JTextField();
        VehicleOwner_Field.setBounds(200, 140, 420, 40); //Label Y + 30 lagi sa field
        VehicleOwner_Field.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mainPanel.add(VehicleOwner_Field);

        JLabel Address_Label = new JLabel("Address");
        Address_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        Address_Label.setBounds(200, 190, 300, 30); // Label Y + 80 Pixels
        mainPanel.add(Address_Label);

        JTextField Address_Field = new JTextField();
        Address_Field.setBounds(200, 220, 420, 40); // Label Y + 30
        Address_Field.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.add(Address_Field);

        JLabel ContactInformation_Label = new JLabel("Contact Information");
        ContactInformation_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        ContactInformation_Label.setBounds(200, 270, 300, 30);
        mainPanel.add(ContactInformation_Label);

        JTextField ContactInformation_Field = new JTextField();
        ContactInformation_Field.setBounds(200, 300, 420, 40);
        ContactInformation_Field.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.add(ContactInformation_Field);

        JLabel IdentificationNumber_Label = new JLabel("Identification Number");
        IdentificationNumber_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        IdentificationNumber_Label.setBounds(200, 350, 300, 30);
        mainPanel.add(IdentificationNumber_Label);

        JTextField IdentificationNumber_Field = new JTextField();
        IdentificationNumber_Field.setBounds(200, 380, 420, 40);
        IdentificationNumber_Field.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.add(IdentificationNumber_Field);

        JLabel DateOfBirth_Label = new JLabel("Date of Birth");
        DateOfBirth_Label.setFont(new Font("Serif", Font.PLAIN, 24));
        DateOfBirth_Label.setBounds(200, 430, 300, 30);
        mainPanel.add(DateOfBirth_Label);

        JTextField DateOfBirth_Field = new JTextField();
        DateOfBirth_Field.setBounds(200, 460, 420, 40);
        DateOfBirth_Field.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.add(DateOfBirth_Field);

        JButton NextButton = new JButton("NEXT");
        NextButton.setFont(new Font("Serif", Font.BOLD, 24));
        NextButton.setBackground(Color.RED);
        NextButton.setForeground(Color.WHITE);
        NextButton.setOpaque(true);
        NextButton.setBorderPainted(false);
        NextButton.setFocusPainted(false);
        NextButton.setBounds(1200, 520, 150, 50);
        mainPanel.add(NextButton);


        NextButton.addActionListener(e -> {
            String VehicleOwner = VehicleOwner_Field.getText();
            String Address = Address_Field.getText();
            String ContactInformation = ContactInformation_Field.getText();
            String IdentificationNumber = IdentificationNumber_Field.getText();
            String DateOfBirth = DateOfBirth_Field.getText();

            //validation para sa mga fields
            if (VehicleOwner.isEmpty() || Address.isEmpty() || ContactInformation.isEmpty()
                    || IdentificationNumber.isEmpty() || DateOfBirth.isEmpty()) {

                //error message if may kulang sa fields or input ng user.
                JOptionPane optionPane = new JOptionPane("Please fill out all the fields.", JOptionPane.ERROR_MESSAGE);
                JDialog dialog = optionPane.createDialog("Error");
                dialog.setSize(500, 180);
                dialog.setVisible(true);
            } else {

                /* mag add pa dito ng function para masave yung input sa database.
                Example: saveVehicleRegistration(VehicleOwner, Address, ContactInformation, IdentificationNumber, DateOfBirth);

                ---> New window ulit para sa next part ng registration. */

            }
        });
        registerFrame.setVisible(true);

    }



    private static JButton createDashboardButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Serif", Font.BOLD, 24));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.RED);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(300, 50));
        return button;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    }



}