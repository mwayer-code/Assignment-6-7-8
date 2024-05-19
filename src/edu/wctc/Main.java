package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Player player = new Player();
        Maze maze = new Maze(player);
        
        boolean gameRunning = true;

        while (gameRunning){
        System.out.println(maze.getCurrentRoomDescription());
        System.out.println(maze.getCurrentRoomExits());
        System.out.print("[l] - Loot\n[x] - Attempt Exit\n[i] - Inventory\n[p] - Print Score\n[n s e w u d] - Move\nEnter a command:");
        char command = keyboard.nextLine().charAt(0);

        switch (command){
            case 'n': case 's': case 'e': case 'w': case 'u': case 'd':
                boolean moved = maze.move(command);
                if (!moved){
                    System.out.println("You can't go that way");
                }
                break;
            case 'l':
                System.out.println(maze.lootCurrentRoom(player));
                break;
            case 'i':
                System.out.println(maze.getPlayerInventory());
                break;
            case 'p' :
                System.out.println(player.getPlayerScore());
                break;
            case 'x':
                String exitMessage = maze.exitCurrentRoom();
                System.out.println(exitMessage);
                if (exitMessage.contains("final score")){
                    keyboard.close();
                    gameRunning = false;                   
                }
                break;
            default:
                System.out.println("Invalid Command");  
            }

            if (!gameRunning) {
                break;
                
            }

        }

    }
}
