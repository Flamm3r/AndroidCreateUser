package lammer.florian.createuserapp;

public class Contact {

    //Variables
    int id;
    String user_ID, password;

    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Getter
    public int getId() {
        return id;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public String getPassword() {
        return password;
    }
}
