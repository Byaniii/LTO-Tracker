import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class frame extends JFrame {

    public static void main(String[] args) {
        frame frame1 = new frame();
        frame1.CreateFrame();
    }

    public void CreateFrame() {
        JFrame frame = new JFrame("LTO Tracker");
        frame.setSize(1500, 900);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createTopPanel(), BorderLayout.NORTH);
        frame.add(createBodyPanel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static JPanel createTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1500, 120));
        topPanel.setBackground(Color.RED);
        topPanel.setLayout(null);

        // Load and add the top-left logo to the top panel
        ImageIcon topLeftLogo = new ImageIcon("eto.png");
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

    private static JPanel createBodyPanel() {
        JPanel bodyPanel = new JPanel();
        bodyPanel.setPreferredSize(new Dimension(1500, 780));
        bodyPanel.setBackground(new Color(0x041427));
        bodyPanel.setLayout(null);

        // Create and add the "ADMIN" button
        CustomButton adminButton = CustomButton.createButton("ADMIN", 400, 450, 300, 80);
        bodyPanel.add(adminButton);

        CustomButton userButton = CustomButton.createButton("USER", 800, 450, 300, 80);
        bodyPanel.add(userButton);
        return bodyPanel;
    }
}
