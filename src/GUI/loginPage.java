package GUI;

import Database.getData;
import Model.Event;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Authenticator;
import java.util.ArrayList;

public class loginPage {

    private String usertype;

    private JButton loginButton;
    private JTextField mailEntry;
    private JTextField passwordEntry;

    public loginPage(String type) {

        usertype = type;



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


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (type.equals("Organizer")) {
                    getData.authenticator(mailEntry.getText(),passwordEntry.getText(),true);
                    message();
                    OrganizerDashboard organizer = new OrganizerDashboard();
                    frame.dispose();
                } else {
                    String emailEntered= mailEntry.getText();
                    String passwordEntered = passwordEntry.getText();
                    System.out.println(emailEntered+" "+passwordEntered);
                    boolean what = getData.authenticator(emailEntered,passwordEntered,false);
                    System.out.println(what);
                    if(what==true){
                        message();
                        User user = new User("k","k","k","k");
                        UserDashboard dashboard = new UserDashboard(user);
                    }else {
                        System.out.println("not working");
                    }


                    frame.dispose();
                }
            }
        });


        frame.setVisible(true);


    }

    public void message() {
        JOptionPane.showMessageDialog(null, "Logged in succesfully!");

    }
}
