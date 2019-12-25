import Database.InsertData;
import Database.getData;
import GUI.DetailedEvent;
import GUI.IbanFrame;
import Model.Event;
import Model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDashboardTest {
    @Test
    public void testPayEventButton() {
        DetailedEvent event = new DetailedEvent(3, new Event("ZorluPop1", 5, 50, "11.01.2019", "Zorlu", 100, "65736256"));
        assertNotNull(event.getPay());
        assertEquals("Pay now!", event.getPay().getText());
        event.getPay().doClick();
        IbanFrame iban = new IbanFrame("65736256");
        assertEquals("Payment", iban.getFrame().getTitle());
    }

    @Test
    public void buyTicket() throws SQLException {
        User user = getData.getLastInsertedUserInATable();
        Event event = getData.getLastInsertedEvent();
        int ticketBuyed = 10;
        InsertData.buyTicket(user.getId(), event.getId(), ticketBuyed);


    }

}
