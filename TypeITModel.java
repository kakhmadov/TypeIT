import javax.swing.*;
import java.io.*;
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
        if (fragenAntworten.containsKey(frage) && fragenAntworten.get(frage).equals(userAntwort)) {
            this.isCorrect = true;
        } else {
            this.isCorrect = false;
        }
        return this.isCorrect;

    }

    // Methode, um die Antwort der Frage zurückzugeben
    public String showAnswer(String frage) {

        return fragenAntworten.getOrDefault(frage, "Keine Antwort gefunden");
    }
    public TreeMap<String, String> getFragenAntworten() {
        return (TreeMap<String, String>) fragenAntworten;
    }
    public void setFragenAntworten(Map<String, String> fragenAntworten) {
        this.fragenAntworten = fragenAntworten;
        fragenAntworten.put(JOptionPane.showInputDialog("Geben Sie hier Ihre Frage ein" ) , JOptionPane.showInputDialog("Geben Sie eine Antwort ein") );

    }
    public static void save(TreeMap<String, String> map, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(map);
            System.out.println("TreeMap erfolgreich gespeichert.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static TreeMap<String, String> load(String fileName) {
        TreeMap<String, String> map = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            map = (TreeMap<String, String>) ois.readObject();
            System.out.println("TreeMap erfolgreich geladen.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

}
