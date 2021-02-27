package com.company.view;

import com.company.model.ChanceField;
import com.company.model.Player;
import com.company.controller.Controller;

import com.company.model.RealEstate;
import com.company.model.ServiceGameField;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MonopolyLoaderController {

    ArrayList<Circle> playerDots = new ArrayList<>(3);
    List<Pane> panesArray = new ArrayList<>();

    @FXML
    private Button dice;

    @FXML
    private Button buy;

    @FXML
    private Button payRent;

    @FXML
    private Button nextPlayer;

    @FXML
    private TextArea playerInfo;

    @FXML
    private GridPane gridBoard;

    @FXML
    private TextArea notification;



    private Controller gameController;

    @FXML
    void initialize() {
        notification.setFont(Font.font(18.0));
        playerInfo.setFont(Font.font(18.0));

        AtomicInteger tempDice = new AtomicInteger();

        dice.setOnAction(event -> {
            if (!gameController.getGameStart()) {
                gameController.getCurrentPlayer().setPlayerID(gameController.dice());
                nextPlayer.setDisable(false);
                dice.setDisable(true);
                notification.setText("Игрок " + gameController.getCurrentPlayer().getName() +
                        " бросает кубик для определения хода: "+ gameController.getCurrentPlayer().getPlayerID());
            }
            else {
                tempDice.set(gameController.dice());
                switchPos(tempDice.get());
                dice.setDisable(true);
                playerInfo.setText(gameController.getPlayerInfo());
                notification.appendText("\nВыпавшая сумма очков: " + tempDice);
                game();
            }

        });


        nextPlayer.setOnAction(event -> {
            if (!gameController.getGameStart())
                initPlayers();
            else {
                gameController.setNextPlayer();
                notification.setText("Ходит игрок " + gameController.getCurrentPlayer().getName() + "!");
                playerInfo.setText(gameController.getPlayerInfo());
                dice.setDisable(false);
                nextPlayer.setDisable(true);
            }
        });

        payRent.setOnAction(event -> {
            gameController.payRent(tempDice.get());
            playerInfo.setText(gameController.getPlayerInfo());
            payRent.setDisable(true);
            nextPlayer.setDisable(false);
        });

        buy.setOnAction(event -> {
            gameController.setProperty(gameController.getCurrentPlayer(), gameController.returnRealEstate());
            playerInfo.setText(gameController.getPlayerInfo());
            buy.setDisable(true);
            nextPlayer.setDisable(false);
        });

    }

    public void monopolyGame() {

        for (Node node : gridBoard.getChildren()) {
            if (node instanceof Pane) {
                panesArray.add(((Pane) (node)));
            }
        }

        for (int i = 0; i < panesArray.size(); i++){
            Pane currentPane = panesArray.get(i);
            posCenter(currentPane);

        }



        if (gameController.getPlayerArrayList().size() == 1) {
            Circle firstPlayer;
            firstPlayer = new Circle(10.0, Color.RED);
            playerDots.add(firstPlayer);
        } else if (gameController.getPlayerArrayList().size() == 2) {
            playerDots.add(new Circle(10.0, Color.RED));
            playerDots.add(new Circle(10.0, Color.BLUE));
        } else {
            playerDots.add(new Circle(10.0, Color.RED));
            playerDots.add(new Circle(10.0, Color.BLUE));
            playerDots.add(new Circle(10.0, Color.GREEN));
        }

        for (int i = 0; i < playerDots.size(); i++) {
            playerDots.get(i).setStroke(Color.BLACK);
            playerDots.get(i).setStrokeWidth(2.0);
        }
        panesArray.get(0).getChildren().addAll(playerDots);
        posCenter(panesArray.get(0));

        for (int i = 0; i < gameController.getPlayerArrayList().size(); i++)
            gameController.getPlayerArrayList().get(i).setSpaceNum(0);

        buy.setDisable(true);
        payRent.setDisable(true);
        nextPlayer.setDisable(true);
        initPlayers();
        notification.setText("Добро пожаловать в игру!\nБросайте кубики, чтобы определить очередь." +
                "\nВнимание: броски осуществляются соответсвенно порядку введния игроков в список!");

    }

    public void initPlayers(){
        Player currentNotInitPlayer = gameController.getNotInitPlayer();
        if (currentNotInitPlayer != null) {
            gameController.setCurrentPlayer(currentNotInitPlayer);
            notification.setText("Игрок " + gameController.getCurrentPlayer().getName() + " бросает кубик для определения хода: ");
            dice.setDisable(false);
            nextPlayer.setDisable(true);
        }
        else {
            gameController.setQueue();
            notification.setText("Очередь определена.\nПервым ходит игрок: " + gameController.getPlayerArrayList().get(0).getName());
            gameController.setCurrentPlayer(gameController.getPlayerArrayList().get(0));
            gameController.setGameStart(true);
            nextPlayer.setDisable(true);
            dice.setDisable(false);
        }
    }

    public void game(){
        if (gameController.getTypeOfField() instanceof RealEstate) {
            if (!gameController.isProperty()) {
                notification.appendText("\nЭто поле можно приобрести в собственность!");
                notification.appendText("\nЦена: "+ gameController.returnRealEstate().getCost());
                buy.setDisable(false);
                nextPlayer.setDisable(false);
                payRent.setDisable(true);
            } else {
                notification.appendText("\nЭто поле собственность игрока " + gameController.getPropertyOf().getName() +
                        "\nЗаплатите ренту!");
                notification.appendText("\nРента: "+ gameController.returnRealEstate().getRent());
                nextPlayer.setDisable(true);
                payRent.setDisable(false);
                buy.setDisable(true);
            }
        }
        else {
            if (gameController.getTypeOfField() instanceof ChanceField) {
                ChanceField temp = ((ChanceField) (gameController.getTypeOfField()));
                temp.getRandomChance();
                notification.appendText("\nПопадание на шанс!\nИгрок " +
                        temp.getText());
                temp.payMoney(gameController.getCurrentPlayer());
            }
            else {
                notification.appendText("\nИгрок попал на поле «" + gameController.getTypeOfField().getName() +
                        "» и должен " + ((ServiceGameField) (gameController.getTypeOfField())).getText());
                ((ServiceGameField) (gameController.getTypeOfField())).payMoney(gameController.getCurrentPlayer());
            }
            buy.setDisable(true);
            payRent.setDisable(true);
            nextPlayer.setDisable(false);
            playerInfo.setText(gameController.getPlayerInfo());
        }
    }

    public void switchPos(int diceNum){
        Player currentPlayer = gameController.getCurrentPlayer();
        int newPos = gameController.setNewPos(diceNum);
        for (int i = 0; i < playerDots.size(); i++){
            if (playerDots.get(i).getFill().equals(currentPlayer.getColor())){
                panesArray.get(currentPlayer.getSpaceNum()).getChildren().remove(playerDots.get(i));
                currentPlayer.setSpaceNum(newPos);
                panesArray.get(newPos).getChildren().add(playerDots.get(i));
            }

        }

    }

    /*
    private Pane getNodeFromGridPane(GridPane gridPane, int arrayNumber) {
        int col = array[arrayNumber][0];
        int row = array[arrayNumber][1];
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                if (node instanceof Pane)
                    return ((Pane) (node));
            }
        }
        return null;
    }
     */

    private void posCenter(Pane node){
        if (node instanceof VBox)
            ((VBox) (node)).setAlignment(Pos.BASELINE_CENTER);
        else {
            ((HBox) (node)).setAlignment(Pos.CENTER_LEFT);
        }
    }

    public void setGameController(Controller controller) {
        this.gameController = controller;
    }
}