package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class DetailedEvent {
    private static String finalNumOfTickets;

    public DetailedEvent() {
        ui();
    }

    private static void ui() {
        JFrame frame = new JFrame("DETAILED EVENT");
        frame.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) dimension.getWidth(), (int) dimension.getHeight());

        ImagePanel panel = new ImagePanel(new ImageIcon("Background3.jpg").getImage());
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        JLabel userName = new JLabel("Name: ");
        userName.setFont(new Font("Calibri", Font.PLAIN, 22));
        userName.setBounds(850, 10, 100, 100);
        panel.add(userName);

        JLabel userSurname = new JLabel("Surname: ");
        userSurname.setFont(new Font("Calibri", Font.PLAIN, 22));
        userSurname.setBounds(1050, 10, 200, 100);
        panel.add(userSurname);

        JButton logout = new JButton("Logout");
        logout.setBounds(1300, 40, 100, 50);
        panel.add(logout);

        JLabel basket = new JLabel("Basket");
        basket.setBounds(300, 40, 100, 50);
        basket.setFont(new Font("Calibri", Font.BOLD, 22));
        panel.add(basket);

        JButton addToBasket = new JButton("Add to basket");
        addToBasket.setBounds(925, 500, 120, 50);
        panel.add(addToBasket);

        JButton pay = new JButton("Pay now!");
        pay.setBounds(1150, 500, 100, 50);
        panel.add(pay);

        JButton reduceTicket = new JButton("Reduce ticket");
        reduceTicket.setBounds(1050, 500, 100, 50);
        panel.add(reduceTicket);

        JTextArea eventDetails = new JTextArea("Event details", 50, 50);
        eventDetails.setBounds(300, 100, 900, 375);
        eventDetails.setVisible(true);
        eventDetails.setLineWrap(true);
        panel.add(eventDetails);

        Choice ticketNumChoice = new Choice();
        for (int i = 1; i < 10; i++) {
            ticketNumChoice.add(" " + i + " ");
        }
        ticketNumChoice.setBounds(800, 500, 100, 50);
        panel.add(ticketNumChoice);

        JLabel numberChosen = new JLabel();
        numberChosen.setFont(new Font("Calibri", Font.PLAIN, 22));
        numberChosen.setBounds(400, 40, 200, 50);
        numberChosen.setBackground(Color.DARK_GRAY);
        panel.add(numberChosen);

/*
        addToBasket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                numberChosen.setText(ticketNumChoice.getSelectedItem() + "tickets added!");
            }
        });
*/
        addToBasket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberChosen.setText(ticketNumChoice.getSelectedItem() + "tickets added!");
            }
        });
/*
        pay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                IbanFrame pay = new IbanFrame();
            }
        });
*/
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    IbanFrame pay = new IbanFrame();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                //finalNumOfTickets = ticketNumChoice.getSelectedItem() ;
                numberChosen.setText("0");
            }
        });
/*
        reduceTicket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                finalNumOfTickets = ticketNumChoice.getSelectedItem() ;
                numberChosen.setText(finalNumOfTickets + " tickets left!");
            }
        });*/

        reduceTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalNumOfTickets = ticketNumChoice.getSelectedItem();
                numberChosen.setText(finalNumOfTickets + " tickets left!");
            }
        });

        frame.setVisible(true);


    }
}
