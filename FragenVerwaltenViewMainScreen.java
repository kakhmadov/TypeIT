import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FragenVerwaltenViewMainScreen extends JPanel{

    private JButton btnFrageHinzufuegen;
    private JButton btnFrageBearbeiten;
    private JButton btnFrageLoeschen;
    private JButton btnZurueck;
    private JButton btnPool1;
    private JButton btnPool2;
    private JButton btnPool3;
    private JLabel lblTitle;
    private JLabel lblInstruction;
    private TypeITController controller;


    public FragenVerwaltenViewMainScreen(TypeITController controller) {
        //this.controller = new TypeITController();

    // setTitle("Fragen Verwalten");
    //  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        setLayout(new BorderLayout());
        setBackground(new Color(96, 105, 99)); // Hintergrundfarbe

        // Titel-Label (Oben)
        lblTitle = new JLabel("TypeIT", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Serif", Font.ITALIC, 32));
        lblTitle.setForeground(Color.BLACK);

        lblInstruction = new JLabel("Wählen Sie den gewünschten Fragepool", SwingConstants.CENTER);
        lblInstruction.setFont(new Font("Serif", Font.ITALIC, 18));
        lblInstruction.setForeground(Color.BLACK);

        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setOpaque(false);
        titlePanel.add(lblTitle);
        titlePanel.add(lblInstruction);
        add(titlePanel, BorderLayout.NORTH);

        // Mittelbereich mit Buttons
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        btnPool1 = new JButton("Pool 1");
        btnPool1.setActionCommand("pool1");
        btnPool1.addActionListener(controller);
        btnPool2 = new JButton("Pool 2");
        btnPool3 = new JButton("Pool 3");
        btnFrageHinzufuegen = new JButton("Hinzufügen");
        btnFrageLoeschen = new JButton("Löschen");
        btnFrageBearbeiten = new JButton("1 Mio Euro Gewinnen");
        btnFrageBearbeiten.setEnabled(false);

        Font buttonFont = new Font("Serif", Font.ITALIC, 18);
        btnPool1.setFont(buttonFont);
        btnPool2.setFont(buttonFont);
        btnPool3.setFont(buttonFont);
        btnFrageHinzufuegen.setFont(buttonFont);
        btnFrageLoeschen.setFont(buttonFont);
        btnFrageBearbeiten.setFont(buttonFont);

        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(btnPool1, gbc);

        gbc.gridy = 1;
        centerPanel.add(btnPool2, gbc);

        gbc.gridy = 2;
        centerPanel.add(btnPool3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(btnFrageHinzufuegen, gbc);

        gbc.gridy = 1;
        centerPanel.add(btnFrageLoeschen, gbc);

        gbc.gridy = 2;
       centerPanel.add(btnFrageBearbeiten, gbc);

        add(centerPanel, BorderLayout.CENTER);

        // Zurück-Button (Links)
        btnZurueck = new JButton("Zurück");
        btnZurueck.setFont(buttonFont);
        btnZurueck.setActionCommand("Zurueck");
        btnZurueck.addActionListener(controller);

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setOpaque(false);
        leftPanel.add(btnZurueck);
        add(leftPanel, BorderLayout.WEST);
        setVisible(true);

    }


    public JButton getBtnFrageHinzufuegen() {
        return btnFrageHinzufuegen;
    }

   public JButton getBtnFrageBearbeiten() {
        return btnFrageBearbeiten;
    }

    public JButton getBtnFrageLoeschen() {
        return btnFrageLoeschen;
    }

    public JButton getBtnZurueck() {
        return btnZurueck;
    }

    public JButton getBtnPool1() {
        return btnPool1;
    }

}
//500 400 Fenstergrößr