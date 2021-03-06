package com.company.model;


public class RealEstate extends GameField {
    private int cost;
    private int rent;
    private boolean property = false;
    private Player propertyOf;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public boolean isProperty() {
        return property;
    }

    public void setProperty(boolean property) {
        this.property = property;
    }

    public Player getPropertyOf() {
        return propertyOf;
    }

    public void setPropertyOf(Player propertyOf) {
        this.propertyOf = propertyOf;
    }
}
