package com.company.service;

import com.company.model.*;

import java.util.ArrayList;


public class Service {


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



    public void setSpaceNum(ArrayList<Player> playerArrayList, int diceSum, int playerIndex) {
       playerArrayList.get(playerIndex).setSpaceNum(playerArrayList.get(playerIndex).getSpaceNum() + diceSum);
    }

    public void playerAdd(ArrayList<Player> playerArrayList, String nme) {
        playerArrayList.add(new Player(playerArrayList.size(), nme,2500));
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

    public class SetQueue {
        private int queue;
        private int diceSum;
        private int playerIndex;
        private int otherPlayerIndex;

        public SetQueue(int queue) {
            this.queue = queue;
        }

        public int getDiceSum() {
            return diceSum;
        }

        public int getPlayerIndex() {
            return playerIndex;
        }

        public int getOtherPlayerIndex() {
            return otherPlayerIndex;
        }

        public SetQueue invoke() {
            diceSum = 8;
            if (queue == 0) {
                playerIndex = 0;
                otherPlayerIndex = 1;

            } else {
                playerIndex = 1;
                otherPlayerIndex = 0;
            }
            return this;
        }
    }
}


