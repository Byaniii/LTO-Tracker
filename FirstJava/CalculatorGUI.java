package FirstJava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private static double currentNumber = 0;
    private static String currentOperation = "";

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);

        // Create label for the result
        JLabel resultLabel = new JLabel("0");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 48));
        resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.add(resultLabel, BorderLayout.CENTER);

        // Create button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "=", "A/C", "/"};

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String buttonText = button.getText();

                    if (buttonText.matches("\\d")) {
                        if (resultLabel.getText().equals("0")) {
                            resultLabel.setText(buttonText);
                        } else {
                            resultLabel.setText(resultLabel.getText() + buttonText);
                        }
                    } else if (buttonText.equals("+")) {
                        currentNumber = Double.parseDouble(resultLabel.getText());
                        currentOperation = "+";
                        resultLabel.setText("0");
                    } else if (buttonText.equals("-")) {
                        currentNumber = Double.parseDouble(resultLabel.getText());
                        currentOperation = "-";
                        resultLabel.setText("0");
                    } else if (buttonText.equals("*")) {
                        currentNumber = Double.parseDouble(resultLabel.getText());
                        currentOperation = "*";
                        resultLabel.setText("0");
                    } else if (buttonText.equals("/")) {
                        currentNumber = Double.parseDouble(resultLabel.getText());
                        currentOperation = "/";
                        resultLabel.setText("0");
                    } else if (buttonText.equals("=")) {
                        double secondNumber = Double.parseDouble(resultLabel.getText());
                        double result = 0;
                        switch (currentOperation) {
                            case "+":
                                result = currentNumber + secondNumber;
                                break;
                            case "-":
                                result = currentNumber - secondNumber;
                                break;
                            case "*":
                                result = currentNumber * secondNumber;
                                break;
                            case "/":
                                if (secondNumber == 0) {
                                    JOptionPane.showMessageDialog(frame, "Cannot divide by zero.", "Error", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                                result = currentNumber / secondNumber;
                                break;
                        }
                        resultLabel.setText(String.valueOf(result));
                        currentOperation = "";
                    } else if (buttonText.equals("Reset")) {
                        currentNumber = 0;
                        currentOperation = "";
                        resultLabel.setText("0");
                    }
                }
            });
        }

        // Add panels to the frame
        frame.add(resultPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}