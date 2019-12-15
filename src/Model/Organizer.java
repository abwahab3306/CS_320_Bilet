package Model;

public class Organizer implements Account {
    private int id;
    private String name, lastname, password, email;

    public Organizer(String name, String lastname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLastname() {
        return this.lastname;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setId(int i) {
        this.id = i;
    }

    @Override
    public void setName(String s) {
        this.name = name;
    }

    @Override
    public void setLastname(String s) {
        this.lastname = s;
    }

    @Override
    public void setPassword(String s) {
        this.password = s;
    }

    @Override
    public void setEmail(String s) {
        this.email = s;
    }
}
