import javax.swing.*;
import java.awt.*;

public class Show_questions_window extends JFrame {
    private JLabel label_hypothesis = new JLabel("Yes");
    private JLabel label_hypothesis_p = new JLabel("No");
    private JLabel blank_label = new JLabel("");
    private JLabel label_column_name[] = new JLabel[Questions.get_question_length()];


    public Show_questions_window() {
        super("Questions");
        this.setBounds(100, 200, 1300, 300);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(20, /*Questions.get_question_length()*/ 1, 2, 2));


        /*for (int i = 0; i < 5; i++) {
            blank_labels[i] = new JLabel("");
            container.add(blank_labels[i]);
        }

        for (int i = 5; i < Questions.get_question_length() - 6; i++) {
            blank_labels[i] = new JLabel("");
            container.add(blank_labels[i]);
        }*/
        //blank_label = new JLabel("");
        for (int i = 0; i < Questions.get_question_length(); i++) {
            if (Questions.get_question(i) != null){
                label_column_name[i] =  new JLabel(Questions.get_question(i) + "    " + Integer.toString(i));
            }
        }
        for (int i = 0; i < Questions.get_question_length(); i++) {
            if (Questions.get_question(i) != null){
                container.add(label_column_name[i]);
            }
        }
/*        for (int i = 0; i < Questions.get_question_length(); i++) {
            System.out.println(Questions.get_question(i));
        }*/
    }

}