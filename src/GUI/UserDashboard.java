package GUI;

import javax.swing.*;
import java.awt.*;


public class UserDashboard {

    public UserDashboard() {
        JFrame frame = new JFrame("USER DASHBOARD");
        frame.setLayout(null);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) dimension.getWidth(), (int) dimension.getHeight());

        ImagePanel panel = new ImagePanel(new ImageIcon("Background3.jpg").getImage());
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        JLabel userName = new JLabel("Name: ");
        userName.setFont(new Font("Calibri", Font.PLAIN, 22));
        userName.setBounds(950, 10, 100, 100);
        panel.add(userName);

        JLabel userSurname = new JLabel("Surname: ");
        userSurname.setFont(new Font("Calibri", Font.PLAIN, 22));
        userSurname.setBounds(1150, 10, 100, 100);
        panel.add(userSurname);

        JButton logout = new JButton("Logout");
        logout.setBounds(1300, 50, 100, 50);
        panel.add(logout);

        JLabel events = new JLabel("All Events");
        events.setFont(new Font("Calibri", Font.BOLD, 32));
        events.setBounds(650, 100, 500, 50);
        panel.add(events);

      /*  for(int eventNumber = 0 ; eventNumber < 5; eventNumber++) {
            for (int y = 300 ; y < eventNumber*100 ; y+=200) {
                JButton event = new JButton("E" + eventNumber);
                event.setFont(new Font("Calibri", Font.PLAIN, 22));
                event.setBounds(500, y, 500, 100);
                panel.add(event);
            }
        } */

        for(int eventNumber = 0 ; eventNumber < 5; eventNumber++) {
            int y =300 ;
            JButton event = new JButton("E" + eventNumber);
            event.setFont(new Font("Calibri", Font.PLAIN, 22));
            event.setBounds(500, y, 500, 100);
            panel.add(event);
            y+= 300 ;
        }

        frame.setVisible(true);
    }

}
