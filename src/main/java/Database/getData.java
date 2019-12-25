
package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Event;
import Model.Organizer;
import Model.User;


public class getData {


    public static int getId(Boolean isorganizer, String email) throws SQLException {
        String usertype = null;
        String table = null;
        if (isorganizer) {
            usertype = "organizer_id";
            table = "organizers";
        } else {
            usertype = "user_id";
            table = "users";
        }
        int ID = -1;
        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM " + table + "  where email='" + email + "'");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ID = Integer.parseInt(rs.getString(usertype));
        }
        connection.close();
        return ID;
    }

    public static String getOrganizer(int orgid) throws SQLException {

        String fullname = "";
        DB_Connection connection = new DB_Connection();
        String query = "SELECT name, surname from organizers WHERE organizer_id=" + orgid;
        PreparedStatement ps = connection.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            String name = rs.getString("name");
            String surname = rs.getString("surname");
            fullname = name + surname;
        }

        return fullname;

    }

    public static ArrayList<String> getMytickets(String Email) {
        ArrayList<String> mytickets = new ArrayList<String>();
        return mytickets;
    }

    public static ArrayList<Event> getEvents(Boolean all, String Email) throws SQLException {

        String query = null;
        if (all) {
            query = "SELECT * FROM events";
        } else {
            int ID = getId(true, Email);
            query = "SELECT * FROM events WHERE organizer_id= '" + ID + "'";
        }

        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        int event_id = 0;
        String name = null;
        int organizer_id = 0;
        int number_of_tickets = 0;
        String date = null;
        String location = null;
        int price = 0;
        String iban_no_organizer = null;
        ArrayList<Event> myEvents = new ArrayList<Event>();
        while (rs.next()) {
            event_id = Integer.parseInt(rs.getString("event_id"));
            name = rs.getString("name");
            organizer_id = Integer.parseInt(rs.getString("organizer_id"));
            number_of_tickets = Integer.parseInt(rs.getString("number_of_tickets"));
            date = rs.getString("date");
            location = rs.getString("location");
            price = Integer.parseInt(rs.getString("price"));
            iban_no_organizer = rs.getString("iban_no_organizer");
            Event event = new Event(name, organizer_id, number_of_tickets, date, location, price, iban_no_organizer);
            event.setId(event_id);
            myEvents.add(event);

        }
        connection.close();

        return myEvents;

    }

    public static int getLastPurchasedTicketNumber() throws SQLException {
        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM reservations");
        ResultSet rs = ps.executeQuery();

        int number_of_tickets = 0;
        while (rs.next()) {
            number_of_tickets = Integer.parseInt(rs.getString("number_of_tickets"));

        }

        return number_of_tickets;
    }


    public static int getNumberOfDataInATable(String tableName) throws SQLException {
        DB_Connection connection = new DB_Connection();
        int totalDataCount = 0;
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM " + tableName);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            totalDataCount += 1;
            // do some work
        }
        connection.close();
        return totalDataCount;
    }

    public static Organizer getLastInsertedOrganizerInATable() throws SQLException {
        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM organizers");
        ResultSet rs = ps.executeQuery();

        int id = 0;
        String name = null;
        String surname = null;
        String mail = null;
        String password = null;
        while (rs.next()) {
            id = Integer.parseInt(rs.getString("organizer_id"));
            name = rs.getString("name");
            surname = rs.getString("surname");
            mail = rs.getString("email");
            password = rs.getString("password");

        }

        Organizer temp = new Organizer(name, surname, mail, password);
        temp.setId(id);
        return temp;

    }

    public static User getLastInsertedUserInATable() throws SQLException {
        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM users");
        ResultSet rs = ps.executeQuery();

        int id = 0;
        String name = null;
        String surname = null;
        String mail = null;
        String password = null;
        while (rs.next()) {

            id = Integer.parseInt(rs.getString("user_id"));
            name = rs.getString("name");
            surname = rs.getString("surname");
            mail = rs.getString("email");
            password = rs.getString("password");

        }
        User temp = new User(name, surname, mail, password);
        temp.setId(id);
        return temp;
    }

    public static Event getLastInsertedEvent() throws SQLException {
        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM events");
        ResultSet rs = ps.executeQuery();

        int event_id = 0;
        String name = null;
        int organizer_id = 0;
        int number_of_tickets = 0;
        String date = null;
        String location = null;
        int price = 0;
        String iban_no_organizer = null;
        while (rs.next()) {

            event_id = Integer.parseInt(rs.getString("event_id"));
            name = rs.getString("name");
            organizer_id = Integer.parseInt(rs.getString("organizer_id"));
            number_of_tickets = Integer.parseInt(rs.getString("number_of_tickets"));
            date = rs.getString("date");
            location = rs.getString("location");
            price = Integer.parseInt(rs.getString("price"));
            iban_no_organizer = rs.getString("iban_no_organizer");

        }
        Event temp = new Event(name, organizer_id, number_of_tickets, date, location, price, iban_no_organizer);
        temp.setId(event_id);
        return temp;
    }

    public static User getUser(String email) throws SQLException {
        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM users where email='" + email + "'");
        ResultSet rs = ps.executeQuery();

        int id = 0;
        String name = null;
        String surname = null;
        String mail = null;
        String password = null;
        while (rs.next()) {

            id = Integer.parseInt(rs.getString("user_id"));
            name = rs.getString("name");
            surname = rs.getString("surname");
            mail = rs.getString("email");
            password = rs.getString("password");

        }
        connection.close();
        User temp = new User(name, surname, mail, password);
        temp.setId(id);
        return temp;

    }

    public static Organizer getOrganizer(String email) throws SQLException {
        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM organizers where email='" + email + "'");
        ResultSet rs = ps.executeQuery();

        int id = 0;
        String name = null;
        String surname = null;
        String mail = null;
        String password = null;
        while (rs.next()) {
            id = Integer.parseInt(rs.getString("organizer_id"));
            name = rs.getString("name");
            surname = rs.getString("surname");
            mail = rs.getString("email");
            password = rs.getString("password");

        }
        connection.close();
        Organizer temp = new Organizer(name, surname, mail, password);
        temp.setId(id);
        return temp;

    }


    public static boolean loginUser(String name, String password) throws SQLException {
        DB_Connection connection = new DB_Connection();
        String sql = "SELECT * from users WHERE email=? and  password=?";
        PreparedStatement ps = connection.conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        boolean isUserExist = false;
        while (rs.next()) {
            isUserExist = true;
        }
        return isUserExist;
    }

    public static boolean loginOrganizer(String name, String password) throws SQLException {
        DB_Connection connection = new DB_Connection();
        String sql = "SELECT * from organizers WHERE email=? and  password=?";
        PreparedStatement ps = connection.conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        boolean isUserExist = false;
        while (rs.next()) {
            isUserExist = true;
        }
        return isUserExist;
    }


}
