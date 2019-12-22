package Tests;

import static org.junit.jupiter.api.Assertions.*;

import GUI.EventCreation;
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
        Event event = new Event("ZorluPop1", 1, 5, "11.01.2019", "Zorlu", 100, "65736256");
        EventCreation eventGUI = new EventCreation(event.getId());
        //assertEquals("New Event", eventGUI.getFrame().getName());
    }

    @Test
    public void testMyEventButton() throws SQLException {
        OrganizerDashboard dashboard = new OrganizerDashboard(new Organizer("Hümeyra Ecem", "Öz", "hecemoz@hotmail.com", "sifre"));
        assertNotNull(dashboard.getMyEventsButton());
        assertEquals("My Events", dashboard.getMyEventsButton().getText());
        dashboard.getMyEventsButton().doClick();
        assertEquals("My Events",dashboard.getMyEventsFrame().getName());
    }

    @Test
    public void testAllEventsLabel() throws SQLException{
        OrganizerDashboard dashboard = new OrganizerDashboard(new Organizer("Hümeyra Ecem", "Öz", "hecemoz@hotmail.com", "sifre"));
        assertNotNull(dashboard.getAllEvents());
        assertEquals("All Events", dashboard.getAllEvents().getText());
        //assertEquals(dashboard.getMyEventsList().toString(),dashboard.getAllEventsLabel().getText());
    }
}
