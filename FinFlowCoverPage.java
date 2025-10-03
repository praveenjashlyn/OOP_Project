import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * A Java Swing application to display an animated cover page for the FinFlow app.
 * The animation includes the title sliding and fading in, followed by a description
 * and a continue button appearing.
 */
public class FinFlowCoverPage extends JFrame {

    public FinFlowCoverPage() {
        initUI();
    }

    private void initUI() {
        setTitle("FinFlow - Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Center the window
        setResizable(false);

        // Pass 'this' (the JFrame instance) to the CoverPanel constructor
        add(new CoverPanel(this));
    }

    public static void main(String[] args) {
        // Ensure UI updates are done on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            FinFlowCoverPage ex = new FinFlowCoverPage();
            ex.setVisible(true);
        });
    }

    /**
     * The main panel that handles all the custom drawing and animation logic.
     */
    static class CoverPanel extends JPanel implements ActionListener {

        private final JFrame parentFrame; // Add\\\\ed field to store the parent frame

        private final Timer timer;

        // Animation state variables
        private float titleAlpha = 0.0f;
        private int titleY;
        private float descAlpha = 0.0f;

        private final String titleText = "FinFlow";
        private final String descriptionText = "Your seamless virtual payment experience.";

        private final Font titleFont = new Font("Inter", Font.BOLD, 72);
        private final Font descFont = new Font("Inter", Font.PLAIN, 22);

        private JButton continueButton;

        private enum AnimationState {
            TITLE_ANIMATION,
            DESCRIPTION_ANIMATION,
            BUTTON_APPEAR,
            IDLE
        }

        private AnimationState state;

        // Modified constructor to accept the parent JFrame
        public CoverPanel(JFrame parentFrame) {
            this.parentFrame = parentFrame;
            setLayout(null); // Use absolute positioning for the button
            setBackground(new Color(24, 28, 40)); // A modern dark blue

            // Initialize timer for animation, firing every 15ms for smooth visuals
            timer = new Timer(15, this);
            state = AnimationState.TITLE_ANIMATION;

            setupContinueButton();

            // Start the animation when the panel is ready
            // Adding a small delay to ensure the panel is sized before starting
            Timer startDelay = new Timer(500, e -> {
                titleY = getHeight(); // Start title at the bottom
                timer.start();
                ((Timer)e.getSource()).stop();
            });
            startDelay.setRepeats(false);
            startDelay.start();
        }

        private void setupContinueButton() {
            continueButton = new JButton("Continue");
            continueButton.setBounds(325, 400, 150, 50);
            continueButton.setFont(new Font("Inter", Font.BOLD, 18));
            continueButton.setForeground(Color.WHITE);
            continueButton.setBackground(new Color(90, 105, 255));
            continueButton.setOpaque(true); // Important for background color on macOS
            continueButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            continueButton.setFocusPainted(false);
            continueButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            continueButton.setVisible(false); // Initially hidden
            continueButton.addActionListener(_ -> {
                // Create and show the new login page
                SwingUtilities.invokeLater(() -> {
                    FinFlowLoginPage loginPage = new FinFlowLoginPage(parentFrame);
                    loginPage.setVisible(true);
                });

                // This line disposes of the FinFlowCoverPage window
                parentFrame.dispose();
            });

            add(continueButton);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            // Enable anti-aliasing for smooth text
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            // Draw Title
            drawText(g2d, titleText, titleFont, new Color(255, 255, 255), titleY, titleAlpha);

            // Draw Description
            if (descAlpha > 0) {
                int descriptionY = getHeight() / 2 + 50;
                drawText(g2d, descriptionText, descFont, new Color(200, 200, 220), descriptionY, descAlpha);
            }

            g2d.dispose();
        }

        /**
         * Helper method to draw centered, translucent text.
         */
        /**
         * Helper method to draw centered, translucent text.
         */
        private void drawText(Graphics2D g2d, String text, Font font, Color color, int y, float alpha) {
            g2d.setFont(font);
            FontRenderContext frc = g2d.getFontRenderContext();
            Rectangle2D bounds = font.getStringBounds(text, frc);
            int textWidth = (int) bounds.getWidth();
            int x = (getWidth() - textWidth) / 2;

            g2d.setColor(color);

            // Clamp the alpha value to be within the valid range [0.0f, 1.0f]
            // This is the fix for the IllegalArgumentException
            alpha = Math.max(0.0f, Math.min(1.0f, alpha));

            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2d.drawString(text, x, y);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (state) {
                case TITLE_ANIMATION:
                    updateTitleAnimation();
                    break;
                case DESCRIPTION_ANIMATION:
                    updateDescriptionAnimation();
                    break;
                case BUTTON_APPEAR:
                    showButton();
                    break;
                case IDLE:
                    // Do nothing
                    break;
            }
            repaint();
        }

        private void updateTitleAnimation() {
            // Animate alpha (fade-in)
            if (titleAlpha < 1.0f) {
                titleAlpha += 0.015f;
                if (titleAlpha > 1.0f) titleAlpha = 1.0f;
            }

            // Animate Y position (ease-out)
            int targetY = getHeight() / 2;
            int distance = titleY - targetY;
            if (distance > 1) {
                titleY -= distance * 0.05; // The "easing" part
            } else {
                titleY = targetY;
                // Once title is in place and faded in, move to the next state
                if (titleAlpha >= 1.0f) {
                    state = AnimationState.DESCRIPTION_ANIMATION;
                }
            }
        }

        private void updateDescriptionAnimation() {
            if (descAlpha < 1.0f) {
                descAlpha += 0.02f;
            } else {
                descAlpha = 1.0f;
                state = AnimationState.BUTTON_APPEAR;
            }
        }

        private void showButton() {
            continueButton.setVisible(true);
            state = AnimationState.IDLE;
            timer.stop(); // Stop the timer as all animations are done
        }
    }
}