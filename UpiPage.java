import javax.swing.*;
import java.awt.*;

public class UpiPage extends JFrame {

    public UpiPage() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - UPI Payment");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(30, 33, 45));
        setLayout(new BorderLayout());

        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(new Color(36, 40, 56));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JLabel titleLabel = new JLabel("UPI Payment");
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
        String[] labels = {"UPI ID:", "Amount:"};
        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Inter", Font.BOLD, 14));
            label.setForeground(Color.WHITE);
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.EAST;
            formPanel.add(label, gbc);
        }

        // Fields
        JTextField upiIdField = new JTextField(20);
        JTextField amountField = new JTextField(10);
        JTextField[] fields = {upiIdField, amountField};

        for (int i = 0; i < fields.length; i++) {
            fields[i].setFont(new Font("Inter", Font.PLAIN, 14));
            fields[i].setBackground(new Color(40, 44, 55));
            fields[i].setForeground(Color.WHITE);
            fields[i].setCaretColor(Color.WHITE);
            fields[i].setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(54, 185, 204)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            ));
            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.WEST;
            formPanel.add(fields[i], gbc);
        }

        // Pay Button
        JButton payButton = new JButton("Pay Now");
        payButton.setFont(new Font("Inter", Font.BOLD, 16));
        payButton.setForeground(Color.WHITE);
        payButton.setBackground(new Color(54, 185, 204));
        payButton.setOpaque(true);
        payButton.setBorderPainted(false);
        payButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE; // Reset fill
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 10, 10, 10);
        formPanel.add(payButton, gbc);

        payButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Payment processing...", "Processing", JOptionPane.INFORMATION_MESSAGE);
            // Logic for UPI payment
            this.dispose();
        });

        add(formPanel, BorderLayout.CENTER);
    }
}
