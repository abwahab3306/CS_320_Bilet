package Database;

import java.sql.SQLException;


public class UpdateData {

    private static String table;

    public static void updateEvent(int id, String name, int organizerid, int ticketnums, String date, String location, int price, String ibanno) {
        String query = "UPDATE `events` SET `name`='" + name + "',`number_of_tickets`=" + ticketnums + ",`date`='"
                + date + "',`location`='" + location + "',`price`=" + price + ",`iban_no_organizer`='" +
                ibanno + "' WHERE `event_id`=" + id;
        send(query);
    }

    public static void changePassword(String Email, Boolean isOrganizer, String newPass) {
        if (isOrganizer) {
            table = "organizers";
        } else {
            table = "users";
        }
        String query = "UPDATE `" + table + "` SET `password`='" + newPass + "' WHERE `email` = '" + Email + "'";
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
