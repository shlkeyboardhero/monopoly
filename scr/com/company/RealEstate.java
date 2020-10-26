package com.company;

public class RealEstate  extends Field {
    int cost;
    int rent;
    boolean property = false;
    int propertyOf;



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
}
