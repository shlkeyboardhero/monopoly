package com.company.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;

import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import com.company.model.Player;
import com.company.controller.Controller;


import java.io.IOException;
import java.util.ArrayList;


public class PlayersLoaderController {

    ObservableList<String> lang = FXCollections.observableArrayList();


    @FXML
    private ListView<String> playerList;

    @FXML
    private TextField namePlayer;

    @FXML
    private Button startGame;

    @FXML
    private Button addPlayers;
    private Controller gameController;


    @FXML
    void initialize() {

        namePlayer.clear();
        namePlayer.setText(null);

        if (lang.size() < 2)
            startGame.setDisable(true);
        else
            startGame.setDisable(false);

        startGame.setOnAction(event -> {
            Parent root = null;
            /*
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource(
                                "monopoly.fxml"));
                root = loader.load();
                loader.getController();
                MonopolyLoaderController controllerEditBook = loader.getController(); //получаем контроллер для второй формы
                controllerEditBook.monopolyGame(gameController.getPlayerArrayList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene1 = new Scene(root);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene1);
            primaryStage.show();
             */
            try {
                Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                gameController.createBoardView(primaryStage);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

        namePlayer.setFont(Font.font(20.0));

        addPlayers.setOnAction(event -> {
            if (lang.size() < 1)
                startGame.setDisable(true);
            else
                startGame.setDisable(false);

            if (lang.size() < 2)
                addPlayers.setDisable(false);
            else {
                addPlayers.setDisable(true);
                namePlayer.setDisable(true);
            }


            if (namePlayer.getLength() >= 2 && namePlayer != null) {
                lang.add(namePlayer.getText());
                playerList.setItems(lang);
                gameController.playerAdd(namePlayer.getText());
                namePlayer.clear();
            }
        });


        namePlayer.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (lang.size() < 1)
                    startGame.setDisable(true);
                else
                    startGame.setDisable(false);

                if (lang.size() < 2)
                    addPlayers.setDisable(false);
                else {
                    addPlayers.setDisable(true);
                    namePlayer.setDisable(true);
                }


                if (namePlayer.getLength() >= 2 && namePlayer != null) {
                    lang.add(namePlayer.getText());
                    playerList.setItems(lang);
                    gameController.playerAdd(namePlayer.getText());
                    namePlayer.clear();
                }
            }
        });


        playerList.setCellFactory(lv -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setText(null);
                    setTextFill(null);
                } else {
                    setText(item);
                    if (getIndex() % 3 == 0)
                        setStyle("-fx-text-fill: red;");
                    if (getIndex() % 3 == 1)
                        setStyle("-fx-text-fill: blue;");
                    if (getIndex() % 3 == 2)
                        setStyle("-fx-text-fill: green;");
                    setFont(Font.font(20));
                }
            }
        });

    }

    public void setGameController(Controller gameController){
        this.gameController = gameController;
    }
}
