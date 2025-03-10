import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FragenVerwaltenView extends JPanel {

    private JButton btnFrageHinzufuegen;
 //   private JButton btnFrageBearbeiten;
    private JButton btnFrageLoeschen;
    private JButton btnZurueck;
    private JButton poolSpeichern;
    private JButton poolLaden;
    private JLabel lblTitle;
    private TypeITController controller;

    public FragenVerwaltenView(TypeITController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());
        setBackground(new Color(96, 105, 99)); // Hintergrundfarbe

        // Titel-Label
        lblTitle = new JLabel("TypeIT", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Serif", Font.ITALIC, 24));
        lblTitle.setForeground(Color.WHITE);
        add(lblTitle, BorderLayout.NORTH);

        // Panel für Buttons mit Abstand zum rechten Rand
        JPanel centerPanelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
        centerPanelWrapper.setOpaque(false);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1, 10, 10));
        centerPanel.setOpaque(false);

        btnFrageHinzufuegen = new JButton("Frage hinzufügen");
        btnFrageHinzufuegen.setActionCommand("frageHinzufuegen");
        btnFrageHinzufuegen.addActionListener(controller);
        btnFrageLoeschen = new JButton("Frage löschen");
        btnFrageLoeschen.setActionCommand("frageLoeschen");
        btnFrageLoeschen.addActionListener(controller);
        poolLaden = new JButton("Pool Laden");
        poolLaden.setActionCommand("poolLaden");
        poolLaden.addActionListener(controller);
        poolSpeichern = new JButton("Pool Speichern");
        poolSpeichern.setActionCommand("poolSpeichern");
        poolSpeichern.addActionListener(controller);


        btnFrageHinzufuegen.setFont(new Font("Serif", Font.ITALIC, 18));
    //    btnFrageBearbeiten.setFont(new Font("Serif", Font.ITALIC, 18));
        btnFrageLoeschen.setFont(new Font("Serif", Font.ITALIC, 18));

        centerPanel.add(btnFrageHinzufuegen);
    //    centerPanel.add(btnFrageBearbeiten);
        centerPanel.add(btnFrageLoeschen);
        centerPanel.add(poolLaden);
        centerPanel.add(poolSpeichern);

        centerPanelWrapper.add(centerPanel);
        add(centerPanelWrapper, BorderLayout.CENTER);

        // Zurück-Button (West)
        btnZurueck = new JButton("Home");
        btnZurueck.setActionCommand("Zurueck");
        btnZurueck.addActionListener(controller);
        btnZurueck.setFont(new Font("Serif", Font.ITALIC, 16));
        JPanel westPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        westPanel.setOpaque(false);
        westPanel.add(btnZurueck);
        add(westPanel, BorderLayout.WEST);
    }


}
// Fenster Größe aut  300 und 225 und nicht veränderbar machen