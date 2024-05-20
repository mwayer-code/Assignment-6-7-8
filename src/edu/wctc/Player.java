package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Score score;
    private PlayerInventory playerInventory;

    public Player(){
        score = Score.getInstance();
        playerInventory = PlayerInventory.getInstance();
    }

//    public void addScore(int score){
//        this.score.addScore(score);
//    }
//
//    public void addToInventory(String item){
//        playerInventory.addItem(item);
//    }

    public List<String> getInventory(){
        return playerInventory.getItems();
    }

    public int getPlayerScore(){
        return score.getScore();
    }
}
