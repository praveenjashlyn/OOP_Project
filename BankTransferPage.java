import javax.swing.*;
import java.awt.*;

public class BankTransferPage extends JFrame {

    public BankTransferPage() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - Bank Transfer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(30, 33, 45));
        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(36, 40, 56));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JLabel titleLabel = new JLabel("Bank Transfer");
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
        String[] labels = {"Account Number:", "Confirm Account Number:", "IFSC Code:", "Beneficiary Name:", "Amount:"};
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
        JTextField accNumField = new JTextField(20);
        JTextField confirmAccNumField = new JTextField(20);
        JTextField ifscField = new JTextField(15);
        JTextField nameField = new JTextField(20);
        JTextField amountField = new JTextField(10);
        JTextField[] fields = {accNumField, confirmAccNumField, ifscField, nameField, amountField};

        for (int i = 0; i < fields.length; i++) {
            fields[i].setFont(new Font("Inter", Font.PLAIN, 14));
            fields[i].setBackground(new Color(40, 44, 55));
            fields[i].setForeground(Color.WHITE);
            fields[i].setCaretColor(Color.WHITE);
            fields[i].setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 193, 7)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            ));
            
            // FIX 1: Make text visible by setting selection colors
            fields[i].setSelectionColor(new Color(255, 193, 7));
            fields[i].setSelectedTextColor(Color.WHITE);

            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.WEST;
            // FIX 2: Allow text fields to expand horizontally
            gbc.weightx = 1.0;
            formPanel.add(fields[i], gbc);
        }

        // Transfer Button
        JButton transferButton = new JButton("Transfer Now");
        transferButton.setFont(new Font("Inter", Font.BOLD, 16));
        transferButton.setForeground(Color.WHITE);
        transferButton.setBackground(new Color(255, 193, 7));
        transferButton.setOpaque(true);
        transferButton.setBorderPainted(false);
        transferButton.setFocusPainted(false);
        
        // Reset layout constraints for the button
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0; // Ensure button does not expand
        gbc.insets = new Insets(20, 10, 10, 10);
        formPanel.add(transferButton, gbc);

        transferButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Transfer processing...", "Processing", JOptionPane.INFORMATION_MESSAGE);
            // Logic for bank transfer
            this.dispose();
        });

        add(formPanel, BorderLayout.CENTER);
    }
    
    // Main method for testing this specific frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankTransferPage bankTransferPage = new BankTransferPage();
            bankTransferPage.setVisible(true);
        });
    }
}