package GUI;

import Database.InsertData;
import Model.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class DetailedEvent {
    private static String finalNumOfTickets;
    private String name;
    private String location;
    private int price;
    private String date;
    private String Iban;


    public DetailedEvent(Event event) {
        name = event.getName();
        location = event.getLocation();
        price = event.getPrice();
        date = event.getDate();
        Iban = event.getIBAN();


        ui(name, location, date, Iban, price);
    }

    private static void ui(String name, String location, String date, String Iban, int price) {
        JFrame frame = new JFrame("DETAILED EVENT");
        frame.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) dimension.getWidth(), (int) dimension.getHeight());

        ImagePanel panel = new ImagePanel(new ImageIcon("Background3.jpg").getImage());
        panel.setLayout(null);
        frame.getContentPane().add(panel);
        /*
        JLabel basket = new JLabel("Basket");
        basket.setBounds(300, 40, 100, 50);
        basket.setFont(new Font("Calibri", Font.BOLD, 22));
        panel.add(basket);
*//*
        JButton addToBasket = new JButton("Add to basket");
        addToBasket.setBounds(925, 500, 120, 50);
        panel.add(addToBasket);
*/
        JButton pay = new JButton("Pay now!");
        pay.setBounds(1150, 500, 100, 50);
        panel.add(pay);
/*
        JButton reduceTicket = new JButton("Reduce ticket");
        reduceTicket.setBounds(1050, 500, 100, 50);
        panel.add(reduceTicket);
*/
        String Details = "Name: " + name + " \n" + "Location: " + location + "\n" + "Ticket Price: " + price + "\n" + "Date: " + date;

        JTextArea eventDetails = new JTextArea(Details, 50, 50);

        eventDetails.setBounds(300, 100, 900, 375);
        eventDetails.setVisible(true);
        eventDetails.setLineWrap(true);
        panel.add(eventDetails);

        Choice ticketNumChoice = new Choice();
        for (int i = 1; i <= 10; i++) {
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
       /* addToBasket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberChosen.setText(ticketNumChoice.getSelectedItem() + "tickets added!");
            }
        });

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


                finalNumOfTickets = ticketNumChoice.getSelectedItem();

//                InsertData.buyTicket();
                IbanFrame pay = new IbanFrame(Iban);

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
        });

        reduceTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalNumOfTickets = ticketNumChoice.getSelectedItem();
                numberChosen.setText(finalNumOfTickets + " tickets left!");
            }
        });*/

        frame.setVisible(true);


    }

    private static void getId(){

    }
}
