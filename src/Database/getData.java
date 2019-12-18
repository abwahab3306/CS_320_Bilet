
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
       String stat = "SELECT PASSWORD FROM `sql7313897`.`" + table +" WHERE ID = " + id;
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

    public static String getIBAN(String ID){
        String Iban = null;
        String qurey = "Select";
        try{
            ResultSet rs = stmt.executeQuery(qurey);
            Iban = rs.toString();
        }catch (Exception e){
            System.out.println(e);
        }


        return Iban;
    }

    public static ResultSet getMyEvents(){
        String qurey ="";
      return get(qurey);
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

