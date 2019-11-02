package shoot.client.gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import shoot.client.net.Client;
import shoot.client.services.SceneManager;
import shoot.client.util.Password;
import shoot.server.models.User;

import java.io.IOException;


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

    public void onConfirm() {

        if (first_name.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please enter a first name!");
            alert.showAndWait();
            return;
        }

        if (last_name.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please enter a last name!");
            alert.showAndWait();
            return;
        }

        if (password.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please enter a valid password!");
            alert.showAndWait();
            return;
        }

        if (!email.getText().matches("^(.*@.*\\..+)$")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please enter a valid email!");
            alert.showAndWait();
            return;
        }

        if (!User.query().where("email", email.getText()).get().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid input");
            alert.setContentText("This email already exists!");
            alert.showAndWait();
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("register ");
        stringBuilder.append(first_name.getText() + " ");
        stringBuilder.append(last_name.getText() + " ");
        stringBuilder.append(email.getText() + " ");
        stringBuilder.append(Password.hashPassword(password.getText()) + " ");

        Client.get().getPrintStream().println(stringBuilder.toString());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("New user successfully created!");
        alert.showAndWait();

        first_name.clear();
        last_name.clear();
        email.clear();
        password.clear();
    }

    public void onBackToLogin() throws IOException {

        SceneManager.get().activate("login");
    }

}
