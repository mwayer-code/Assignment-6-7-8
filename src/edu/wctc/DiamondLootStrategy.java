package edu.wctc;

public class DiamondLootStrategy implements LootStrategy{
    @Override
    public void loot() {
        System.out.println("You found a Diamond");
        PlayerInventory.getInstance().addItem("Diamond");
        Score.getInstance().addScore(100);
    }
}
