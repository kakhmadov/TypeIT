import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class TypeITModel {
    private Map<String, String> fragenAntworten;
    private boolean isCorrect;
    private String userAntwort;


    public TypeITModel(Map<String, String> fragenAntworten) {
        fragenAntworten = new TreeMap<>();
        this.fragenAntworten = fragenAntworten;
    }


    public boolean isCorrect(String frage, String userAntwort) {
        // Überprüfen, ob die Frage in der Map vorhanden ist und die Antwort des Benutzers korrekt ist
        if (fragenAntworten.containsKey(frage) && fragenAntworten.get(frage).equalsIgnoreCase(userAntwort)) {
            this.isCorrect = true;
        } else {
            this.isCorrect = false;
        }
        return this.isCorrect;
    }

    // Methode, um die Antwort der Frage zurückzugeben
    public String showAnswer(String frage) {
        // Gibt die Antwort zurück, die mit der Frage in der Map verknüpft ist
        return fragenAntworten.getOrDefault(frage, "Keine Antwort gefunden");
    }
    public Map<String, String> getFragenAntworten() {
        return fragenAntworten;
    }
    public void setFragenAntworten(Map<String, String> fragenAntworten) {
        this.fragenAntworten = fragenAntworten;
        fragenAntworten.put(JOptionPane.showInputDialog("Geben Sie hier Ihre Frage ein" ) , JOptionPane.showInputDialog("Geben Sie eine Antwort ein") );

    }
}
