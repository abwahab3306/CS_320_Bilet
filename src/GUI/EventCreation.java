package GUI;

import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Database.InsertData;

public class EventCreation {

	public EventCreation() {

		JFrame frame = new JFrame("New Event");

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(600, 450);
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		frame.setLocation(x, y);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);

		JLabel eventName = new JLabel("Event Name:");
		eventName.setFont(new Font("Calibri", Font.PLAIN, 15));
		eventName.setBounds(50, 50, 120, 30);
		panel.add(eventName);

		JTextField eventText = new JTextField();
		eventText.setFont(new Font("Calibri", Font.PLAIN, 15));
		eventText.setBounds(180, 50, 300, 30);
		panel.add(eventText);

		JLabel event_ticket = new JLabel("Ticket Number:");
		event_ticket.setFont(new Font("Calibri", Font.PLAIN, 15));
		event_ticket.setBounds(50, 100, 120, 30);
		panel.add(event_ticket);

		JTextField ticket_num = new JTextField();
		ticket_num.setFont(new Font("Calibri", Font.PLAIN, 15));
		ticket_num.setBounds(180, 100, 300, 30);
		panel.add(ticket_num);

		JLabel event_date = new JLabel("Date:");
		event_date.setFont(new Font("Calibri", Font.PLAIN, 15));
		event_date.setBounds(50, 150, 120, 30);
		panel.add(event_date);

		JTextField dateText = new JTextField();
		dateText.setFont(new Font("Calibri", Font.PLAIN, 15));
		dateText.setBounds(180, 150, 300, 30);
		panel.add(dateText);

		JLabel eventLocation = new JLabel("Location:");
		eventLocation.setFont(new Font("Calibri", Font.PLAIN, 15));
		eventLocation.setBounds(50, 200, 120, 30);
		panel.add(eventLocation);

		JTextField locationText = new JTextField();
		locationText.setFont(new Font("Calibri", Font.PLAIN, 15));
		locationText.setBounds(180, 200, 300, 30);
		panel.add(locationText);

		JLabel eventPrice = new JLabel("Price:");
		eventPrice.setFont(new Font("Calibri", Font.PLAIN, 15));
		eventPrice.setBounds(50, 250, 120, 30);
		panel.add(eventPrice);

		JTextField priceText = new JTextField();
		priceText.setFont(new Font("Calibri", Font.PLAIN, 15));
		priceText.setBounds(180, 250, 300, 30);
		panel.add(priceText);

		JLabel eventiban = new JLabel("IBAN:");
		eventiban.setFont(new Font("Calibri", Font.PLAIN, 15));
		eventiban.setBounds(50, 300, 120, 30);
		panel.add(eventiban);

		JTextField ibanno = new JTextField();
		ibanno.setFont(new Font("Calibri", Font.PLAIN, 15));
		ibanno.setBounds(180, 300, 300, 30);
		panel.add(ibanno);

		JButton button = new JButton("Create Event");
		button.setBounds(x / 2, 350, 150, 30);
		panel.add(button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int ticket = Integer.parseInt(ticket_num.getText());
				int date = Integer.parseInt(dateText.getText());
				int price = Integer.parseInt(priceText.getText());
				int iban = Integer.parseInt(eventiban.getText());

				Model.Event event = new Model.Event(eventName.getText(), 5, ticket, date, locationText.getText(), price,
						iban);
				InsertData.createEvent(iban);
			}
		});
		frame.setVisible(true);
	}
}
