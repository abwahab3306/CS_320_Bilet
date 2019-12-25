package Database;

import java.sql.SQLException;

public class DeleteData {

    public static void deleteEvent(int event_id) {

        deleteTicket(event_id);

        String query = "DELETE FROM `events` WHERE `event_id` =" + event_id;

        send(query);

    }

    public static void deleteTicket(int event_id) {

        String query = "DELETE FROM `reservations` WHERE `event_id` =" + event_id;

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
