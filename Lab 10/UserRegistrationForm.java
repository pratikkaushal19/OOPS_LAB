import javax.swing.*;
import java.awt.*;

public class UserRegistrationForm extends JFrame {

    private JTextField nameField, emailField;
    private JPasswordField passField, confirmField;
    private JLabel resultLabel;

    public UserRegistrationForm() {
        setTitle("Registration Form");
        setSize(350, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        // Components
        nameField = new JTextField();
        emailField = new JTextField();
        passField = new JPasswordField();
        confirmField = new JPasswordField();
        JButton registerBtn = new JButton("Register");
        resultLabel = new JLabel("", JLabel.CENTER);
        resultLabel.setForeground(Color.RED);

        // Add to frame
        add(new JLabel("Name:")); add(nameField);
        add(new JLabel("Email:")); add(emailField);
        add(new JLabel("Password:")); add(passField);
        add(new JLabel("Confirm Password:")); add(confirmField);
        add(registerBtn); add(resultLabel);

        // Action
        registerBtn.addActionListener(e -> validateForm());

        setVisible(true);
    }

    private void validateForm() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String pass = new String(passField.getPassword());
        String confirm = new String(confirmField.getPassword());

        if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
            resultLabel.setText("All fields are required.");
        } else if (!email.contains("@")) {
            resultLabel.setText("Invalid email.");
        } else if (!pass.equals(confirm)) {
            resultLabel.setText("Passwords do not match.");
        } else {
            resultLabel.setForeground(Color.GREEN);
            resultLabel.setText("Registration Successful!");
        }
    }

    public static void main(String[] args) {
        new UserRegistrationForm();
    }
}
