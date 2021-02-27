package com.company.model;

import java.util.ArrayList;

public class ChanceField extends GameField {

   @Override
   public String getName() {
      return name;
   }

   String name;
   String text;
   int changesMoney;
   int changesPos;


   public String getText() {
      return text;
   }

   public int getChangesMoney() {
      return changesMoney;
   }

   public int getChangesPos() {
      return changesPos;
   }

   public void setText(String text) {
      this.text = text;
   }

   public void payMoney(Player player) {
      player.changeCash(changesMoney);
   }

   public void setChangesMoney(int changesMoney) {
      this.changesMoney = changesMoney;
   }

   public void setChangesPos(int changesPos) {
      this.changesPos = changesPos;
   }


   public ChanceField(String name) {
      this.name=name;
      this.text = null;
      this.changesMoney=0;
      this.changesPos=0;
   }

   public void getRandomChance(){
      int rand = (int) (1 + Math.random() * 3);
      switch (rand) {
         case 1:
            setText("получает от банка девиденды в размере: 50");
            setChangesMoney(50);
            break;
         case 2:
            setText("получает ссуду на строительство: 150");
            setChangesMoney(150);
            break;
         case 3:
            setText("получает оплаченный больничный: 25");
            setChangesMoney(25);
            break;
         case 4:
            setText("тратит на лекарства: 50 ");
            setChangesMoney(-50);
            break;
      }
   }

}

