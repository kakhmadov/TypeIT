import javax.swing.*;
import java.awt.*;

public class HangmanDrawingPanel extends JPanel {
    private int wrongAttempts = 0;

    public void incrementWrongAttempts() {
        if (wrongAttempts < 6) wrongAttempts++;
        repaint();
    }

    public void reset() {
        wrongAttempts = 0;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.BLACK);

        int centerX = getWidth() / 2;
        int baseY = getHeight() - 30;
        int headRadius = 20;

        // Draw gallows
        g2d.drawLine(centerX - 50, baseY, centerX + 50, baseY); // Base
        g2d.drawLine(centerX, baseY, centerX, 50);               // Vertical pole
        g2d.drawLine(centerX, 50, centerX + 80, 50);             // Horizontal beam
        g2d.drawLine(centerX + 80, 50, centerX + 80, 70);        // Rope

        // Draw hangman based on wrong attempts
        if (wrongAttempts >= 1) g2d.drawOval(centerX + 80 - headRadius, 70, 2 * headRadius, 2 * headRadius); // Head
        if (wrongAttempts >= 2) g2d.drawLine(centerX + 80, 70 + 2 * headRadius, centerX + 80, 170);           // Body
        if (wrongAttempts >= 3) g2d.drawLine(centerX + 80, 110, centerX + 60, 120);                           // Left arm
        if (wrongAttempts >= 4) g2d.drawLine(centerX + 80, 110, centerX + 100, 120);                          // Right arm
        if (wrongAttempts >= 5) g2d.drawLine(centerX + 80, 170, centerX + 60, 200);                           // Left leg
        if (wrongAttempts >= 6) g2d.drawLine(centerX + 80, 170, centerX + 100, 200);                           // Right leg
    }
}