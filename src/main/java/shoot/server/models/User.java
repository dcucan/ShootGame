package shoot.server.models;

import jeda00.db.Query;

public class User extends Model<Integer> {

    public void setFirstName(String firstName) {
        setString("first_name", firstName);
    }

    public void setLastName(String lastName) {
        setString("last_name", lastName);
    }

    public String getFirstName() {
        return getString("first_name");
    }

    public String getLastName() {
        return getString("last_name");
    }


    public static Query<User> query() {
        return new Query<>(User.class);
    }
}
