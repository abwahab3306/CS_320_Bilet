package GUI;

import Database.getData;
import Model.Event;
import Model.Organizer;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Authenticator;
import java.sql.SQLException;
import java.util.ArrayList;

public class loginPage {

    private String usertype;

    private JButton loginButton;
    private JTextField mailEntry;
    private JTextField passwordEntry;

    public loginPage(String type) {

        usertype = type;

        pageUI();
    }

    private void pageUI() {


        JFrame frame = new JFrame("LOGIN PAGE");
        frame.setSize(1920, 1080);

        ImagePanel panel = new ImagePanel(new ImageIcon("Background.jpg").getImage());
        frame.getContentPane().add(panel);

        JLabel email = new JLabel("E-mail:");
        email.setFont(new Font("Calibri", Font.BOLD, 22));
        email.setBounds(650, 250, 100, 22);
        panel.add(email);

        mailEntry = new JTextField("");
        mailEntry.setFont(new Font("Courier", Font.PLAIN, 22));
        mailEntry.setBounds(650, 300, 300, 30);
        panel.add(mailEntry);


        JLabel password = new JLabel("Password:");
        password.setFont(new Font("Calibri", Font.BOLD, 22));
        password.setBounds(650, 350, 250, 30);
        panel.add(password);

        passwordEntry = new JPasswordField("");
        passwordEntry.setBounds(650, 400, 300, 30);
        panel.add(passwordEntry);


        loginButton = new JButton("Login");
        loginButton.setBounds(750, 450, 100, 50);
        panel.add(loginButton);


        JButton forgetPassword = new JButton("Forget My Password!");
        forgetPassword.setBounds(1000, 500, 200, 50);
        panel.add(forgetPassword);

        forgetPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forgotMyPassFrame passFrame = new forgotMyPassFrame(usertype);
            }
        });


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emailEntered = mailEntry.getText();
                String passwordEntered = passwordEntry.getText();
                boolean what = false;
                if (usertype.equals("Organizer")) {
                    try {
                        what = getData.loginOrganizer(emailEntered, passwordEntered);


                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    if (what == true) {
                        message();
                        Organizer org = null;
                        try {
                            org = getData.getOrganizer(emailEntered);
                            org.setId(getData.getId(true, emailEntered));

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            OrganizerDashboard organizer = new OrganizerDashboard(org);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        frame.dispose();
                    } else {
                        wronginfo();
                    }

                } else {


                    try {
                        what = getData.loginUser(emailEntered, passwordEntered);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    if (what == true) {
                        message();
                        User user = null;
                        try {
                            user = getData.getUser(emailEntered);
                            user.setId(getData.getId(false, emailEntered));
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            UserDashboard dashboard = new UserDashboard(user);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        frame.dispose();
                    } else {

                        wronginfo();

                    }


                }
            }
        });


        frame.setVisible(true);


    }

    public void message() {
        JOptionPane.showMessageDialog(null, "Logged in succesfully!");

    }

    public void wronginfo() {
        JOptionPane.showMessageDialog(null, "wrong info entered");

    }
}
