import Database.InsertData;
import Database.UpdateData;
import Database.getData;
import Model.Organizer;
import Model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DBLoginAndRegisterTests {
    @Test
    public void testInsertOrganizer1() throws SQLException {
        int before = getData.getNumberOfDataInATable("organizers");
        Organizer organizer = new Organizer("Furkan", "Karayer", "furkan.karayer@gmail.com", "password");
        InsertData.insertAccount(true, organizer.getName(), organizer.getLastname(), organizer.getEmail(),
                organizer.getPassword());
        int after = getData.getNumberOfDataInATable("organizers");
        assertEquals(before + 1, after);
    }

    @Test
    public void testInsertUser1() throws SQLException {
        // get number of organizers
        int before = getData.getNumberOfDataInATable("users");
        User user = new User("Furkan", "Karayer", "furkan.karayer@gmail.com", "password");
        InsertData.insertAccount(false, user.getName(), user.getLastname(), user.getEmail(), user.getPassword());
        int after = getData.getNumberOfDataInATable("users");
        assertEquals(before + 1, after);
    }

    @Test
    public void testInsertOrganizer2() throws SQLException {
        Organizer organizer = new Organizer("Ozan", "Ozbirecikli", "ozan@mail.com", "password");
        InsertData.insertAccount(true, organizer.getName(), organizer.getLastname(), organizer.getEmail(),
                organizer.getPassword());

        Organizer lastOrganizerInATable = getData.getOrganizer(organizer.getEmail());
        assertEquals(lastOrganizerInATable.getName(), organizer.getName());
        assertEquals(lastOrganizerInATable.getLastname(), organizer.getLastname());
        assertEquals(lastOrganizerInATable.getEmail(), organizer.getEmail());
        assertEquals(lastOrganizerInATable.getPassword(), organizer.getPassword());
    }

    @Test
    public void testInsertUser2() throws SQLException {
        User user = new User("Ozan", "Ozbirecikli", "ozan@mail.com", "password2");
        InsertData.insertAccount(false, user.getName(), user.getLastname(), user.getEmail(), user.getPassword());

        User lastUserInATable = getData.getLastInsertedUserInATable();
        assertEquals(lastUserInATable.getName(), user.getName());
        assertEquals(lastUserInATable.getLastname(), user.getLastname());
        assertEquals(lastUserInATable.getEmail(), user.getEmail());
        assertEquals(lastUserInATable.getPassword(), user.getPassword());
    }

    @Test
    public void testLoginUser() throws SQLException {
        // already inserted user above
        User user = new User("Furkan", "Karayer", "furkan.karayer@gmail.com", "password");
        boolean login = getData.loginUser(user.getEmail(), user.getPassword());
        assertEquals(true, login);
    }

    @Test
    public void testLoginOrganizer() throws SQLException {
        // already inserted user above
        Organizer organizer = new Organizer("Furkan", "Karayer", "furkan.karayer@gmail.com", "password");
        boolean login = getData.loginOrganizer(organizer.getEmail(), organizer.getPassword());
        assertEquals(true, login);
    }

    @Test
    public void testForgotPassOrganizer() throws SQLException {
        // already inserted user above
        Organizer organizer = new Organizer("Furkan", "Karayer", "furkan.karayer@gmail.com", "password");
        UpdateData.changePassword(organizer.getEmail(), true, organizer.getPassword());
        boolean login = getData.loginOrganizer(organizer.getEmail(), organizer.getPassword());
        assertEquals(true, login);
    }

    @Test
    public void testForgotPassUser() throws SQLException {
        // already inserted user above
        User user = new User("Furkan", "Karayer", "furkan.karayer@gmail.com", "password");
        UpdateData.changePassword(user.getEmail(), false, user.getPassword());
        boolean login = getData.loginOrganizer(user.getEmail(), user.getPassword());
        assertEquals(true, login);
    }


}

