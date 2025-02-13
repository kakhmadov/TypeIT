import javax.swing.*;
import java.awt.*;

public class LoesungAnzeigenHangman extends JPanel {
    private JButton btnBeenden, btnPruefen, btnLoesung, btnNext, btnPrev;
    private JTextArea txtSentence;
    private JTextField txtAnswer;
    private JLabel lblImage;
    private String bildPfad;
    private String loesung;
    private String satz;

    public LoesungAnzeigenHangman() {

        setLayout(new BorderLayout());
        setBackground(new Color(96, 105, 99));  // Setzt die Hintergrundfarbe des Hauptpanels

        // Obere Leiste mit Beenden-Button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setOpaque(false); // Verhindert, dass der Hintergrund des Panels die Farbe überschreibt
        btnBeenden = new JButton("Beenden");
        topPanel.add(btnBeenden);
        add(topPanel, BorderLayout.NORTH);

        // Hauptbereich mit Text und Bild
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.setOpaque(false); // Verhindert, dass der Hintergrund des Panels die Farbe überschreibt

        // Linker Bereich: Satz und Eingabe
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setOpaque(false); // Verhindert, dass der Hintergrund des Panels die Farbe überschreibt
        txtSentence = new JTextArea("In diesem Satz hat sich ein Fehler eingeschlichen. Kannst du diesen finden?\n\n" +
                satz +  " \n\n\n\n\n\n\n\n\n\n\n");
        txtSentence.setEditable(false);
        textPanel.add(txtSentence, BorderLayout.NORTH);
        txtAnswer = new JTextField(loesung);
        txtAnswer.setEditable(false);
        textPanel.add(txtAnswer, BorderLayout.SOUTH);
        centerPanel.add(textPanel);

        // Rechter Bereich: Bilddarstellung
        lblImage = new JLabel();
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerPanel.add(lblImage);

        // Bild einfügen
        ImageIcon icon = new ImageIcon(new ImageIcon(bildPfad).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        lblImage.setIcon(icon); // Das Bild direkt in lblImage setzen

        add(centerPanel, BorderLayout.CENTER);

        // Untere Steuerleiste mit Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setOpaque(false); // Verhindert, dass der Hintergrund des Panels die Farbe überschreibt
        btnPrev = new JButton("<-");
        btnPruefen = new JButton("PRÜFEN");
        btnPruefen.setEnabled(false);
        btnNext = new JButton("->");
        btnLoesung = new JButton("Lösung verbergen");

        bottomPanel.add(btnPrev);
        bottomPanel.add(btnPruefen);
        bottomPanel.add(btnNext);
        bottomPanel.add(btnLoesung);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void showView() {
        setVisible(true);
    }
}
