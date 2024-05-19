package edu.wctc;

public class GoldLootStrategy implements LootStrategy{
    @Override
    public void loot() {
        System.out.println("You found a Gold Bar");
        PlayerInventory.getInstance().addItem("Gold Bar");
        Score.getInstance().addScore(75);
    }
}
