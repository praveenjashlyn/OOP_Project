import javax.swing.*;
import java.awt.*;

public class PaymentSuccessPage extends JFrame {

    private Timer redirectTimer;
    private int countdown = 5;
    private JLabel countdownLabel;

    public PaymentSuccessPage() {
        initUI();
    }

    private void initUI() {
        setTitle("Payment Successful");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(30, 33, 45));
        setLayout(new GridBagLayout());

        // Success Icon
        JLabel iconLabel = new JLabel("✔");
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 80));
        iconLabel.setForeground(new Color(34, 197, 94)); // Green color

        // Success Message
        JLabel messageLabel = new JLabel("Payment Successful!");
        messageLabel.setFont(new Font("Inter", Font.BOLD, 24));
        messageLabel.setForeground(Color.WHITE);

        // Countdown Label
        countdownLabel = new JLabel("Redirecting to dashboard in " + countdown + " seconds...");
        countdownLabel.setFont(new Font("Inter", Font.PLAIN, 14));
        countdownLabel.setForeground(new Color(150, 150, 150));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        add(iconLabel, gbc);
        add(messageLabel, gbc);
        add(countdownLabel, gbc);

        // Timer to update the countdown label every second
        redirectTimer = new Timer(1000, _ -> {
            countdown--;
            if (countdown > 0) {
                countdownLabel.setText("Redirecting to dashboard in " + countdown + " seconds...");
            } else {
                redirectTimer.stop();
                dispose(); // Close this success page
                new FinFlowDashboard().setVisible(true); // Open the dashboard
            }
        });
        redirectTimer.setInitialDelay(1000); // Start countdown after 1 second
        redirectTimer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PaymentSuccessPage().setVisible(true));
    }
}
