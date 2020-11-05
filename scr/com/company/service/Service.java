package com.company.service;

import com.company.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    Scanner scanner = new Scanner(System.in);

    public void createFields(ArrayList squareArrayList) {
        squareArrayList.add(new ServiceGameField("Вперед"));
        squareArrayList.add(new Street("Ул. Житная", 60, 2));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Нагатинская", 60, 4));
        //squareArrayList.add(new ServiceGameField("Подоходный налог"));
        squareArrayList.add(new Railway("Рижская железная дорога", 200, 25));
        squareArrayList.add(new Street("Варшавское шоссе", 100, 6));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Огорева", 100, 6));
        squareArrayList.add(new Street("Ул. Первая Парковая", 120, 8));
        //squareArrayList.add(new )
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


    //((Street) squareArrayList.get(6)).isProperty();
    //new Game().start();

    public void consoleRealization(ArrayList<Player> playerArrayList, ArrayList<GameField> squareArrayList) {
        playerCreate(playerArrayList);
        int g = 1;
        int h = 1;
        while (g == 1) {
            startGame(playerArrayList, squareArrayList, h);


            switch (getQueue()) {
                case 0:
                    step(playerArrayList, squareArrayList, 0);
                case 1:
                    step(playerArrayList, squareArrayList, 1);
            }

        }
    }

    private void step(ArrayList<Player> playerArrayList, ArrayList<GameField> squareArrayList, int queue) {
        int diceSum = 8; //getDiceSum() - для проверки цикла; 8 - для проверки ЖКХ (у них рента в 4 раза больше хода кубика);
        int playerIndex;
        int otherPlayerIndex;
        if (queue == 0) {
            playerIndex = 0;
            otherPlayerIndex = 1;

        } else {
            playerIndex = 1;
            otherPlayerIndex = 0;
        }
        System.out.println("------------------------------------------------------------");
        System.out.println("Ходит игрок №" + playerIndex + ": " + diceSum);
        playerArrayList.get(playerIndex).setSpaceNum(playerArrayList.get(playerIndex).getSpaceNum() + diceSum);

        System.out.println("------------------------------------------------------------");
        System.out.println("Игрок №" + playerArrayList.get(playerIndex).getPlayerID() + " " + playerArrayList.get(playerIndex).getName() + "\n");
        System.out.println("Баланс: " + playerArrayList.get(playerIndex).getCash() + " " + "\n");
        int currentPosition = playerArrayList.get(playerIndex).getSpaceNum();
        System.out.println("Текущая позиция: " + "[" + playerArrayList.get(playerIndex).getSpaceNum() + "] " + squareArrayList.get(currentPosition).getName());
        System.out.print("Текущие владения: ");
        if (playerArrayList.get(playerIndex).getPropertiesList().isEmpty())
            System.out.println("Нету");
        else
            System.out.println(playerArrayList.get(playerIndex).getPropertiesList());

        if (!isProperty(((RealEstate) squareArrayList.get(currentPosition)))) {
            System.out.println("\nЖелаете купить данную недвижемость?\n [1] - DA [2] - NET");

            switch (scanner.nextInt()) {
                case 1:
                    setProperty(playerArrayList.get(playerIndex), (RealEstate) squareArrayList.get(currentPosition));
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Игрок №" + playerArrayList.get(playerIndex).getPlayerID() + " " + playerArrayList.get(playerIndex).getName() + "\n");
                    System.out.println("Баланс: " + playerArrayList.get(playerIndex).getCash() + " " + "\n");
                    System.out.print("Текущие владения: ");
                    if (playerArrayList.get(playerIndex).getPropertiesList().isEmpty())
                        System.out.println("Нету");
                    else
                        System.out.println(playerArrayList.get(playerIndex).getPropertiesList());
                    step(playerArrayList, squareArrayList, otherPlayerIndex);
                case 2:
                    step(playerArrayList, squareArrayList, otherPlayerIndex);
            }
        } else {
            System.out.println("------------------------------------------------------------");
            System.out.println("Заплатите ренту: " + getRent(((RealEstate) squareArrayList.get(currentPosition)), diceSum));
            payRent(getRent(((RealEstate) squareArrayList.get(currentPosition)), diceSum), playerArrayList.get(playerIndex), playerArrayList.get(otherPlayerIndex));
            System.out.println("Баланс: " + playerArrayList.get(playerIndex).getCash());
            System.out.println("------------------------------------------------------------");
            step(playerArrayList, squareArrayList, otherPlayerIndex);

        }
    }



    private int getDiceSum() {
        return new Dice().getDiceNumber() + new Dice().getDiceNumber();
    }

    private void startGame(ArrayList<Player> playerArrayList, ArrayList<GameField> squareArrayList, int h) {
        while (h == 1) {
            System.out.println("Список игроков: \n");
            for (int i = 0; i < playerArrayList.size(); i++) {
                System.out.println("Игрок №" + playerArrayList.get(i).getPlayerID() + " " + playerArrayList.get(i).getName() + "\n");
                System.out.println("Баланс: " + playerArrayList.get(i).getCash() + " " + "\n");
                System.out.println("Текущая позиция: " + "[" + playerArrayList.get(i).getSpaceNum() + "] " + squareArrayList.get(playerArrayList.get(i).getSpaceNum()).getName());
                System.out.print("Текущие владения: ");
                if (playerArrayList.get(i).getPropertiesList().isEmpty())
                    System.out.println("Нету");
                else
                    System.out.println(playerArrayList.get(i).getPropertiesList());
                System.out.println("------------------------------------------------------------");
            }
            break;
        }
    }

    private void playerCreate(ArrayList<Player> playerArrayList) {
        System.out.println("--------------------Монополия-------------------------");
        while (playerArrayList.size() < 2) {
            System.out.println("Введите имя игрока:");
            String nme = scanner.nextLine();
            playerAdd(playerArrayList, nme);
        }
        System.out.println("------------------------------------------------------------");
    }



    private int getQueue() {
        System.out.println("Определяем очередь: ");
        int diceQueue1 = getDiceSum();
        int diceQueue2 = getDiceSum();
        if (diceQueue1 > diceQueue2) {
            System.out.println("Первым ходит игрок №0, сумма кубиков: " + diceQueue1 + " | у другого играка сумма кубиков: " + diceQueue2);
            return 0;
        } else {
            System.out.println("Первым ходит игрок №1, сумма кубиков: " + diceQueue2 + " | у другого играка сумма кубиков: " + diceQueue1);
            return 1;
        }
    }

    private void playerAdd(ArrayList<Player> playerArrayList, String nme) {
        playerArrayList.add(new Player(playerArrayList.size(), nme,2500));
    }

    private void payRent(int rent, Player player, Player otherPlayer) {
        player.changeCash(-rent);
        otherPlayer.changeCash(rent);
    }

    private int getRent(RealEstate realEstate, int diceValue) {
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

}


