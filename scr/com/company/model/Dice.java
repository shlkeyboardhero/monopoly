package com.company.model;


public class Dice {


    public int getDiceNumber() {
        return getRandom();
    }

    private int getRandom() {
        int rnd;
        rnd = (int) (2 + Math.random() * 10);
        return rnd;
    }


}