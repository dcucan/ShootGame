package shoot.server.handlers;

import shoot.server.events.UserRegistration;
import shoot.server.models.User;

public class RegisterUser {

    public RegisterUser(UserRegistration userRegistration){
        User user = new User();
        user.setFirstName(userRegistration.firstName);
        user.setLastName(userRegistration.lastName);
        user.setEmail(userRegistration.email);
        user.setPassword(userRegistration.password);
        user.save();
    }
}
