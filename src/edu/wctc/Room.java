package edu.wctc;

public abstract class Room{
    private String name;
    private Room north, south, east, west, up, down;

    private boolean hasBeenLooted = false;

    private LootStrategy lootStrategy;



    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public void setDown(Room down) {
        this.down = down;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Room getAdjoiningRoom(char direction){
        return switch (direction) {
            case 'n' -> north;
            case 's' -> south;
            case 'e' -> east;
            case 'w' -> west;
            case 'u' -> up;
            case 'd' -> down;
            default -> null;
        };
    }


    public String getExits(){
        StringBuilder exits = new StringBuilder();
        exits.append("The Exits are: ");
        if (north != null){
            exits.append("North ");
        }
        if (south != null ){
            exits.append("South ");
        }
        if (east != null ){
            exits.append("East ");
        }
        if (west != null){
            exits.append("West ");
        }
        if (up != null){
            exits.append("Up ");
        }
        if (down != null){
            exits.append("Down ");
        }
        return exits.toString();

    }

    public boolean isValidDirection (char direction){
        switch (direction){
            case'n':
                if (north != null){
                    return true;
                }
            case 's':
                if (south != null){
                    return true;
                }
            case 'e':
                if (east != null){
                    return true;
                }
            case 'w':
                if (west != null){
                    return true;
                }
            case 'u':
                if (up != null){
                    return true;
                }
            case 'd':
                if (down != null){
                    return true;
                }
            default:
                return false;
        }
    }

    public abstract String getDescription();

    public void setLootStrategy(LootStrategy lootStrategy){
        this.lootStrategy = lootStrategy;
    }

    public void performLoot(){
        if (!hasBeenLooted && lootStrategy != null){
            lootStrategy.loot();
            hasBeenLooted = true;
        }
    }



}
