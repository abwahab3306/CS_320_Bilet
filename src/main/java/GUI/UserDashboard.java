package GUI;

import Database.getData;
import Model.Event;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDashboard {
    private int id;
    private String name;
    private String Lastname;
    private ArrayList<Event> Allevents;

    public UserDashboard(User user) throws SQLException {

        id = user.getId();
        name = user.getName();
        Lastname = user.getLastname();
        Allevents = getData.getEvents(true, null);

        userUi();
    }

    private void userUi() {
        final JFrame frame = new JFrame("USER DASHBOARD");
        frame.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) dimension.getWidth(), (int) dimension.getHeight());

        ImagePanel panel = new ImagePanel(new ImageIcon("Background3.jpg").getImage());
        panel.setLayout(null);
        frame.getContentPane().add(panel);


        JLabel userName = new JLabel("Name: " + name);
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

        JLabel header = new JLabel("Upcoming Events");
        header.setFont(new Font("Calibri", Font.PLAIN, 22));
        header.setBounds(500, 110, 500, 50);
        header.setVisible(true);
        panel.add(header);


        final JList list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBounds(500, 180, 500, 500);
        list.setFont(new Font("Calibri", Font.PLAIN, 20));
        panel.add(list);

        DefaultListModel dlm = new DefaultListModel();
        for (int eventNum = 0; eventNum < Allevents.size(); eventNum++) {
            Event SelectedEvent = Allevents.get(eventNum);
            dlm.addElement(SelectedEvent.getName());

        }
        list.setModel(dlm);
        JButton details = new JButton("Details");
        details.setBounds(1100, 200, 100, 50);
        panel.add(details);

        details.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                DetailedEvent detailedEvent = new DetailedEvent(id, Allevents.get(list.getSelectedIndex()));
            }
        });


        logout.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Logged out Succesfully!");
                frame.dispose();
            }
        });


        frame.setVisible(true);
    }


}
