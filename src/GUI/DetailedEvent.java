package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DetailedEvent {
    public DetailedEvent () {
        JFrame frame = new JFrame("DETAILED EVENT");
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
        userSurname.setBounds(1150, 10, 200, 100);
        panel.add(userSurname);

        JButton logout = new JButton("Logout");
        logout.setBounds(1300, 40, 100, 50);
        panel.add(logout);

        JButton basket = new JButton("Basket");
        basket.setBounds(300, 40, 100, 50);
        panel.add(basket);

        JButton addToBasket = new JButton("Add to basket");
        addToBasket.setBounds(950, 500, 100, 50);
        panel.add(addToBasket);

        JTextArea eventDetails = new JTextArea("Event details",50,50);
        eventDetails.setBounds(500,300,400,400);
        eventDetails.setVisible(true);
        eventDetails.setLineWrap(true);
        panel.add(eventDetails) ;

        String numbers[] = {"1","2","3","4","5","6","7","8","9"} ;
        JList ticketNumbers = new JList(numbers) ;
        ticketNumbers.getSelectedValue() ;
        JPanel numberChosen = new JPanel() ;
        numberChosen.add(ticketNumbers);
        panel.add(ticketNumbers) ;
        panel.add(numberChosen);

        basket.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
//                Basket basket = new Basket() ;
            }
        });

        basket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Basket basket = new Basket();
            }
        });

        frame.setVisible(true);
    }
}
