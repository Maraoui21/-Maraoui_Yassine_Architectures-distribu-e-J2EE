package com.enset;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;

public class javafxClient extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        // set up the scene
        AnchorPane root = FXMLLoader.load(getClass().getResource("/chatUi.fxml"));
        Scene scene = new Scene(root);
        // set up the stage
        stage.setTitle("Chating app");
        stage.setScene(scene);
        stage.resizableProperty().set(false);
        stage.show();
    }
}
