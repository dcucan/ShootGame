package shoot.client.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import shoot.client.net.Client;
import shoot.common.EventBus;
import shoot.server.events.UserRegistration;


public class RegisterController implements Controller {



    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;

    @FXML
    private TextField email;

    @FXML
    private TextField password;




    @Override
    public void initialize() {

        first_name.clear();
        last_name.clear();
        email.clear();
        password.clear();

    }

    public void onConfirm(){

        System.out.println("test");
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("register ");
        stringBuilder.append(first_name.getText() +" ");
        stringBuilder.append(last_name.getText() +" ");
        stringBuilder.append(email.getText() + " ");
        stringBuilder.append(password.getText() + " ");

        Client.get().getPrintStream().println(stringBuilder.toString());




    }

}
