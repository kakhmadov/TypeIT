import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

public class TypeITController implements ActionListener {
  //  private TypeITModel model;
    private TypeITView view;
    private JFrame frame;
    private TypeITModel model;
    private int aktuellIndex = 0;
    private StandardModeView modeView = new StandardModeView(this);
    private HangmanView hangmanView = new HangmanView(this);
    private FrageLoeschen loeschen = new FrageLoeschen(this);



    public TypeITController() {
        view = new TypeITView(this);
       frame = view;
       Map fragenAntworten = new TreeMap();
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
                frame.setContentPane( new FragenVerwaltenViewMainScreen(this) );
                frame.revalidate();
                frame.repaint();
                frame.setVisible(true);
            }
            case "Zurueck", "HangBEENDEN" -> {
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
                try{

                    frame.setVisible(false);
                    frame.getContentPane().removeAll();
                    modeView = new StandardModeView(this);
                    frame.setContentPane(modeView);
                    frame.revalidate();
                    frame.repaint();
                    frame.setVisible(true);
                    String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex] ;// Holen der ersten Frage basierend auf dem Index
                    modeView.setFrage(ersteFrage);

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(frame, "Sie müssen zuerst einen Fragepool hinzufügen um zu Spielen");
                    frame.setVisible(false);
                    frame = new TypeITView(this);
                    frame.revalidate();
                    frame.repaint();
                    frame.setVisible(true);
                }
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
/*
                System.out.println(hangmanView.getTxtAnswer().getText());
                boolean richtig =  model.isCorrect((String) model.getFragenAntworten().keySet().toArray()[aktuellIndex], hangmanView.getTxtAnswer().getText());

                if (aktuellIndex < model.getFragenAntworten().size() - 1) {
                    aktuellIndex++;
                }

                String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex] ;// Holen der ersten Frage basierend auf dem Index
                hangmanView = new HangmanView(this);
                hangmanView.setFrage(ersteFrage);
                frame.getContentPane().removeAll();
                frame.setContentPane( hangmanView );
                frame.revalidate();
                frame.repaint();

                if (richtig){
                    JOptionPane.showMessageDialog(frame, "Richtig Bravo :)");
                }else{
                    JOptionPane.showMessageDialog(frame,"Diesen Satz solltest du dir lieber noch einmal anschauen :(");
                }

 */
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
                }

            }

            case "PrüfenStandard" -> {
                System.out.println(modeView.getAnswerField().getText());
                boolean richtig =  model.isCorrect((String) model.getFragenAntworten().keySet().toArray()[aktuellIndex], modeView.getAnswerField().getText());

                if (aktuellIndex < model.getFragenAntworten().size() - 1) {
                    aktuellIndex++;
                }

                String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex] ;// Holen der ersten Frage basierend auf dem Index
                modeView = new StandardModeView(this);
                modeView.setFrage(ersteFrage);
                frame.getContentPane().removeAll();
                frame.setContentPane( modeView );
                frame.revalidate();
                frame.repaint();


                if (richtig){
                    JOptionPane.showMessageDialog(frame, "Richtig Bravo :)");
                }else{
                    JOptionPane.showMessageDialog(frame,"Diesen Satz solltest du dir lieber noch einmal anschauen :(");
                }



            }
            case "showSolution" ->{
                JOptionPane.showMessageDialog(frame,"Die richtige Antwort lautet:\n "  + model.showAnswer(modeView.getFrage())); ;
            }
            case "Next" ->{
                if (aktuellIndex < model.getFragenAntworten().size() - 1) {
                    aktuellIndex++;
                }else{
                    JOptionPane.showMessageDialog(frame,"Sie haben das Ende Ihres Fragepools errreicht");
                }
                String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex] ;// Holen der ersten Frage basierend auf dem Index
                modeView = new StandardModeView(this);
                modeView.setFrage(ersteFrage);
                frame.getContentPane().removeAll();
                frame.setContentPane( modeView );
                frame.revalidate();
                frame.repaint();
            }
            case "Prev" ->{
                if (aktuellIndex > 0) {
                    aktuellIndex--;
                } else {
                    JOptionPane.showMessageDialog(frame, "Sie haben den Anfang Ihres Fragepools erreicht.");
                }
                String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex] ;// Holen der ersten Frage basierend auf dem Index
                modeView = new StandardModeView(this);
                modeView.setFrage(ersteFrage);
                frame.getContentPane().removeAll();
                frame.setContentPane( modeView );
                frame.revalidate();
                frame.repaint();
            }
            case "frageLoeschen" -> {
                loeschen = new FrageLoeschen(this);
                for(String key : model.getFragenAntworten().keySet()){
                    loeschen.getComboBox().addItem(key);
                }
                frame.setVisible(false);
                frame.getContentPane().removeAll();
                frame.setContentPane(loeschen);
                frame.revalidate();
                frame.repaint();
                frame.setVisible(true);
            }
            case "loeschenFinal" ->{
                String selectedKey = (String) loeschen.getComboBox().getSelectedItem(); // Ausgewählten Schlüssel holen
                if (selectedKey != null && model.getFragenAntworten().containsKey(selectedKey)) {
                    model.getFragenAntworten().remove(selectedKey); // Löschen des Elements aus der Map
                    loeschen.getComboBox().removeItem(selectedKey); // Entfernen des Elements aus der JComboBox
                    JOptionPane.showMessageDialog(frame, "Die Frage wurde gelöscht.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Es wurde keine gültige Frage ausgewählt.");
                }
            }
            case "poolSpeichern" ->{
                TypeITModel.save(model.getFragenAntworten(),"PoolBinary");
            }
            case "poolLaden" ->{
                TreeMap<String,String> loadedMap = TypeITModel.load("PoolBinary");
                model.setFragenAntworten(loadedMap);

            }







            }

        }
    }

