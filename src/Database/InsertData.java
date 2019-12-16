
package Database;

import java.sql.SQLException;

public class InsertData {

    private static final String a = "";

    private static String table;
    private static String id;


    public static void insertAccount(Boolean isOrganizer, String name, String surname, String email, String password) {

        if (isOrganizer) {
            table = "organizers";
            id = "organizer_id";
        } else {
            table = "users";
            id = "user_id";
        }

        String query = "INSERT IGNORE INTO `sql7313897`.`" + table + "` (`" + id + "`, `name`, `surname`, `email`, `password`) VALUES (NULL,'" + name + "','" +
                surname + "','" + email + "','" + password + "')";


        try {
            DB_Connection connection = new DB_Connection();
            connection.insertData(query);
            table = null;
            id = null;
        } catch (Exception e) {

        }

    }
}

