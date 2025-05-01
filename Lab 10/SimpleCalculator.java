import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JTextField display;
    private StringBuilder currentInput;
    private double num1 = 0, num2 = 0;
    private char operator;

    public SimpleCalculator() {
        // Frame settings
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Text field for display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "+", "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        currentInput = new StringBuilder();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            currentInput.append(cmd);
            display.setText(currentInput.toString());
        } else if (cmd.matches("[+\\-*/]")) {
            try {
                num1 = Double.parseDouble(currentInput.toString());
                operator = cmd.charAt(0);
                currentInput.setLength(0);
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (cmd.equals("=")) {
            try {
                num2 = Double.parseDouble(currentInput.toString());
                double result = 0;
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/': 
                        if (num2 == 0) {
                            display.setText("Cannot divide by zero");
                            return;
                        }
                        result = num1 / num2; 
                        break;
                }
                display.setText(String.valueOf(result));
                currentInput.setLength(0);
                currentInput.append(result); // allow chaining
            } catch (NumberFormatException ex) {
                display.setText("Error");
            }
        } else if (cmd.equals("C")) {
            currentInput.setLength(0);
            display.setText("");
            num1 = num2 = 0;
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
