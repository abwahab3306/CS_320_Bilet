package GUI;

import Database.getData;
import Model.Event;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDashboard {
    private int id;
    private String name;
    private String Lastname;

    public UserDashboard(User user) throws SQLException {

        id = user.getId();
        name= user.getName();
        Lastname = user.getLastname();
        JFrame frame = new JFrame("USER DASHBOARD");
        frame.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) dimension.getWidth(), (int) dimension.getHeight());

        ImagePanel panel = new ImagePanel(new ImageIcon("Background3.jpg").getImage());
        panel.setLayout(null);
        frame.getContentPane().add(panel);



        JLabel userName = new JLabel("Name: " +name);
        userName.setFont(new Font("Calibri", Font.PLAIN, 22));
        userName.setBounds(950, 10, 500, 100);
        userName.setForeground(Color.WHITE);
        panel.add(userName);

        JLabel userSurname = new JLabel("Surname: " + Lastname);
        userSurname.setFont(new Font("Calibri", Font.PLAIN, 22));
        userSurname.setBounds(1150, 10, 500, 100);
        userSurname.setForeground(Color.WHITE);
        panel.add(userSurname);

        JButton logout = new JButton("Logout");
        logout.setBounds(1300, 40, 100, 50);
        panel.add(logout);


        JLabel events = new JLabel("BILET");
        events.setFont(new Font("Calibri", Font.BOLD, 32));
        events.setBounds(700, 40, 500, 50);
        panel.add(events);

        JTextField search = new JTextField("Search here!") ;
        search.setFont(new Font("Calibri", Font.PLAIN, 22));
        search.setBounds(500,110,500,50);
        search.setVisible(true);
        panel.add(search);

        int y = 150;
        JButton event = null;
        ArrayList<Event> Allevents = getData.getEvents(true, null);

        for (int eventNumber = 0; eventNumber < Allevents.size(); eventNumber++) {
            Event SelectedEvent = Allevents.get(eventNumber);
            event = new JButton(SelectedEvent.getName());
            event.setFont(new Font("Calibri", Font.PLAIN, 22));
            event.setBounds(500, y + 10, 500, 100);
            panel.add(event);
            y += 100;

            event.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    DetailedEvent detailedEvent = new DetailedEvent(id, SelectedEvent);
                }
            });

        }

        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //?
            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Logged out Succesfully!");
                frame.dispose();
            }
        });


        frame.setVisible(true);
    }

}
