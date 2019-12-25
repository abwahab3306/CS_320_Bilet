package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Database.InsertData;

public class EventCreation {

    private int organizerID;
    private JFrame frame;

    public EventCreation(int id) {

        organizerID = id;
        gui();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void gui() {

        frame = new JFrame("New Event");

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(600, 450);
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        panel.setBackground(Color.gray);

        JLabel eventName = new JLabel("Event Name:");
        eventName.setFont(new Font("Calibri", Font.PLAIN, 15));
        eventName.setBounds(50, 50, 120, 30);
        panel.add(eventName);

        final JTextField eventText = new JTextField();
        eventText.setFont(new Font("Calibri", Font.PLAIN, 15));
        eventText.setBounds(180, 50, 300, 30);
        panel.add(eventText);

        JLabel event_ticket = new JLabel("Ticket Number:");
        event_ticket.setFont(new Font("Calibri", Font.PLAIN, 15));
        event_ticket.setBounds(50, 100, 120, 30);
        panel.add(event_ticket);

        final JTextField ticket_num = new JTextField();
        ticket_num.setFont(new Font("Calibri", Font.PLAIN, 15));
        ticket_num.setBounds(180, 100, 300, 30);
        panel.add(ticket_num);

        JLabel event_date = new JLabel("Date:");
        event_date.setFont(new Font("Calibri", Font.PLAIN, 15));
        event_date.setBounds(50, 150, 120, 30);
        panel.add(event_date);

        final JTextField dateText = new JTextField();
        dateText.setFont(new Font("Calibri", Font.PLAIN, 15));
        dateText.setBounds(180, 150, 300, 30);
        panel.add(dateText);

        JLabel eventLocation = new JLabel("Location:");
        eventLocation.setFont(new Font("Calibri", Font.PLAIN, 15));
        eventLocation.setBounds(50, 200, 120, 30);
        panel.add(eventLocation);

        final JTextField locationText = new JTextField();
        locationText.setFont(new Font("Calibri", Font.PLAIN, 15));
        locationText.setBounds(180, 200, 300, 30);
        panel.add(locationText);

        JLabel eventPrice = new JLabel("Price:");
        eventPrice.setFont(new Font("Calibri", Font.PLAIN, 15));
        eventPrice.setBounds(50, 250, 120, 30);
        panel.add(eventPrice);

        final JTextField priceText = new JTextField();
        priceText.setFont(new Font("Calibri", Font.PLAIN, 15));
        priceText.setBounds(180, 250, 300, 30);
        panel.add(priceText);

        JLabel eventiban = new JLabel("IBAN:");
        eventiban.setFont(new Font("Calibri", Font.PLAIN, 15));
        eventiban.setBounds(50, 300, 120, 30);
        panel.add(eventiban);

        final JTextField ibanno = new JTextField();
        ibanno.setFont(new Font("Calibri", Font.PLAIN, 15));
        ibanno.setBounds(180, 300, 300, 30);
        panel.add(ibanno);

        JButton button = new JButton("Create Event");
        button.setBounds(x / 2, 350, 150, 30);
        panel.add(button);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int ticket = Integer.parseInt(ticket_num.getText());
                String date = dateText.getText();
                int price = Integer.parseInt(priceText.getText());
                String iban = ibanno.getText();

                Model.Event event = new Model.Event(eventText.getText(), organizerID, ticket, date, locationText.getText(), price,
                        iban);

                System.out.println(event.getName() + " " + event.getOrganizerId() + " " + event.getTicketNumber() + " " + event.getDate()
                        + " " + event.getLocation() + " " + event.getPrice() + " " + event.getIBAN());


                InsertData.createEvent(event.getName(), event.getOrganizerId(), event.getTicketNumber(), event.getDate(),
                        event.getLocation(), event.getPrice(), event.getIBAN());


                JOptionPane.showMessageDialog(null, "Event created succesfully!");
                frame.dispose();


            }
        });
        frame.setVisible(true);
    }
}
