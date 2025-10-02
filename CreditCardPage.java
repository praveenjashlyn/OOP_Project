// // // import javax.swing.*;
// // // import java.awt.*;

// // // public class CreditCardPage extends JFrame {

// // //     public CreditCardPage() {
// // //         initUI();
// // //     }

// // //     private void initUI() {
// // //         setTitle("FinFlow - Credit Card");
// // //         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
// // //         setSize(500, 400);
// // //         setLocationRelativeTo(null);
// // //         setResizable(false);
// // //         getContentPane().setBackground(new Color(30, 33, 45));
// // //         setLayout(new BorderLayout());

// // //         // Header
// // //         JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
// // //         headerPanel.setBackground(new Color(36, 40, 56));
// // //         headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
// // //         JLabel titleLabel = new JLabel("Credit Card Payment");
// // //         titleLabel.setFont(new Font("Inter", Font.BOLD, 24));
// // //         titleLabel.setForeground(Color.WHITE);
// // //         headerPanel.add(titleLabel);
// // //         add(headerPanel, BorderLayout.NORTH);

// // //         // Form Panel
// // //         JPanel formPanel = new JPanel(new GridBagLayout());
// // //         formPanel.setBackground(new Color(30, 33, 45));
// // //         formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
// // //         GridBagConstraints gbc = new GridBagConstraints();
// // //         gbc.insets = new Insets(10, 10, 10, 10);
// // //         gbc.fill = GridBagConstraints.HORIZONTAL;

// // //         // Labels
// // //         String[] labels = {"Card Number:", "Expiry Date (MM/YY):", "CVV:", "Amount:"};
// // //         for (int i = 0; i < labels.length; i++) {
// // //             JLabel label = new JLabel(labels[i]);
// // //             label.setFont(new Font("Inter", Font.BOLD, 14));
// // //             label.setForeground(Color.WHITE);
// // //             gbc.gridx = 0;
// // //             gbc.gridy = i;
// // //             gbc.anchor = GridBagConstraints.EAST;
// // //             gbc.weightx = 0; // Ensure labels column does not expand
// // //             formPanel.add(label, gbc);
// // //         }

// // //         // Fields
// // //         JTextField cardNumberField = new JTextField(20);
// // //         JTextField expiryField = new JTextField(5);
// // //         JPasswordField cvvField = new JPasswordField(3);
// // //         JTextField amountField = new JTextField(10);
// // //         javax.swing.text.JTextComponent[] fields = {cardNumberField, expiryField, cvvField, amountField};

// // //         for (int i = 0; i < fields.length; i++) {
// // //             fields[i].setFont(new Font("Inter", Font.PLAIN, 14));
// // //             fields[i].setBackground(new Color(40, 44, 55));
// // //             fields[i].setForeground(Color.WHITE);
// // //             fields[i].setCaretColor(Color.WHITE);
// // //             fields[i].setBorder(BorderFactory.createCompoundBorder(
// // //                 BorderFactory.createLineBorder(new Color(255, 99, 132)),
// // //                 BorderFactory.createEmptyBorder(5, 5, 5, 5)
// // //             ));

// // //             // FIX 1: Make text visible by setting selection colors
// // //             fields[i].setSelectionColor(new Color(255, 99, 132));
// // //             fields[i].setSelectedTextColor(Color.WHITE);

// // //             gbc.gridx = 1;
// // //             gbc.gridy = i;
// // //             gbc.anchor = GridBagConstraints.WEST;
// // //             // FIX 2: Allow text fields to expand horizontally
// // //             gbc.weightx = 1.0;
// // //             formPanel.add(fields[i], gbc);
// // //         }

// // //         // Pay Button
// // //         JButton payButton = new JButton("Pay Now");
// // //         payButton.setFont(new Font("Inter", Font.BOLD, 16));
// // //         payButton.setForeground(Color.WHITE);
// // //         payButton.setBackground(new Color(255, 99, 132));
// // //         payButton.setOpaque(true);
// // //         payButton.setBorderPainted(false);
// // //         payButton.setFocusPainted(false);

// // //         // Reset layout constraints for the button
// // //         gbc.gridx = 0;
// // //         gbc.gridy = labels.length;
// // //         gbc.gridwidth = 2;
// // //         gbc.anchor = GridBagConstraints.CENTER;
// // //         gbc.weightx = 0; // Ensure button does not expand
// // //         gbc.insets = new Insets(20, 10, 10, 10);
// // //         formPanel.add(payButton, gbc);

// // //         payButton.addActionListener(e -> {
// // //             JOptionPane.showMessageDialog(this, "Payment processing...", "Processing", JOptionPane.INFORMATION_MESSAGE);
// // //             // Logic for credit card payment
// // //             this.dispose();
// // //         });

// // //         add(formPanel, BorderLayout.CENTER);
// // //     }

// // //     // Main method for testing this specific frame
// // //     public static void main(String[] args) {
// // //         SwingUtilities.invokeLater(() -> {
// // //             CreditCardPage creditCardPage = new CreditCardPage();
// // //             creditCardPage.setVisible(true);
// // //         });
// // //     }
// // // }

// // // 


// // import javax.swing.*;
// // import javax.swing.event.DocumentEvent;
// // import javax.swing.event.DocumentListener;
// // import java.awt.*;
// // import java.awt.event.FocusAdapter;
// // import java.awt.event.FocusEvent;
// // import java.time.YearMonth;
// // import java.time.format.DateTimeParseException;

// // public class CreditCardPage extends JFrame {

// //     // --- UI Components ---
// //     private JTextField cardNumberField;
// //     private JTextField expiryField;
// //     private JPasswordField cvvField;
// //     private JTextField amountField;

// //     // --- Error Labels for Inline Validation ---
// //     private JLabel cardNumberErrorLabel;
// //     private JLabel expiryErrorLabel;
// //     private JLabel cvvErrorLabel;
// //     private JLabel amountErrorLabel;

// //     public CreditCardPage() {
// //         initUI();
// //     }

// //     private void initUI() {
// //         setTitle("FinFlow - Credit Card");
// //         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
// //         setSize(500, 500); // Increased height to accommodate error labels
// //         setLocationRelativeTo(null);
// //         setResizable(false);
// //         getContentPane().setBackground(new Color(30, 33, 45));
// //         setLayout(new BorderLayout());

// //         // Header
// //         JPanel headerPanel = createHeaderPanel();
// //         add(headerPanel, BorderLayout.NORTH);

// //         // Form Panel
// //         JPanel formPanel = createFormPanel();
// //         add(formPanel, BorderLayout.CENTER);

// //         // Add listeners for real-time validation
// //         setupValidationListeners();
// //     }

// //     private JPanel createHeaderPanel() {
// //         JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
// //         headerPanel.setBackground(new Color(36, 40, 56));
// //         headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
// //         JLabel titleLabel = new JLabel("Credit Card Payment");
// //         titleLabel.setFont(new Font("Inter", Font.BOLD, 24));
// //         titleLabel.setForeground(Color.WHITE);
// //         headerPanel.add(titleLabel);
// //         return headerPanel;
// //     }

// //     private JPanel createFormPanel() {
// //         JPanel formPanel = new JPanel(new GridBagLayout());
// //         formPanel.setBackground(new Color(30, 33, 45));
// //         formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
// //         GridBagConstraints gbc = new GridBagConstraints();
// //         gbc.fill = GridBagConstraints.HORIZONTAL;

// //         // --- Row 1 & 2: Card Number ---
// //         gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
// //         formPanel.add(createLabel("Card Number:"), gbc);
// //         gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
// //         cardNumberField = createTextField(20);
// //         formPanel.add(cardNumberField, gbc);
// //         gbc.gridx = 1; gbc.gridy = 1; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(2, 12, 10, 10);
// //         cardNumberErrorLabel = createErrorLabel();
// //         formPanel.add(cardNumberErrorLabel, gbc);

// //         // --- Row 3 & 4: Expiry Date ---
// //         gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
// //         formPanel.add(createLabel("Expiry Date (MM/YY):"), gbc);
// //         gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
// //         expiryField = createTextField(5);
// //         formPanel.add(expiryField, gbc);
// //         gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(2, 12, 10, 10);
// //         expiryErrorLabel = createErrorLabel();
// //         formPanel.add(expiryErrorLabel, gbc);

// //         // --- Row 5 & 6: CVV ---
// //         gbc.gridx = 0; gbc.gridy = 4; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
// //         formPanel.add(createLabel("CVV:"), gbc);
// //         gbc.gridx = 1; gbc.gridy = 4; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
// //         cvvField = createPasswordField(3);
// //         formPanel.add(cvvField, gbc);
// //         gbc.gridx = 1; gbc.gridy = 5; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(2, 12, 10, 10);
// //         cvvErrorLabel = createErrorLabel();
// //         formPanel.add(cvvErrorLabel, gbc);

// //         // --- Row 7 & 8: Amount ---
// //         gbc.gridx = 0; gbc.gridy = 6; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
// //         formPanel.add(createLabel("Amount:"), gbc);
// //         gbc.gridx = 1; gbc.gridy = 6; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
// //         amountField = createTextField(10);
// //         formPanel.add(amountField, gbc);
// //         gbc.gridx = 1; gbc.gridy = 7; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(2, 12, 10, 10);
// //         amountErrorLabel = createErrorLabel();
// //         formPanel.add(amountErrorLabel, gbc);

// //         // --- Pay Button ---
// //         JButton payButton = createPayButton();
// //         gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
// //         gbc.weightx = 0; gbc.insets = new Insets(20, 10, 10, 10);
// //         formPanel.add(payButton, gbc);

// //         return formPanel;
// //     }

// //     private void setupValidationListeners() {
// //         cardNumberField.getDocument().addDocumentListener(new ValidationListener(() -> validateCardNumber()));
// //         cardNumberField.addFocusListener(new ValidationFocusListener(() -> validateCardNumber()));

// //         expiryField.getDocument().addDocumentListener(new ValidationListener(() -> validateExpiryDate()));
// //         expiryField.addFocusListener(new ValidationFocusListener(() -> validateExpiryDate()));
        
// //         cvvField.getDocument().addDocumentListener(new ValidationListener(() -> validateCvv()));
// //         cvvField.addFocusListener(new ValidationFocusListener(() -> validateCvv()));

// //         amountField.getDocument().addDocumentListener(new ValidationListener(() -> validateAmount()));
// //         amountField.addFocusListener(new ValidationFocusListener(() -> validateAmount()));
// //     }

// //     private boolean validateCardNumber() {
// //         String cardNumber = cardNumberField.getText().trim();
// //         if (!cardNumber.matches("\\d{16}")) {
// //             cardNumberErrorLabel.setText("Card number must be 16 digits.");
// //             return false;
// //         }
// //         cardNumberErrorLabel.setText(" "); // Clear error
// //         return true;
// //     }

// //     private boolean validateExpiryDate() {
// //         String expiryDateStr = expiryField.getText().trim();
// //         if (!expiryDateStr.matches("(0[1-9]|1[0-2])/[0-9]{2}")) {
// //             expiryErrorLabel.setText("Invalid format. Use MM/YY.");
// //             return false;
// //         }
// //         try {
// //             String[] parts = expiryDateStr.split("/");
// //             int month = Integer.parseInt(parts[0]);
// //             int year = Integer.parseInt(parts[1]) + 2000;
// //             if (YearMonth.of(year, month).isBefore(YearMonth.now())) {
// //                 expiryErrorLabel.setText("Card has expired.");
// //                 return false;
// //             }
// //         } catch (NumberFormatException | DateTimeParseException e) {
// //             expiryErrorLabel.setText("Invalid date.");
// //             return false;
// //         }
// //         expiryErrorLabel.setText(" "); // Clear error
// //         return true;
// //     }
    
// //     private boolean validateCvv() {
// //         String cvv = new String(cvvField.getPassword()).trim();
// //         if (!cvv.matches("\\d{3}")) {
// //             cvvErrorLabel.setText("CVV must be 3 digits.");
// //             return false;
// //         }
// //         cvvErrorLabel.setText(" "); // Clear error
// //         return true;
// //     }

// //     private boolean validateAmount() {
// //         String amountStr = amountField.getText().trim();
// //         try {
// //             double amount = Double.parseDouble(amountStr);
// //             if (amount <= 1) {
// //                 amountErrorLabel.setText("Amount must be greater than 1.");
// //                 return false;
// //             }
// //         } catch (NumberFormatException ex) {
// //             amountErrorLabel.setText("Please enter a valid number.");
// //             return false;
// //         }
// //         amountErrorLabel.setText(" "); // Clear error
// //         return true;
// //     }
    
// //     private static class ValidationListener implements DocumentListener {
// //         private final Runnable validator;
// //         public ValidationListener(Runnable validator) { this.validator = validator; }
// //         @Override public void insertUpdate(DocumentEvent e) { validator.run(); }
// //         @Override public void removeUpdate(DocumentEvent e) { validator.run(); }
// //         @Override public void changedUpdate(DocumentEvent e) { validator.run(); }
// //     }
    
// //     private static class ValidationFocusListener extends FocusAdapter {
// //         private final Runnable validator;
// //         public ValidationFocusListener(Runnable validator) { this.validator = validator; }
// //         @Override public void focusLost(FocusEvent e) { validator.run(); }
// //     }

// //     private JLabel createLabel(String text) {
// //         JLabel label = new JLabel(text);
// //         label.setFont(new Font("Inter", Font.BOLD, 14));
// //         label.setForeground(Color.WHITE);
// //         return label;
// //     }

// //     private JLabel createErrorLabel() {
// //         JLabel label = new JLabel(" ");
// //         label.setFont(new Font("Inter", Font.PLAIN, 12));
// //         label.setForeground(new Color(255, 80, 80));
// //         return label;
// //     }

// //     private JTextField createTextField(int columns) {
// //         JTextField textField = new JTextField(columns);
// //         styleTextComponent(textField);
// //         return textField;
// //     }

// //     private JPasswordField createPasswordField(int columns) {
// //         JPasswordField passwordField = new JPasswordField(columns);
// //         styleTextComponent(passwordField);
// //         return passwordField;
// //     }

// //     private void styleTextComponent(javax.swing.text.JTextComponent component) {
// //         component.setFont(new Font("Inter", Font.PLAIN, 14));
// //         component.setBackground(new Color(40, 44, 55));
// //         component.setForeground(Color.WHITE);
// //         component.setCaretColor(Color.WHITE);
// //         Color themeColor = new Color(255, 99, 132);
// //         component.setBorder(BorderFactory.createCompoundBorder(
// //                 BorderFactory.createLineBorder(themeColor),
// //                 BorderFactory.createEmptyBorder(5, 5, 5, 5)
// //         ));
// //         component.setSelectionColor(themeColor);
// //         component.setSelectedTextColor(Color.WHITE);
// //     }
    
// //     private JButton createPayButton() {
// //         JButton payButton = new JButton("Pay Now");
// //         payButton.setFont(new Font("Inter", Font.BOLD, 16));
// //         payButton.setForeground(Color.WHITE);
// //         payButton.setBackground(new Color(255, 99, 132));
// //         payButton.setOpaque(true);
// //         payButton.setBorderPainted(false);
// //         payButton.setFocusPainted(false);

// //         payButton.addActionListener(e -> {
// //             boolean isCardValid = validateCardNumber();
// //             boolean isExpiryValid = validateExpiryDate();
// //             boolean isCvvValid = validateCvv();
// //             boolean isAmountValid = validateAmount();

// //             if (isCardValid && isExpiryValid && isCvvValid && isAmountValid) {
// //                 OTPPage otpPage = new OTPPage();
// //                 otpPage.setVisible(true);
// //                 this.dispose(); 
// //             } else {
// //                 JOptionPane.showMessageDialog(this, "Please fix the errors shown in red.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
// //             }
// //         });
// //         return payButton;
// //     }

// //     public static void main(String[] args) {
// //         SwingUtilities.invokeLater(() -> {
// //             CreditCardPage creditCardPage = new CreditCardPage();
// //             creditCardPage.setVisible(true);
// //         });
// //     }
// // }



// import javax.swing.*;
// import javax.swing.event.DocumentEvent;
// import javax.swing.event.DocumentListener;
// import java.awt.*;
// import java.awt.event.FocusAdapter;
// import java.awt.event.FocusEvent;
// import java.time.YearMonth;
// import java.time.format.DateTimeParseException;

// public class CreditCardPage extends JFrame {

//     // --- UI Components ---
//     private JTextField senderNameField; // ADDED
//     private JTextField receiverNameField; // ADDED
//     private JTextField cardNumberField;
//     private JTextField expiryField;
//     private JPasswordField cvvField;
//     private JTextField amountField;

//     // --- Error Labels for Inline Validation ---
//     private JLabel senderNameErrorLabel; // ADDED
//     private JLabel receiverNameErrorLabel; // ADDED
//     private JLabel cardNumberErrorLabel;
//     private JLabel expiryErrorLabel;
//     private JLabel cvvErrorLabel;
//     private JLabel amountErrorLabel;

//     public CreditCardPage() {
//         initUI();
//     }

//     private void initUI() {
//         setTitle("FinFlow - Credit Card");
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setSize(500, 620); // Increased height for new fields
//         setLocationRelativeTo(null);
//         setResizable(false);
//         getContentPane().setBackground(new Color(30, 33, 45));
//         setLayout(new BorderLayout());

//         // Header
//         JPanel headerPanel = createHeaderPanel();
//         add(headerPanel, BorderLayout.NORTH);

//         // Form Panel
//         JPanel formPanel = createFormPanel();
//         add(formPanel, BorderLayout.CENTER);

//         // Add listeners for real-time validation
//         setupValidationListeners();
//     }

//     private JPanel createHeaderPanel() {
//         JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//         headerPanel.setBackground(new Color(36, 40, 56));
//         headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
//         JLabel titleLabel = new JLabel("Credit Card Payment");
//         titleLabel.setFont(new Font("Inter", Font.BOLD, 24));
//         titleLabel.setForeground(Color.WHITE);
//         headerPanel.add(titleLabel);
//         return headerPanel;
//     }

//     private JPanel createFormPanel() {
//         JPanel formPanel = new JPanel(new GridBagLayout());
//         formPanel.setBackground(new Color(30, 33, 45));
//         formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.fill = GridBagConstraints.HORIZONTAL;

//         // Start GridBagLayout Y position
//         int yPos = 0;

//         // --- Sender's Name ---
//         gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
//         formPanel.add(createLabel("Name (Exactly in card):"), gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
//         senderNameField = createTextField(20);
//         formPanel.add(senderNameField, gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(2, 12, 10, 10);
//         senderNameErrorLabel = createErrorLabel();
//         formPanel.add(senderNameErrorLabel, gbc);

//         // --- Receiver's Name ---
//         gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
//         formPanel.add(createLabel("Receiver's Name:"), gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
//         receiverNameField = createTextField(20);
//         formPanel.add(receiverNameField, gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(2, 12, 10, 10);
//         receiverNameErrorLabel = createErrorLabel();
//         formPanel.add(receiverNameErrorLabel, gbc);

//         // --- Card Number ---
//         gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
//         formPanel.add(createLabel("Card Number:"), gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
//         cardNumberField = createTextField(20);
//         formPanel.add(cardNumberField, gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(2, 12, 10, 10);
//         cardNumberErrorLabel = createErrorLabel();
//         formPanel.add(cardNumberErrorLabel, gbc);

//         // --- Expiry Date ---
//         gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
//         formPanel.add(createLabel("Expiry Date (MM/YY):"), gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
//         expiryField = createTextField(5);
//         formPanel.add(expiryField, gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(2, 12, 10, 10);
//         expiryErrorLabel = createErrorLabel();
//         formPanel.add(expiryErrorLabel, gbc);

//         // --- CVV ---
//         gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
//         formPanel.add(createLabel("CVV:"), gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
//         cvvField = createPasswordField(3);
//         formPanel.add(cvvField, gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(2, 12, 10, 10);
//         cvvErrorLabel = createErrorLabel();
//         formPanel.add(cvvErrorLabel, gbc);

//         // --- Amount ---
//         gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
//         formPanel.add(createLabel("Amount:"), gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
//         amountField = createTextField(10);
//         formPanel.add(amountField, gbc);
//         gbc.gridx = 1; gbc.gridy = yPos++; gbc.anchor = GridBagConstraints.WEST; gbc.insets = new Insets(2, 12, 10, 10);
//         amountErrorLabel = createErrorLabel();
//         formPanel.add(amountErrorLabel, gbc);

//         // --- Pay Button ---
//         JButton payButton = createPayButton();
//         gbc.gridx = 0; gbc.gridy = yPos; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
//         gbc.weightx = 0; gbc.insets = new Insets(20, 10, 10, 10);
//         formPanel.add(payButton, gbc);

//         return formPanel;
//     }

//     private void setupValidationListeners() {
//         // Listeners for new name fields
//         senderNameField.getDocument().addDocumentListener(new ValidationListener(this::validateSenderName));
//         senderNameField.addFocusListener(new ValidationFocusListener(this::validateSenderName));

//         receiverNameField.getDocument().addDocumentListener(new ValidationListener(this::validateReceiverName));
//         receiverNameField.addFocusListener(new ValidationFocusListener(this::validateReceiverName));

//         // Listeners for existing fields
//         cardNumberField.getDocument().addDocumentListener(new ValidationListener(this::validateCardNumber));
//         cardNumberField.addFocusListener(new ValidationFocusListener(this::validateCardNumber));

//         expiryField.getDocument().addDocumentListener(new ValidationListener(this::validateExpiryDate));
//         expiryField.addFocusListener(new ValidationFocusListener(this::validateExpiryDate));
        
//         cvvField.getDocument().addDocumentListener(new ValidationListener(this::validateCvv));
//         cvvField.addFocusListener(new ValidationFocusListener(this::validateCvv));

//         amountField.getDocument().addDocumentListener(new ValidationListener(this::validateAmount));
//         amountField.addFocusListener(new ValidationFocusListener(this::validateAmount));
//     }

//     private boolean validateSenderName() {
//         String name = senderNameField.getText().trim();
//         if (name.isEmpty()) {
//             senderNameErrorLabel.setText("Sender's name cannot be empty.");
//             return false;
//         }
//         if (!name.matches("^[a-zA-Z\\s'-]+$")) { // Allows letters, spaces, hyphens, apostrophes
//             senderNameErrorLabel.setText("Please enter a valid name.");
//             return false;
//         }
//         senderNameErrorLabel.setText(" ");
//         return true;
//     }

//     private boolean validateReceiverName() {
//         String name = receiverNameField.getText().trim();
//         if (name.isEmpty()) {
//             receiverNameErrorLabel.setText("Receiver's name cannot be empty.");
//             return false;
//         }
//         if (!name.matches("^[a-zA-Z\\s'-]+$")) { // Allows letters, spaces, hyphens, apostrophes
//             receiverNameErrorLabel.setText("Please enter a valid name.");
//             return false;
//         }
//         receiverNameErrorLabel.setText(" ");
//         return true;
//     }

//     private boolean validateCardNumber() {
//         String cardNumber = cardNumberField.getText().trim();
//         if (!cardNumber.matches("\\d{16}")) {
//             cardNumberErrorLabel.setText("Card number must be 16 digits.");
//             return false;
//         }
//         cardNumberErrorLabel.setText(" "); // Clear error
//         return true;
//     }

//     private boolean validateExpiryDate() {
//         String expiryDateStr = expiryField.getText().trim();
//         if (!expiryDateStr.matches("(0[1-9]|1[0-2])/[0-9]{2}")) {
//             expiryErrorLabel.setText("Invalid format. Use MM/YY.");
//             return false;
//         }
//         try {
//             String[] parts = expiryDateStr.split("/");
//             int month = Integer.parseInt(parts[0]);
//             int year = Integer.parseInt(parts[1]) + 2000;
//             if (YearMonth.of(year, month).isBefore(YearMonth.now())) {
//                 expiryErrorLabel.setText("Card has expired.");
//                 return false;
//             }
//         } catch (NumberFormatException | DateTimeParseException e) {
//             expiryErrorLabel.setText("Invalid date.");
//             return false;
//         }
//         expiryErrorLabel.setText(" "); // Clear error
//         return true;
//     }
    
//     private boolean validateCvv() {
//         String cvv = new String(cvvField.getPassword()).trim();
//         if (!cvv.matches("\\d{3}")) {
//             cvvErrorLabel.setText("CVV must be 3 digits.");
//             return false;
//         }
//         cvvErrorLabel.setText(" "); // Clear error
//         return true;
//     }

//     private boolean validateAmount() {
//         String amountStr = amountField.getText().trim();
//         try {
//             double amount = Double.parseDouble(amountStr);
//             if (amount <= 1) {
//                 amountErrorLabel.setText("Amount must be greater than 1.");
//                 return false;
//             }
//         } catch (NumberFormatException ex) {
//             amountErrorLabel.setText("Please enter a valid number.");
//             return false;
//         }
//         amountErrorLabel.setText(" "); // Clear error
//         return true;
//     }
    
//     private JButton createPayButton() {
//         JButton payButton = new JButton("Pay Now");
//         payButton.setFont(new Font("Inter", Font.BOLD, 16));
//         payButton.setForeground(Color.WHITE);
//         payButton.setBackground(new Color(255, 99, 132));
//         payButton.setOpaque(true);
//         payButton.setBorderPainted(false);
//         payButton.setFocusPainted(false);

//         payButton.addActionListener(e -> {
//             // Run all validations one last time
//             boolean isSenderValid = validateSenderName();
//             boolean isReceiverValid = validateReceiverName();
//             boolean isCardValid = validateCardNumber();
//             boolean isExpiryValid = validateExpiryDate();
//             boolean isCvvValid = validateCvv();
//             boolean isAmountValid = validateAmount();

//             if (isSenderValid && isReceiverValid && isCardValid && isExpiryValid && isCvvValid && isAmountValid) {
//                 // NEW CODE
// OTPPage otpPage = new OTPPage(new Color(255, 99, 132)); // Pass the red theme color
//                 otpPage.setVisible(true);
//                 this.dispose(); 
//             } else {
//                 JOptionPane.showMessageDialog(this, "Please fix the errors shown in red.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
//             }
//         });
//         return payButton;
//     }

//     // --- Helper Methods (Unchanged) ---
    
//     private static class ValidationListener implements DocumentListener {
//         private final Runnable validator;
//         public ValidationListener(Runnable validator) { this.validator = validator; }
//         @Override public void insertUpdate(DocumentEvent e) { validator.run(); }
//         @Override public void removeUpdate(DocumentEvent e) { validator.run(); }
//         @Override public void changedUpdate(DocumentEvent e) { validator.run(); }
//     }
    
//     private static class ValidationFocusListener extends FocusAdapter {
//         private final Runnable validator;
//         public ValidationFocusListener(Runnable validator) { this.validator = validator; }
//         @Override public void focusLost(FocusEvent e) { validator.run(); }
//     }

//     private JLabel createLabel(String text) {
//         JLabel label = new JLabel(text);
//         label.setFont(new Font("Inter", Font.BOLD, 14));
//         label.setForeground(Color.WHITE);
//         return label;
//     }

//     private JLabel createErrorLabel() {
//         JLabel label = new JLabel(" ");
//         label.setFont(new Font("Inter", Font.PLAIN, 12));
//         label.setForeground(new Color(255, 80, 80));
//         return label;
//     }

//     private JTextField createTextField(int columns) {
//         JTextField textField = new JTextField(columns);
//         styleTextComponent(textField);
//         return textField;
//     }

//     private JPasswordField createPasswordField(int columns) {
//         JPasswordField passwordField = new JPasswordField(columns);
//         styleTextComponent(passwordField);
//         return passwordField;
//     }

//     private void styleTextComponent(javax.swing.text.JTextComponent component) {
//         component.setFont(new Font("Inter", Font.PLAIN, 14));
//         component.setBackground(new Color(40, 44, 55));
//         component.setForeground(Color.WHITE);
//         component.setCaretColor(Color.WHITE);
//         Color themeColor = new Color(255, 99, 132);
//         component.setBorder(BorderFactory.createCompoundBorder(
//                 BorderFactory.createLineBorder(themeColor),
//                 BorderFactory.createEmptyBorder(5, 5, 5, 5)
//         ));
//         component.setSelectionColor(themeColor);
//         component.setSelectedTextColor(Color.WHITE);
//     }
    
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             CreditCardPage creditCardPage = new CreditCardPage();
//             creditCardPage.setVisible(true);
//         });
//     }
// }

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;

public class CreditCardPage extends JFrame {

    // --- UI Components ---
    private JTextField senderNameField;
    private JTextField cardNumberField;
    private JTextField expiryField;
    private JPasswordField cvvField;
    private JTextField amountField;

    // --- Error Labels for Inline Validation ---
    private JLabel senderNameErrorLabel;
    private JLabel cardNumberErrorLabel;
    private JLabel expiryErrorLabel;
    private JLabel cvvErrorLabel;
    private JLabel amountErrorLabel;

    public CreditCardPage() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - Credit Card");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 550); // Adjusted height
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
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JLabel titleLabel = new JLabel("Credit Card Payment");
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

        // --- Sender's Name ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("Name (Exactly in Card):"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        senderNameField = createTextField(20);
        formPanel.add(senderNameField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        senderNameErrorLabel = createErrorLabel();
        formPanel.add(senderNameErrorLabel, gbc);

        // --- Card Number ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("Card Number:"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        cardNumberField = createTextField(20);
        formPanel.add(cardNumberField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        cardNumberErrorLabel = createErrorLabel();
        formPanel.add(cardNumberErrorLabel, gbc);

        // --- Expiry Date ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("Expiry Date (MM/YY):"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        expiryField = createTextField(5);
        formPanel.add(expiryField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        expiryErrorLabel = createErrorLabel();
        formPanel.add(expiryErrorLabel, gbc);

        // --- CVV ---
        gbc.gridx = 0; gbc.gridy = yPos; gbc.anchor = GridBagConstraints.EAST; gbc.insets = new Insets(10, 10, 0, 10);
        formPanel.add(createLabel("CVV:"), gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.weightx = 1.0; gbc.anchor = GridBagConstraints.WEST;
        cvvField = createPasswordField(3);
        formPanel.add(cvvField, gbc);
        gbc.gridx = 1; gbc.gridy = yPos++; gbc.insets = new Insets(2, 12, 10, 10);
        cvvErrorLabel = createErrorLabel();
        formPanel.add(cvvErrorLabel, gbc);

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
        gbc.weightx = 0; gbc.insets = new Insets(20, 10, 10, 10);
        formPanel.add(payButton, gbc);

        return formPanel;
    }

    private void setupValidationListeners() {
        senderNameField.getDocument().addDocumentListener(new ValidationListener(this::validateSenderName));
        senderNameField.addFocusListener(new ValidationFocusListener(this::validateSenderName));
        cardNumberField.getDocument().addDocumentListener(new ValidationListener(this::validateCardNumber));
        cardNumberField.addFocusListener(new ValidationFocusListener(this::validateCardNumber));
        expiryField.getDocument().addDocumentListener(new ValidationListener(this::validateExpiryDate));
        expiryField.addFocusListener(new ValidationFocusListener(this::validateExpiryDate));
        cvvField.getDocument().addDocumentListener(new ValidationListener(this::validateCvv));
        cvvField.addFocusListener(new ValidationFocusListener(this::validateCvv));
        amountField.getDocument().addDocumentListener(new ValidationListener(this::validateAmount));
        amountField.addFocusListener(new ValidationFocusListener(this::validateAmount));
    }

    private boolean validateSenderName() {
        String name = senderNameField.getText().trim();
        if (name.isEmpty()) {
            senderNameErrorLabel.setText("Cardholder's name cannot be empty.");
            return false;
        } else if (!name.matches("^[a-zA-Z\\s'-]+$")) {
            senderNameErrorLabel.setText("Please enter a valid name.");
            return false;
        }
        senderNameErrorLabel.setText(" ");
        return true;
    }

    private boolean validateCardNumber() {
        String cardNumber = cardNumberField.getText().trim();
        if (!cardNumber.matches("\\d{16}")) {
            cardNumberErrorLabel.setText("Card number must be 16 digits.");
            return false;
        }
        cardNumberErrorLabel.setText(" ");
        return true;
    }

    private boolean validateExpiryDate() {
        String expiryDateStr = expiryField.getText().trim();
        if (!expiryDateStr.matches("(0[1-9]|1[0-2])/[0-9]{2}")) {
            expiryErrorLabel.setText("Invalid format. Use MM/YY.");
            return false;
        }
        try {
            String[] parts = expiryDateStr.split("/");
            int month = Integer.parseInt(parts[0]);
            int year = Integer.parseInt(parts[1]) + 2000;
            if (YearMonth.of(year, month).isBefore(YearMonth.now())) {
                expiryErrorLabel.setText("Card has expired.");
                return false;
            }
        } catch (NumberFormatException | DateTimeParseException e) {
            expiryErrorLabel.setText("Invalid date.");
            return false;
        }
        expiryErrorLabel.setText(" ");
        return true;
    }

    private boolean validateCvv() {
        String cvv = new String(cvvField.getPassword()).trim();
        if (!cvv.matches("\\d{3}")) {
            cvvErrorLabel.setText("CVV must be 3 digits.");
            return false;
        }
        cvvErrorLabel.setText(" ");
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

    private JButton createPayButton() {
        JButton payButton = new JButton("Pay Now");
        payButton.setFont(new Font("Inter", Font.BOLD, 16));
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(new Color(255, 99, 132)); // Red theme
        payButton.setOpaque(true);
        payButton.setBorderPainted(false);
        payButton.setFocusPainted(false);

        payButton.addActionListener(e -> {
            boolean isAllValid = validateSenderName() &
                                 validateCardNumber() & validateExpiryDate() &
                                 validateCvv() & validateAmount();

            if (isAllValid) {
                new OTPPage(new Color(255, 99, 132)).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please fix the errors shown in red.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });
        return payButton;
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

    private JPasswordField createPasswordField(int columns) {
        JPasswordField passwordField = new JPasswordField(columns);
        styleTextComponent(passwordField);
        return passwordField;
    }

    private void styleTextComponent(javax.swing.text.JTextComponent component) {
        component.setFont(new Font("Inter", Font.PLAIN, 14));
        component.setBackground(new Color(40, 44, 55));
        component.setForeground(Color.WHITE);
        component.setCaretColor(Color.WHITE);
        Color themeColor = new Color(255, 99, 132); // Red theme
        component.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(themeColor),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        component.setSelectionColor(themeColor);
        component.setSelectedTextColor(Color.WHITE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreditCardPage().setVisible(true));
    }
}