package LTO;

import javax.swing.*;
import java.awt.*;

public class CustomTextField extends JTextField {

    // Constructor to create a custom text field with specified bounds
    public CustomTextField(int x, int y, int width, int height) {
        super();
        setBounds(x, y, width, height);
        setFont(new Font("Serif", Font.PLAIN, 18));
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    // Static factory method for easy instantiation
    public static CustomTextField createTextField(int x, int y, int width, int height) {
        return new CustomTextField(x, y, width, height);
    }
}
