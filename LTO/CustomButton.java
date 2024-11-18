package LTO;

import java.awt.*;
import javax.swing.*;


public class CustomButton extends JButton{
    public CustomButton(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 30)); // Larger, bold font
        setBackground(Color.WHITE); // White background
        setForeground(Color.BLACK); // Black text
        setFocusPainted(false); // Remove focus border
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Black border
        setOpaque(true);
    }

    public static CustomButton createButton(String text, int x, int y, int width, int height) {
        CustomButton button = new CustomButton(text);
        button.setBounds(x, y, width, height);
        return button; //
    }

    public static CustomButton createRedButton(String text, int x, int y, int width, int height, int fontSize) {
        CustomButton redButton = new CustomButton(text);
        redButton.setBackground(Color.RED); // White background
        redButton.setForeground(Color.WHITE); // Black text
        redButton.setFocusPainted(false); // Remove focus border
        redButton.setBorder(null); 
        redButton.setOpaque(true);
        redButton.setBounds(x, y, width, height);
        redButton.setFont(new Font("Arial", Font.BOLD, fontSize));
        return redButton;
    }
}
