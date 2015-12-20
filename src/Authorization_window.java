import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Authorization_window extends JFrame {
    private JButton button_OK = new JButton("OK");
    private JTextField input_login = new JTextField("", 5);
    private JTextField input_password = new JTextField("", 5);
    private JLabel label_login = new JLabel("Login:");
    private JLabel label_password = new JLabel("Password:");

    public Authorization_window() {
        super("Authorization");
        this.setBounds(100, 100, 250, 100);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label_login);
        container.add(label_password);
        container.add(input_login);
        container.add(input_password);
        ButtonGroup group = new ButtonGroup();
        button_OK.addActionListener(new ButtonEventListener());
        container.add(button_OK);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Engineer engineer = new Engineer();
            String message = "";
            String inputted_login = input_login.getText();
            String inputted_password = input_password.getText();
            if (engineer.authorization(inputted_login, inputted_password)) {
                message += "Authorization successful";
                JOptionPane.showMessageDialog(null,
                        message,
                        "",
                        JOptionPane.PLAIN_MESSAGE);
                engineer.logged_in = true;
                GUI.ChangeButton1CaptionToLogout();
                setVisible(false);
                dispose();
            } else {
                message += "Authorization unsuccessful";
                JOptionPane.showMessageDialog(null,
                        message,
                        "",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

}