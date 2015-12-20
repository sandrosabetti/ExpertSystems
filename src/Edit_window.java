import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Edit_window extends JFrame {
    private JButton button_change_transition = new JButton("Change transition");
    private JButton button_add_question = new JButton("Add question");

    private JButton button_show = new JButton("Show");

    private JLabel label_transition_number = new JLabel("Number of transition");
    private JLabel label_transition_value = new JLabel("New transition value");
    private JLabel label_new_question = new JLabel("New question");
    private JRadioButton radio_change_for_yes_answer = new JRadioButton("Change yes-transition");
    private JRadioButton radio_change_for_no_answer = new JRadioButton("Change no-transition");
    private JTextField input_transition_number = new JTextField("", 5);
    private JTextField input_transition_value = new JTextField("", 5);
    private JTextField input_new_question = new JTextField("", 5);
    Questions question = new Questions();
    Transitions transition = new Transitions();

    public Edit_window() {
        super("Consultation");
        this.setBounds(300, 300, 600, 300);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 4, 2, 2));
        ButtonGroup group = new ButtonGroup();
        group.add(radio_change_for_yes_answer);
        group.add(radio_change_for_no_answer);
        container.add(radio_change_for_yes_answer);
        radio_change_for_yes_answer.setSelected(true);
        container.add(radio_change_for_no_answer);
        container.add(label_transition_number);
        container.add(input_transition_number);
        container.add(label_transition_value);
        container.add(input_transition_value);
        container.add(label_new_question);
        container.add(input_new_question);
        button_change_transition.addActionListener(new ButtonEventListener1());
        container.add(button_change_transition);
        button_add_question.addActionListener(new ButtonEventListener2());
        container.add(button_add_question);
        button_show.addActionListener(new ButtonEventListener3());
        container.add(button_show);
    }

    class ButtonEventListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int i = 0;
            int j = 0;
            String new_transition_value = "0";
            j = Integer.parseInt(input_transition_number.getText());
            if (radio_change_for_yes_answer.isSelected()) {
                i = 0;
            } else {
                i = 1;
            }
//            new_transition_value = Integer.parseInt(input_transition_value.getText());
            new_transition_value = input_transition_value.getText();
            transition.change_transition(i, j, new_transition_value);
        }
    }

    class ButtonEventListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String new_question = "New question";
            new_question = input_new_question.getText();
            question.add_question(new_question);
        }
    }

    class ButtonEventListener3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Show_window app1 = new Show_window();
            app1.setVisible(true);
            Show_questions_window app2 = new Show_questions_window();
            app2.setVisible(true);
        }
    }

}