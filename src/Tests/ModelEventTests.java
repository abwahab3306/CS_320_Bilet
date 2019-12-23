
package Tests;


import org.junit.jupiter.api.Test;

import Model.Event;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelEventTests {
    @Test
    public void testEventConstructor1() {
        Event event = new Event("ZorluPop1", 5, 5, "11.01.2019", "Zorlu", 100, "65736256");
        assertEquals("ZorluPop1", event.getName());
    }

    @Test
    public void testEventConstructor2() {
        Event event = new Event("ZorluPop1", 5, 5, "11.01.2019", "Zorlu", 100, "65736256");
        assertEquals(1, event.getOrganizerId());
    }

    @Test
    public void testEventConstructor3() {
        Event event = new Event("ZorluPop1", 5, 5, "11.01.2019", "Zorlu", 100, "65736256");
        assertEquals(5, event.getTicketNumber());
    }

    @Test
    public void testEventConstructor4() {
        Event event = new Event("ZorluPop1", 5, 5, "11.01.2019", "Zorlu", 100, "65736256");
        assertEquals("11.01.2019", event.getDate());
    }

    @Test
    public void testEventConstructor5() {
        Event event = new Event("ZorluPop1", 5, 5, "11.01.2019", "Zorlu", 100, "65736256");
        assertEquals("Zorlu", event.getLocation());
    }

    @Test
    public void testEventConstructor6() {
        Event event = new Event("ZorluPop1", 1, 5, "11.01.2019", "Zorlu", 100, "65736256");
        assertEquals(100, event.getPrice());
    }

    @Test
    public void testEventConstructor7() {
        Event event = new Event("ZorluPop1", 5, 5, "11.01.2019", "Zorlu", 100, "65736256");
        assertEquals("65736256", event.getIBAN());
    }

    @Test
    public void testEventSetTicketNumber() {
        Event event = new Event("ZorluPop1", 5, 5, "11.01.2019", "Zorlu", 100, "65736256");
        event.setTicketNumber(15);
        assertEquals(15, event.getTicketNumber());
    }

    @Test
    public void testEventSetLocation() {
        Event event = new Event("ZorluPop1", 5, 5, "11.01.2019", "Zorlu", 100, "65736256");
        event.setLocation("IF");
        assertEquals("IF", event.getLocation());
    }

    @Test
    public void testEventSetPrice() {
        Event event = new Event("ZorluPop1", 5, 5, "11.01.2019", "Zorlu", 100, "65736256");
        event.setPrice(150);
        assertEquals(150, event.getPrice());
    }

    @Test
    public void testEventIBAN() {
        Event event = new Event("ZorluPop1", 5, 5, "11.01.2019", "Zorlu", 100, "65736256");
        event.setIBAN("87123618");
        assertEquals("87123618", event.getIBAN());
    }
}

