import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinFlowDashboard extends JFrame {

    public FinFlowDashboard() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(30, 33, 45));
        setLayout(new BorderLayout());

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
        headerPanel.setBackground(new Color(36, 40, 56));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel logoLabel = new JLabel("\uD83D\uDCB0");
        logoLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 40));
        logoLabel.setForeground(new Color(90, 105, 255));
        headerPanel.add(logoLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        JLabel appTitle = new JLabel("FinFlow");
        appTitle.setFont(new Font("Inter", Font.BOLD, 32));
        appTitle.setForeground(new Color(90, 105, 255));
        headerPanel.add(appTitle);
        headerPanel.add(Box.createHorizontalGlue());

        // User Name Label
        JLabel userNameLabel = new JLabel("John Doe");
        userNameLabel.setFont(new Font("Inter", Font.BOLD, 16));
        userNameLabel.setForeground(Color.WHITE);
        userNameLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15)); // Add some spacing to the right
        headerPanel.add(userNameLabel);

        // Hamburger menu button
        JButton menuButton = new JButton("☰");
        menuButton.setFont(new Font("Inter", Font.BOLD, 24));
        menuButton.setForeground(Color.WHITE);
        menuButton.setOpaque(false);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        menuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerPanel.add(menuButton);

        // Popup menu for user details and logout
        JPopupMenu userMenu = new JPopupMenu();
        userMenu.setBackground(new Color(40, 44, 55));
        userMenu.setBorder(BorderFactory.createLineBorder(new Color(70, 75, 90)));

        // User details
        addMenuItem(userMenu, "Mobile: +91 98765 43210");
        addMenuItem(userMenu, "Email: john.doe@example.com");

        userMenu.addSeparator();

        // Logout button
        JMenuItem logoutItem = new JMenuItem("Logout");
        logoutItem.setFont(new Font("Inter", Font.BOLD, 14));
        logoutItem.setForeground(new Color(255, 99, 132)); // Red color for logout
        logoutItem.setBackground(new Color(40, 44, 55));
        logoutItem.addActionListener(_ -> {
            // Logic to logout and return to login screen
            this.dispose();
            new FinFlowCoverPage().setVisible(true);
        });
        userMenu.add(logoutItem);

        menuButton.addActionListener(_ -> {
            userMenu.show(menuButton, 0, menuButton.getHeight());
        });

        add(headerPanel, BorderLayout.NORTH);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(0, 40));
        mainPanel.setBackground(new Color(30, 33, 45));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        // A panel for the top content (Balance and Send Money)
        JPanel topContentPanel = new JPanel(new GridBagLayout());
        topContentPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();

        // Balance Card
        JPanel balanceCard = createCardPanel(new Color(90, 105, 255), 340, 120);
        balanceCard.setLayout(new BoxLayout(balanceCard, BoxLayout.Y_AXIS));
        JLabel balanceHeading = new JLabel("Balance");
        balanceHeading.setFont(new Font("Inter", Font.BOLD, 24));
        balanceHeading.setForeground(Color.WHITE);
        balanceHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel balanceValue = new JLabel("\u20B9 25,000.00");
        balanceValue.setFont(new Font("Inter", Font.BOLD, 36));
        balanceValue.setForeground(Color.WHITE);
        balanceValue.setAlignmentX(Component.CENTER_ALIGNMENT);
        balanceCard.add(Box.createVerticalGlue());
        balanceCard.add(balanceHeading);
        balanceCard.add(Box.createRigidArea(new Dimension(0, 10)));
        balanceCard.add(balanceValue);
        balanceCard.add(Box.createVerticalGlue());
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        topContentPanel.add(balanceCard, gbc);

        // Spacer
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        topContentPanel.add(Box.createHorizontalGlue(), gbc);

        // Send Money Button
        JButton payNowButton = createPayNowButton();
        gbc.gridx = 2;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        topContentPanel.add(payNowButton, gbc);

        mainPanel.add(topContentPanel, BorderLayout.NORTH);

        // Transaction History
        mainPanel.add(createTransactionHistoryPanel(), BorderLayout.CENTER);

        add(mainPanel, BorderLayout.CENTER);
    }

    private void addMenuItem(JPopupMenu menu, String text) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setFont(new Font("Inter", Font.PLAIN, 14));
        menuItem.setForeground(Color.WHITE);
        menuItem.setBackground(new Color(40, 44, 55));
        menuItem.setEnabled(false); // Make it non-clickable
        menu.add(menuItem);
    }

    private JPanel createTransactionHistoryPanel() {
        // Main container for the entire history section
        JPanel historySectionPanel = new JPanel(new BorderLayout(0, 15));
        historySectionPanel.setOpaque(false);
        historySectionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Title Label
        JLabel titleLabel = new JLabel("Recent Transactions");
        titleLabel.setFont(new Font("Inter", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        historySectionPanel.add(titleLabel, BorderLayout.NORTH);

        // Panel to hold the transaction rows
        JPanel rowsPanel = new JPanel();
        rowsPanel.setLayout(new BoxLayout(rowsPanel, BoxLayout.Y_AXIS));
        rowsPanel.setOpaque(false);

        // Add two transaction rows
        rowsPanel.add(createTransactionRow("Sent to John Doe", "- ₹5,000.00", "Oct 02, 2025", false));
        rowsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        rowsPanel.add(createTransactionRow("Received from Jane Smith", "+ ₹2,500.00", "Oct 01, 2025", true));
        
        historySectionPanel.add(rowsPanel, BorderLayout.CENTER);

        // Panel for the "See More" button, aligned to the right
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        buttonPanel.setOpaque(false);

        JButton seeMoreButton = new JButton("See More...");
        seeMoreButton.setFont(new Font("Inter", Font.BOLD, 14));
        seeMoreButton.setForeground(new Color(180, 180, 180));
        seeMoreButton.setContentAreaFilled(false);
        seeMoreButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        seeMoreButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        seeMoreButton.addActionListener(_ -> {
            this.setVisible(false);
            new TransactionHistoryPage(this).setVisible(true);
        });
        
        buttonPanel.add(seeMoreButton);
        historySectionPanel.add(buttonPanel, BorderLayout.SOUTH);

        return historySectionPanel;
    }

    private JPanel createTransactionRow(String description, String amount, String date, boolean isCredit) {
        // A custom rounded panel for each transaction row
        JPanel rowPanel = new RoundedPanel(new BorderLayout(15, 0), 20);
        rowPanel.setBackground(new Color(40, 44, 55));
        rowPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));

        // Icon for credit/debit
        JLabel iconLabel = new JLabel();
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 24));
        if (isCredit) {
            iconLabel.setText("⬇️"); // Down arrow for incoming
            iconLabel.setForeground(new Color(34, 197, 94));
        } else {
            iconLabel.setText("⬆️"); // Up arrow for outgoing
            iconLabel.setForeground(new Color(239, 68, 68));
        }
        rowPanel.add(iconLabel, BorderLayout.WEST);

        // Panel for description and date
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);

        JLabel descLabel = new JLabel(description);
        descLabel.setForeground(Color.WHITE);
        descLabel.setFont(new Font("Inter", Font.BOLD, 16));
        
        JLabel dateLabel = new JLabel(date);
        dateLabel.setForeground(new Color(150, 150, 150));
        dateLabel.setFont(new Font("Inter", Font.PLAIN, 12));
        
        infoPanel.add(descLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(0, 4)));
        infoPanel.add(dateLabel);
        
        rowPanel.add(infoPanel, BorderLayout.CENTER);

        // Amount Label
        JLabel amountLabel = new JLabel(amount);
        amountLabel.setFont(new Font("Inter", Font.BOLD, 16));
        amountLabel.setForeground(isCredit ? new Color(34, 197, 94) : new Color(239, 68, 68));
        rowPanel.add(amountLabel, BorderLayout.EAST);
        
        return rowPanel;
    }

    // Helper for the rounded balance card
    private JPanel createCardPanel(Color color, int width, int height) {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 0, 0, 40));
                g2.fillRoundRect(8, 10, getWidth() - 16, getHeight() - 16, 40, 40);
                g2.setColor(color);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
                g2.dispose();
            }
        };
        card.setOpaque(false);
        card.setPreferredSize(new Dimension(width, height));
        card.setMaximumSize(new Dimension(width, height));
        card.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return card;
    }

    // Helper for the attractive "Send Money" button
    private JButton createPayNowButton() {
        JButton button = new JButton("<html><div style='text-align: center;'>\uD83D\uDCE4<br/>Send Money</div></html>") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 0, 0, 50));
                g2.fillRoundRect(8, 10, getWidth() - 16, getHeight() - 16, 50, 50);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
                g2.dispose();
                super.paintComponent(g);
            }
        };

        Color baseColor = new Color(54, 185, 204);
        Color hoverColor = baseColor.brighter();
        
        button.setFont(new Font("Inter", Font.BOLD, 26));
        button.setForeground(Color.WHITE);
        button.setBackground(baseColor);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(340, 120));
        button.setMaximumSize(new Dimension(340, 120));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(baseColor);
            }
        });
        
        button.addActionListener(_ -> {
            new ReceiverDetailsPage().setVisible(true); // This opens the new page
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
            } catch (Exception ex) {
                System.err.println("Failed to initialize LaF");
            }
            new FinFlowDashboard().setVisible(true);
        });
    }
}