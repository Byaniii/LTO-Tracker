import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class frame extends JFrame {
    public JPanel bodyPanel; // Declare bodyPanel as an instance variable

    // Constructor to initialize the frame
    public frame(String title) {
        setTitle(title);
        setSize(1500, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(createTopPanel(), BorderLayout.NORTH);
        bodyPanel = createBodyPanel(); // Initialize and store the body panel
        add(bodyPanel, BorderLayout.CENTER);
        setVisible(true);//
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1500, 120));
        topPanel.setBackground(Color.RED);
        topPanel.setLayout(null);

        // Load and add the top-left logo to the top panel
        ImageIcon topLeftLogo = new ImageIcon("logo.png");
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

    private JPanel createBodyPanel() {
        bodyPanel = new JPanel(); // Use `bodyPanel` instance variable
        bodyPanel.setPreferredSize(new Dimension(1500, 780));
        bodyPanel.setBackground(new Color(0x041427));
        bodyPanel.setLayout(null);

        return bodyPanel;
    }

    // Method to add a button to the body panel without specifying actions
    public CustomButton addButtonToBodyPanel(String text, int x, int y, int width, int height) {
        CustomButton customButton = new CustomButton(text);
        customButton.setBounds(x, y, width, height);
        bodyPanel.add(customButton); // Add the button to the existing body panel
        bodyPanel.revalidate(); // Refresh the panel to show the new button
        bodyPanel.repaint(); // Repaint the panel to update the UI
        return customButton; // Return the button so actions can be added externally
    }
}
