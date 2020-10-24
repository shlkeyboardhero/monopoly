package com.company;


public class Dice {

    int dice;

    public void getDiceNumber() {
        this.dice = getRandom();
    }

    public int getRandom(){
        int rnd;
        rnd = (int) (1 + Math.random() * 5);
        return rnd;
    }
}