package com.example.abbreviationapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.abbreviationlibrary.AbbreviationLibrary;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 628, 764);
        stage.setTitle("Abbreviation Edit");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        AbbreviationLibrary myAbb = new AbbreviationLibrary();
        System.out.println(myAbb.getName());

        launch();
    }
}