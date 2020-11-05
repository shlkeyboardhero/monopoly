package com.company.view;

import com.company.model.GameField;
import com.company.model.Player;
import com.company.service.Service;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Player> playerArrayList = new ArrayList<>(40);
        ArrayList<GameField> squareArrayList = new ArrayList<>();


        new Service().createFields(squareArrayList);
        new Service().consoleRealization(playerArrayList, squareArrayList);

    }

}

