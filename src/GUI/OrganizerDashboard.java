package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrganizerDashboard {

    public OrganizerDashboard(){

        JFrame frame = new JFrame("ORGANIZER DASHBOARD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1920,1080);

        ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\hecem\\OneDrive\\Resimler\\Background3.jpg").getImage());
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        JLabel organizerName = new JLabel("Name: ");
        organizerName.setFont(new Font("Calibri", Font.PLAIN, 22));
        organizerName.setBounds(100,100,100,100);
        panel.add(organizerName);

        JLabel organizerSurname = new JLabel("Surname: ");
        organizerSurname.setFont(new Font("Calibri", Font.PLAIN, 22));
        organizerSurname.setBounds(100,200, 100,100);
        panel.add(organizerSurname);

        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Calibri", Font.PLAIN, 22));
        email.setBounds(100, 300, 100,100);
        panel.add(email);

        JButton createEvent = new JButton("Create Event");
        createEvent.setBounds(100, 450, 130,50);
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
            @Override
            public void actionPerformed(ActionEvent e) {
                EventCreation newEvent = new EventCreation();
            }
        });



        frame.setVisible(true);
    }
}
