package GUI;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IbanFrame {

    private static JTextField iban;
    private static JButton button;
    private static JLabel txt, txt2, txt3;


    public IbanFrame() {

//        Color color = new Color(128, 0, 0);

        ui();
    }

    public static void ui() {
        JFrame frame = new JFrame("Payment");

        frame.setSize(500, 200);


        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        frame.add(panel);


        txt = new JLabel("To complete purchase, send the "
                + "ticket fee to organizer's IBAN provided below.");
        txt.setFont(new Font("Calibri", Font.ITALIC, 13));
        txt2 = new JLabel("Your ticket will be sent to your email address"
                + " after you provide the fee.");
        txt2.setFont(new Font("Calibri", Font.ITALIC, 13));

        iban = new JTextField("IBAN: "); // iban query will be provided here

        button = new JButton("OK");
        button.setSize(20, 20);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        txt3 = new JLabel("Thank you for using Bilet APP. Enjoy your time!");
        txt3.setFont(new Font("Calibri", Font.BOLD + Font.ITALIC, 17));


        panel.add(txt);
        panel.add(iban);
        panel.add(txt2);
        panel.add(txt3);
        panel.add(button);

        frame.setVisible(true);


    }
}

