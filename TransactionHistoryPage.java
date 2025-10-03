import javax.swing.*;
import java.awt.*;

public class TransactionHistoryPage extends JFrame {

    private JFrame dashboard;

    public TransactionHistoryPage(JFrame dashboard) {
        this.dashboard = dashboard;
        initUI();
    }

    private void initUI() {
        setTitle("Transaction History");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(24, 28, 40));

        // Title
        JLabel titleLabel = new JLabel("All Transactions", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Inter", Font.BOLD, 28));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Transaction List
        JPanel transactionsPanel = new JPanel();
        transactionsPanel.setBackground(new Color(24, 28, 40));
        transactionsPanel.setLayout(new BoxLayout(transactionsPanel, BoxLayout.Y_AXIS));

        // Placeholder transactions
        for (int i = 1; i <= 10; i++) {
            transactionsPanel.add(createTransactionPanel("Transaction " + i, "Amount: $" + (i * 100)));
        }

        JScrollPane scrollPane = new JScrollPane(transactionsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Back Button
        JButton backButton = new JButton("Back to Dashboard");
        backButton.setFont(new Font("Inter", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(90, 105, 255));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        backButton.addActionListener(_ -> {
            dispose();
            dashboard.setVisible(true);
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(24, 28, 40));
        buttonPanel.add(backButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createTransactionPanel(String description, String amount) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(40, 44, 55));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(70, 75, 90)),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setForeground(Color.WHITE);
        descriptionLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        panel.add(descriptionLabel, BorderLayout.WEST);

        JLabel amountLabel = new JLabel(amount);
        amountLabel.setForeground(Color.GREEN);
        amountLabel.setFont(new Font("Inter", Font.BOLD, 16));
        panel.add(amountLabel, BorderLayout.EAST);

        return panel;
    }
}
