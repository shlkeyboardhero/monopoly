package com.company.view;

import com.company.model.Dice;
import com.company.model.GameField;
import com.company.model.Player;
import com.company.model.RealEstate;
import com.company.service.Service;

import java.util.ArrayList;
import java.util.Scanner;



public class ConsoleView extends Service {

    public void consoleRealization(ArrayList<Player> playerArrayList, ArrayList<GameField> squareArrayList) {
        playerCreate(playerArrayList);
        int g = 1;
        while (g == 1) {
            startGame(playerArrayList, squareArrayList);


            switch (getQueue()) {
                case 0:
                    step(playerArrayList, squareArrayList, 0);
                case 1:
                    step(playerArrayList, squareArrayList, 1);
            }

        }
    }


    Scanner scanner = new Scanner(System.in);
    private void step(ArrayList<Player> playerArrayList, ArrayList<GameField> squareArrayList, int queue) {
        Service.SetQueue setQueue = new Service.SetQueue(queue).invoke();
        int diceSum = setQueue.getDiceSum();
        int playerIndex = setQueue.getPlayerIndex();
        int otherPlayerIndex = setQueue.getOtherPlayerIndex();
        System.out.println("------------------------------------------------------------");
        System.out.println("Ходит игрок №" + playerIndex + ": " + diceSum);
        setSpaceNum(playerArrayList, diceSum, playerIndex);

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




    public int getDiceSum() {
        return new Dice().getDiceNumber() + new Dice().getDiceNumber();
    }

    public void startGame(ArrayList<Player> playerArrayList, ArrayList<GameField> squareArrayList) {
        int h=1;
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

    public void playerCreate(ArrayList<Player> playerArrayList) {
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

}
