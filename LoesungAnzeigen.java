import javax.swing.*;
import java.awt.*;

public class LoesungAnzeigen extends JPanel {
    private JButton exitButton;
    private JButton showSolutionButton;
    private JTextField answerField;
    private JLabel sentenceLabel;

    public LoesungAnzeigen() {
        setLayout(new BorderLayout());
        setBackground(new Color(64, 79, 79));

        // Obere Leiste mit "Beenden"-Button
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);

        exitButton = new JButton("Beenden");
        exitButton.setFocusable(false);
        topPanel.add(exitButton, BorderLayout.WEST);

        JLabel titleLabel = new JLabel("StandartModus", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 22));
        titleLabel.setForeground(Color.BLACK);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);

        // Hauptbereich mit Aufgabenbeschreibung & Satz
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);

        // Satz, den der Benutzer korrigieren soll
        sentenceLabel = new JLabel("<html> <h2>Die Lösung lautet: </h2></html> ", SwingConstants.CENTER);
        sentenceLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        sentenceLabel.setForeground(Color.BLACK);
        sentenceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(sentenceLabel);

        // Eingabefeld für die Antwort
        answerField = new JTextField("Hier steht die Lösung.");
        answerField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        answerField.setEditable(false);
        answerField.setHorizontalAlignment(JTextField.CENTER);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(answerField);
        mainPanel.add(Box.createVerticalStrut(10));

        add(mainPanel, BorderLayout.CENTER);

        // Untere Leiste mit Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        bottomPanel.setOpaque(false);

        // Fehlende Initialisierung des Buttons
        showSolutionButton = new JButton("Lösung verbergen");

        bottomPanel.add(showSolutionButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Getter-Methoden für die Buttons und das Textfeld (Controller kann darauf zugreifen)
    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getShowSolutionButton() {
        return showSolutionButton;
    }

    public JTextField getAnswerField() {
        return answerField;
    }

    public JLabel getSentenceLabel() {
        return sentenceLabel;
    }


}
