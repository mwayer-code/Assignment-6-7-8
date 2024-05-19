package edu.wctc;

public class Stairs extends Room{
    public Stairs(String name){
        super.setName(name);
    }

    @Override
    public String getDescription() {
        return "You are on the Stairs named " + super.getName();
    }
}
