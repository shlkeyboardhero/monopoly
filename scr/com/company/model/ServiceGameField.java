package com.company.model;

import com.company.model.GameField;
import com.company.model.Player;

public class ServiceGameField extends GameField {

    public ServiceGameField(String name) {
        setName(name);
    }

    public void payForward(Player player) {
        player.changeCash(200);
    }

    public void payExact(Player player) {
        player.changeCash(-200);
    }
}
