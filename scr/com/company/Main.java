package com.company;

public class Main {

    public static void main(String[] args) {

        Dice diceN1 = new Dice();
        Dice diceN2 = new Dice();

        int dice1 = diceN1.getDiceNumber();
        int dice2 = diceN2.getDiceNumber();

        System.out.println(dice1);
        System.out.println(dice2);
    }

}