package edu.wctc;

import java.util.ArrayList;
import java.util.List;
//Singleton

public class PlayerInventory {
    private static PlayerInventory instance;
    private List<String> items;

    private PlayerInventory(){
        items = new ArrayList<>();
    }

    public static PlayerInventory getInstance(){
        if (instance == null){
            instance = new PlayerInventory();
        }
        return instance;
    }

    public void addItem(String item){
        items.add(item);
    }

    public List<String> getItems(){
        return items;
    }

}
