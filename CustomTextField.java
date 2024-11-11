import javax.swing.*;
import java.awt.*;

public class CustomTextField extends JTextField {
    public CustomTextField(int columns) {
        super(columns);
        setFont(new Font("Arial", Font.PLAIN, 20)); // Set font style and size
        setPreferredSize(new Dimension(300, 40)); // Set preferred size
        setBackground(Color.WHITE); // Set background color
        setForeground(Color.BLACK); // Set text color
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); // Set border
    }

    // Method to create a text field with specific bounds
    public static CustomTextField createTextField(int x, int y, int width, int height) {
        CustomTextField textField = new CustomTextField(20); // Default columns
        textField.setBounds(x, y, width, height);
        return textField;
    }
}
