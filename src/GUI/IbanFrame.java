package GUI;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class IbanFrame {

    //    private static JTextField iban;
    private static JButton button;
    private static JLabel txt, txt2, txt3;
    private static String iban;
    private static JFrame frame;

    public IbanFrame(String Iban) {

//        Color color = new Color(128, 0, 0);
        iban = Iban;

        ui();
    }

    public static void ui() {
        frame = new JFrame("Payment");

        frame.setSize(500, 200);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);

        frame.setLocation(x, y);

        JPanel panel = new JPanel();
        panel.setBackground(Color.gray);
        frame.add(panel);


        txt = new JLabel("To complete purchase, send the "
                + "ticket fee to organizer's IBAN provided below.");
        txt.setFont(new Font("Calibri", Font.ITALIC, 13));
        txt2 = new JLabel("Your ticket will be sent to your email address"
                + " after you provide the fee.");
        txt2.setFont(new Font("Calibri", Font.ITALIC, 13));


        JLabel ibanLabel = new JLabel("IBAN: " + iban);
        ibanLabel.setForeground(Color.BLUE);


        button = new JButton("OK");
        button.setSize(20, 20);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Ticket Purchased successfully!");
                frame.dispose();
            }
        });

        txt3 = new JLabel("Thank you for using Bilet APP. Enjoy your time!");
        txt3.setFont(new Font("Calibri", Font.BOLD + Font.ITALIC, 17));


        panel.add(txt);

        panel.add(ibanLabel);
        panel.add(txt2);
        panel.add(txt3);
        panel.add(button);

        frame.setVisible(true);

    }
    public JFrame getFrame() { return frame;};
}

