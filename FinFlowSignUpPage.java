import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class FinFlowSignUpPage extends JFrame {

    public FinFlowSignUpPage() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - Sign Up");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the window
        setResizable(false);

        // Main panel with a dark background
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(new Color(24, 28, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Create Your Account");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Inter", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 30, 20);
        mainPanel.add(titleLabel, gbc);

        // Reset insets and gridwidth for form fields
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridwidth = 1;

        // Name
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(nameLabel, gbc);

        JTextField nameField = new RoundedTextField();
        nameField.setPreferredSize(new Dimension(220, 40));
        nameField.setForeground(Color.WHITE);
        nameField.setBackground(new Color(40, 44, 55));
        nameField.setBorder(null);
        nameField.setCaretColor(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(nameField, gbc);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(emailLabel, gbc);

        JTextField emailField = new RoundedTextField();
        emailField.setPreferredSize(new Dimension(220, 40));
        emailField.setForeground(Color.WHITE);
        emailField.setBackground(new Color(40, 44, 55));
        emailField.setBorder(null);
        emailField.setCaretColor(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(emailField, gbc);

        // Phone Number
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(phoneLabel, gbc);

        JTextField phoneField = new RoundedTextField();
        phoneField.setPreferredSize(new Dimension(220, 40));
        phoneField.setForeground(Color.WHITE);
        phoneField.setBackground(new Color(40, 44, 55));
        phoneField.setBorder(null);
        phoneField.setCaretColor(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(phoneField, gbc);

        // Card Details Section (using placeholders)
        JLabel cardLabel = new JLabel("Debit/Credit Card:");
        cardLabel.setForeground(Color.WHITE);
        cardLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        mainPanel.add(cardLabel, gbc);

        // Placeholder for debit/credit card number
        JTextField cardField = new RoundedTextField();
        cardField.setPreferredSize(new Dimension(220, 40));
        cardField.setForeground(Color.WHITE);
        cardField.setBackground(new Color(40, 44, 55));
        cardField.setBorder(null);
        cardField.setCaretColor(Color.WHITE);
        cardField.setText("Enter your card number");
        cardField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (cardField.getText().equals("Enter your card number")) {
                    cardField.setText("");
                    cardField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (cardField.getText().isEmpty()) {
                    cardField.setText("Enter your card number");
                    cardField.setForeground(new Color(150, 150, 150));
                }
            }
        });
        cardField.setForeground(new Color(150, 150, 150));
        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(cardField, gbc);

        // Sign Up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Inter", Font.BOLD, 18));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(new Color(90, 105, 255));
        signUpButton.setFocusPainted(false);
        signUpButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 20, 10, 20);
        mainPanel.add(signUpButton, gbc);

        signUpButton.addActionListener(e -> {
            // Placeholder for sign-up logic
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String card = cardField.getText();

            JOptionPane.showMessageDialog(this,
                    "Account Created!\nName: " + name + "\nEmail: " + email + "\nPhone: " + phone,
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        });

        add(mainPanel);
    }
}