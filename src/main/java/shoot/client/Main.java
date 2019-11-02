package shoot.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import shoot.client.gui.controllers.LoginController;
import shoot.client.gui.controllers.RegisterController;
import shoot.client.net.Client;
import shoot.client.services.SceneManager;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        Client.get().start();

        Scene scene = new Scene(new Pane());
        SceneManager.get().setScene(scene);
        SceneManager.get().newScreen("register", "gui/fxml/newUser.fxml", new RegisterController());
        SceneManager.get().newScreen("login", "gui/fxml/login.fxml", new LoginController());
        SceneManager.get().activate("register");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
