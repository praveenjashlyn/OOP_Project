import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A Java Swing application to display the FinFlow dashboard.
 * This page appears after login and provides options to create an account.
 */
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

        // Header panel with logo and title
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

        add(headerPanel, BorderLayout.NORTH);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(30, 33, 45));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));

        // Balance Card
        JPanel balanceCard = createCardPanel(new Color(90, 105, 255), 340, 120);
        balanceCard.setAlignmentX(Component.CENTER_ALIGNMENT);
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

        mainPanel.add(balanceCard);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        // Payment Methods Heading
        JLabel paymentHeading = new JLabel("Payment Methods");
        paymentHeading.setFont(new Font("Inter", Font.BOLD, 28));
        paymentHeading.setForeground(Color.WHITE);
        paymentHeading.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(paymentHeading);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Payment Methods Cards Panel
        JPanel methodsPanel = new JPanel();
        methodsPanel.setLayout(new GridLayout(1, 4, 30, 0));
        methodsPanel.setBackground(new Color(30, 33, 45));
        methodsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 180));

        methodsPanel.add(createPaymentCard("Debit Card", "\uD83D\uDCB3", new Color(90, 105, 255)));
        methodsPanel.add(createPaymentCard("Credit Card", "\uD83D\uDCB5", new Color(255, 99, 132)));
        methodsPanel.add(createPaymentCard("UPI", "\uD83D\uDCF1", new Color(54, 185, 204)));
        methodsPanel.add(createPaymentCard("Bank Transfer", "\uD83D\uDCB0", new Color(255, 193, 7)));

        mainPanel.add(methodsPanel);
        mainPanel.add(Box.createVerticalGlue());

        add(mainPanel, BorderLayout.CENTER);
    }

    // Card panel with rounded corners and shadow
    private JPanel createCardPanel(Color color, int width, int height) {
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Shadow
                g2.setColor(new Color(0, 0, 0, 40));
                g2.fillRoundRect(8, 10, getWidth() - 16, getHeight() - 16, 40, 40);
                // Card background
                g2.setColor(color);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        card.setOpaque(false);
        card.setPreferredSize(new Dimension(width, height));
        card.setMaximumSize(new Dimension(width, height));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return card;
    }

    // Payment method card-like button
    private JButton createPaymentCard(String text, String icon, Color color) {
        JButton button = new JButton("<html><center>" + icon + "<br>" + text + "</center></html>") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // Shadow
                g2.setColor(new Color(0, 0, 0, 40));
                g2.fillRoundRect(6, 8, getWidth() - 12, getHeight() - 12, 30, 30);
                // Card background
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        button.setFont(new Font("Inter", Font.BOLD, 20));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder(25, 10, 25, 10));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(170, 150));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.CENTER);

        // Hover effect
        Color hoverColor = color.brighter();
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
                button.repaint();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
                button.repaint();
            }
        });

        button.addActionListener(e -> {
            switch (text) {
                case "Debit Card":
                    new DebitCardPage().setVisible(true);
                    break;
                case "Credit Card":
                    new CreditCardPage().setVisible(true);
                    break;
                case "UPI":
                    new UpiPage().setVisible(true);
                    break;
                case "Bank Transfer":
                    new BankTransferPage().setVisible(true);
                    break;
            }
        });

        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");
            } catch (Exception ex) {
                // fallback to default
            }
            FinFlowDashboard dashboard = new FinFlowDashboard();
            dashboard.setVisible(true);
        });
    }
}
