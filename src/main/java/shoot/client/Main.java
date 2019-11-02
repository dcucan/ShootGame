package shoot.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import shoot.client.gui.controllers.RegisterController;
import shoot.client.net.Client;
import shoot.client.services.SceneManager;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {



        Client client = null;
        try {
            client = new Client("localhost", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.start();


        launch(args);




    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Pane());
        SceneManager.get().setScene(scene);
        SceneManager.get().newScreen("register", "gui/fxml/newUser.fxml", new RegisterController());
        SceneManager.get().activate("register");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
