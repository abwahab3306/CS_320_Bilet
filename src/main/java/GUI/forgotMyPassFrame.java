package GUI;

import Database.UpdateData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class forgotMyPassFrame {


    private static JTextField txt;
    private static JPasswordField txt2;
    private static JLabel label, label2;
    private static JButton button, button2;
    private static Boolean usertype;


    public forgotMyPassFrame(String type) {

        if (type.equals("Organizer")) {
            usertype = true;
        } else {
            usertype = false;
        }
        ui();

    }

    public static void ui() {
        final JFrame frame = new JFrame("New Password");
        frame.setDefaultCloseOperation(frame.HIDE_ON_CLOSE);
        frame.setSize(400, 300);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);

        frame.add(panel);

        label = new JLabel("Enter your email address: ");
        label.setFont(new Font("Calibri", Font.ITALIC, 14));

        txt = new JTextField(15);

        label.setLabelFor(txt);

        label2 = new JLabel("Enter your new password: ");
        label2.setFont(new Font("Calibri", Font.ITALIC, 14));

        final JPasswordField txt2 = new JPasswordField(15);

        label2.setLabelFor(txt2);


        button = new JButton("Change My Password");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = txt.getText();

                String password = new String(txt2.getPassword());

                UpdateData.changePassword(email, usertype, password);


                JOptionPane.showMessageDialog(frame, "Your password has changed!");
                frame.dispose();
            }
        });

        button2 = new JButton("Display Password");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = new String(txt2.getPassword());
                JOptionPane.showMessageDialog(frame, "Password is: " + password);

            }
        });

        panel.add(label);
        panel.add(txt);
        panel.add(label2);
        panel.add(txt2);
        panel.add(button);
        panel.add(button2);
        frame.setVisible(true);
    }


}

