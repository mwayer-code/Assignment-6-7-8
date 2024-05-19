package edu.wctc;

public class Basement extends Room{
    public Basement(String name){
        super.setName(name);
    }

    @Override
    public String getDescription() {
        return "You are in a Basement named " + super.getName();
    }
}
