
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class main {
    public static void main(String[] args) {
        frame newFrame = new frame("LTO Tracker");

        // Resize LOGO
        ImageIcon Icon = new ImageIcon("eto.png");
        Image resizedImage = Icon.getImage().getScaledInstance(250,250, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Center LOGO
        JLabel logoLabel = new JLabel(resizedIcon);
        logoLabel.setBounds(633, 39, 250, 250);
        newFrame.bodyPanel.add(logoLabel);

        // Title text: "LTO TRACKER"
        JLabel centerText = new JLabel("LTO TRACKER");
        centerText.setForeground(Color.WHITE);
        centerText.setFont(new Font("Serif", Font.BOLD, 35));
        centerText.setBounds(630,289,700,48); 
        newFrame.bodyPanel.add(centerText);

        // Subtitle text: "KEEPING OUR ROADS SAFE"
        JLabel subtitleLabel = new JLabel("\"KEEPING OUR ROADS SAFE\"", SwingConstants.CENTER);
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setFont(new Font("Serif", Font.BOLD, 40));
        subtitleLabel.setBounds(455,364,590,53);
        newFrame.bodyPanel.add(subtitleLabel);


        
        CustomButton adminButton = newFrame.addButtonToBodyPanel("ADMIN", 400, 450, 300, 80);
        adminButton.addActionListener(e -> {
            AdminFrame useFrame = new AdminFrame();  
        });

        CustomButton userButton = newFrame.addButtonToBodyPanel("USER", 800, 450, 300, 80);
        userButton.addActionListener(e -> {  
        });


    }
}
