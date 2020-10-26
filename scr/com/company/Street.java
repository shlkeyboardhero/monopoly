package com.company;

public class Street extends RealEstate {

    int rent;

    public boolean isProperty() {
        return property;
    }

    public void setProperty(Player player) {
        if (isProperty() == false){
            propertyOf = player.getPlayerID();
            property = true;
            player.changeCash(-cost);
        }
    }

    public Street(String name, int cost, int square, int defRent){
        this.name=name;
        this.cost=cost;
        this.square=square;
        rent=defRent;
    }
}