import javax.swing.*;
import java.awt.*;

public class PoolHinzufuegen extends JPanel {
    private JButton backButton, addButton;
    private JTextField fragepoolNameField;
    private JRadioButton standardButton, quizButton, hangmanButton;
    private ButtonGroup modeGroup;

    public PoolHinzufuegen() {
        setLayout(new BorderLayout());
        setBackground(new Color(96, 105, 99));

        // Header
        JLabel titleLabel = new JLabel("TypeIT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.ITALIC, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Center Panel for Form Elements
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new GridLayout(4, 1, 10, 10));

        fragepoolNameField = new JTextField("Fragepool Name");
        centerPanel.add(fragepoolNameField);

        JPanel modePanel = new JPanel(new FlowLayout());
        JLabel modeLabel = new JLabel("Modus:");
        modePanel.setOpaque(false);
        modePanel.add(modeLabel);

        standardButton = new JRadioButton("Standart");
        quizButton = new JRadioButton("Quiz");
        hangmanButton = new JRadioButton("Hang-Man");

        modeGroup = new ButtonGroup();
        modeGroup.add(standardButton);
        modeGroup.add(quizButton);
        modeGroup.add(hangmanButton);

        modePanel.add(standardButton);
        modePanel.add(quizButton);
        modePanel.add(hangmanButton);

        centerPanel.add(modePanel);

        addButton = new JButton("Hinzufügen");
        centerPanel.add(addButton);

        add(centerPanel, BorderLayout.CENTER);

        // Back Button
        backButton = new JButton("Zurück");
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backPanel.setOpaque(false);
        backPanel.add(backButton);
        add(backPanel, BorderLayout.WEST);
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getFragepoolNameField() {
        return fragepoolNameField;
    }

    public JRadioButton getStandardButton() {
        return standardButton;
    }

    public JRadioButton getQuizButton() {
        return quizButton;
    }

    public JRadioButton getHangmanButton() {
        return hangmanButton;
    }
}
