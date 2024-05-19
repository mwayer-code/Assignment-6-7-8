package edu.wctc;

public class Bathroom extends Room{
    public Bathroom(String name){
        super.setName(name);
    }

    @Override
    public String getDescription() {
        return "You are in a Bathroom named " + super.getName();
    }
}
