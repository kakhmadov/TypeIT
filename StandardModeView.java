import javax.swing.*;
import java.awt.*;

public class StandardModeView extends JPanel {
    private JButton exitButton;
    private JButton prevButton;
    private JButton checkButton;
    private JButton nextButton;
    private JButton showSolutionButton;
    private JTextField answerField;
    private JLabel sentenceLabel;
    private String frage;

    public StandardModeView() {
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

        // Anweisungstext
        JLabel instructionText = new JLabel("In diesen Sätzen haben sich einige Fehler\n eingeschlichen. Kannst du sie finden?");
        instructionText.setFont(new Font("SansSerif", Font.PLAIN, 14));
        instructionText.setOpaque(true);
        instructionText.setBackground(Color.WHITE);
        instructionText.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createVerticalStrut(10)); // Abstand
        mainPanel.add(instructionText);
        mainPanel.add(Box.createVerticalStrut(10));

        // Satz, den der Benutzer korrigieren soll
        sentenceLabel = new JLabel(frage, SwingConstants.CENTER);
        sentenceLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        sentenceLabel.setForeground(Color.BLACK);
        sentenceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(sentenceLabel);

        // Eingabefeld für die Antwort
        answerField = new JTextField("Geben Sie hier Ihre Antwort ein.");
        answerField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        answerField.setHorizontalAlignment(JTextField.CENTER);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(answerField);
        mainPanel.add(Box.createVerticalStrut(10));

        add(mainPanel, BorderLayout.CENTER);

        // Untere Leiste mit Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        bottomPanel.setOpaque(false);

        prevButton = new JButton("<-");
        checkButton = new JButton("PRÜFEN");
        nextButton = new JButton("->");
        showSolutionButton = new JButton("Lösung anzeigen");

        bottomPanel.add(prevButton);
        bottomPanel.add(checkButton);
        bottomPanel.add(nextButton);
        bottomPanel.add(showSolutionButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    // Getter-Methoden für die Buttons und das Textfeld (Controller kann darauf zugreifen)
    public JButton getExitButton() {
        return exitButton;
    }

    public JButton getPrevButton() {
        return prevButton;
    }

    public JButton getCheckButton() {
        return checkButton;
    }

    public JButton getNextButton() {
        return nextButton;
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
    public String getFrage() {
        return frage;

    }
    public void setFrage(String frage) {
        this.frage= frage;
        sentenceLabel.setText(frage);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new FragenVerwaltenView());
        frame.setSize(500,500);
        frame.setVisible(true);
    }

}
