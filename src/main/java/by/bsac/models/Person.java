package by.bsac.models;

/**
 * A Person model indicates alive person independently on its role (user or admin);
 * It's a main alive model on all application.
 */
public class Person {

    protected long user_id; //Person user identification
    protected String user_email; //Person user email
    protected String user_password; //Person user password

    //Default constructor
    public Person() {

    }

    //Getters and setters
    public long getUserId() {
        return user_id;
    }

    private void setUserId(long user_id) {
        this.user_id = user_id;
    }

    public String getUserEmail() {
        return user_email;
    }

    public void setUserEmail(String user_email) {
        this.user_email = user_email;
    }

    public String getUserPassword() {
        return user_password;
    }

    public void setUserPassword(String user_password) {
        this.user_password = user_password;
    }
}
