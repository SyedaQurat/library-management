package dto;

public class User {

    private int user_id;
    private String user_name;
    private String password;

    public int getId() {
        return user_id;
    }

    public int setId(int user_id) {
        this.user_id = user_id;
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String setUser_name(String user_name) {
        this.user_name = user_name;
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return password;
    }
}
