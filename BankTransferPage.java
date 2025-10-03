// import javax.swing.*;
// import java.awt.*;

// public class BankTransferPage extends JFrame {

//     public BankTransferPage() {
//         initUI();
//     }

//     private void initUI() {
//         setTitle("FinFlow - Bank Transfer");
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setSize(500, 620); // Increased height for new fields
//         setLocationRelativeTo(null);
//         setResizable(false);
//         getContentPane().setBackground(new Color(30, 33, 45));
//         setLayout(new BorderLayout());

//         // Header
//         JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//         headerPanel.setBackground(new Color(36, 40, 56));
//         headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
//         JLabel titleLabel = new JLabel("Bank Transfer");
//         titleLabel.setFont(new Font("Inter", Font.BOLD, 24));
//         titleLabel.setForeground(Color.WHITE);
//         headerPanel.add(titleLabel);
//         add(headerPanel, BorderLayout.NORTH);

//         // Form Panel
//         JPanel formPanel = new JPanel(new GridBagLayout());
//         formPanel.setBackground(new Color(30, 33, 45));
//         formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(10, 10, 10, 10);
//         gbc.fill = GridBagConstraints.HORIZONTAL;

//         // Labels
//         String[] labels = {"Account Number:", "Confirm Account Number:", "IFSC Code:", "Beneficiary Name:", "Amount:"};
//         for (int i = 0; i < labels.length; i++) {
//             JLabel label = new JLabel(labels[i]);
//             label.setFont(new Font("Inter", Font.BOLD, 14));
//             label.setForeground(Color.WHITE);
//             gbc.gridx = 0;
//             gbc.gridy = i;
//             gbc.anchor = GridBagConstraints.EAST;
//             gbc.weightx = 0; // Ensure labels column does not expand
//             formPanel.add(label, gbc);
//         }

//         // Fields
//         JTextField accNumField = new JTextField(20);
//         JTextField confirmAccNumField = new JTextField(20);
//         JTextField ifscField = new JTextField(15);
//         JTextField nameField = new JTextField(20);
//         JTextField amountField = new JTextField(10);
//         JTextField[] fields = {accNumField, confirmAccNumField, ifscField, nameField, amountField};

//         for (int i = 0; i < fields.length; i++) {
//             fields[i].setFont(new Font("Inter", Font.PLAIN, 14));
//             fields[i].setBackground(new Color(40, 44, 55));
//             fields[i].setForeground(Color.WHITE);
//             fields[i].setCaretColor(Color.WHITE);
//             fields[i].setBorder(BorderFactory.createCompoundBorder(
//                 BorderFactory.createLineBorder(new Color(255, 193, 7)),
//                 BorderFactory.createEmptyBorder(5, 5, 5, 5)
//             ));
            
//             // FIX 1: Make text visible by setting selection colors
//             fields[i].setSelectionColor(new Color(255, 193, 7));
//             fields[i].setSelectedTextColor(Color.WHITE);

//             gbc.gridx = 1;
//             gbc.gridy = i;
//             gbc.anchor = GridBagConstraints.WEST;
//             // FIX 2: Allow text fields to expand horizontally
//             gbc.weightx = 1.0;
//             formPanel.add(fields[i], gbc);
//         }

//         // Transfer Button
//         JButton transferButton = new JButton("Transfer Now");
//         transferButton.setFont(new Font("Inter", Font.BOLD, 16));
//         transferButton.setForeground(Color.WHITE);
//         transferButton.setBackground(new Color(255, 193, 7));
//         transferButton.setOpaque(true);
//         transferButton.setBorderPainted(false);
//         transferButton.setFocusPainted(false);
        
//         // Reset layout constraints for the button
//         gbc.gridx = 0;
//         gbc.gridy = labels.length;
//         gbc.gridwidth = 2;
//         gbc.anchor = GridBagConstraints.CENTER;
//         gbc.weightx = 0; // Ensure button does not expand
//         gbc.insets = new Insets(20, 10, 10, 10);
//         formPanel.add(transferButton, gbc);

//         transferButton.addActionListener(e -> {
//             JOptionPane.showMessageDialog(this, "Transfer processing...", "Processing", JOptionPane.INFORMATION_MESSAGE);
//             // Logic for bank transfer
//             this.dispose();
//         });

//         add(formPanel, BorderLayout.CENTER);
//     }
    
//     // Main method for testing this specific frame
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             BankTransferPage bankTransferPage = new BankTransferPage();
//             bankTransferPage.setVisible(true);
//         });
//     }
// }

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class BankTransferPage extends JFrame {

    // --- UI Components ---
    private JTextField accNumField;
    private JTextField confirmAccNumField;
    private JTextField ifscField;
    private JTextField nameField;
    private JTextField amountField;

    // --- Error Labels for Inline Validation ---
    private JLabel accNumErrorLabel;
    private JLabel confirmAccNumErrorLabel;
    private JLabel ifscErrorLabel;
    private JLabel nameErrorLabel;
    private JLabel amountErrorLabel;

    public BankTransferPage() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - Bank Transfer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 650); // Adjusted height for error labels
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(30, 33, 45));
        setLayout(new BorderLayout());

        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createFormPanel(), BorderLayout.CENTER);
        setupValidationListeners();
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(36, 40, 56));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        JLabel titleLabel = new JLabel("Bank Transfer");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        return headerPanel;
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(30, 33, 45));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int yPos = 0;

        // --- Account Number ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("Account Number:"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        accNumField = createTextField(20);
        formPanel.add(accNumField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        accNumErrorLabel = createErrorLabel();
        formPanel.add(accNumErrorLabel, gbc);

        // --- Confirm Account Number ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("Confirm Account Number:"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        confirmAccNumField = createTextField(20);
        formPanel.add(confirmAccNumField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        confirmAccNumErrorLabel = createErrorLabel();
        formPanel.add(confirmAccNumErrorLabel, gbc);

        // --- IFSC Code ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("IFSC Code:"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        ifscField = createTextField(15);
        formPanel.add(ifscField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        ifscErrorLabel = createErrorLabel();
        formPanel.add(ifscErrorLabel, gbc);

        // --- Beneficiary Name ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("Beneficiary Name:"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        nameField = createTextField(20);
        formPanel.add(nameField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        nameErrorLabel = createErrorLabel();
        formPanel.add(nameErrorLabel, gbc);

        // --- Amount ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("Amount:"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        amountField = createTextField(10);
        formPanel.add(amountField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        amountErrorLabel = createErrorLabel();
        formPanel.add(amountErrorLabel, gbc);

        // --- Transfer Button ---
        JButton transferButton = createTransferButton();
        gbc.gridx = 0; gbc.gridy = yPos; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0; gbc.insets = new Insets(25, 10, 10, 10);
        formPanel.add(transferButton, gbc);

        return formPanel;
    }

    private void setupValidationListeners() {
        accNumField.getDocument().addDocumentListener(new ValidationListener(this::validateAccNum));
        accNumField.addFocusListener(new ValidationFocusListener(this::validateAccNum));
        confirmAccNumField.getDocument().addDocumentListener(new ValidationListener(this::validateConfirmAccNum));
        confirmAccNumField.addFocusListener(new ValidationFocusListener(this::validateConfirmAccNum));
        ifscField.getDocument().addDocumentListener(new ValidationListener(this::validateIfsc));
        ifscField.addFocusListener(new ValidationFocusListener(this::validateIfsc));
        nameField.getDocument().addDocumentListener(new ValidationListener(this::validateBeneficiaryName));
        nameField.addFocusListener(new ValidationFocusListener(this::validateBeneficiaryName));
        amountField.getDocument().addDocumentListener(new ValidationListener(this::validateAmount));
        amountField.addFocusListener(new ValidationFocusListener(this::validateAmount));
    }

    private boolean validateAccNum() {
        String accNum = accNumField.getText().trim();
        if (!accNum.matches("\\d{9,18}")) {
            accNumErrorLabel.setText("Must be 9-18 digits.");
            return false;
        }
        accNumErrorLabel.setText(" ");
        // Also validate the confirmation field whenever the first field changes
        validateConfirmAccNum();
        return true;
    }

    private boolean validateConfirmAccNum() {
        String accNum = accNumField.getText().trim();
        String confirmAccNum = confirmAccNumField.getText().trim();
        if (confirmAccNum.isEmpty()) {
            confirmAccNumErrorLabel.setText("Please confirm account number.");
            return false;
        }
        if (!confirmAccNum.equals(accNum)) {
            confirmAccNumErrorLabel.setText("Account numbers do not match.");
            return false;
        }
        confirmAccNumErrorLabel.setText(" ");
        return true;
    }

    private boolean validateIfsc() {
        String ifsc = ifscField.getText().trim().toUpperCase();
        if (!ifsc.matches("^[A-Z]{4}0[A-Z0-9]{6}$")) {
            ifscErrorLabel.setText("Invalid IFSC code format.");
            return false;
        }
        ifscErrorLabel.setText(" ");
        return true;
    }

    private boolean validateBeneficiaryName() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            nameErrorLabel.setText("Beneficiary name cannot be empty.");
            return false;
        } else if (!name.matches("^[a-zA-Z\\s'-]+$")) {
            nameErrorLabel.setText("Please enter a valid name.");
            return false;
        }
        nameErrorLabel.setText(" ");
        return true;
    }

    private boolean validateAmount() {
        String amountStr = amountField.getText().trim();
        try {
            if (Double.parseDouble(amountStr) <= 1) {
                amountErrorLabel.setText("Amount must be greater than 1.");
                return false;
            }
        } catch (NumberFormatException ex) {
            amountErrorLabel.setText("Please enter a valid number.");
            return false;
        }
        amountErrorLabel.setText(" ");
        return true;
    }

    private JButton createTransferButton() {
        JButton button = new JButton("Transfer Now");
        button.setFont(new Font("Inter", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(255, 193, 7));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(180, 40));

        button.addActionListener(_ -> {
            boolean isAllValid = validateAccNum() & validateConfirmAccNum() & validateIfsc() &
                                 validateBeneficiaryName() & validateAmount();

            if (isAllValid) {
                new OTPPage(new Color(255, 193, 7)).setVisible(true); // Open OTP page with bank transfer theme
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please fix the errors shown in red.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });
        return button;
    }

    // --- Helper Methods ---
    private static class ValidationListener implements DocumentListener {
        private final Runnable validator;
        public ValidationListener(Runnable validator) { this.validator = validator; }
        @Override public void insertUpdate(DocumentEvent e) { validator.run(); }
        @Override public void removeUpdate(DocumentEvent e) { validator.run(); }
        @Override public void changedUpdate(DocumentEvent e) { validator.run(); }
    }

    private static class ValidationFocusListener extends FocusAdapter {
        private final Runnable validator;
        public ValidationFocusListener(Runnable validator) { this.validator = validator; }
        @Override public void focusLost(FocusEvent e) { validator.run(); }
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Inter", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
        return label;
    }

    private JLabel createErrorLabel() {
        JLabel label = new JLabel(" ");
        label.setFont(new Font("Inter", Font.PLAIN, 12));
        label.setForeground(new Color(255, 80, 80));
        return label;
    }

    private JTextField createTextField(int columns) {
        JTextField textField = new JTextField(columns);
        styleTextComponent(textField);
        return textField;
    }
    
    private void styleTextComponent(JTextField component) {
        component.setFont(new Font("Inter", Font.PLAIN, 14));
        component.setBackground(new Color(40, 44, 55));
        component.setForeground(Color.WHITE);
        component.setCaretColor(Color.WHITE);
        Color themeColor = new Color(255, 193, 7);
        component.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(themeColor),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        component.setSelectionColor(themeColor);
        component.setSelectedTextColor(Color.WHITE);
    }
}