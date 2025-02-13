import javax.swing.*;
import java.awt.*;

public class TypeITView extends JFrame {
    private JButton standardButton;
    private JButton hangmanButton;
    private JButton quizButton;
    private JButton manageQuestionsButton;

    public TypeITView() {
        // Fenster-Setup
        setTitle("Type IT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600); // Größeres Fenster für bessere Sichtbarkeit
        setLayout(new BorderLayout());
        setBackground(new Color(64, 79, 79)); // Einheitsfarbe für den Hintergrund

        // Hintergrundfarbe für das gesamte JFrame setzen
        getContentPane().setBackground(new Color(64, 79, 79));

        // Titel Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(true);
        titlePanel.setBackground(new Color(64, 79, 79));  // Hintergrundfarbe des Panels

        JLabel titleLabel = new JLabel("TypeIT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.ITALIC, 30)); // Größerer Titel
        titleLabel.setForeground(Color.WHITE); // Textfarbe für den Titel
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Wählen Sie einen Spielmodus um zu beginnen", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 18)); // Etwas größere Schrift für den Untertitel
        subtitleLabel.setForeground(Color.WHITE); // Textfarbe für den Untertitel
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(subtitleLabel);

        add(titlePanel, BorderLayout.NORTH);

        // Hauptpanel für Buttons
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); // Weniger Rand oben/unten
        mainPanel.setOpaque(true);  // Hintergrund sichtbar
        mainPanel.setBackground(new Color(64, 79, 79)); // Einheitsfarbe für das Panel

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10)); // Größerer Abstand zwischen den Buttons
        buttonPanel.setOpaque(true);  // Hintergrund sichtbar
        buttonPanel.setBackground(new Color(64, 79, 79)); // Gleiche Hintergrundfarbe wie der Rest

        standardButton = new JButton("Standart");
        hangmanButton = new JButton("Hang-Man");
        quizButton = new JButton("Quiz");
        manageQuestionsButton = new JButton("Fragen-Verwalten");

        // Alle Buttons anpassen
        standardButton.setPreferredSize(new Dimension(200, 50));  // Größere Buttons
        hangmanButton.setPreferredSize(new Dimension(200, 50));
        quizButton.setPreferredSize(new Dimension(200, 50));
        manageQuestionsButton.setPreferredSize(new Dimension(200, 50));

        buttonPanel.add(standardButton);
        buttonPanel.add(quizButton);
        buttonPanel.add(hangmanButton);
        buttonPanel.add(manageQuestionsButton);

        // Panel für Buttons + Bild
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(true);  // Hintergrund sichtbar
        bottomPanel.setBackground(new Color(64, 79, 79)); // Gleiche Hintergrundfarbe wie der Rest
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        // Bild Panel in der unteren rechten Ecke
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        imagePanel.setOpaque(false);  // Transparent für das Bild-Panel

        ImageIcon icon = new ImageIcon(new ImageIcon("Hintergrundbild.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(icon);
        imagePanel.add(imageLabel);

        bottomPanel.add(imagePanel, BorderLayout.SOUTH);

        mainPanel.add(bottomPanel, BorderLayout.CENTER);
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
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
