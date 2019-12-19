
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Organizer;
import Model.User;


public class getData {

    public static boolean authenticator(String Email , String Password, Boolean isOrganizer)  {
        String table;
        if (isOrganizer) {
            table = "organizers";
        } else {
            table = "users";
        }
       String stat = "SELECT password FROM " + table +" "+"where email="+"'"+Email+"'";
       try {
           DB_Connection connection = new DB_Connection();
           ResultSet rs = connection.send_query(stat);
           System.out.println("this step is working 1");
           String dbpass;
           if(rs.next()){
               dbpass = rs.getString(1);
               System.out.println(":: "+ dbpass + Password);
               if (dbpass.contentEquals(Password)){
                   return true;
               }
           }




       } catch (SQLException e){

           return false;
       }
        return false;

    }

    private static ResultSet get(ResultSet q){
        return q;
    }

    public static String getIBAN() {
        String Iban;
        /*      ResultSet rs = get(qurey);*/
        Iban ="kdsjnds";
        return Iban;
    }



    public static ArrayList<String> getMytickets(String Email) {
        ArrayList<String> mytickets = new ArrayList<String>();
        return mytickets;
    }

    public static ArrayList<String> getMyEvents(String Email) throws SQLException {
        ArrayList<String> myEvents = new ArrayList<String>();
        return myEvents;

    }
    public static ArrayList<String> getAllEvents() throws SQLException {
        ArrayList<String> myEvents = new ArrayList<String>();
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

	public static boolean loginUser(String name, String password) throws SQLException {
		DB_Connection connection = new DB_Connection();
        String sql = "SELECT * from users WHERE name=? and  password=?";
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
        String sql = "SELECT * from organizers WHERE name=? and  password=?";
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
