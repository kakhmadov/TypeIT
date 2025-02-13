import javax.swing.*;
import java.awt.*;

public class FragenVerwaltenView extends JPanel {

    private JButton btnFrageHinzufuegen;
    private JButton btnFrageBearbeiten;
    private JButton btnFrageLoeschen;
    private JButton btnZurueck;
    private JLabel lblTitle;

    public FragenVerwaltenView() {
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
        btnFrageBearbeiten = new JButton("Frage bearbeiten");
        btnFrageLoeschen = new JButton("Frage löschen");

        btnFrageHinzufuegen.setFont(new Font("Serif", Font.ITALIC, 18));
        btnFrageBearbeiten.setFont(new Font("Serif", Font.ITALIC, 18));
        btnFrageLoeschen.setFont(new Font("Serif", Font.ITALIC, 18));

        centerPanel.add(btnFrageHinzufuegen);
        centerPanel.add(btnFrageBearbeiten);
        centerPanel.add(btnFrageLoeschen);

        centerPanelWrapper.add(centerPanel);
        add(centerPanelWrapper, BorderLayout.CENTER);

        // Zurück-Button (West)
        btnZurueck = new JButton("Zurück");
        btnZurueck.setFont(new Font("Serif", Font.ITALIC, 16));
        JPanel westPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        westPanel.setOpaque(false);
        westPanel.add(btnZurueck);
        add(westPanel, BorderLayout.WEST);
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
}
// Fenster Größe aut  300 und 225 und nicht veränderbar machen