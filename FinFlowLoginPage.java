import javax.swing.*;
import java.awt.*;

public class FinFlowLoginPage extends JFrame {

    private final JFrame coverPageFrame;

    public FinFlowLoginPage(JFrame coverPageFrame) {
        this.coverPageFrame = coverPageFrame;
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the window
        setResizable(false);

        // Main panel with a dark background
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(24, 28, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20); // Increased insets for better spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Username label and text field
        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(userLabel, gbc);

        // Use the new RoundedTextField
        JTextField userText = new RoundedTextField();
        userText.setPreferredSize(new Dimension(200, 35)); // Set a preferred size
        userText.setForeground(Color.WHITE);
        userText.setBackground(new Color(40, 44, 55)); // A slightly lighter dark color for the input field
        userText.setBorder(null); // Remove the default border
        userText.setCaretColor(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(userText, gbc);

        // Password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(passwordLabel, gbc);

        // Use the new RoundedPasswordField
        JPasswordField passwordText = new RoundedPasswordField();
        passwordText.setPreferredSize(new Dimension(200, 35)); // Set a preferred size
        passwordText.setForeground(Color.WHITE);
        passwordText.setBackground(new Color(40, 44, 55));
        passwordText.setBorder(null);
        passwordText.setCaretColor(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(passwordText, gbc);
        
        // Sign Up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Inter", Font.BOLD, 14));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(new Color(90, 105, 255));
        signUpButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; 
        mainPanel.add(signUpButton, gbc);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Inter", Font.BOLD, 14));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(90, 105, 255));
        loginButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(loginButton, gbc);

        // Add action listener to the login button
        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());

            // Simple login validation
            if ("user".equals(username) && "password".equals(password)) {
                JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                if(coverPageFrame != null) {
                    coverPageFrame.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add action listener to the sign-up button
        signUpButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Redirecting to a new registration form...", "Sign Up", JOptionPane.INFORMATION_MESSAGE);
        });
        
        add(mainPanel);
    }
}
