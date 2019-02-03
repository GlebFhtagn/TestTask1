package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Test Task");
        primaryStage.setScene(new Scene(root, 300, 275));
        Scene scene = primaryStage.getScene();
        ComboBox<String> taskBox = (ComboBox<String>) scene.lookup("#taskBox");
        taskBox.setItems(FXCollections.observableArrayList("Substring Task", "Decimal Decomposition"));
        taskBox.setValue("Substring Task");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
