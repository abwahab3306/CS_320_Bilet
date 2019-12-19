package GUI;

import Database.getData;
import Model.Event;
import Model.Organizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrganizerDashboard {
    private String name;
    private String lastname;
    private String orgemail;

    public OrganizerDashboard(Organizer organizer) throws SQLException {
        name = organizer.getName();
        lastname =organizer.getLastname();
        orgemail = organizer.getEmail();


        JFrame frame = new JFrame("ORGANIZER DASHBOARD");

        frame.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) dimension.getWidth(), (int) dimension.getHeight());


        ImagePanel panel = new ImagePanel(new ImageIcon("Background3.jpg").getImage());
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        JLabel organizerName = new JLabel("Name: " + name);
        organizerName.setFont(new Font("Calibri", Font.PLAIN, 22));
        organizerName.setBounds(100, 100, 100, 100);
        panel.add(organizerName);

        JLabel organizerSurname = new JLabel("Surname: "+ lastname);
        organizerSurname.setFont(new Font("Calibri", Font.PLAIN, 22));
        organizerSurname.setBounds(100, 200, 200, 100);
        panel.add(organizerSurname);

        JLabel email = new JLabel("Email: " + orgemail);
        email.setFont(new Font("Calibri", Font.PLAIN, 22));
        email.setBounds(100, 300, 100, 100);
        panel.add(email);

        JButton createEvent = new JButton("Create Event");
        createEvent.setBounds(100, 450, 130, 50);
        panel.add(createEvent);

        JButton myEvents = new JButton("My Events");
        myEvents.setBounds(340, 450, 130, 50);
        panel.add(myEvents);

        JButton logout = new JButton("Logout");
        logout.setBounds(220, 550, 130, 50);
        panel.add(logout);


        JLabel events = new JLabel("All Events");
        events.setFont(new Font("Calibri", Font.BOLD, 32));
        events.setBounds(700, 60, 130, 50);
        panel.add(events);


        createEvent.addActionListener(new ActionListener() {
            ArrayList<Event> events = getData.getMyEvents(orgemail);
            @Override
            public void actionPerformed(ActionEvent e) {
                EventCreation newEvent = new EventCreation();
            }
        });


        frame.setVisible(true);
    }
}
