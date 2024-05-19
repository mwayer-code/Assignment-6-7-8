package edu.wctc;
//Singleton
public class Score {
    private static Score instance;
    private int score;

    private Score(){
        score = 0;
    }

    public static Score getInstance(){
        if (instance == null){
            instance = new Score();
        }
        return instance;
    }

    public void addScore(int points){
        score += points;
    }

    public int getScore(){
        return score;
    }
}
