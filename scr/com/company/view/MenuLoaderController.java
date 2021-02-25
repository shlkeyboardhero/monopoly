package com.company.view;

import com.company.controller.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuLoaderController {

    @FXML
    private Button play;

    @FXML
    public Button rules;
    private Controller gameController;

    @FXML
    void initialize() {
        rules.setOnAction(event -> {
            /*Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("rule1.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene1 = new Scene(root);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene1);
            primaryStage.show();*/
            try {
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                gameController.createRulesLoaderView(primaryStage);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

        play.setOnAction(event -> {
            /*Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("makePlayers.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene1 = new Scene(root);

            primaryStage.setScene(scene1);
            primaryStage.show();*/
            try {
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                gameController.createPlayerLoaderView(primaryStage);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });


    }

    public void setGameController(Controller controller) {
        this.gameController = controller;
    }
}