import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class TypeITController implements ActionListener {
    private TypeITView view;
    private JFrame frame;
    private TypeITModel model;
    private int aktuellIndex = 0;
    private StandardModeView modeView = new StandardModeView(this);
    private FrageLoeschen loeschen = new FrageLoeschen(this);
    private HangmanView hangmanView = new HangmanView(this);

    public TypeITController() {
        view = new TypeITView(this);
        frame = view;
        Map<String, String> fragenAntworten = new TreeMap<>();
        model = new TypeITModel(fragenAntworten);
    }

    public static void main(String[] args) {
        new TypeITController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "manageQuestions" -> {
                frame.setVisible(false);
                frame.getContentPane().removeAll();
                frame.setContentPane(new FragenVerwaltenViewMainScreen(this));
                frame.revalidate();
                frame.repaint();
                frame.setVisible(true);
            }
            case "Zurueck" -> {
                frame.setVisible(false);
                frame = new TypeITView(this);
                frame.revalidate();
                frame.repaint();
                frame.setVisible(true);
            }
            case "pool1" -> {
                frame.setVisible(false);
                frame.getContentPane().removeAll();
                frame.setContentPane(new FragenVerwaltenView(this));
                frame.revalidate();
                frame.repaint();
                frame.setVisible(true);
            }
            case "frageHinzufuegen" -> {
                model.setFragenAntworten(model.getFragenAntworten());
            }
            case "STANDARD" -> {
                try {
                    frame.setVisible(false);
                    frame.getContentPane().removeAll();
                    modeView = new StandardModeView(this);
                    frame.setContentPane(modeView);
                    frame.revalidate();
                    frame.repaint();
                    frame.setVisible(true);
                    String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex];
                    modeView.setFrage(ersteFrage);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Sie müssen zuerst einen Fragepool hinzufügen um zu spielen.");
                    frame.setVisible(false);
                    frame = new TypeITView(this);
                    frame.revalidate();
                    frame.repaint();
                    frame.setVisible(true);
                }
            }

            // --- QUIZ MODE (NEW FUNCTIONALITY) ---
            case "QUIZ" -> {
                try {
                    frame.setVisible(false);
                    frame.getContentPane().removeAll();
                    frame.setContentPane(new QuizView(this)); // Switches to QuizView
                    frame.revalidate();
                    frame.repaint();
                    frame.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Ein Fehler ist aufgetreten beim Laden des Quiz-Modus.");
                    frame.setVisible(false);
                    frame = new TypeITView(this);
                    frame.revalidate();
                    frame.repaint();
                    frame.setVisible(true);
                }
            }

            case "QuizCheck" -> {
                if (frame.getContentPane() instanceof QuizView quizView) {
                    String imagePath = quizView.getCurrentImageFile();
                    String userInput = quizView.getUserAnswer();

                    String imageName = imagePath.replaceAll("[^0-9]", "");

                    String expectedAnswer = switch (imageName) {
                        case "1" -> "Buecher";
                        case "2" -> "Glas";
                        case "3" -> "Schach";
                        case "4" -> "Jeans";
                        case "5" -> "Gluehlampe";
                        case "6" -> "Schuhe";
                        case "7" -> "Stuhl";
                        case "8" -> "Kaffe";
                        case "9" -> "Zahn";
                        case "10" -> "Parfum";
                        case "11" -> "Stein";
                        case "12" -> "Globus";
                        case "13" -> "Laterne";
                        case "14" -> "Bleistift";
                        case "15" -> "Sanduhr";
                        case "16" -> "Streichholz";
                        case "17" -> "Schreibmaschine";
                        case "18" -> "Mond";
                        case "19" -> "Megafon";
                        case "20" -> "Lampe";
                        default -> "Unbekannt";
                    };

                    if (userInput.equalsIgnoreCase(expectedAnswer)) {
                        JOptionPane.showMessageDialog(frame, "Richtig! Das ist ein: " + expectedAnswer);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Falsch! Die richtige Antwort wäre: " + expectedAnswer);
                    }

                    frame.setVisible(false);
                    frame.getContentPane().removeAll();
                    frame.setContentPane(new QuizView(this));
                    frame.revalidate();
                    frame.repaint();
                    frame.setVisible(true);
                }
            }

            case "PrüfenStandard" -> {
                System.out.println(modeView.getAnswerField().getText());
                boolean richtig = model.isCorrect(
                        (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex],
                        modeView.getAnswerField().getText()
                );

                if (aktuellIndex < model.getFragenAntworten().size() - 1) {
                    aktuellIndex++;
                }

                String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex];
                modeView = new StandardModeView(this);
                modeView.setFrage(ersteFrage);
                frame.getContentPane().removeAll();
                frame.setContentPane(modeView);
                frame.revalidate();
                frame.repaint();

                if (richtig) {
                    JOptionPane.showMessageDialog(frame, "Richtig Bravo :)");
                } else {
                    JOptionPane.showMessageDialog(frame, "Diesen Satz solltest du dir lieber noch einmal anschauen :(");
                }
            }
            case "showSolution" -> {
                JOptionPane.showMessageDialog(frame, "Die richtige Antwort lautet:\n " + model.showAnswer(modeView.getFrage()));
            }
            case "Next" -> {
                if (aktuellIndex < model.getFragenAntworten().size() - 1) {
                    aktuellIndex++;
                } else {
                    JOptionPane.showMessageDialog(frame, "Sie haben das Ende Ihres Fragepools erreicht.");
                }
                String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex];
                modeView = new StandardModeView(this);
                modeView.setFrage(ersteFrage);
                frame.getContentPane().removeAll();
                frame.setContentPane(modeView);
                frame.revalidate();
                frame.repaint();
            }
            case "Prev" -> {
                if (aktuellIndex > 0) {
                    aktuellIndex--;
                } else {
                    JOptionPane.showMessageDialog(frame, "Sie haben den Anfang Ihres Fragepools erreicht.");
                }
                String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex];
                modeView = new StandardModeView(this);
                modeView.setFrage(ersteFrage);
                frame.getContentPane().removeAll();
                frame.setContentPane(modeView);
                frame.revalidate();
                frame.repaint();
            }
            case "frageLoeschen" -> {
                loeschen = new FrageLoeschen(this);
                for (String key : model.getFragenAntworten().keySet()) {
                    loeschen.getComboBox().addItem(key);
                }
                frame.setVisible(false);
                frame.getContentPane().removeAll();
                frame.setContentPane(loeschen);
                frame.revalidate();
                frame.repaint();
                frame.setVisible(true);
            }
            case "loeschenFinal" -> {
                String selectedKey = (String) loeschen.getComboBox().getSelectedItem();
                if (selectedKey != null && model.getFragenAntworten().containsKey(selectedKey)) {
                    model.getFragenAntworten().remove(selectedKey);
                    loeschen.getComboBox().removeItem(selectedKey);
                    JOptionPane.showMessageDialog(frame, "Die Frage wurde gelöscht.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Es wurde keine gültige Frage ausgewählt.");
                }
            }
            case "poolSpeichern" -> {
                TypeITModel.save(model.getFragenAntworten(), "PoolBinary");
            }
            case "poolLaden" -> {
                TreeMap<String, String> loadedMap = TypeITModel.load("PoolBinary");
                model.setFragenAntworten(loadedMap);
            }
            case "HANGMAN" -> {
                try {

                    frame.setVisible(false);
                    frame.getContentPane().removeAll();
                    hangmanView = new HangmanView(this);
                    frame.setContentPane(hangmanView);
                    frame.revalidate();
                    frame.repaint();
                    frame.setVisible(true);
                    String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex];// Holen der ersten Frage basierend auf dem Index
                    hangmanView.setFrage(ersteFrage);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Sie müssen zuerst einen Fragepool hinzufügen um zu Spielen");
                    frame.setVisible(false);
                    frame = new TypeITView(this);
                    frame.revalidate();
                    frame.repaint();
                    frame.setVisible(true);
                }
            }

            case "HangLOESUNG" ->   {
                JOptionPane.showMessageDialog(frame,"Die richtige Antwort lautet:\n "  + model.showAnswer(hangmanView.getFrage()));
            }

            case "HangPRUEFEN" -> {

                String userAnswer = hangmanView.getTxtAnswer().getText();
                String currentQuestion = hangmanView.getFrage();
                boolean correct = model.isCorrect(currentQuestion, userAnswer);

                if (correct) {
                    JOptionPane.showMessageDialog(frame, "Richtig! :)");
                    // Move to next question
                    if (aktuellIndex < model.getFragenAntworten().size() - 1) {
                        aktuellIndex++;
                        hangmanView.setFrage((String) model.getFragenAntworten().keySet().toArray()[aktuellIndex]);
                        hangmanView.getDrawingPanel().reset();
                    }
                } else {
                    hangmanView.getDrawingPanel().incrementWrongAttempts();
                    JOptionPane.showMessageDialog(frame, "Falsch! :(");
                    if(hangmanView.getDrawingPanel().getWrongAttempts()==6) {
                        JOptionPane.showMessageDialog
                                (
                                        frame,
                                        "Oje, du hast bereits 6 falsche Antworten. \n" +
                                                "Schaue dir nochmal die Rechtschreibung an und \n" +
                                                "probiere es später noch einmal."
                                );
                        frame.setVisible(false);
                        frame = new TypeITView(this);
                        frame.revalidate();
                        frame.repaint();
                        frame.setVisible(true);
                    }
                }

            }


        }
    }
}
