package com.company.model;

import java.util.ArrayList;

public class ChanceField extends GameField {



   public String getText() {
      return text;
   }

   public int getChangesMoney() {
      return changesMoney;
   }

   public int getChangesPos() {
      return changesPos;
   }

   String text;
   int changesMoney;
   int changesPos;

   public ChanceField(String text, int changesMoney, int changesPos) {
      this.text = text;
      this.changesMoney = changesMoney;
      this.changesPos = changesPos;
   }



}

