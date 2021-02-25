package com.company.view;

import com.company.model.GameField;
import com.company.model.Player;
import com.company.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import java.util.ArrayList;



public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        new Controller().createMenuView(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);

        //new ConsoleView().consoleRealization(playerArrayList, squareArrayList);
    }

}

