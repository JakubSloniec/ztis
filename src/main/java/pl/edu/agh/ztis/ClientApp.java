package pl.edu.agh.ztis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.edu.agh.ztis.server.configuration.Configuration;

/**
 * Created by Jakub Sloniec on 11.04.2016.
 */
public class ClientApp extends Application {

    public static void main(String[] args) {
        Application.launch(ClientApp.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("client_application.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle(Configuration.APP_TITLE);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
