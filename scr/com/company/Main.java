package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Dice diceN1 = new Dice();
        Dice diceN2 = new Dice();

        ArrayList<Player> playerArrayList = new ArrayList<>();
        ArrayList <Field> squareArrayList = new ArrayList<>();

        playerArrayList.add(new Player("First player"));
        playerArrayList.add(new Player("Second player"));

        squareArrayList.add(new Street("Ул. Житная", 60,2));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Нагатинская",60,4));
        //squareArrayList.add(new );
        squareArrayList.add(new Railway("Рижская железная дорога",200, 25));
        squareArrayList.add(new Street("Варшавское шоссе",100 ,6));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Огорева",100 ,6));
        squareArrayList.add(new Street("Ул. Первая Парковая",120 ,8));
        //squareArrayList.add(new )
        squareArrayList.add(new Street("Ул. Полянка",140 ,10));
        squareArrayList.add(new HaCS("Электростанция"));
        squareArrayList.add(new Street("Ул. Сретенка",140 ,10));
        squareArrayList.add(new Street("Ростовкая набережная",160 ,12));
        squareArrayList.add(new Railway("Курская железная дорога",200,25));
        squareArrayList.add(new Street("Рязанский проспект",180 ,14));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Вавилова",180 ,14));
        squareArrayList.add(new Street("Рублевское шоссе",200 ,16));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Тверская",220 ,18));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Пушкинская",220 ,18));
        squareArrayList.add(new Street("Площадь Маяковская", 240,20));
        squareArrayList.add(new Railway("Казанская железная дорога", 200,25));
        squareArrayList.add(new Street("Ул. Грузинский вал",260 ,22));
        squareArrayList.add(new Street("Новинский бульвар",260,22));
        squareArrayList.add(new HaCS("Водопровод"));
        squareArrayList.add(new Street("Смоленская Площадь", 280,24));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Щусева",300 ,26));
        squareArrayList.add(new Street("Гоголевский проспект", 300 ,26));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Кутозовский проспект",320 ,28));
        squareArrayList.add(new Railway("Ленинская железная дорога",200,25));
        squareArrayList.add(new Street("Ул. Малая бронная",350 ,35));
        //squareArrayList.add(new );
        squareArrayList.add(new Street("Ул. Арбат",400 ,50));


        int dice1 = diceN1.getDiceNumber();
        int dice2 = diceN2.getDiceNumber();

        System.out.println(dice1);
        System.out.println(dice2);
    }

}