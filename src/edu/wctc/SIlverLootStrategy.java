package edu.wctc;

public class SIlverLootStrategy implements LootStrategy{
    @Override
    public void loot() {
        System.out.println("You found a Silver Coin");
        PlayerInventory.getInstance().addItem("Silver Coin");
        Score.getInstance().addScore(50);
    }
}
