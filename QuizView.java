import javax.swing.*;
import java.awt.*;
import java.io.File;

public class QuizView extends JPanel {
    private JTextField answerField;
    private JLabel imageLabel;
    private JButton submitButton, backButton;

    public QuizView(TypeITController controller) {
        setLayout(new BorderLayout());
        setBackground(new Color(96, 105, 99));

        // Top: Image instead of text
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        // Load and display the image
        loadImage("quiz_image.jpg"); // Change filename here if needed

        // Center: Answer Field
        answerField = new JTextField();
        answerField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(answerField, BorderLayout.CENTER);

        // Bottom: Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        submitButton = new JButton("Senden");
        backButton = new JButton("Zurück");

        backButton.setActionCommand("Zurueck");
        backButton.addActionListener(controller);

        buttonPanel.add(submitButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadImage(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            ImageIcon icon = new ImageIcon(filename);
            Image scaledImage = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
        } else {
            imageLabel.setText("Bild nicht gefunden: " + filename);
            imageLabel.setForeground(Color.RED);
        }
    }
}
