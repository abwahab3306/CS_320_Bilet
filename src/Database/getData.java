
package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Event;
import Model.Organizer;
import Model.User;


public class getData {


    public static String getOrgId(String email) throws SQLException {
        String ID = null;
        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM organizers where email='" + email + "'");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            ID = rs.getString("organizer_id");
        }
        connection.close();
        return ID;
    }

    public static ArrayList<String> getMytickets(String Email) {
        ArrayList<String> mytickets = new ArrayList<String>();
        return mytickets;
    }

    public static ArrayList<Event> getMyEvents(String Email) throws SQLException {
        String ID = getOrgId(Email);
        System.out.println(ID + "sdkmkd");
        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM events WHERE organizer_id= '" + ID + "'");
        ResultSet rs = ps.executeQuery();
        String event_id = null;
        String name = null;
        int organizer_id = 0;
        int number_of_tickets = 0;
        String date = null;
        String location = null;
        int price = 0;
        String iban_no_organizer = null;
        while (rs.next()) {
            event_id = rs.getString("event_id");
            name = rs.getString("name");
            organizer_id = Integer.parseInt(rs.getString("organizer_id"));
            number_of_tickets = Integer.parseInt(rs.getString("number_of_tickets"));
            date = rs.getString("date");
            location = rs.getString("location");
            price = Integer.parseInt(rs.getString("price"));
            iban_no_organizer = rs.getString("iban_no_organizer");
            Event event = new Event(name, organizer_id, number_of_tickets, date, location, price, iban_no_organizer);

        }
        connection.close();
        ArrayList<Event> myEvents = new ArrayList<Event>();
        return myEvents;

    }

    public static ArrayList<Event> getAllEvents() throws SQLException {
        ArrayList<Event> myEvents = new ArrayList<Event>();
        DB_Connection connection = new DB_Connection();
        PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM events");
        ResultSet rs = ps.executeQuery();
        String event_id = null;
        String name = null;
        int organizer_id = 0;
        int number_of_tickets = 0;
        String date = null;
        String location = null;
        int price = 0;
        String iban_no_organizer = null;
        while (rs.next()) {
            event_id = rs.getString("event_id");
            name = rs.getString("name");
            organizer_id = Integer.parseInt(rs.getString("organizer_id"));
            number_of_tickets = Integer.parseInt(rs.getString("number_of_tickets"));
            date = rs.getString("date");
            location = rs.getString("location");
            price = Integer.parseInt(rs.getString("price"));
            iban_no_organizer = rs.getString("iban_no_organizer");
            Event event = new Event(name, organizer_id, number_of_tickets, date, location, price, iban_no_organizer);
            myEvents.add(event);
        }
        connection.close();
        return myEvents;

    }

    public static ArrayList<String> getSoldtickts(String qurey) throws SQLException {
        ArrayList<String> myEvents = new ArrayList<String>();
        return myEvents;
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

		String name = null;
		String surname = null;
		String mail = null;
		String password = null;
		while (rs.next()) {
			name = rs.getString("name");
			surname = rs.getString("surname");
			mail = rs.getString("email");
			password = rs.getString("password");

		}
		return new Organizer(name, surname, mail, password);
	}

	public static User getLastInsertedUserInATable() throws SQLException {
		DB_Connection connection = new DB_Connection();
		PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM users");
		ResultSet rs = ps.executeQuery();

		String name = null;
		String surname = null;
		String mail = null;
		String password = null;
		while (rs.next()) {
			name = rs.getString("name");
			surname = rs.getString("surname");
			mail = rs.getString("email");
			password = rs.getString("password");

		}
		return new User(name, surname, mail, password);
	}

	public static User getUser(String email) throws SQLException{
		DB_Connection connection = new DB_Connection();
		PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM users where email=?" );
		ps.setString(1,email);
		ResultSet rs = ps.executeQuery();

		String name = null;
		String surname = null;
		String mail = null;
		String password = null;
		while (rs.next()) {
			name = rs.getString("name");
			surname = rs.getString("surname");
			mail = rs.getString("email");
			password = rs.getString("password");

		}
		connection.close();
		return new User(name, surname, mail, password);

	}

	public static Organizer getOrganizer(String email) throws SQLException{
		DB_Connection connection = new DB_Connection();
		PreparedStatement ps = connection.conn.prepareStatement("SELECT * FROM organizers where email=?" );
		ps.setString(1,email);
		ResultSet rs = ps.executeQuery();
		String name = null;
		String surname = null;
		String mail = null;
		String password = null;
		while (rs.next()) {
			name = rs.getString("name");
			surname = rs.getString("surname");
			mail = rs.getString("email");
			password = rs.getString("password");

		}
		connection.close();
		return new Organizer(name, surname, mail, password);

	}




	public static boolean loginUser(String email, String password) throws SQLException {
		DB_Connection connection = new DB_Connection();
        String sql = "SELECT * from users WHERE email=? and  password=?";
		PreparedStatement ps = connection.conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		boolean isUserExist = false;
		while (rs.next()) {
			isUserExist = true;
		}
		return isUserExist;
	}

	public static boolean loginOrganizer(String email, String password) throws SQLException {
		DB_Connection connection = new DB_Connection();
        String sql = "SELECT * from organizers WHERE email=? and  password=?";
		PreparedStatement ps = connection.conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		boolean isUserExist = false;
		while (rs.next()) {
			isUserExist = true;
		}
		return isUserExist;
	}


}
