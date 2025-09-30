import javax.swing.*;
import java.awt.*;

public class DebitCardPage extends JFrame {

    public DebitCardPage() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - Debit Card");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(30, 33, 45));
        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(36, 40, 56));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JLabel titleLabel = new JLabel("Debit Card Payment");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(30, 33, 45));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels
        String[] labels = {"Card Number:", "Expiry Date (MM/YY):", "CVV:", "Amount:"};
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Inter", Font.BOLD, 14));
            label.setForeground(Color.WHITE);
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.weightx = 0; // Ensure labels column does not expand
            formPanel.add(label, gbc);
        }

        // Fields
        JTextField cardNumberField = new JTextField(20);
        JTextField expiryField = new JTextField(5);
        JPasswordField cvvField = new JPasswordField(3);
        JTextField amountField = new JTextField(10);
        javax.swing.text.JTextComponent[] fields = {cardNumberField, expiryField, cvvField, amountField};

        for (int i = 0; i < fields.length; i++) {
            fields[i].setFont(new Font("Inter", Font.PLAIN, 14));
            fields[i].setBackground(new Color(40, 44, 55));
            fields[i].setForeground(Color.WHITE);
            fields[i].setCaretColor(Color.WHITE);
            fields[i].setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(90, 105, 255)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            ));

            // FIX 1: Make text visible by setting selection colors
            fields[i].setSelectionColor(new Color(90, 105, 255));
            fields[i].setSelectedTextColor(Color.WHITE);

            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.WEST;
            // FIX 2: Allow text fields to expand horizontally
            gbc.weightx = 1.0;
            formPanel.add(fields[i], gbc);
        }

        // Pay Button
        JButton payButton = new JButton("Pay Now");
        payButton.setFont(new Font("Inter", Font.BOLD, 16));
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(new Color(90, 105, 255));
        payButton.setOpaque(true);
        payButton.setBorderPainted(false);
        payButton.setFocusPainted(false);
        
        // Reset layout constraints for the button
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0; // Ensure button does not expand
        gbc.insets = new Insets(20, 10, 10, 10);
        formPanel.add(payButton, gbc);

        payButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Payment processing...", "Processing", JOptionPane.INFORMATION_MESSAGE);
            // Logic for debit card payment
            this.dispose();
        });

        add(formPanel, BorderLayout.CENTER);
    }
    
    // You can add a main method to run this class independently for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DebitCardPage debitCardPage = new DebitCardPage();
            debitCardPage.setVisible(true);
        });
    }
}