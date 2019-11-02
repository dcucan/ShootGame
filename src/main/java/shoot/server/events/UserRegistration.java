package shoot.server.events;



public class UserRegistration {

    public final String firstName;
    public final String lastName;
    public final String email;
    public final String password;

    public UserRegistration(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email = email;
        this.password = password;
    }

    public static UserRegistration fromString(String input){
        String[] data = input.split(" ");
        return new UserRegistration(data[1],data[2],data[3],data[4]);
    }


}
