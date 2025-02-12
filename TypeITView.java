import javax.swing.*;
import java.awt.*;

public class TypeITView extends JPanel {
    private JButton standardButton;
    private JButton hangmanButton;
    private JButton quizButton;
    private JButton manageQuestionsButton;

    public TypeITView() {
        setLayout(new BorderLayout());
        setBackground(new Color(64, 79, 79));

        // Titel Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(false);

        JLabel titleLabel = new JLabel("TypeIT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.ITALIC, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Wählen Sie einen Spielmodus um zu beginnen", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(subtitleLabel);

        add(titlePanel, BorderLayout.NORTH);

        // Hauptpanel für Buttons und Bild
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 50, 5, 50)); // Weniger Rand oben/unten
        mainPanel.setOpaque(false);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 5, 5)); // Weniger Abstand zwischen Buttons
        buttonPanel.setOpaque(false);

        standardButton = new JButton("Standart");
        hangmanButton = new JButton("Hang-Man");
        quizButton = new JButton("Quiz");
        manageQuestionsButton = new JButton("Fragen-Verwalten");

        buttonPanel.add(standardButton);
        buttonPanel.add(quizButton);
        buttonPanel.add(hangmanButton);
        buttonPanel.add(manageQuestionsButton);

        // Panel für Buttons + Bild
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // Bild Panel in der unteren rechten Ecke
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        imagePanel.setOpaque(false);

        ImageIcon icon = new ImageIcon(new ImageIcon("Hintergrundbild.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(icon);
        imagePanel.add(imageLabel);

        bottomPanel.add(imagePanel, BorderLayout.SOUTH);

        mainPanel.add(bottomPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);

    }

    // Getter-Methoden für die Buttons (Controller kann darauf zugreifen)
    public JButton getStandardButton() {
        return standardButton;
    }

    public JButton getHangmanButton() {
        return hangmanButton;
    }

    public JButton getQuizButton() {
        return quizButton;
    }

    public JButton getManageQuestionsButton() {
        return manageQuestionsButton;
    }
}
