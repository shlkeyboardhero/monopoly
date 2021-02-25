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
import java.net.URL;
import java.util.ResourceBundle;

public class RuleLoaderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button understandButton;
    private Controller gameController;

    @FXML
    void initialize() {
        understandButton.setOnAction(event -> {
            /*Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("menu.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene1 = new Scene(root);
            primaryStage.setScene(scene1);
            primaryStage.show();*/
            try {
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                gameController.createMenuView(primaryStage);
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
