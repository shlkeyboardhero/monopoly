package com.company.view;

import com.company.model.GameField;
import com.company.model.Player;
import com.company.service.Service;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import java.util.ArrayList;



public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        primaryStage.setTitle("Monopoly");
        primaryStage.setScene(new Scene(root, 1100, 720));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        ArrayList<Player> playerArrayList = new ArrayList<>(40);
        ArrayList<GameField> squareArrayList = new ArrayList<>();


        new Service().createFields(squareArrayList);
        new ConsoleView().consoleRealization(playerArrayList, squareArrayList);
    }

}

