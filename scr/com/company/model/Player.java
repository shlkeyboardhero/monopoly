package com.company.model;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class Player {
    private int totalCash;
    private int spaceNum;
    private int playerID;
    private String name;
    private Color color;


    public Color getColor() {
        return color;
    }

    public Player(String name, int totalCash, Color color) {
        this.totalCash = totalCash;
        this.name = name;
        playerID = 0;
        spaceNum=0;
        this.color = color;
    }


    private ArrayList<RealEstate> propertiesList = new ArrayList<>();

    public ArrayList<RealEstate> getPropertiesList() {
        return propertiesList;
    }

    public void addRealEstate(RealEstate realEstate) {
        propertiesList.add(realEstate);
    }

    public int getCash() {

        return totalCash;
    }

    public void changeCash(int cash) {

        totalCash += cash;
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

    public void setPlayerID(int id) {
        playerID = id;
    }


    public String toString() {
        return String.valueOf(playerID) + ' ' +  name;
    }

    public String getName() {
        return name;
    }

}
