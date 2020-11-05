package com.company.view;
import com.company.model.Player;

import javax.swing.*;
import java.util.ArrayList;

public class Game {

    ArrayList<Player> playerArrayList = new ArrayList<>();

    JFrame create;
    JFrame wndMain;
    JFrame play;
    JButton start;


    JLabel lbl;
    JList<Player> lbl1;
    JList<Player> play1;


    public void addPlayer(String name) {
        //playerArrayList.add(new Player(playerArrayList.size(), name));
        if (!playerArrayList.isEmpty()) {
            lbl.setVisible(false);
            lbl1.setVisible(true);
        }

        ListModel<Player> bigData = new AbstractListModel<Player>() {
            public int getSize() { return playerArrayList.size(); }
            public Player getElementAt(int index) { return playerArrayList.get(index); }
        };

        lbl1.setModel(bigData);

        if (playerArrayList.size()>1)
            start.setEnabled(true);
    }

    public void start() {
        wndMain =new JFrame("Монополия");
        wndMain.setBounds(250,250,600,400);
        wndMain.setResizable(false);
        wndMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wndMain.setLayout(null);

        lbl = new JLabel("Игроки еще не заданы!");
        lbl.setBounds(75,30,280,50);



        lbl1 = new JList<Player>();
        lbl1.setBounds(75,30,400,300);
        lbl1.setVisible(false);
        wndMain.add(lbl1);

        wndMain.add(lbl);

        JButton btn = new JButton("Создать игрока");
        btn.setBounds(50,120, 200, 30);
        wndMain.add(btn);
        btn.addActionListener(event -> addPlayers() );
        wndMain.setVisible(true);

        start = new JButton("Начать игру");
        start.setBounds(50,150, 200, 30);
        wndMain.add(start);
        start.setEnabled(false);
        start.addActionListener(event-> wndMain.dispose());
        start.addActionListener(event -> play() );
    }

    public void addPlayers() {
        create =new JFrame("Монополия. Создание игроков");
        create.setBounds(500,500,300,200);
        create.setResizable(false);
        create.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        create.setLayout(null);

        JLabel lbl = new JLabel("Введите имя игрока");
        lbl.setBounds(75,0,280,50);
        create.add(lbl);



        JTextField txtFld = new JTextField();
        txtFld.setBounds(10,50,265,50);
        txtFld.setVisible(true);
        create.add(txtFld);

        JButton btn = new JButton("Создать игрока");
        btn.setBounds(50,120, 200, 30);
        btn.addActionListener(event -> addPlayer(txtFld.getText()));
        btn.addActionListener(event -> create.dispose());
        create.add(btn);


        create.setVisible(true);

    }

    public void play() {
        play = new JFrame("Монополия. Игра");
        play.setBounds(250, 250, 700, 500);
        play.setResizable(false);
        play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        play.setLayout(null);
        play.setVisible(true);




        ListModel<Player> bigDataPlay = new AbstractListModel<Player>() {
            public int getSize() { return playerArrayList.size(); }
            public Player getElementAt(int index) { return playerArrayList.get(index); }
        };

        play1 = new JList<Player>();
        play1.setBounds(75,30,200,200);

        play1.setModel(bigDataPlay);
        play1.setVisible(true);

        play.add(play1);
    }

}


