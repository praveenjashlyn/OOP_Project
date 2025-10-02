// // import javax.swing.*;
// // import java.awt.*;

// // public class OTPPage extends JFrame {

// //     private JPasswordField otpField;

// //     public OTPPage() {
// //         initUI();
// //     }

// //     private void initUI() {
// //         setTitle("FinFlow - OTP Verification");
// //         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
// //         setSize(500, 400); // Same size for consistency
// //         setLocationRelativeTo(null);
// //         setResizable(false);
// //         getContentPane().setBackground(new Color(30, 33, 45));
// //         setLayout(new GridBagLayout()); // Use GridBagLayout for centering

// //         GridBagConstraints gbc = new GridBagConstraints();
// //         gbc.gridwidth = GridBagConstraints.REMAINDER;
// //         gbc.insets = new Insets(10, 0, 10, 0);

// //         // --- Info Label ---
// //         JLabel infoLabel = new JLabel("OTP has been sent to your mobile number.");
// //         infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
// //         infoLabel.setForeground(Color.WHITE);
// //         add(infoLabel, gbc);

// //         // --- Instruction Label ---
// //         JLabel otpLabel = new JLabel("Please enter the 6-digit OTP below");
// //         otpLabel.setFont(new Font("Inter", Font.PLAIN, 14));
// //         otpLabel.setForeground(Color.LIGHT_GRAY);
// //         add(otpLabel, gbc);
        
// //         // --- OTP Input Field ---
// //         otpField = new JPasswordField(6);
// //         otpField.setFont(new Font("Inter", Font.BOLD, 24));
// //         otpField.setForeground(Color.WHITE);
// //         otpField.setBackground(new Color(40, 44, 55));
// //         otpField.setCaretColor(Color.WHITE);
// //         otpField.setHorizontalAlignment(JTextField.CENTER);
// //         otpField.setBorder(BorderFactory.createCompoundBorder(
// //                 BorderFactory.createLineBorder(new Color(255, 99, 132)),
// //                 BorderFactory.createEmptyBorder(10, 10, 10, 10)
// //         ));
// //         // Add some extra vertical padding for the field
// //         gbc.insets = new Insets(20, 0, 20, 0);
// //         add(otpField, gbc);
        
// //         // --- Verify Button ---
// //         JButton verifyButton = new JButton("Verify Payment");
// //         verifyButton.setFont(new Font("Inter", Font.BOLD, 16));
// //         verifyButton.setForeground(Color.WHITE);
// //         verifyButton.setBackground(new Color(255, 99, 132));
// //         verifyButton.setOpaque(true);
// //         verifyButton.setBorderPainted(false);
// //         verifyButton.setFocusPainted(false);
// //         verifyButton.setPreferredSize(new Dimension(180, 40));
        
// //         // Reset insets for the button
// //         gbc.insets = new Insets(10, 0, 10, 0);
// //         add(verifyButton, gbc);
        
// //         // --- Action Listener for Verification ---
// //         verifyButton.addActionListener(e -> {
// //             String otp = new String(otpField.getPassword()).trim();
// //             // Simple validation: check if it's a 6-digit number.
// //             // In a real app, you'd compare this to a server-generated code.
// //             if (otp.matches("\\d{6}")) {
// //                 JOptionPane.showMessageDialog(this, "Payment Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
// //                 // On success, close the OTP window.
// //                 // In a real app, you might navigate back to a main page.
// //                 this.dispose(); 
// //             } else {
// //                 JOptionPane.showMessageDialog(this, "Invalid OTP. Please enter the 6-digit code.", "Verification Failed", JOptionPane.ERROR_MESSAGE);
// //             }
// //         });
// //     }

// //     // Main method for testing this specific frame
// //     public static void main(String[] args) {
// //         SwingUtilities.invokeLater(() -> {
// //             OTPPage otpPage = new OTPPage();
// //             otpPage.setVisible(true);
// //         });
// //     }
// // }

// import javax.swing.*;
// import java.awt.*;

// public class OTPPage extends JFrame {

//     public OTPPage(Color themeColor) {
//         initUI(themeColor);
//     }

//     private void initUI(Color themeColor) {
//         setTitle("FinFlow - OTP Verification");
//         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         setSize(500, 400);
//         setLocationRelativeTo(null);
//         setResizable(false);
//         getContentPane().setBackground(new Color(30, 33, 45));
//         setLayout(new GridBagLayout());

//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.gridwidth = GridBagConstraints.REMAINDER;
//         gbc.insets = new Insets(10, 0, 10, 0);

//         // --- Info & Instruction Labels ---
//         JLabel infoLabel = new JLabel("OTP has been sent to your mobile number.");
//         infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
//         infoLabel.setForeground(Color.WHITE);
//         add(infoLabel, gbc);

//         JLabel otpLabel = new JLabel("Please enter the 6-digit OTP below");
//         otpLabel.setFont(new Font("Inter", Font.PLAIN, 14));
//         otpLabel.setForeground(Color.LIGHT_GRAY);
//         add(otpLabel, gbc);
        
//         // --- OTP Input Field ---
//         JPasswordField otpField = new JPasswordField(6);
//         otpField.setFont(new Font("Inter", Font.BOLD, 24));
//         otpField.setForeground(Color.WHITE);
//         otpField.setBackground(new Color(40, 44, 55));
//         otpField.setCaretColor(Color.WHITE);
//         otpField.setHorizontalAlignment(JTextField.CENTER);
//         otpField.setBorder(BorderFactory.createCompoundBorder(
//                 BorderFactory.createLineBorder(themeColor),
//                 BorderFactory.createEmptyBorder(10, 10, 10, 10)
//         ));
        
//         gbc.insets = new Insets(20, 0, 20, 0);
//         add(otpField, gbc);
        
//         // --- Verify Button ---
//         JButton verifyButton = new JButton("Verify Payment");
//         verifyButton.setFont(new Font("Inter", Font.BOLD, 16));
//         verifyButton.setForeground(Color.WHITE);
//         verifyButton.setBackground(themeColor);
//         verifyButton.setOpaque(true);
//         verifyButton.setBorderPainted(false);
//         verifyButton.setFocusPainted(false);
//         verifyButton.setPreferredSize(new Dimension(180, 40));
        
//         gbc.insets = new Insets(10, 0, 10, 0);
//         add(verifyButton, gbc);
        
//         // --- Action Listener ---
//         verifyButton.addActionListener(e -> {
//             String otp = new String(otpField.getPassword()).trim();
//             if (otp.matches("\\d{6}")) {
//                 JOptionPane.showMessageDialog(this, "Payment Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
//                 this.dispose(); 
//             } else {
//                 JOptionPane.showMessageDialog(this, "Invalid OTP. Please enter the 6-digit code.", "Verification Failed", JOptionPane.ERROR_MESSAGE);
//             }
//         });
//     }
// }

import javax.swing.*;
import java.awt.*;

public class OTPPage extends JFrame {

    public OTPPage(Color themeColor) {
        initUI(themeColor);
    }

    private void initUI(Color themeColor) {
        setTitle("FinFlow - OTP Verification");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(30, 33, 45));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 10, 0);

        // --- Info & Instruction Labels ---
        JLabel infoLabel = new JLabel("OTP has been sent to your mobile number.");
        infoLabel.setFont(new Font("Inter", Font.BOLD, 16));
        infoLabel.setForeground(Color.WHITE);
        add(infoLabel, gbc);

        JLabel otpLabel = new JLabel("Please enter the 6-digit OTP below");
        otpLabel.setFont(new Font("Inter", Font.PLAIN, 14));
        otpLabel.setForeground(Color.LIGHT_GRAY);
        add(otpLabel, gbc);
        
        // --- OTP Input Field ---
        JPasswordField otpField = new JPasswordField(6);
        otpField.setFont(new Font("Inter", Font.BOLD, 24));
        otpField.setForeground(Color.WHITE);
        otpField.setBackground(new Color(40, 44, 55));
        otpField.setCaretColor(Color.WHITE);
        otpField.setHorizontalAlignment(JTextField.CENTER);
        otpField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(themeColor),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        
        gbc.insets = new Insets(20, 0, 20, 0);
        add(otpField, gbc);
        
        // --- Verify Button ---
        JButton verifyButton = new JButton("Verify Payment");
        verifyButton.setFont(new Font("Inter", Font.BOLD, 16));
        verifyButton.setForeground(Color.WHITE);
        verifyButton.setBackground(themeColor);
        verifyButton.setOpaque(true);
        verifyButton.setBorderPainted(false);
        verifyButton.setFocusPainted(false);
        verifyButton.setPreferredSize(new Dimension(180, 40));
        
        gbc.insets = new Insets(10, 0, 10, 0);
        add(verifyButton, gbc);
        
        // --- Action Listener ---
        verifyButton.addActionListener(e -> {
            String otp = new String(otpField.getPassword()).trim();
            if (otp.matches("\\d{6}")) {
                // *** THIS IS THE MODIFIED PART ***

                // 1. Remove all components from the frame
                getContentPane().removeAll();

                // 2. Create and style the success label
                JLabel successLabel = new JLabel("Payment Successful!");
                successLabel.setFont(new Font("Inter", Font.BOLD, 28));
                successLabel.setForeground(new Color(40, 180, 99)); // A nice green color
                successLabel.setHorizontalAlignment(SwingConstants.CENTER);

                // 3. Change layout and add the new label to center it
                setLayout(new BorderLayout());
                add(successLabel, BorderLayout.CENTER);

                // 4. Refresh the frame to show the changes
                revalidate();
                repaint();
                
            } else {
                JOptionPane.showMessageDialog(this, "Invalid OTP. Please enter the 6-digit code.", "Verification Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}