package shoot.client.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import shoot.client.services.Auth;
import shoot.client.util.Password;
import shoot.server.models.User;

import javax.xml.soap.Text;

public class LoginController implements Controller {
    @Override
    public void initialize() {

        email.clear();
        password.clear();
    }

    @FXML
    private TextField email;

    @FXML
    private TextField password;



    public void onConfirm(){


        User user;


        if(User.query().where("email",email.getText()).get().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Forgot your password?");
            alert.setContentText("Invalid email or password!");
            alert.showAndWait();
            return;
        } else {
            user = User.query().where("email",email.getText()).first();
        }


        if (Password.checkPassword(password.getText(), user.getPassword())){
            Auth.get().setUser(user);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Successful!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Forgot your password?");
            alert.setContentText("Invalid email or password!");
            alert.showAndWait();
            return;
        }

    }
}
