import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login implements ActionListener {
    private static JLabel label;
    private static JTextField userText;
    private static JLabel success;
    private static JLabel passwordLabel;
    private static JTextField passwordText;
    public static void main(String[] args) {
        JPanel panel = new JPanel(); // new panel object
        JFrame frame = new JFrame(); // creates new frame object
        frame.setTitle("LTO TRACKER SYSTEM");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(350, 200); // sets frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the window (if omitted program till runs)
        frame.add(panel); // adds the panel to the frame

        panel.setLayout(null);
        label = new JLabel("User");
        label.setBounds(10, 10, 100, 20);
        panel.add(label);

        userText = new JTextField(20); // creates JTexField object
        userText.setBounds(100,20,165,25); // modify text field object
        panel.add(userText);

        frame.setVisible(true); // makes frame visible

        // This creates the password text on the left
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel); // adds the text to the window

        // this creates the password input box
        passwordText = new JTextField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText); // adds the input window to the window



        // this creates the login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.addActionListener(new login());
        panel.add(loginButton);

        // Retrieves the input text
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText(); // retrieves username input
        String password = passwordText.getText(); // retrieves password input
        if (user.equals("yanyan") && password.equals("3211")) {
            success.setText("Login Successful");

            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(success);
            topFrame.dispose();
            // Create a new frame to display "Hello World"
            JFrame newFrame = new JFrame("Welcome");
            newFrame.setSize(300, 150);
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Only closes the new frame

            // Create a panel for the new frame
            JPanel newPanel = new JPanel();
            newFrame.add(newPanel);

            // Add a label with "Hello World" text to the new panel
            JLabel helloLabel = new JLabel("Hello World");
            newPanel.add(helloLabel);

            // Make the new frame visible
            newFrame.setVisible(true);
        }
    }
}