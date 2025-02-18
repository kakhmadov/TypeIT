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
        StandardModeView modeView = new StandardModeView(this);
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
                frame.setVisible(false);
                frame.getContentPane().removeAll();
                modeView = new StandardModeView(this);
                frame.setContentPane(modeView);

                String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex] ;// Holen der ersten Frage basierend auf dem Index
                modeView.setFrage(ersteFrage);






                frame.revalidate();
                frame.repaint();
                frame.setVisible(true);

            }
            case "PrüfenStandard" -> {
               boolean richtig =  model.isCorrect((String) model.getFragenAntworten().keySet().toArray()[0], modeView.getAnswerField().getText());
                if (richtig == true){
                    JOptionPane.showMessageDialog(null, "Richtige ANTWORT DU HUND");
                }else{
                    JOptionPane.showMessageDialog(null,"Falsch du idiot");
                }

                aktuellIndex++;
                String ersteFrage = (String) model.getFragenAntworten().keySet().toArray()[aktuellIndex] ;// Holen der ersten Frage basierend auf dem Index
                modeView.setFrage(ersteFrage);
                frame.revalidate();
                frame.repaint();






            }





            }

        }
    }

