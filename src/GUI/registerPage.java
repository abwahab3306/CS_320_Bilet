package GUI;

import Database.InsertData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class registerPage {

    private String usertype;

    private JButton registerButton;
    private JTextField nameEntry;
    private JTextField surnameEntry;
    private JTextField emailEntry;
    private JTextField passwordEntry;

    public registerPage(String type){

        usertype = type;

        JFrame frame = new JFrame("REGISTER PAGE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);

        ImagePanel panel = new ImagePanel(new ImageIcon("C:\\Users\\hecem\\IdeaProjects\\CS_320_Bilet-master\\Background.jpg").getImage());
        frame.getContentPane().add(panel);

        JLabel welcomeMessage = new JLabel("Welcome to Bilet!");
        welcomeMessage.setFont(new Font("Calibri",Font.ITALIC, 40));
        welcomeMessage.setBackground(Color.BLACK);
        welcomeMessage.setForeground(Color.PINK);
        welcomeMessage.setOpaque(true);
        welcomeMessage.setBounds(680, 100, 290, 50);
        panel.add(welcomeMessage);


        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Calibri", Font.BOLD, 22));
        name.setBounds(680, 200, 100, 20);
        panel.add(name);

        nameEntry = new JTextField("");
        nameEntry.setFont(new Font("Calibri", Font.PLAIN, 22));
        nameEntry.setBounds(680, 230, 300, 30);
        panel.add(nameEntry);


        JLabel surname = new JLabel("Surname:");
        surname.setFont(new Font("Calibri", Font.BOLD, 22));
        surname.setBounds(680, 280, 100, 20);
        panel.add(surname);

        surnameEntry = new JTextField("");
        surnameEntry.setFont(new Font("Calibri", Font.PLAIN, 22));
        surnameEntry.setBounds(680, 310,300, 30);
        panel.add(surnameEntry);


        JLabel email = new JLabel("E-mail:");
        email.setFont(new Font("Calibri", Font.BOLD, 22));
        email.setBounds(680, 370, 100, 22);
        panel.add(email);

        emailEntry = new JTextField("");
        emailEntry.setFont(new Font("Courier", Font.PLAIN, 22));
        emailEntry.setBounds(680, 400, 300, 30);
        panel.add(emailEntry);


        JLabel password = new JLabel("Password:");
        password.setFont(new Font("Calibri", Font.BOLD, 22));
        password.setBounds(680, 460, 250, 30);
        panel.add(password);

        passwordEntry = new JPasswordField("");
        passwordEntry.setBounds(680, 490, 300, 30);
        panel.add(passwordEntry);


        registerButton = new JButton("Register");
        registerButton.setBounds(780,600, 100,50);
        panel.add(registerButton);


        frame.setVisible(true);

        sendData();
    }

    public void sendData() {
        System.out.println("Usertype is " + usertype);
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (usertype.equals("Organizer")) {
                InsertData.insertAccount(true, nameEntry.getName(), surnameEntry.getName(), emailEntry.getText(), passwordEntry.getText());
                } else {
                    InsertData.insertAccount(false, nameEntry.getName(), surnameEntry.getName(), emailEntry.getText(), passwordEntry.getText());
                }
            }
        });
    }
}
