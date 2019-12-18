package Database;

import java.sql.SQLException;

public class UpdateData {


    public static void updateEvent(int id, String name, int organizerid, int ticketnums, int date, String location, int price, int ibanno) {

        String query = "UPDATE `events` SET `event_id`=" + id + ",`name`='" + name + "',`organizer_id`=" + organizerid + ",`number_of_tickets`=" +
                ticketnums + "," + "`date`=" + date + ",`location`='" + location + "',`price`=" + price + ",`iban_no_organizer`=" + ibanno + " WHERE 1";

    }

}
