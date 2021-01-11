package com.company.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayersController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> playerList;

    @FXML
    private TextField namePlayer;

    @FXML
    private Button startGame;

    @FXML
    private Button addPlayers;

    @FXML
    void initialize() {
        startGame.setDisable(true);
        startGame.setOnAction(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("monopoly.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene1 = new Scene(root);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene1);
            primaryStage.show();
        });
    }
}
