package edu.wctc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maze {
    private RoomFactory roomFactory;
    private Room currentRoom;
    private Player player;
    private boolean isFinished = false;
    private Map<String, Room> rooms;

    public Maze(Player player){
        this.player = player;
        rooms = new HashMap<>();
        roomFactory = new RoomFactory();

        //create loot strategies

        LootStrategy diamond = new DiamondLootStrategy();
        LootStrategy gold = new GoldLootStrategy();
        LootStrategy silver = new SIlverLootStrategy();
        LootStrategy none = new NoLootStrategy();


        //create rooms
        rooms.put("Main Office", roomFactory.createRoom("office", "Main Office"));
        rooms.put("Bathroom 1", roomFactory.createRoom("bathroom", "Bathroom 1"));
        rooms.put("Bathroom 2", roomFactory.createRoom("bathroom", "Bathroom 2"));
        rooms.put("Rooftop", roomFactory.createRoom("roof", "Rooftop"));
        rooms.put("Main Elevator", roomFactory.createRoom("elevator", "Main Elevator"));
        rooms.put("Main Hallway", roomFactory.createRoom("hallway", "Main Hallway"));
        rooms.put("Basement Stairs", roomFactory.createRoom("stairs", "Basement Stairs"));
        rooms.put("Basement", roomFactory.createRoom("basement", "Basement"));
        rooms.put("Main Entrance", roomFactory.createRoom("front door", "Main Entrance"));

        //assign loot strategies
        rooms.get("Main Office").setLootStrategy(diamond);
        rooms.get("Bathroom 1").setLootStrategy(gold);
        rooms.get("Bathroom 2").setLootStrategy(silver);
        rooms.get("Rooftop").setLootStrategy(silver);
        rooms.get("Main Elevator").setLootStrategy(gold);
        rooms.get("Main Hallway").setLootStrategy(none);
        rooms.get("Basement Stairs").setLootStrategy(none);
        rooms.get("Basement").setLootStrategy(diamond);
        rooms.get("Main Entrance").setLootStrategy(none);



        //connect rooms
        rooms.get("Main Office").setUp(rooms.get("Main Elevator"));
        rooms.get("Main Office").setDown(rooms.get("Basement Stairs"));
        rooms.get("Main Office").setWest(rooms.get("Bathroom 1"));
        rooms.get("Main Office").setEast(rooms.get("Main Hallway"));

        rooms.get("Bathroom 1").setEast(rooms.get("Main Office"));
        

        rooms.get("Main Hallway").setEast(rooms.get("Main Entrance"));
        rooms.get("Main Hallway").setWest(rooms.get("Main Office"));

        rooms.get("Main Entrance").setWest(rooms.get("Main Hallway"));

        rooms.get("Rooftop").setDown(rooms.get("Main Elevator"));

        rooms.get("Main Elevator").setUp(rooms.get("Rooftop"));
        rooms.get("Main Elevator").setDown(rooms.get("Main Office"));


        rooms.get("Basement Stairs").setDown(rooms.get("Basement"));
        rooms.get("Basement Stairs").setUp(rooms.get("Main Office"));

        rooms.get("Basement").setUp(rooms.get("Basement Stairs"));
        rooms.get("Basement").setWest(rooms.get("Bathroom 2"));

        rooms.get("Bathroom 2").setEast(rooms.get("Basement"));



        currentRoom = rooms.get("Rooftop");


    }

    public String exitCurrentRoom(){
        Room currentRoom = getCurrentRoom();
        if (currentRoom instanceof Exitable){
            return "You have exited the maze. Your final score is: " + player.getPlayerScore();
        }else {
            return "You can't exit the maze from here";
        }
    }

    public String getCurrentRoomDescription(){
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits(){
        return currentRoom.getExits();
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

    public List<String> getPlayerInventory(){
        return player.getInventory();
    }

    public int getPlayerScore(){
        return player.getPlayerScore();
    }

    public void addRoom(String key, String type, String name){
        Room room  = roomFactory.createRoom(type, name);
        rooms.put(key, room);
    }

    public String lootCurrentRoom(Player player){
        Room currentRoom = getCurrentRoom();
        if (currentRoom != null){
            currentRoom.performLoot();
            return "You looted the room";
        }else {
            return "There is nothing to loot";
        }
    }

    public boolean move (char direction) {
        if (currentRoom.isValidDirection(direction)){
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return true;
        }else {
            return false;
        }
    }

    

}
