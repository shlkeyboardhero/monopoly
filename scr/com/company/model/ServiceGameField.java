package com.company.model;

import com.company.model.GameField;
import com.company.model.Player;

public class ServiceGameField extends GameField {

    @Override
    public String getName() {
        return name;
    }

    String name;


    String text;
    int money;

    public ServiceGameField(String name, String text, int money) {
        this.name = name;
        this.text = text;
        this.money = money;
    }

    public String getText() {
        return text;
    }

    public ServiceGameField(String name, String text) {
        this.name = name;
        this.text = text;
    }


    public void payMoney(Player player) {
        player.changeCash(money);
    }
}
