package edu.wctc;

public class Office extends Room{
    public Office(String name){
        super.setName(name);
    }

    @Override
    public String getDescription() {
        return "You are in the Office named " + super.getName();
    }
}
