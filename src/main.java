
import Database.DB_Connection;
import GUI.loginPage;
import GUI.registerPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class main {

    private static DB_Connection connection;

    public static void main(String[] args) {


        instantiateJDBC();
        try {
            connection = new DB_Connection();
            System.out.println("Current Users: ");
            connection.send_query("users", "user_id", "name", "surname", "email", "password");
            System.out.println("Current Organizers: ");
            connection.send_query("organizers", "organizer_id", "name", "surname", "email", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        mainpanel();

    }


    private static void instantiateJDBC() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void mainpanel() {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        JPanel panel = new JPanel();
        frame.add(panel);

        JRadioButton radioUser = new JRadioButton("User");
        radioUser.setActionCommand("User");
        JRadioButton radioOrganizer = new JRadioButton("Organizer");
        radioOrganizer.setActionCommand("Organizer");
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioOrganizer);
        bg.add(radioUser);

        panel.add(radioOrganizer);
        panel.add(radioUser);
        JButton but_login = new JButton("Login");
        JButton but_reg = new JButton("Register");
        panel.add(but_login);
        panel.add(but_reg);


        but_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sl = bg.getSelection().getActionCommand();
//                System.out.println(sl);
                loginPage login = new loginPage(sl);
            }
        });


        but_reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String se = bg.getSelection().getActionCommand();
//                System.out.println(se);
                registerPage reg = new registerPage(se);
            }
        });


    }


}
