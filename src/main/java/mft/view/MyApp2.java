package mft.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApp2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene=new Scene(
                FXMLLoader.load(getClass().getResource("Flight.Profile.fxml"))
        );
        primaryStage.setScene(scene);
        primaryStage.setTitle(".Flight.Profile");
        primaryStage.show();

    }
}

