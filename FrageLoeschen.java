import javax.swing.*;
import java.awt.*;

public class FrageLoeschen extends JPanel {
    private TypeITController controller;
    private JComboBox<String> frage;
    private JButton loeschen = new JButton("Löschen");

    public FrageLoeschen(TypeITController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());
        setBackground(new Color(96, 105, 99));

        // Erstellen und hinzufügen der JComboBox
        frage = new JComboBox<>();
        frage.setEditable(true);
        add(frage, BorderLayout.NORTH);

        // Hinzufügen des "Löschen"-Buttons
        add(loeschen, BorderLayout.SOUTH);

        loeschen.setActionCommand("loeschenFinal");
        loeschen.addActionListener(controller);
    }


    public JComboBox<String> getComboBox() {
        return frage;
    }
}
