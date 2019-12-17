
package Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class getData {
    private static Statement stmt;
    private static String table;
    private static String id;
    public static boolean authenticator(String id, String Password, Boolean isOrganizer) throws SQLException {
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
       } catch (Exception e){
           return false;
       }
    }

    public static String getIBAN(String ID){
        String Iban;
        try {

        }
        return Iban;
    }


}

