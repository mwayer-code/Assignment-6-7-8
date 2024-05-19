package edu.wctc;

public class NoLootStrategy implements LootStrategy{
    @Override
    public void loot() {
        System.out.println("You found Nothing.");
    }
}
