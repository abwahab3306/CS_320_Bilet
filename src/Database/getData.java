
package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


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

}

