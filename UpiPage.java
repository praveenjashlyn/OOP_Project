import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UpiPage extends JFrame {

    // --- UI Components ---
    private JTextField upiIdField;
    private JTextField amountField;

    // --- Error Labels for Inline Validation ---
    private JLabel upiIdErrorLabel;
    private JLabel amountErrorLabel;

    public UpiPage() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - UPI Payment");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400); // Adjusted height for error labels
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
        JLabel titleLabel = new JLabel("UPI Payment");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        return headerPanel;
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(30, 33, 45));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int yPos = 0;

        // --- UPI ID ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("UPI ID (Optional):"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        upiIdField = createTextField(20);
        formPanel.add(upiIdField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        upiIdErrorLabel = createErrorLabel();
        formPanel.add(upiIdErrorLabel, gbc);

        // --- Amount ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("Amount:"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        amountField = createTextField(10);
        formPanel.add(amountField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        amountErrorLabel = createErrorLabel();
        formPanel.add(amountErrorLabel, gbc);

        // --- Pay Button ---
        JButton payButton = createPayButton();
        gbc.gridx = 0; gbc.gridy = yPos; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0; gbc.insets = new Insets(25, 10, 10, 10);
        formPanel.add(payButton, gbc);

        return formPanel;
    }

    private void setupValidationListeners() {
        upiIdField.getDocument().addDocumentListener(new ValidationListener(this::validateUpiId));
        upiIdField.addFocusListener(new ValidationFocusListener(this::validateUpiId));

        amountField.getDocument().addDocumentListener(new ValidationListener(this::validateAmount));
        amountField.addFocusListener(new ValidationFocusListener(this::validateAmount));
    }

    private boolean validateUpiId() {
        String upiId = upiIdField.getText().trim();
        // Field is optional, so an empty string is valid.
        if (upiId.isEmpty()) {
            upiIdErrorLabel.setText(" "); // Clear any previous error
            return true;
        }
        // If not empty, it must match the UPI format.
        if (!upiId.matches("^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+$")) {
            upiIdErrorLabel.setText("Invalid UPI format (e.g., name@bank).");
            return false;
        }
        upiIdErrorLabel.setText(" "); // Clear error
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
        amountErrorLabel.setText(" "); // Clear error
        return true;
    }

    private JButton createPayButton() {
        JButton button = new JButton("Pay Now");
        button.setFont(new Font("Inter", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(54, 185, 204));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 40));

        button.addActionListener(_ -> {
            boolean isUpiValid = validateUpiId();
            boolean isAmountValid = validateAmount();

            if (isUpiValid && isAmountValid) {
                dispose();
                new OTPPage(new Color(54, 185, 204)).setVisible(true); // Open OTP page with UPI theme
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
        textField.setFont(new Font("Inter", Font.PLAIN, 14));
        textField.setBackground(new Color(40, 44, 55));
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        Color themeColor = new Color(54, 185, 204);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(themeColor),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        textField.setSelectionColor(themeColor);
        textField.setSelectedTextColor(Color.WHITE);
        return textField;
    }
}