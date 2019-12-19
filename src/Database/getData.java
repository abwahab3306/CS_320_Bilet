
package Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class getData {
    private static Statement stmt;
    private static String table;
    private static String id;
    private static String qurey;
    public static boolean authenticator(String id, String Password, Boolean isOrganizer)  {
        if (isOrganizer) {
            table = "organizers";
            id = "organizer_id";
        } else {
            table = "users";
            id = "user_id";
        }
       String stat = "SELECT PASSWORD FROM" + table +" WHERE ID = " + id +"AND PASSWORD ="+Password;
       try {
           ResultSet rs = stmt.executeQuery(stat);
           return true;
       } catch (SQLException e){
           return false;
       }

    }

    private static ResultSet get(String qurey){
        ResultSet rs=null;
        try{
            rs = stmt.executeQuery(qurey);
        }catch (Exception e){
            System.out.println(e);
        }
        return rs;
    }

    public static String getIBAN(String ID) throws SQLException {
        String Iban = null;
        String qurey = "SELECT IBAN FROM ORGANIZER WHERE EMAIL="+ID;
        ResultSet rs = get(qurey);
        Iban = rs.getString("IBAN");
        return Iban;
    }



    public static ArrayList<String> getMytickets(String Email) throws SQLException {
        ArrayList<String> mytickets = new ArrayList<String>();
        qurey = "Select ";
        ResultSet rs = get(qurey);
        try {
            while (rs.next()){

            }
        }
         catch(SQLException e){

        }
        return mytickets;
    }

    public static ArrayList<String> getMyEvents(String Email) throws SQLException {
        qurey =  "SELECT * FROM EVENTS WHERE EMAIL="+ Email;
        ArrayList<String> myEvents = new ArrayList<String>();
        ResultSet rs = get(qurey);
        try {
            while (rs.next()){
                String name = rs.getString("Email");

            }
        }
        catch(SQLException e){

        }
        return myEvents;
    }
    public static ArrayList<String> getAllEvents() throws SQLException {
        ArrayList<String> myEvents = new ArrayList<String>();
        ResultSet rs = get(qurey);
        try {
            while (rs.next()){

            }
        }
        catch(SQLException e){

        }
        return myEvents;
    }
    public static ArrayList<String> getSoldtickts(String qurey) throws SQLException {
        ArrayList<String> myEvents = new ArrayList<String>();
        ResultSet rs = get(qurey);
        try {
            while (rs.next()){

            }
        }
        catch(SQLException e){

        }
        return myEvents;
    }

}

