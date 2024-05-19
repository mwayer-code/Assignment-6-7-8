package edu.wctc;

public class Roof extends Room{
    public Roof(String name){
        super.setName(name);
    }

    @Override
    public String getDescription() {
        return "You are in the Roof named " + super.getName();
    }
}
