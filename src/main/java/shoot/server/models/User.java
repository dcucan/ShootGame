package shoot.server.models;

import jeda00.db.Query;

public class User extends Model<Integer> {

    public void setFirstName(String firstName) {
        setString("first_name", firstName);
    }

    public void setLastName(String lastName) {
        setString("last_name", lastName);
    }

    public void setEmail(String email){ setString("email", email);}

    public void setPassword(String password){ setString("password", password);}

    public String getFirstName() {
        return getString("first_name");
    }

    public String getLastName() {
        return getString("last_name");
    }

    public String getPassword() {
        return getString("password");
    }

    public String getEmail() {
        return getString("email");
    }


    public static Query<User> query() {
        return new Query<>(User.class);
    }
}
