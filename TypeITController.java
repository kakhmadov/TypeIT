import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class TypeITController {
    private TypeITModel model;
    private TypeITView view;

    public TypeITController(TypeITModel model, TypeITView view) {
        /*
        Nur zum Testen !
         */
        Map<String, String> fragenAntworten = model.getFragenAntworten();
        fragenAntworten.put("Su HUND ?" , "Du Hund !");






        this.model = model;
        this.view = view;
        this.view.getStandardButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.getContentPane().removeAll();
                StandardModeView standardModeView = new StandardModeView();
                String aktuelleFrage = fragenAntworten.keySet().iterator().next();
                standardModeView.setFrage(aktuelleFrage);
                standardModeView.getCheckButton().addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(model.isCorrect(aktuelleFrage,standardModeView.getAnswerField().getText())){
                            JOptionPane.showMessageDialog(view.getContentPane(), "Correct !");
                        }else{
                            JOptionPane.showMessageDialog(view.getContentPane(), "Wrong !");
                        }
                    }
                });
                view.setContentPane(standardModeView);
                view.revalidate();
                view.repaint();
            }
        });




    }

    public static void main(String[] args) {
        TypeITController controller = new TypeITController(new TypeITModel(null) , new TypeITView());


    }





}
