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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;


public class Controller {
    private Dice dice = new Dice();
    private Player currentPlayer = null;
    private int tempStep = 0;

    private boolean gameStart = false;

    private List<Integer> queueRes = new ArrayList<>();

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
            setChanceArray();
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
        squareArrayList.add(new ServiceGameField("Вперед"));
        squareArrayList.add(new Street("Ул. Житная", 60, 2));
        squareArrayList.add(new ChanceField("Подоходный налог: заплатите 200.", 200,0));
        squareArrayList.add(new Street("Ул. Нагатинская", 60, 4));
        squareArrayList.add(getChanceArray().get(4));
        squareArrayList.add(new Railway("Рижская железная дорога", 200, 25));
        squareArrayList.add(new Street("Варшавское шоссе", 100, 6));
        squareArrayList.add(getChanceArray().get((int) (Math.random() * getChanceArray().size())));
        squareArrayList.add(new Street("Ул. Огорева", 100, 6));
        squareArrayList.add(new Street("Ул. Первая Парковая", 120, 8));
        squareArrayList.add(new ServiceGameField("Тюрьма"));
        squareArrayList.add(new Street("Ул. Полянка", 140, 10));
        squareArrayList.add(new PublicService("Электростанция", 150));
        squareArrayList.add(new Street("Ул. Сретенка", 140, 10));
        squareArrayList.add(new Street("Ростовкая набережная", 160, 12));
        squareArrayList.add(new Railway("Курская железная дорога", 200, 25));
        squareArrayList.add(new Street("Рязанский проспект", 180, 14));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Вавилова", 180, 14));
        squareArrayList.add(new Street("Рублевское шоссе", 200, 16));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Тверская", 220, 18));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Пушкинская", 220, 18));
        squareArrayList.add(new Street("Площадь Маяковская", 240, 20));
        squareArrayList.add(new Railway("Казанская железная дорога", 200, 25));
        squareArrayList.add(new Street("Ул. Грузинский вал", 260, 22));
        squareArrayList.add(new Street("Новинский бульвар", 260, 22));
        squareArrayList.add(new PublicService("Водопровод", 150));
        squareArrayList.add(new Street("Смоленская Площадь", 280, 24));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Щусева", 300, 26));
        squareArrayList.add(new Street("Гоголевский проспект", 300, 26));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Кутозовский проспект", 320, 28));
        squareArrayList.add(new Railway("Ленинская железная дорога", 200, 25));
        squareArrayList.add(new Street("Ул. Малая бронная", 350, 35));
        //squareArrayList.add(new ServiceGameField("Сверхналог"));
        squareArrayList.add(new Street("Ул. Арбат", 400, 50));


    }

    public void setGameStart(boolean tf){
        gameStart = tf;
    }

    public boolean getGameStart(){
        return gameStart;
    }

    private void setChanceArray() {
        chanceArray.add(new ChanceField("Вернитесь на 3 поля назад", 0, -3 ));
        chanceArray.add(new ChanceField("Банк платит девиденды в размере 50", 50, 0));
        chanceArray.add(new ChanceField("Ссуда на строительство получите 150", 150, 0 ));
        chanceArray.add(new ChanceField("Изберательная кампания, заплатите 50 каждому игроку", 50, -3 ));
        chanceArray.add(new ChanceField("Подоходный налог: заплатите 200.", 200,0));
    }



    //((Street) squareArrayList.get(6)).isProperty();
    //new Game().start();


    public void setTempStep(int temp) {
        tempStep = temp;
    }

    public int getTempStep(){
        return tempStep;
    }

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
        if (playerArrayList.size() == 0){
            return Color.RED;
        }
        else
            if (playerArrayList.size() == 1){
                return Color.BLUE;
            }
        else
            return Color.GREEN;
    }

    public void payRent(int rent, Player player, Player otherPlayer) {
        player.changeCash(-rent);
        otherPlayer.changeCash(rent);
    }

    public int getRent(RealEstate realEstate, int diceValue) {
        int finalRent;
        if (realEstate.getRent() == 1) {
            finalRent = 4 * diceValue;
            return finalRent;
        } else
            return realEstate.getRent();
    }

    public void setProperty(Player player, RealEstate realEstate) {
        if (!isProperty(realEstate)) {
            realEstate.setPropertyOf(player.getPlayerID());
            realEstate.setProperty(true);
            player.changeCash(-realEstate.getCost());
            player.addRealEstate(realEstate);
        }
    }

    public boolean isProperty(RealEstate realEstate) {

        return realEstate.isProperty();
    }

    public String getPlayerInfo(){
        String stringInfo;
        stringInfo = ("Имя игрока: " + getCurrentPlayer().getName() +
                "\nТекущаю позиция: " + getCurrentPlayer().getSpaceNum() +
                "\nТекущий баланс: " + getCurrentPlayer().getCash() +
                "\nТекущие владения: " + getCurrentPlayer().getPropertiesList());
        return stringInfo;
    }

    public void changePlayerPos(int i){
        getCurrentPlayer().setSpaceNum(getCurrentPlayer().getSpaceNum()+i);
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


