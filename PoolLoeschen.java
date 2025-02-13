import javax.swing.*;
import java.awt.*;

public class PoolLoeschen extends JPanel {
    private JButton backButton;
    private JButton deleteButton;
    private JRadioButton pool1;
    private JRadioButton pool2;
    private JRadioButton pool3;
    private ButtonGroup poolGroup;

    public PoolLoeschen() {
        setLayout(new BorderLayout());
        setBackground(new Color(96, 105, 99));

        // Titel Label
        JLabel titleLabel = new JLabel("TypeIT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.ITALIC, 20));
        titleLabel.setOpaque(false);
        add(titleLabel, BorderLayout.NORTH);

        // Linker Bereich mit Back-Button
        backButton = new JButton("Zurück");
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(backButton);
        leftPanel.setOpaque(false);
        add(leftPanel, BorderLayout.WEST);

        // Zentraler Bereich mit Radiobuttons
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new GridLayout(3, 1, 5, 5));

        pool1 = new JRadioButton("Pool 1");
      //  pool1.setOpaque(false);
        pool2 = new JRadioButton("Pool 2");
     //   pool2.setOpaque(false);
        pool3 = new JRadioButton("Pool 3");
    //    pool3.setOpaque(false);

        poolGroup = new ButtonGroup();
        poolGroup.add(pool1);
        poolGroup.add(pool2);
        poolGroup.add(pool3);

        centerPanel.add(pool1);
        centerPanel.add(pool2);
        centerPanel.add(pool3);

        add(centerPanel, BorderLayout.CENTER);

        // Rechter Bereich mit Löschen-Button
        deleteButton = new JButton("Löschen");
        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.add(deleteButton);
        add(rightPanel, BorderLayout.EAST);
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JRadioButton getPool1() {
        return pool1;
    }

    public JRadioButton getPool2() {
        return pool2;
    }

    public JRadioButton getPool3() {
        return pool3;
    }
}
