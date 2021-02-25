package com.company.controller;

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