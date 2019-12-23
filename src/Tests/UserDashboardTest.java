package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Database.getData;
import GUI.DetailedEvent;
import GUI.IbanFrame;
import Model.Event;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class UserDashboardTest {
    @Test
    public void testPayEventButton() throws SQLException {
        DetailedEvent event = new DetailedEvent(3, new Event("ZorluPop1", 1, 5, "11.01.2019", "Zorlu", 100, "65736256"));
        assertNotNull(event.getPay());
        assertEquals("Pay now!", event.getPay().getText());
        event.getPay().doClick();
        IbanFrame iban = new IbanFrame("65736256");
        assertEquals("Payment", iban.getFrame().getName());
    }

}
