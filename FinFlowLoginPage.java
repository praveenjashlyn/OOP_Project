import javax.swing.*;
import java.awt.*;

public class FinFlowLoginPage extends JFrame {

    private final JFrame coverPageFrame;

    public FinFlowLoginPage(JFrame coverPageFrame) {
        this.coverPageFrame = coverPageFrame;
        initUI(true); // Show back button
    }

    public FinFlowLoginPage() {
        this.coverPageFrame = null; // No cover page to go back to
        initUI(false); // Hide back button
    }

    private void initUI(boolean showBackButton) {
        setTitle("FinFlow - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
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
        signUpButton.setBackground(new Color(135, 206, 235)); // Sky blue
        signUpButton.setOpaque(true);
        signUpButton.setFocusPainted(false);
        signUpButton.setBorderPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(signUpButton, gbc);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Inter", Font.BOLD, 14));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(135, 206, 235)); // Sky blue
        loginButton.setOpaque(true);
        loginButton.setFocusPainted(false);
        loginButton.setBorderPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(loginButton, gbc);

        if (showBackButton) {
            JButton backButton = new JButton("Back");
            backButton.setFont(new Font("Inter", Font.BOLD, 14));
            backButton.setForeground(Color.WHITE);
            backButton.setBackground(new Color(100, 100, 100)); // A neutral gray
            backButton.setOpaque(true);
            backButton.setFocusPainted(false);
            backButton.setBorderPainted(false);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2; // Span both columns
            gbc.anchor = GridBagConstraints.CENTER;
            mainPanel.add(backButton, gbc);

            backButton.addActionListener(_ -> {
                this.dispose();
                coverPageFrame.setVisible(true);
            });
        }


        // Add action listener to the login button
        loginButton.addActionListener(_ -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());

            // Simple login validation
            if ("user".equals(username) && "password".equals(password)) {
                
                // Create and shsow the new login page
                SwingUtilities.invokeLater(() -> {
                    FinFlowDashboard Dashboard = new FinFlowDashboard();
                    Dashboard.setVisible(true);
                });

                // Dispose the cover page and the login page on successful login
                coverPageFrame.dispose();
                this.dispose();
                
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Updated action listener to open the new sign-up page
        signUpButton.addActionListener(_ -> {
            FinFlowSignUpPage signUpPage = new FinFlowSignUpPage();
            signUpPage.setVisible(true);
        });

        add(mainPanel);
    }
}
