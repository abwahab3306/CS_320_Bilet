package GUI;

import Database.InsertData;
import Database.UpdateData;
import Database.getData;
import Model.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DetailedEvent {
    private static int finalNumOfTickets;
    private int eventid;
    private int userid;
    private int organizerid;
    private String name;
    private int numoftic;
    private String location;
    private int price;
    private String date;
    private String Iban;
    private String orgname;
    private JButton pay;


    public DetailedEvent(int id, Event event) {
        eventid = event.getId();
        userid = id;
        organizerid = event.getOrganizerId();
        name = event.getName();
        numoftic = event.getTicketNumber();
        location = event.getLocation();
        price = event.getPrice();
        date = event.getDate();
        Iban = event.getIBAN();

        try {
            orgname = getData.getOrganizer(organizerid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ui(name, location, numoftic, date, Iban, price);
    }

    private void ui(String name, String location, int numoftic, String date, String Iban, int price) {
        JFrame frame = new JFrame("DETAILED EVENT");
        frame.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) dimension.getWidth(), (int) dimension.getHeight());

        ImagePanel panel = new ImagePanel(new ImageIcon("Background3.jpg").getImage());
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        pay = new JButton("Pay now!");
        pay.setBounds(1000, 250, 100, 50);
        panel.add(pay);

        JLabel eventName = new JLabel("Name: " + name);
        eventName.setFont(new Font("Calibri", Font.PLAIN, 20));
        eventName.setBounds(300, 100, 400, 50);
        eventName.setOpaque(true);
        eventName.setBackground(Color.BLACK);
        eventName.setForeground(Color.WHITE);
        panel.add(eventName);

        JLabel eventOrg = new JLabel("Organizer: " + orgname);
        eventOrg.setFont(new Font("Calibri", Font.PLAIN, 20));
        eventOrg.setBounds(300, 175, 400, 50);
        eventOrg.setOpaque(true);
        eventOrg.setBackground(Color.BLACK);
        eventOrg.setForeground(Color.WHITE);
        panel.add(eventOrg);

        JLabel eventTic = new JLabel("Number of Tickets: " + Integer.toString(numoftic));
        eventTic.setFont(new Font("Calibri", Font.PLAIN, 20));
        eventTic.setBounds(300, 250, 400, 50);
        eventTic.setOpaque(true);
        eventTic.setBackground(Color.BLACK);
        eventTic.setForeground(Color.WHITE);
        panel.add(eventTic);

        JLabel eventDate = new JLabel("Date: " + date);
        eventDate.setFont(new Font("Calibri", Font.PLAIN, 20));
        eventDate.setBounds(300, 325, 400, 50);
        eventDate.setOpaque(true);
        eventDate.setBackground(Color.BLACK);
        eventDate.setForeground(Color.WHITE);
        panel.add(eventDate);

        JLabel eventLocation = new JLabel("Location: " + location);
        eventLocation.setFont(new Font("Calibri", Font.PLAIN, 20));
        eventLocation.setBounds(300, 400, 400, 50);
        eventLocation.setOpaque(true);
        eventLocation.setBackground(Color.BLACK);
        eventLocation.setForeground(Color.WHITE);
        panel.add(eventLocation);

        JLabel eventPrice = new JLabel("Price: " + Integer.toString(price));
        eventPrice.setFont(new Font("Calibri", Font.PLAIN, 20));
        eventPrice.setBounds(300, 475, 400, 50);
        eventPrice.setOpaque(true);
        eventPrice.setBackground(Color.BLACK);
        eventPrice.setForeground(Color.WHITE);
        panel.add(eventPrice);

        Choice ticketNumChoice = new Choice();
        for (int i = 1; i <= 10; i++) {
            ticketNumChoice.add(" " + i + " ");
        }
        ticketNumChoice.setBounds(800, 250, 100, 75);
        ticketNumChoice.setBackground(Color.BLACK);
        ticketNumChoice.setForeground(Color.BLUE);

        panel.add(ticketNumChoice);


        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                finalNumOfTickets = Integer.parseInt(ticketNumChoice.getSelectedItem().trim());

                InsertData.buyTicket(userid, eventid, finalNumOfTickets);
                int ticketleft = numoftic - finalNumOfTickets;
                UpdateData.updateTicket(eventid, ticketleft);
                IbanFrame pay = new IbanFrame(Iban);

            }
        });

        frame.setVisible(true);

    }

    public JButton getPay() {return pay;};

}
