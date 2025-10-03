import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
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

        // --- Table Setup ---
        // In a real application, this data would be fetched from a database (e.g., using JDBC).
        String[] columnNames = {"Date", "Transaction ID", "Receiver/Sender", "Amount", "Balance"};
        Object[][] data = {
            {"03 Oct 2025", "TXN789012", "Sent to John Doe", "- ₹5,000.00", "₹20,000.00"},
            {"02 Oct 2025", "TXN654321", "Received from Jane Smith", "+ ₹2,500.00", "₹25,000.00"},
            {"01 Oct 2025", "TXN987654", "Online Shopping", "- ₹1,200.00", "₹22,500.00"},
            {"30 Sep 2025", "TXN123456", "Salary Credit", "+ ₹50,000.00", "₹23,700.00"},
            {"29 Sep 2025", "TXN456789", "Rent Payment", "- ₹15,000.00", "₹-26,300.00"},
            {"28 Sep 2025", "TXN789123", "Cash Withdrawal", "- ₹3,000.00", "₹11,300.00"},
            {"27 Sep 2025", "TXN321654", "Received from Mike", "+ ₹1,000.00", "₹14,300.00"},
            {"26 Sep 2025", "TXN654987", "Electricity Bill", "- ₹850.00", "₹13,300.00"},
            {"25 Sep 2025", "TXN987321", "Sent to Emily", "- ₹2,000.00", "₹14,150.00"},
            {"24 Sep 2025", "TXN123789", "Zomato Order", "- ₹450.00", "₹16,150.00"}
        };

        JTable transactionTable = new JTable(data, columnNames);
        styleTable(transactionTable);

        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        scrollPane.getViewport().setBackground(new Color(24, 28, 40));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Back Button
        JButton backButton = new JButton("Back to Dashboard");
        backButton.setFont(new Font("Inter", Font.BOLD, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(90, 105, 255));
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(_ -> {
            dispose();
            dashboard.setVisible(true);
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(24, 28, 40));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        buttonPanel.add(backButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void styleTable(JTable table) {
        table.setBackground(new Color(40, 44, 55));
        table.setForeground(Color.WHITE);
        table.setGridColor(new Color(70, 75, 90));
        table.setFont(new Font("Inter", Font.PLAIN, 14));
        table.setRowHeight(40);
        table.setSelectionBackground(new Color(90, 105, 255));
        table.setSelectionForeground(Color.WHITE);
        table.setShowGrid(true);
        table.setShowVerticalLines(false);
        table.setFillsViewportHeight(true);
        table.setIntercellSpacing(new Dimension(0, 1));

        // Style the table header
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(36, 40, 56));
        header.setForeground(new Color(180, 180, 180));
        header.setFont(new Font("Inter", Font.BOLD, 16));
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(90, 105, 255)));
        header.setPreferredSize(new Dimension(header.getWidth(), 50));

        // Make table non-editable
        table.setDefaultEditor(Object.class, null);

        // Custom cell renderer to color the "Amount" column
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (column == 3) { // Amount column
                    String amount = (String) value;
                    if (amount.startsWith("+")) {
                        c.setForeground(new Color(34, 197, 94)); // Green for credit
                    } else {
                        c.setForeground(new Color(239, 68, 68)); // Red for debit
                    }
                } else {
                    c.setForeground(isSelected ? Color.WHITE : new Color(220, 220, 220));
                }
                setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        };

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
}
