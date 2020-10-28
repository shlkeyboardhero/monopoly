package com.company;


public class Dice {


    public int getDiceNumber() {
        return getRandom();
    }

    public int getRandom() {
        int rnd;
        rnd = (int) (1 + Math.random() * 5);
        return rnd;
    }


}