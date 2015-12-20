import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.apache.log4j.*;
import java.util.*;

public class Consultation_window extends JFrame {

    private static Logger logger = Logger.getLogger(Consultation_window.class);
    private JButton button_yes = new JButton("Yes");
    private JButton button_no = new JButton("No");
    private JButton button_back = new JButton("Back");

    private JLabel label_question = new JLabel("Хотите подобрать модель для оценки премии опциона на облигации?");

    Questions question = new Questions();
    Transitions transition = new Transitions();
    int question_number = 0;
    int previous_question_number = 0;


    public Consultation_window() {
        super("Consultation");
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Started consultation mode on " + Calendar.getInstance().getTime());
        this.setBounds(600, 200, 500, 150);
        Container container = this.getContentPane();

        container.setLayout(new BorderLayout());
        container.add(label_question, BorderLayout.NORTH);


        button_yes.addActionListener(new ButtonYesEventListener());
        container.add(button_yes, BorderLayout.WEST);
        button_no.addActionListener(new ButtonNoEventListener());
        container.add(button_no, BorderLayout.EAST);

        button_back.addActionListener(new ButtonBackEventListener());
        container.add(button_back, BorderLayout.SOUTH);
    }

    class ButtonYesEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (question_number < 100) {
                logger.info("Put question " + question.get_question(question_number));
                previous_question_number = question_number;
                question_number = transition.get_transitions(0, question_number);
                label_question.setText(question.get_question(question_number));
            }
            logger.info("Gotten answer Yes");
            if (question_number > 100) {
                setVisible(false);
                dispose();
                String message = "";
                message += question.get_question(question_number);
                logger.info("Outputted result " + question.get_question(question_number));
                JOptionPane.showMessageDialog(null,
                        message,
                        "Result",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    class ButtonNoEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (question_number < 100) {
                logger.info("Put question " + question.get_question(question_number));
                previous_question_number = question_number;
                question_number = transition.get_transitions(1, question_number);
                label_question.setText(question.get_question(question_number));
            }
            logger.info("Gotten answer No");
            if (question_number > 100) {
                setVisible(false);
                dispose();
                String message = "";
                message += question.get_question(question_number);
                logger.info("Outputted result " + question.get_question(question_number));
                JOptionPane.showMessageDialog(null,
                        message,
                        "Result",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    class ButtonBackEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            question_number = previous_question_number;
            label_question.setText(question.get_question(previous_question_number));
        }
    }

}