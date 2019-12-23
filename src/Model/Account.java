package Model;

public abstract class Account {

    private int id;
    private String name, lastname, password, email;


    public Account(String name, String lastname, String email, String password) {

        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return this.name;
    }


    public String getLastname() {
        return this.lastname;
    }


    public String getPassword() {
        return this.password;
    }


    public String getEmail() {
        return this.email;
    }


    public void setId(int i) {
        this.id = i;
    }


    public void setName(String s) {
        this.name = s;
    }


    public void setLastname(String s) {
        this.lastname = s;
    }


    public void setPassword(String s) {
        this.password = s;
    }


    public void setEmail(String s) {
        this.email = s;
    }


}
