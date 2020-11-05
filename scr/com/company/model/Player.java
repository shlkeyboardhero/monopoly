package com.company.model;

import java.util.ArrayList;

public class Player {
    private int totalCash;
    private int totalAssets;
    private int spaceNum;
    private int playerID;
    private boolean isTurn = false;
    private String name;


    public Player(int playerID, String name, int totalCash) {
        this.totalCash = totalCash;
        this.name = name;
        this.playerID = playerID;
        spaceNum=0;
    }


    public int getCash() {

        return totalCash;
    }

    public void changeCash(int cash) {

        totalCash += cash;
    }

    private ArrayList<RealEstate> propertiesList = new ArrayList<>();

    public ArrayList<RealEstate> getPropertiesList() {
        return propertiesList;
    }

    public void addRealEstate(RealEstate realEstate) {
        propertiesList.add(realEstate);
    }


    public int getSpaceNum() {

        return spaceNum;
    }

    public void setSpaceNum(int spaceNum) {
        this.spaceNum = spaceNum;
    }

    public int getPlayerID() {

        return playerID;
    }

    public void setPlayerID(int playerID) {

        this.playerID = playerID;
    }

    public String toString() {
        return String.valueOf(playerID) + ' ' +  name;
    }

    public String getName() {
        return name;
    }
}
