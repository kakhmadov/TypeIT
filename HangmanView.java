import javax.swing.*;
import java.awt.*;

public class HangmanView extends JPanel {
    private JButton btnBeenden, btnPruefen, btnLoesung, btnNext;
    private JTextArea txtSentence;
    private JTextField txtAnswer;
    private JLabel lblImage;
    private String bildPfad;
    private String frage;
    private HangmanDrawingPanel drawingPanel;

    public HangmanView(TypeITController controller) {

        setLayout(new BorderLayout());
        setBackground(new Color(96, 105, 99));  // Setzt die Hintergrundfarbe des Hauptpanels

        // Obere Leiste mit Beenden-Button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setOpaque(false); // Verhindert, dass der Hintergrund des Panels die Farbe überschreibt
        btnBeenden = new JButton("Beenden");
        btnBeenden.setActionCommand("HangBEENDEN");
        btnBeenden.addActionListener(controller);
        topPanel.add(btnBeenden);
        add(topPanel, BorderLayout.NORTH);

        // Hauptbereich mit Text und Bild
        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.setOpaque(false); // Verhindert, dass der Hintergrund des Panels die Farbe überschreibt

        // Linker Bereich: Satz und Eingabe
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setOpaque(false); // Verhindert, dass der Hintergrund des Panels die Farbe überschreibt

        txtSentence = new JTextArea("""
                In diesem Satz hat sich ein Fehler eingeschlichen. Kannst du diesen finden?

                Der Junge hat das Buch, dass auf dem Tisch lag, genommen.""");
        txtSentence.setPreferredSize(new Dimension(300,400));
        txtSentence.setLineWrap(true);
        txtSentence.setWrapStyleWord(true);
        txtSentence.setEditable(false);
        textPanel.add(txtSentence, BorderLayout.NORTH);
        txtAnswer = new JTextField("Geben Sie hier Ihre Antwort ein.");
        textPanel.add(txtAnswer, BorderLayout.SOUTH);
        centerPanel.add(textPanel);

        // Rechter Bereich: Bilddarstellung
        drawingPanel = new HangmanDrawingPanel();
        drawingPanel.setPreferredSize(new Dimension(300, 400));
        drawingPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerPanel.add(drawingPanel);

        // Bild einfügen
        ImageIcon icon = new ImageIcon(new ImageIcon(bildPfad).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        //lblImage.setIcon(icon); // Das Bild direkt in lblImage setzen

        add(centerPanel, BorderLayout.CENTER);

        // Untere Steuerleiste mit Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setOpaque(false); // Verhindert, dass der Hintergrund des Panels die Farbe überschreibt
        btnPruefen = new JButton("PRÜFEN");
        btnPruefen.setActionCommand("HangPRUEFEN");
        btnPruefen.addActionListener(controller);
        btnNext = new JButton("->");
        btnNext.setActionCommand("HangNAECHSTES");
        btnNext.addActionListener(controller);
        btnLoesung = new JButton("Lösung anzeigen");
        btnLoesung.setActionCommand("HangLOESUNG");
        btnLoesung.addActionListener(controller);

        bottomPanel.add(btnPruefen);
        bottomPanel.add(btnNext);
        bottomPanel.add(btnLoesung);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void showView() {
        setVisible(true);
    }

    public void setFrage(String frage)  {
        this.frage=frage;
        txtSentence.setText(frage);
    }

    public String getFrage()    {return frage;}

    public JTextField getTxtAnswer()    {return this.txtAnswer;}

    public HangmanDrawingPanel getDrawingPanel() {
        return drawingPanel;
    }
}


