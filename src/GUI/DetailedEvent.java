package GUI;

import Database.InsertData;
import Model.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class DetailedEvent {
    private static int finalNumOfTickets;
    private int eventid;
    private int userid;
    private String name;
    private String location;
    private int price;
    private String date;
    private String Iban;


    public DetailedEvent(int id, Event event) {
        eventid = event.getId();
        userid = id;
        name = event.getName();
        location = event.getLocation();
        price = event.getPrice();
        date = event.getDate();
        Iban = event.getIBAN();


        ui(name, location, date, Iban, price);
    }

    private void ui(String name, String location, String date, String Iban, int price) {
        JFrame frame = new JFrame("DETAILED EVENT");
        frame.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) dimension.getWidth(), (int) dimension.getHeight());

        ImagePanel panel = new ImagePanel(new ImageIcon("Background3.jpg").getImage());
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        JButton pay = new JButton("Pay now!");
        pay.setBounds(1000, 500, 100, 50);
        panel.add(pay);

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


        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                finalNumOfTickets = Integer.parseInt(ticketNumChoice.getSelectedItem().trim());

                InsertData.buyTicket(userid, eventid, finalNumOfTickets);
                IbanFrame pay = new IbanFrame(Iban);

            }
        });

        frame.setVisible(true);


    }


}
