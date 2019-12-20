package Database;

import java.sql.SQLException;


public class UpdateData {

    private static String table;
    public static void updateEvent(int id, String name, int organizerid, int ticketnums, int date, String location, int price, int ibanno) {
        String query = "UPDATE `events` SET `event_id`=" + id + ",`name`='" + name + "',`organizer_id`=" + organizerid + ",`number_of_tickets`=" +
                ticketnums + "," + "`date`=" + date + ",`location`='" + location + "',`price`=" + price + ",`iban_no_organizer`=" + ibanno + " WHERE 1";
        send(query);
    }

    public static void changePassword(String Email, Boolean isOrganizer, String newPass) {
        if (isOrganizer) {
            table = "organizers";
        } else {
            table = "users";
        }
        String query = "UPDATE" + table + "SET 'password'=" + newPass + "WHERE email = " + Email;
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
