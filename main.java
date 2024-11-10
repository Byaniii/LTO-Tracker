import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    public static void main(String[] args) {
        // Create an instance of the frame with the desired title
        frame newFrame = new frame("LTO Tracker");

        // Add the "USER" button and specify its action
        CustomButton userButton = newFrame.addButtonToBodyPanel("USER", 400, 450, 300, 80);

        // Add an ActionListener to the button to define the action when it's clicked
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
