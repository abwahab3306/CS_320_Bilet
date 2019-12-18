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

        String query = "INSERT IGNORE INTO `" + table + "` (`" + id + "`, `name`, `surname`, `email`, `password`) VALUES (NULL,'" + name + "','" +
                surname + "','" + email + "','" + password + "')";


        send(query);

        table = null;
        id = null;

    }

    public static void createEvent(String name, int organizerid, int ticketnums, int date, String location, int price, int ibanno) {

        String query = "INSERT IGNORE INTO `events` (`event_id`, `name`, `organizer_id`, `number_of_tickets`, `date`, `location`, `price`, `iban_no_organizer`) VALUES (NULL,'" + name + "','" +
                organizerid + "','" + ticketnums + "','" + date + "','" + location + "','" + price + "','" + ibanno + "')";

        send(query);


    }

    public static void buyTicket(int userid, int eventid, int num_of_ticket) {
        String query = "INSERT IGNORE INTO `reservations` (`res_id`, `user_id`, `event_id`, `number_of_tickets`) VALUES (NULL,'" + userid + "','" +
                eventid + "','" + num_of_ticket + "')";

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
