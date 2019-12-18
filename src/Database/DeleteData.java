package Database;

import java.sql.SQLException;

public class DeleteData {

    public static void deleteEvent(String table, int event_id) {

        String query = "DELETE FROM `" + table + "` WHERE `" + table + "`.`event_id` =" + event_id;

        send(query);

    }

    private static void send(String query) {
        try {
            DB_Connection connection = new DB_Connection();
            connection.insertData(query);

        } catch (Exception e) {

        }
    }
}
