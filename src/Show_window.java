import javax.swing.*;
import java.awt.*;

public class Show_window extends JFrame {
    private JLabel label_hypothesis = new JLabel("Yes");
    private JLabel label_hypothesis_p = new JLabel("No");
    private JLabel blank_label = new JLabel("");
    private JLabel label_column_name[] = new JLabel[Transitions.get_transitions_length()];
    private JLabel py_last_row_labels[] = new JLabel[Transitions.get_transitions_length()];
    private JLabel pn_last_row_labels[] = new JLabel[Transitions.get_transitions_length()];


    public Show_window() {
        super("Add_hypothesis_window");
        this.setBounds(100, 200, 1300, 200);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 3, Transitions.get_transitions_length(), Transitions.get_transitions_length()));


        /*for (int i = 0; i < 5; i++) {
            blank_labels[i] = new JLabel("");
            container.add(blank_labels[i]);
        }

        for (int i = 5; i < Transitions.get_transitions_length() - 6; i++) {
            blank_labels[i] = new JLabel("");
            container.add(blank_labels[i]);
        }*/
        //blank_label = new JLabel("");
        for (int i = 0; i < Transitions.get_transitions_length(); i++) {
            label_column_name[i] =  new JLabel(Questions.get_question(i));
            py_last_row_labels[i] = new JLabel(Questions.get_question(Transitions.get_transitions(0,i)));
            pn_last_row_labels[i] = new JLabel(Questions.get_question(Transitions.get_transitions(1,i)));
        }
        container.add(blank_label);
        for (int i = 0; i < Transitions.get_transitions_length(); i++) {
            container.add(py_last_row_labels[i]);
        }
        for (int i = 0; i < Transitions.get_transitions_length(); i++) {
            container.add(label_column_name[i]);
        }
        container.add(label_hypothesis);
        for (int i = 0; i < Transitions.get_transitions_length(); i++) {
            container.add(pn_last_row_labels[i]);
        }
        container.add(label_hypothesis_p);
        for (int i = 0; i < Transitions.get_transitions_length(); i++) {
            container.add(py_last_row_labels[i]);
        }
    }

}