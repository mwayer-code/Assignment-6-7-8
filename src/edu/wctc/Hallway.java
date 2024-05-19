package edu.wctc;

public class Hallway extends Room{
    public Hallway(String name){
        super.setName(name);
    }

    @Override
    public String getDescription() {
        return "You are in the Hallway named " + super.getName();
    }
}
