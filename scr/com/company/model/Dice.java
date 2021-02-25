package com.company.model;


public class Dice {


    public int getDiceNumber() {
        return getRandom();
    }

    private int getRandom() {
        int rnd;
        rnd = (int) (1 + Math.random() * 11);
        return rnd;
    }


}