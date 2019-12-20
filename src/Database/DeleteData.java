package Database;

import java.sql.SQLException;

public class DeleteData {

    public static void deleteEvent(int event_id) {

        String query = "DELETE FROM `events` WHERE `events`.`event_id` =" + event_id;

        send(query);

    }

    public static void deleteTicket(int user_id) {

        String query = "DELETE FROM `reservations` WHERE `reservations`.`user_id` =" + user_id;

        send(query);

    }

    private static void send(String query) {
        try {
            DB_Connection connection = new DB_Connection();
            connection.insertData(query);

        } catch (SQLException e) {

        }
    }
}
