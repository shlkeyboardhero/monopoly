package com.company.controller;

import com.company.model.*;
import com.company.view.MenuLoaderController;
import com.company.view.MonopolyLoaderController;
import com.company.view.PlayersLoaderController;
import com.company.view.RuleLoaderController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;


public class Controller {
    private Dice dice = new Dice();
    private Player currentPlayer = null;

    private boolean gameStart = false;


    private ArrayList<Player> playerArrayList = new ArrayList<>(4);



    private ArrayList<GameField> squareArrayList = new ArrayList<>();
    private ArrayList<ChanceField> chanceArray = new ArrayList<>(5);


    public void createMenuView (Stage primaryStage) throws IOException {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/company/view/menu.fxml"));
            root = loader.load();
            loader.getController();
            MenuLoaderController controllerEditBook = loader.getController(); //получаем контроллер для второй формы
            controllerEditBook.setGameController(this);
            primaryStage.setTitle("Monopoly");
            primaryStage.setScene(new Scene(root, 1100, 720));
            primaryStage.setResizable(false);
            primaryStage.show();
            createFields();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Player> getPlayerArrayList(){
        return playerArrayList;
    }

    public void createRulesLoaderView (Stage primaryStage) throws IOException {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/company/view/rule1.fxml"));
            root = loader.load();
            loader.getController();
            RuleLoaderController controllerEditBook = loader.getController(); //получаем контроллер для второй формы
            controllerEditBook.setGameController(this);
            Scene scene1 = new Scene(root);
            primaryStage.setScene(scene1);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createPlayerLoaderView (Stage primaryStage) throws IOException {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/company/view/makePlayers.fxml"));
            root = loader.load();
            loader.getController();
            PlayersLoaderController controllerEditBook = loader.getController(); //получаем контроллер для второй формы
            controllerEditBook.setGameController(this);
            Scene scene1 = new Scene(root);
            primaryStage.setScene(scene1);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void createBoardView (Stage primaryStage) throws IOException {
        Parent root = null;
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/company/view/monopoly.fxml"));
            root = loader.load();
            loader.getController();
            MonopolyLoaderController controllerEditBook = loader.getController(); //получаем контроллер для второй формы
            controllerEditBook.setGameController(this);
            controllerEditBook.monopolyGame();
            Scene scene1 = new Scene(root);
            primaryStage.setScene(scene1);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Controller(){

    }


    public ArrayList<ChanceField> getChanceArray() {
        return chanceArray;
    }

    public void createFields() {
        squareArrayList.add(new ServiceGameField("Вперед", "получает 200.", 200));
        squareArrayList.add(new Street("Ул. Житная", 60, 2));
        squareArrayList.add(new ChanceField("Общественная казна №1"));
        squareArrayList.add(new Street("Ул. Нагатинская", 60, 4));
        squareArrayList.add(new ServiceGameField("Подоходный налог","заплатить 200.", -200));
        squareArrayList.add(new Railway("Рижская железная дорога", 200, 25));
        squareArrayList.add(new Street("Варшавское шоссе", 100, 6));
        squareArrayList.add(new ChanceField("Шанс№1"));
        squareArrayList.add(new Street("Ул. Огорева", 100, 6));
        squareArrayList.add(new Street("Ул. Первая Парковая", 120, 8));
        squareArrayList.add(new ServiceGameField("Тюрьма", "просто поситить ее."));
        squareArrayList.add(new Street("Ул. Полянка", 140, 10));
        squareArrayList.add(new PublicService("Электростанция", 150));
        squareArrayList.add(new Street("Ул. Сретенка", 140, 10));
        squareArrayList.add(new Street("Ростовкая набережная", 160, 12));
        squareArrayList.add(new Railway("Курская железная дорога", 200, 25));
        squareArrayList.add(new Street("Рязанский проспект", 180, 14));
        squareArrayList.add(new ChanceField("Общественная казна №2"));
        squareArrayList.add(new Street("Ул. Вавилова", 180, 14));
        squareArrayList.add(new Street("Рублевское шоссе", 200, 16));
        squareArrayList.add(new ServiceGameField("Стоянка","остановился отдохнуть."));
        squareArrayList.add(new Street("Ул. Тверская", 220, 18));
        squareArrayList.add(new ChanceField("Шанс №2"));
        squareArrayList.add(new Street("Ул. Пушкинская", 220, 18));
        squareArrayList.add(new Street("Площадь Маяковская", 240, 20));
        squareArrayList.add(new Railway("Казанская железная дорога", 200, 25));
        squareArrayList.add(new Street("Ул. Грузинский вал", 260, 22));
        squareArrayList.add(new Street("Новинский бульвар", 260, 22));
        squareArrayList.add(new PublicService("Водопровод", 150));
        squareArrayList.add(new Street("Смоленская Площадь", 280, 24));
        squareArrayList.add(new ServiceGameField("Ссылка в тюрьму", "отправиться в тюрьму, но она не работает."));
        squareArrayList.add(new Street("Ул. Щусева", 300, 26));
        squareArrayList.add(new Street("Гоголевский проспект", 300, 26));
        squareArrayList.add(new ChanceField("Общественная казна №3"));
        squareArrayList.add(new Street("Кутозовский проспект", 320, 28));
        squareArrayList.add(new Railway("Ленинская железная дорога", 200, 25));
        squareArrayList.add(new ChanceField("Шанс №3"));
        squareArrayList.add(new Street("Ул. Малая бронная", 350, 35));
        squareArrayList.add(new ServiceGameField("Сверхналог","заплотить 200.", -200));
        squareArrayList.add(new Street("Ул. Арбат", 400, 50));


    }

    public ArrayList<GameField> getSquareArrayList() {
        return squareArrayList;
    }

    public void setGameStart(boolean tf){
        gameStart = tf;
    }

    public boolean getGameStart(){
        return gameStart;
    }






    //((Street) squareArrayList.get(6)).isProperty();
    //new Game().start();


    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player){
        currentPlayer = player;
    }

    public int dice(){
        return dice.getDiceNumber();
    }

    public void setSpaceNum(ArrayList<Player> playerArrayList, int diceSum, int playerIndex) {
       playerArrayList.get(playerIndex).setSpaceNum(playerArrayList.get(playerIndex).getSpaceNum() + diceSum);
    }

    public void playerAdd(String nme) {
        playerArrayList.add(new Player(nme,1500,setColor()));
    }

    private Color setColor(){
        if (playerArrayList.size() == 0)
            return Color.RED;
        else {
            if (playerArrayList.size() == 1)
                return Color.BLUE;
            else
                return Color.GREEN;
        }
    }

    public void payRent(int rent, Player player, Player otherPlayer) {
        player.changeCash(-rent);
        otherPlayer.changeCash(rent);
    }

    public void payRent(int dice) {
        payRent(getRent(returnRealEstate(), dice), getCurrentPlayer(), getPropertyOf());
    }

    public int getRent(RealEstate realEstate, int diceValue) {
        int finalRent;
        if (realEstate.getRent() == 1) {
            finalRent = 4 * diceValue;
            return finalRent;
        } else
            return realEstate.getRent();
    }

    public RealEstate returnRealEstate(){
        return (RealEstate) getSquareArrayList().get(getCurrentPlayer().getSpaceNum());
    }

    public void setProperty(Player player, RealEstate realEstate) {
        if (!isProperty(realEstate)) {
            realEstate.setPropertyOf(player);
            realEstate.setProperty(true);
            player.changeCash(-realEstate.getCost());
            player.addRealEstate(realEstate);
        }
    }

    public GameField getTypeOfField(){
        return getSquareArrayList().get(getCurrentPlayer().getSpaceNum());
    }

    public Player getPropertyOf(){
        return ((RealEstate) (squareArrayList.get(currentPlayer.getSpaceNum()))).getPropertyOf();
    }

    public boolean isProperty(){
        return isProperty(((RealEstate) squareArrayList.get(currentPlayer.getSpaceNum())));
    }

    public boolean isProperty(RealEstate realEstate) {

        return realEstate.isProperty();
    }


    public String getPlayerInfo(){
        String stringInfo;
        stringInfo = ("Имя игрока: " + getCurrentPlayer().getName() +
                "\nТекущаю позиция: " + getCurrentPlayer().getSpaceNum() + " - " +
                squareArrayList.get(getCurrentPlayer().getSpaceNum()).getName() +
                "\nТекущий баланс: " + getCurrentPlayer().getCash() +
                "\nТекущие владения: " + getCurrentPlayer().getPropertiesList());
        return stringInfo;
    }

    public void setNextPlayer(){
        int nextPlayerIndex;
        nextPlayerIndex = (playerArrayList.indexOf(getCurrentPlayer()) + 1) % playerArrayList.size();
        setCurrentPlayer(playerArrayList.get(nextPlayerIndex));
    }

    public int setNewPos(int dice){
        return (currentPlayer.getSpaceNum() + dice) % 40;
    }

    public void setQueue() {
        Comparator<Player> playerComparator = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getPlayerID() - (o2.getPlayerID());
            }

        };

        Collections.sort(playerArrayList, Collections.reverseOrder(playerComparator));
    }




    public Player getNotInitPlayer() {
        for (int i = 0; i < playerArrayList.size(); i++) {
            if (playerArrayList.get(i).getPlayerID() == 0){
                return playerArrayList.get(i);
            }
        }
        return null;
    }


}


