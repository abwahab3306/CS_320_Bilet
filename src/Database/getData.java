
package Database;
import java.sql.SQLException;


public class getData {
    private static String table;
    private static String id;
    public static boolean authenticator(String id, String Password, Boolean isOrganizer){
        if (isOrganizer) {
            table = "organizers";
            id = "organizer_id";
        } else {
            table = "users";
            id = "user_id";
        }

        String stat = "SELECT PASSWORD FROM `sql7313897`.`" + table +" WHERE ID = " + id;



        if(stat==Password){
            return true;
        }else
            return false;
    }

    public static void getAllEvents() {
        String Stat = 
    }
}

