package edu.wctc;

public class FrontDoor extends Room implements Exitable{
    public FrontDoor(String name){
        super.setName(name);
    }

    @Override
    public String getDescription() {
        return "You are in the Front Door named " + super.getName();
    }

    @Override
    public String exit(Player player) {
        return "You have exited the maze. Your final score is: " + player.getPlayerScore();
    }
}
