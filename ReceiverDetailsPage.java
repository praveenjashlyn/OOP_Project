import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ReceiverDetailsPage extends JFrame {

    private JTextField receiverNameField;
    private JTextField phoneNoField;
    private JLabel receiverNameErrorLabel;
    private JLabel phoneNoErrorLabel;

    public ReceiverDetailsPage() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - Receiver Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(30, 33, 45));
        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(36, 40, 56));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        JLabel titleLabel = new JLabel("Enter Receiver's Details");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = createFormPanel();
        add(formPanel, BorderLayout.CENTER);

        // Add listeners for validation
        setupValidationListeners();
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(30, 33, 45));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        int yPos = 0;

        // --- Receiver's Name ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("Receiver's Name:"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        receiverNameField = createTextField(20);
        formPanel.add(receiverNameField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        receiverNameErrorLabel = createErrorLabel();
        formPanel.add(receiverNameErrorLabel, gbc);

        // --- Phone Number ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("Phone Number:"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        phoneNoField = createTextField(20);
        formPanel.add(phoneNoField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        phoneNoErrorLabel = createErrorLabel();
        formPanel.add(phoneNoErrorLabel, gbc);

        // --- Continue Button ---
        JButton continueButton = createContinueButton();
        gbc.gridx = 0; gbc.gridy = yPos; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0; gbc.insets = new Insets(25, 10, 10, 10);
        formPanel.add(continueButton, gbc);

        return formPanel;
    }
    
    private void setupValidationListeners() {
        receiverNameField.getDocument().addDocumentListener(new ValidationListener(this::validateReceiverName));
        receiverNameField.addFocusListener(new ValidationFocusListener(this::validateReceiverName));

        phoneNoField.getDocument().addDocumentListener(new ValidationListener(this::validatePhoneNo));
        phoneNoField.addFocusListener(new ValidationFocusListener(this::validatePhoneNo));
    }

    private boolean validateReceiverName() {
        String name = receiverNameField.getText().trim();
        if (name.isEmpty()) {
            receiverNameErrorLabel.setText("Receiver's name cannot be empty.");
            return false;
        } else if (!name.matches("^[a-zA-Z\\s'-]+$")) {
            receiverNameErrorLabel.setText("Please enter a valid name.");
            return false;
        }
        receiverNameErrorLabel.setText(" ");
        return true;
    }
    
    private boolean validatePhoneNo() {
        String phone = phoneNoField.getText().trim();
        if (!phone.matches("\\d{10}")) {
            phoneNoErrorLabel.setText("Phone number must be 10 digits.");
            return false;
        }
        phoneNoErrorLabel.setText(" ");
        return true;
    }

    private JButton createContinueButton() {
        JButton button = new JButton("Continue");
        button.setFont(new Font("Inter", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(90, 105, 255));
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 40));

        button.addActionListener(_ -> {
            boolean isNameValid = validateReceiverName();
            boolean isPhoneValid = validatePhoneNo();

            if (isNameValid && isPhoneValid) {
                new PaymentMethodsPage().setVisible(true);
                this.dispose(); // Close this page
            } else {
                JOptionPane.showMessageDialog(this, "Please fix the errors shown in red.", "Invalid Details", JOptionPane.ERROR_MESSAGE);
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
        Color themeColor = new Color(90, 105, 255);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(themeColor),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        textField.setSelectionColor(themeColor);
        textField.setSelectedTextColor(Color.WHITE);
        return textField;
    }
}