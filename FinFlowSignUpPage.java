import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        gbc.insets = new Insets(5, 20, 5, 20); // Adjusted insets for a cleaner look
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2; // Each component will span two columns

        // Title
        JLabel titleLabel = new JLabel("Create Your Account");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Inter", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 30, 20);
        mainPanel.add(titleLabel, gbc);

        // Reset insets for form fields
        gbc.insets = new Insets(5, 20, 0, 20);
        gbc.anchor = GridBagConstraints.WEST;

        // --- Name ---
        JLabel nameLabel = new JLabel("<html>Full Name <font color='red'>*</font></html>");
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridy++;
        mainPanel.add(nameLabel, gbc);

        JTextField nameField = new RoundedTextField();
        nameField.setForeground(Color.WHITE);
        nameField.setBackground(new Color(40, 44, 55));
        nameField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        nameField.setCaretColor(Color.WHITE);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 0, 20);
        mainPanel.add(nameField, gbc);

        JLabel nameErrorLabel = new JLabel("Name can only contain letters and spaces.");
        nameErrorLabel.setForeground(Color.RED);
        nameErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        nameErrorLabel.setVisible(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(nameErrorLabel, gbc);

        // --- Email ---
        gbc.insets = new Insets(5, 20, 0, 20);
        JLabel emailLabel = new JLabel("<html>Email <font color='red'>*</font></html>");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridy++;
        mainPanel.add(emailLabel, gbc);

        JTextField emailField = new RoundedTextField();
        emailField.setForeground(Color.WHITE);
        emailField.setBackground(new Color(40, 44, 55));
        emailField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        emailField.setCaretColor(Color.WHITE);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 0, 20);
        mainPanel.add(emailField, gbc);

        JLabel emailErrorLabel = new JLabel("Invalid email format.");
        emailErrorLabel.setForeground(Color.RED);
        emailErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        emailErrorLabel.setVisible(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(emailErrorLabel, gbc);

        // --- Phone Number ---
        gbc.insets = new Insets(5, 20, 0, 20);
        JLabel phoneLabel = new JLabel("<html>Phone Number <font color='red'>*</font></html>");
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridy++;
        mainPanel.add(phoneLabel, gbc);

        JTextField phoneField = new RoundedTextField();
        phoneField.setForeground(Color.WHITE);
        phoneField.setBackground(new Color(40, 44, 55));
        phoneField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        phoneField.setCaretColor(Color.WHITE);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 0, 20);
        mainPanel.add(phoneField, gbc);

        JLabel phoneErrorLabel = new JLabel("Phone number must be 10 digits.");
        phoneErrorLabel.setForeground(Color.RED);
        phoneErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        phoneErrorLabel.setVisible(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(phoneErrorLabel, gbc);

        // --- Account Number ---
        gbc.insets = new Insets(5, 20, 0, 20);
        JLabel accNumLabel = new JLabel("<html>Account Number <font color='red'>*</font></html>");
        accNumLabel.setForeground(Color.WHITE);
        accNumLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridy++;
        mainPanel.add(accNumLabel, gbc);

        JTextField accNumField = new RoundedTextField();
        accNumField.setForeground(Color.WHITE);
        accNumField.setBackground(new Color(40, 44, 55));
        accNumField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        accNumField.setCaretColor(Color.WHITE);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 0, 20);
        mainPanel.add(accNumField, gbc);

        JLabel accNumErrorLabel = new JLabel("Account number must contain only digits.");
        accNumErrorLabel.setForeground(Color.RED);
        accNumErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        accNumErrorLabel.setVisible(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(accNumErrorLabel, gbc);

        // --- IFSC Code ---
        gbc.insets = new Insets(5, 20, 0, 20);
        JLabel ifscLabel = new JLabel("<html>IFSC Code <font color='red'>*</font></html>");
        ifscLabel.setForeground(Color.WHITE);
        ifscLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridy++;
        mainPanel.add(ifscLabel, gbc);

        JTextField ifscField = new RoundedTextField();
        ifscField.setForeground(Color.WHITE);
        ifscField.setBackground(new Color(40, 44, 55));
        ifscField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        ifscField.setCaretColor(Color.WHITE);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 0, 20);
        mainPanel.add(ifscField, gbc);

        JLabel ifscErrorLabel = new JLabel("Invalid IFSC code format.");
        ifscErrorLabel.setForeground(Color.RED);
        ifscErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        ifscErrorLabel.setVisible(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(ifscErrorLabel, gbc);

        // --- Password ---
        gbc.insets = new Insets(5, 20, 0, 20);
        JLabel passwordLabel = new JLabel("<html>Password <font color='red'>*</font></html>");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridy++;
        mainPanel.add(passwordLabel, gbc);

        JPasswordField passwordField = new RoundedPasswordField();
        passwordField.setForeground(Color.WHITE);
        passwordField.setBackground(new Color(40, 44, 55));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        passwordField.setCaretColor(Color.WHITE);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(passwordField, gbc);

        // --- Retype Password ---
        gbc.insets = new Insets(5, 20, 0, 20);
        JLabel retypePasswordLabel = new JLabel("<html>Retype Password <font color='red'>*</font></html>");
        retypePasswordLabel.setForeground(Color.WHITE);
        retypePasswordLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridy++;
        mainPanel.add(retypePasswordLabel, gbc);

        JPasswordField retypePasswordField = new RoundedPasswordField();
        retypePasswordField.setForeground(Color.WHITE);
        retypePasswordField.setBackground(new Color(40, 44, 55));
        retypePasswordField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        retypePasswordField.setCaretColor(Color.WHITE);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 0, 20);
        mainPanel.add(retypePasswordField, gbc);

        JLabel passwordErrorLabel = new JLabel("Passwords do not match.");
        passwordErrorLabel.setForeground(Color.RED);
        passwordErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        passwordErrorLabel.setVisible(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(passwordErrorLabel, gbc);

        // --- Debit Card ---
        gbc.insets = new Insets(5, 20, 0, 20);
        JLabel debitCardLabel = new JLabel("Debit Card (Optional)");
        debitCardLabel.setForeground(Color.WHITE);
        debitCardLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridy++;
        mainPanel.add(debitCardLabel, gbc);

        JTextField debitCardField = new RoundedTextField();
        debitCardField.setForeground(Color.WHITE);
        debitCardField.setBackground(new Color(40, 44, 55));
        debitCardField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        debitCardField.setCaretColor(Color.WHITE);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 0, 20);
        mainPanel.add(debitCardField, gbc);

        JLabel debitCardErrorLabel = new JLabel("Debit card number must be 16 digits.");
        debitCardErrorLabel.setForeground(Color.RED);
        debitCardErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        debitCardErrorLabel.setVisible(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(debitCardErrorLabel, gbc);

        // --- Debit Card Details Panel ---
        JPanel debitCardDetailsPanel = new JPanel(new GridBagLayout());
        debitCardDetailsPanel.setBackground(new Color(24, 28, 40));
        GridBagConstraints dc = new GridBagConstraints();
        dc.fill = GridBagConstraints.HORIZONTAL;

        // Debit Expiry Date
        dc.gridx = 0;
        dc.gridy = 0;
        dc.weightx = 0.5;
        dc.insets = new Insets(0, 0, 0, 5);
        JLabel debitExpiryLabel = new JLabel("Expiry Date (MM/YY)");
        debitExpiryLabel.setForeground(Color.WHITE);
        debitExpiryLabel.setFont(new Font("Inter", Font.BOLD, 14));
        debitCardDetailsPanel.add(debitExpiryLabel, dc);

        dc.gridy = 1;
        JTextField debitExpiryField = new RoundedTextField();
        debitExpiryField.setForeground(Color.WHITE);
        debitExpiryField.setBackground(new Color(40, 44, 55));
        debitExpiryField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        debitExpiryField.setCaretColor(Color.WHITE);
        debitCardDetailsPanel.add(debitExpiryField, dc);

        dc.gridy = 2;
        dc.gridwidth = 1;
        JLabel debitExpiryErrorLabel = new JLabel("Invalid Expiry Date.");
        debitExpiryErrorLabel.setForeground(Color.RED);
        debitExpiryErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        debitExpiryErrorLabel.setVisible(false);
        debitCardDetailsPanel.add(debitExpiryErrorLabel, dc);

        // Debit CVV
        dc.gridx = 1;
        dc.gridy = 0;
        dc.insets = new Insets(0, 5, 0, 0);
        JLabel debitCvvLabel = new JLabel("CVV");
        debitCvvLabel.setForeground(Color.WHITE);
        debitCvvLabel.setFont(new Font("Inter", Font.BOLD, 14));
        debitCardDetailsPanel.add(debitCvvLabel, dc);

        dc.gridy = 1;
        JTextField debitCvvField = new RoundedPasswordField();
        debitCvvField.setForeground(Color.WHITE);
        debitCvvField.setBackground(new Color(40, 44, 55));
        debitCvvField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        debitCvvField.setCaretColor(Color.WHITE);
        debitCardDetailsPanel.add(debitCvvField, dc);

        dc.gridy = 2;
        JLabel debitCvvErrorLabel = new JLabel("Invalid CVV.");
        debitCvvErrorLabel.setForeground(Color.RED);
        debitCvvErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        debitCvvErrorLabel.setVisible(false);
        debitCardDetailsPanel.add(debitCvvErrorLabel, dc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(debitCardDetailsPanel, gbc);


        // --- Credit Card ---
        gbc.insets = new Insets(5, 20, 0, 20);
        JLabel creditCardLabel = new JLabel("Credit Card (Optional)");
        creditCardLabel.setForeground(Color.WHITE);
        creditCardLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridy++;
        mainPanel.add(creditCardLabel, gbc);

        JTextField creditCardField = new RoundedTextField();
        creditCardField.setForeground(Color.WHITE);
        creditCardField.setBackground(new Color(40, 44, 55));
        creditCardField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        creditCardField.setCaretColor(Color.WHITE);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 0, 20);
        mainPanel.add(creditCardField, gbc);

        JLabel creditCardErrorLabel = new JLabel("Credit card number must be 16 digits.");
        creditCardErrorLabel.setForeground(Color.RED);
        creditCardErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        creditCardErrorLabel.setVisible(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(creditCardErrorLabel, gbc);

        // --- Credit Card Details Panel ---
        JPanel creditCardDetailsPanel = new JPanel(new GridBagLayout());
        creditCardDetailsPanel.setBackground(new Color(24, 28, 40));
        GridBagConstraints cc = new GridBagConstraints();
        cc.fill = GridBagConstraints.HORIZONTAL;

        // Credit Expiry Date
        cc.gridx = 0;
        cc.gridy = 0;
        cc.weightx = 0.5;
        cc.insets = new Insets(0, 0, 0, 5);
        JLabel creditExpiryLabel = new JLabel("Expiry Date (MM/YY)");
        creditExpiryLabel.setForeground(Color.WHITE);
        creditExpiryLabel.setFont(new Font("Inter", Font.BOLD, 14));
        creditCardDetailsPanel.add(creditExpiryLabel, cc);

        cc.gridy = 1;
        JTextField creditExpiryField = new RoundedTextField();
        creditExpiryField.setForeground(Color.WHITE);
        creditExpiryField.setBackground(new Color(40, 44, 55));
        creditExpiryField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        creditExpiryField.setCaretColor(Color.WHITE);
        creditCardDetailsPanel.add(creditExpiryField, cc);

        cc.gridy = 2;
        cc.gridwidth = 1;
        JLabel creditExpiryErrorLabel = new JLabel("Invalid Expiry Date.");
        creditExpiryErrorLabel.setForeground(Color.RED);
        creditExpiryErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        creditExpiryErrorLabel.setVisible(false);
        creditCardDetailsPanel.add(creditExpiryErrorLabel, cc);

        // Credit CVV
        cc.gridx = 1;
        cc.gridy = 0;
        cc.insets = new Insets(0, 5, 0, 0);
        JLabel creditCvvLabel = new JLabel("CVV");
        creditCvvLabel.setForeground(Color.WHITE);
        creditCvvLabel.setFont(new Font("Inter", Font.BOLD, 14));
        creditCardDetailsPanel.add(creditCvvLabel, cc);

        cc.gridy = 1;
        JTextField creditCvvField = new RoundedPasswordField();
        creditCvvField.setForeground(Color.WHITE);
        creditCvvField.setBackground(new Color(40, 44, 55));
        creditCvvField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        creditCvvField.setCaretColor(Color.WHITE);
        creditCardDetailsPanel.add(creditCvvField, cc);

        cc.gridy = 2;
        JLabel creditCvvErrorLabel = new JLabel("Invalid CVV.");
        creditCvvErrorLabel.setForeground(Color.RED);
        creditCvvErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        creditCvvErrorLabel.setVisible(false);
        creditCardDetailsPanel.add(creditCvvErrorLabel, cc);

        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(creditCardDetailsPanel, gbc);

        // --- UPI ID ---
        gbc.insets = new Insets(5, 20, 0, 20);
        JLabel upiLabel = new JLabel("UPI ID (Optional)");
        upiLabel.setForeground(Color.WHITE);
        upiLabel.setFont(new Font("Inter", Font.BOLD, 14));
        gbc.gridy++;
        mainPanel.add(upiLabel, gbc);

        JTextField upiField = new RoundedTextField();
        upiField.setForeground(Color.WHITE);
        upiField.setBackground(new Color(40, 44, 55));
        upiField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        upiField.setCaretColor(Color.WHITE);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 0, 20);
        mainPanel.add(upiField, gbc);

        JLabel upiErrorLabel = new JLabel("Invalid UPI ID format.");
        upiErrorLabel.setForeground(Color.RED);
        upiErrorLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        upiErrorLabel.setVisible(false);
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 10, 20);
        mainPanel.add(upiErrorLabel, gbc);

        // --- Sign Up Button ---
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Inter", Font.BOLD, 18));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(new Color(90, 105, 255));
        signUpButton.setFocusPainted(false);
        signUpButton.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        gbc.gridy++;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(signUpButton, gbc);

        // --- Back to Login ---
        JLabel loginLabel = new JLabel("Already have an account? Login");
        loginLabel.setForeground(new Color(150, 150, 150));
        loginLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gbc.gridy++;
        gbc.insets = new Insets(0, 20, 20, 20);
        mainPanel.add(loginLabel, gbc);

        loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new FinFlowLoginPage().setVisible(true);
            }
        });

        // Add focus listeners for border highlighting and inline validation
        addValidationListener(nameField, nameErrorLabel, "^[a-zA-Z\\s]+$", "Name can only contain letters and spaces.");
        addValidationListener(emailField, emailErrorLabel, "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "Invalid email format.");
        addValidationListener(phoneField, phoneErrorLabel, "\\d{10}", "Phone number must be 10 digits.");
        addValidationListener(accNumField, accNumErrorLabel, "\\d+", "Account number must contain only digits.");
        addValidationListener(ifscField, ifscErrorLabel, "^[A-Z]{4}0[A-Z0-9]{6}$", "Invalid IFSC code format.");
        addValidationListener(debitCardField, debitCardErrorLabel, "^(\\d{16})?$", "Debit card must be 16 digits.");
        addValidationListener(debitExpiryField, debitExpiryErrorLabel, "^(0[1-9]|1[0-2])/([0-9]{2})?$", "Expiry date must be in MM/YY format.");
        addValidationListener(debitCvvField, debitCvvErrorLabel, "^(\\d{3,4})?$", "CVV must be 3 or 4 digits.");
        addValidationListener(creditCardField, creditCardErrorLabel, "^(\\d{16})?$", "Credit card must be 16 digits.");
        addValidationListener(creditExpiryField, creditExpiryErrorLabel, "^(0[1-9]|1[0-2])/([0-9]{2})?$", "Expiry date must be in MM/YY format.");
        addValidationListener(creditCvvField, creditCvvErrorLabel, "^(\\d{3,4})?$", "CVV must be 3 or 4 digits.");
        addValidationListener(upiField, upiErrorLabel, "^([\\w.-]+@[\\w.-]+)?$", "Invalid UPI ID format.");
        addValidationListener(passwordField, passwordErrorLabel, "^.{8,}$", "Password must be at least 8 characters.");

        // Password matching validation
        retypePasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                retypePasswordField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(90, 105, 255), 2), // Highlight color
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                String pass = new String(passwordField.getPassword());
                String retypePass = new String(retypePasswordField.getPassword());
                if (!pass.equals(retypePass)) {
                    passwordErrorLabel.setText("Passwords do not match.");
                    passwordErrorLabel.setVisible(true);
                    retypePasswordField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.RED, 2),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    ));
                } else {
                    passwordErrorLabel.setVisible(false);
                    retypePasswordField.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(70, 75, 90)),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    ));
                }
            }
        });


        signUpButton.addActionListener(_ -> {
            // Final validation check
            boolean allValid = true;
            String pass = new String(passwordField.getPassword());
            String retypePass = new String(retypePasswordField.getPassword());

            if (!pass.equals(retypePass)) {
                passwordErrorLabel.setVisible(true);
                allValid = false;
            } else {
                passwordErrorLabel.setVisible(false);
            }

            if (nameErrorLabel.isVisible() || emailErrorLabel.isVisible() || phoneErrorLabel.isVisible() ||
                accNumErrorLabel.isVisible() || ifscErrorLabel.isVisible() || passwordErrorLabel.isVisible() || debitCardErrorLabel.isVisible() ||
                debitExpiryErrorLabel.isVisible() || debitCvvErrorLabel.isVisible() ||
                creditCardErrorLabel.isVisible() || creditExpiryErrorLabel.isVisible() || creditCvvErrorLabel.isVisible() ||
                upiErrorLabel.isVisible()) {
                allValid = false;
            }

            // Also check mandatory fields aren't empty
            if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty() ||
                accNumField.getText().isEmpty() || ifscField.getText().isEmpty() || pass.isEmpty()) {
                allValid = false;
                 JOptionPane.showMessageDialog(this, "Please fill in all mandatory fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }


            if (allValid) {
                JOptionPane.showMessageDialog(this,
                        "Account Created!\nName: " + nameField.getText() + "\nEmail: " + emailField.getText() + "\nPhone: " + phoneField.getText(),
                        "Success", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                 if (!(nameField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty() ||
                accNumField.getText().isEmpty() || ifscField.getText().isEmpty() || pass.isEmpty()))
                JOptionPane.showMessageDialog(this, "Please correct the errors in the form.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane);
    }

    private void addValidationListener(JTextField field, JLabel errorLabel, String regex, String errorMessage) {
        field.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                field.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(90, 105, 255), 2), // Highlight color
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
                ));
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                String text;
                if (field instanceof JPasswordField) {
                    text = new String(((JPasswordField) field).getPassword());
                } else {
                    text = field.getText();
                }

                if (!text.matches(regex)) {
                    field.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.RED, 2), // Error color
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    ));
                    errorLabel.setText(errorMessage);
                    errorLabel.setVisible(true);
                } else {
                    field.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(70, 75, 90)),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)
                    ));
                    errorLabel.setVisible(false);
                }
            }
        });
    }
}