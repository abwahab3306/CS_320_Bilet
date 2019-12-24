package Tests;

import static org.junit.jupiter.api.Assertions.*;

import Database.InsertData;
import Database.getData;
import GUI.OrganizerDashboard;
import Model.Organizer;
import Model.Event;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class OrganizerDashboardTest {
    @Test
    public void testCreateEventButton() throws SQLException {
        OrganizerDashboard dashboard = new OrganizerDashboard(new Organizer("Hümeyra Ecem", "Öz", "hecemoz@hotmail.com", "sifre"));
        assertNotNull(dashboard.getCreateEvent());
        assertEquals("Create Event", dashboard.getCreateEvent().getText());
        dashboard.getCreateEvent().doClick();
        Event event = new Event("ZorluPop1", 5, 150, "23.12.2019", "Zorlu", 100, "TR65736256");
        InsertData.createEvent(event.getName(), event.getOrganizerId(), event.getTicketNumber(), event.getDate(),
                event.getLocation(), event.getPrice(), event.getIBAN());
        assertEquals("ZorluPop1", getData.getLastInsertedEvent().getName());
        assertEquals(5, getData.getLastInsertedEvent().getOrganizerId());
        assertEquals(150, getData.getLastInsertedEvent().getTicketNumber());
        assertEquals("Zorlu", getData.getLastInsertedEvent().getLocation());
    }

    @Test
    public void testMyEventButton() throws SQLException {
        Organizer organizer = new Organizer("Hümeyra Ecem", "Öz", "hecemoz@hotmail.com", "sifre");
        InsertData.insertAccount(true, organizer.getName(), organizer.getLastname(), organizer.getEmail(), organizer.getPassword());
        OrganizerDashboard dashboard = new OrganizerDashboard(organizer);
        assertNotNull(dashboard.getMyEventsButton());
        assertEquals("My Events", dashboard.getMyEventsButton().getText());
        dashboard.getMyEventsButton().doClick();
        int eventnums;
        eventnums = getData.getEvents(false, organizer.getEmail()).size();
        if (eventnums < 1) {
            assertEquals(true, dashboard.getEmpty());
        } else {
            assertEquals(false, dashboard.getEmpty());
        }

    }

    @Test
    public void testAllEventsLabel() throws SQLException {
        OrganizerDashboard dashboard = new OrganizerDashboard(new Organizer("Hümeyra Ecem", "Öz", "hecemoz@hotmail.com", "sifre"));
        assertNotNull(dashboard.getAllEvents());
        assertEquals("All Events", dashboard.getAllEvents().getText());

    }

}
