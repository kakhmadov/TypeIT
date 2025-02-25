import javax.swing.*;
import java.awt.*;

public class TypeITView extends JFrame {
    private JButton standardButton;
    private JButton hangmanButton;
    private JButton quizButton;
    private JButton manageQuestionsButton;
    private JPanel mainPanel;
    private TypeITController controller;

    public TypeITView(TypeITController controller) {
        // Fenster-Setup
        this.controller = controller;
        setTitle("Type IT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());
        setBackground(new Color(64, 79, 79));

        getContentPane().setBackground(new Color(64, 79, 79));

        // Titel Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
        titlePanel.setOpaque(true);
        titlePanel.setBackground(new Color(64, 79, 79));

        JLabel titleLabel = new JLabel("TypeIT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.ITALIC, 30));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(titleLabel);

        JLabel subtitleLabel = new JLabel("Wählen Sie einen Spielmodus um zu beginnen", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(subtitleLabel);

        add(titlePanel, BorderLayout.NORTH);

        // Hauptpanel für Buttons
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        mainPanel.setOpaque(true);
        mainPanel.setBackground(new Color(64, 79, 79));

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setOpaque(true);
        buttonPanel.setBackground(new Color(64, 79, 79));

        standardButton = new JButton("Standart");
        standardButton.setActionCommand("STANDARD");
        standardButton.addActionListener(controller);

        hangmanButton = new JButton("Hang-Man");

        quizButton = new JButton("Quiz");
        quizButton.setActionCommand("QUIZ");  // ✅ Now the ActionCommand is set
        quizButton.addActionListener(controller);  // ✅ Now it is connected to the Controller

        manageQuestionsButton = new JButton("Fragen-Verwalten");
        manageQuestionsButton.setActionCommand("manageQuestions");
        manageQuestionsButton.addActionListener(controller);

        standardButton.setPreferredSize(new Dimension(200, 50));
        hangmanButton.setPreferredSize(new Dimension(200, 50));
        quizButton.setPreferredSize(new Dimension(200, 50));
        manageQuestionsButton.setPreferredSize(new Dimension(200, 50));

        buttonPanel.add(standardButton);
        buttonPanel.add(quizButton);
        buttonPanel.add(hangmanButton);
        buttonPanel.add(manageQuestionsButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(true);
        bottomPanel.setBackground(new Color(64, 79, 79));
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        imagePanel.setOpaque(false);

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

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
