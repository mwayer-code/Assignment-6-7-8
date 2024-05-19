package edu.wctc;

public class Elevator extends Room{
    public Elevator(String name){
        super.setName(name);
    }

    @Override
    public String getDescription() {
        return "You are in a Elevator named " + super.getName();
    }
}
