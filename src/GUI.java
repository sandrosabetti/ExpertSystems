import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUI extends JFrame {
    static private JButton button_authorization = new JButton("Authorization");
    private JButton button_consultation = new JButton("Consultation mode");
    private JButton button_edit = new JButton("Edit mode");
    Engineer engineer = new Engineer();

    public GUI() {
        super("Option model");
        this.setBounds(300, 300, 300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 3, 2, 2));
        ButtonGroup group = new ButtonGroup();
        button_authorization.addActionListener(new ButtonEventListener1());
        container.add(button_authorization);
        button_consultation.addActionListener(new ButtonEventListener2());
        container.add(button_consultation);
        button_edit.addActionListener(new ButtonEventListener3());
        container.add(button_edit);
/*        if ()
        button.setText("logged in as" + inputted_login);*/
    }

    public static void ChangeButton1CaptionToLogout() {
        button_authorization.setText("Log out");
    }

    public static void ChangeButton1CaptionToLogin() {
        button_authorization.setText("Authorization");
    }

    class ButtonEventListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (engineer.logged_in == false) {
                Authorization_window app = new Authorization_window();
                app.setVisible(true);
            } else {
                engineer.logged_in = false;
                GUI.ChangeButton1CaptionToLogin();
            }
        }
    }

    class ButtonEventListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Consultation_window app = new Consultation_window();
            app.setVisible(true);
        }
    }

    class ButtonEventListener3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (/*engineer.logged_in ==*/ true) {
                Edit_window app = new Edit_window();
                app.setVisible(true);
            } else {
                String message = "You have to log in first";
                JOptionPane.showMessageDialog(null,
                        message,
                        "Inaccessible",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

}