import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Random;

public class QuizView extends JPanel {
    private JTextField answerField;
    private JLabel imageLabel;
    private JButton submitButton, backButton;
    private static final String IMAGE_FOLDER = "pictures";
    private String currentImageFile;

    public QuizView(TypeITController controller) {
        setLayout(new BorderLayout());
        setBackground(new Color(96, 105, 99));

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.NORTH);

        currentImageFile = getRandomImage();
        loadImage(currentImageFile);

        answerField = new JTextField();
        answerField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        add(answerField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        submitButton = new JButton("Prüfen");
        backButton = new JButton("Zurück");

        submitButton.setActionCommand("QuizCheck");
        submitButton.addActionListener(controller);
        backButton.setActionCommand("Zurueck");
        backButton.addActionListener(controller);

        buttonPanel.add(submitButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String getRandomImage() {
        Random random = new Random();
        int randomNumber = random.nextInt(20) + 1; // Zufallszahl zwischen 1 und 20
        return IMAGE_FOLDER + "/" + randomNumber + ".jpg";
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

    public String getCurrentImageFile() {
        return currentImageFile;
    }

    public String getUserAnswer() {
        return answerField.getText().trim();
    }
}