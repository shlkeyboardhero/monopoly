package com.company.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button play;

    @FXML
    public Button rules;

    @FXML
    void initialize() {
        /*rules.setOnAction(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("rule.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage ruleStage = new Stage();
            ruleStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(root, 740, 270);
            ruleStage.setScene(scene);
            ruleStage.setResizable(false);
            ruleStage.setTitle("Правила");
            ruleStage.showAndWait();
        });*/

        rules.setOnAction(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("rule1.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene1 = new Scene(root);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene1);
            primaryStage.show();
        });

        play.setOnAction(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("makePlayers.fxml"));
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