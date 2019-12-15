package GUI;

import javax.swing.*;
import java.awt.*;

public class EventCreation {

    public EventCreation(){

        JFrame frame = new JFrame("New Event");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel eventName = new JLabel("Event Name:");
        eventName.setFont(new Font("Calibri", Font.PLAIN, 22));
        eventName.setBounds(50,50,120,50);
        panel.add(eventName);

        JTextField eventText = new JTextField();
        eventText.setFont(new Font("Calibri", Font.PLAIN, 22));
        eventText.setBounds(180,60,300, 30);
        panel.add(eventText);

        JLabel eventLocation = new JLabel("Location:");
        eventLocation.setFont(new Font("Calibri", Font.PLAIN, 22));
        eventLocation.setBounds(50, 120, 120,50);
        panel.add(eventLocation);

        JTextField locationText = new JTextField();
        locationText.setFont(new Font("Calibri", Font.PLAIN, 22));
        locationText.setBounds(180,130,300,30);
        panel.add(locationText);

        JLabel eventPrice = new JLabel("Price:");
        eventPrice.setFont(new Font("Calibri", Font.PLAIN, 22));
        eventPrice.setBounds(50, 190, 120,50);
        panel.add(eventPrice);

        JTextField priceText = new JTextField();
        priceText.setFont(new Font("Calibri", Font.PLAIN, 22));
        priceText.setBounds(180,200,300,30);
        panel.add(priceText);

        JButton button = new JButton("Create Event");
        button.setBounds(180, 270, 150,50);
        panel.add(button);

        frame.setVisible(true);
    }
}
