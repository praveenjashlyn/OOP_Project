import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaymentMethodsPage extends JFrame {

    public PaymentMethodsPage() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - Payment Methods");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Closes only this window
        setSize(900, 650); // Shorter since there's no balance card
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(30, 33, 45));
        setLayout(new BorderLayout());

        // Header panel - identical to the dashboard's header
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

        // Main panel for payment options
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(30, 33, 45));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 60, 40, 60));

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
        add(mainPanel, BorderLayout.CENTER);
    }

    // This helper method is copied directly from your dashboard to ensure identical style
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
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });

        // Action listener to open the correct payment page
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
}