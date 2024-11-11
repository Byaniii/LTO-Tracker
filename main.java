import javax.swing.*;

public class main {
    public static void main(String[] args) {
        // Create an instance of the frame with the desired title
        frame newFrame = new frame("LTO Tracker");

        // Add the "USER" button and specify its action
        CustomButton userButton = newFrame.addButtonToBodyPanel("USER", 400, 450, 300, 80);

        // Add an ActionListener to the button to define the action when it's clicked
        userButton.addActionListener(e -> {
            // Create a new frame for the login page
            frame loginFrame = new frame("Login");

        });

        // Add the "ADMIN" button and specify its action
        CustomButton AdminButton = newFrame.addButtonToBodyPanel("ADMIN", 800, 450, 300, 80);

        AdminButton.addActionListener(e -> {
            frame loginFrame = new frame("Login");
        });
    }
}
