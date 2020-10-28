package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Player> playerArrayList = new ArrayList<>(40);
        ArrayList<GameField> squareArrayList = new ArrayList<>();


        new Service().createFields(squareArrayList);
        new Service().consoleRealization(playerArrayList, squareArrayList);

    }

}

