package edu.wctc;

//Factory Method

public class RoomFactory {
    public Room createRoom(String type, String name){
        Room room;
        switch (type.toLowerCase()){
            case "office":
                room = new Office(name);
                break;
            case "bathroom":
                room = new Bathroom(name);
                break;
            case "elevator":
                room = new Elevator(name);
                break;
            case "front door":
                room = new FrontDoor(name);
                break;
            case "roof":
                room = new Roof(name);
                break;
            case "stairs":
                room = new Stairs(name);
                break;
            case "basement":
                room = new Basement(name);
                break;
            case "hallway":
                room = new Hallway(name);
                break;
            default:
                throw new IllegalArgumentException("Invalid room type: " + type);
        }
        return room;
    }

}
