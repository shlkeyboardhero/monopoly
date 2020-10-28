package com.company;

public class ServiceGameField extends GameField {

    ServiceGameField(String name) {
        this.name=name;
    }

    public void payForward(Player player) {
        player.changeCash(200);
    }

    public void payExact(Player player) {
        player.changeCash(-200);
    }
}
