import java.util.ArrayList;
import java.util.Scanner;

public class UserInterFace {

    public void game() {
        Adventure adventure = new Adventure();
        System.out.println("Welcome traveller");
        System.out.println("your can move in following directions");
        System.out.println("North, east, south or west." +
                " You do by typing ''go'' followed by the 4 directions");

        System.out.println("You are starting here:\n" + adventure.getCurrentRoomName() + ": " + adventure.getCurrentRoomDescription());
        System.out.println("they may be some enemy's in the rooms ");
        int counting = 0;
        for (Item item : adventure.seeItemsInCurrentRoom()) {
            counting++;
            System.out.println(counting + ". " + item);
        }
        String userChoice = "";
        while (!userChoice.equalsIgnoreCase("exit")) {
            Scanner input = new Scanner(System.in);
            userChoice = input.nextLine().trim().toLowerCase();


            switch (userChoice) {
                case "go north", "go east", "go west", "go south":
                    String moveResult = adventure.move(userChoice);
                    System.out.println(moveResult);
                    if (!moveResult.equals("You cannot go that way")) {
                        if (adventure.player.placement.getEnemyInRooms() == null) {
                            System.out.println("they is on enemy in this room ");
                        } else {
                            System.out.println(adventure.player.placement.getClosestEnemy());
                        }
                        if (!adventure.checkRoomForItems()) {
                            System.out.println("There is nothing exciting to take here.");
                        } else {
                            System.out.println("Items in this room: ");
                            int counter = 0;
                            for (Item item : adventure.seeItemsInCurrentRoom()) {
                                counter++;
                                System.out.println(counter + ". " + item);
                            }
                        }
                    }
                    break;
//                case "north" , "go north" , "n":
//                    if (adventure.player.placement.getNeighbourNorth() != null) {
//                        adventure.player.placement = adventure.player.placement.getNeighbourNorth();
//                        System.out.println(adventure.player.getPlacement());
////                        System.out.println(adventure.seeItemsInCurrentRoom());
//
//                    } else {
//                        System.out.println("connot go this way");
//                    }
//                    break;
//                case "east" , "go east" , "e" :
//                    if (adventure.player.placement.getNeighBourEast() != null) {
//                        adventure.player.placement= adventure.player.placement.getNeighBourEast();
//                        System.out.println(adventure.player.getPlacement());
//                    } else if (adventure.player.placement.getNeighBourEast() == null) {
//                        System.out.println("connot go this way");
//                    }
//                    break;
//                case "south" , "go south" , "s":
//                    if (adventure.player.placement.getNeighBourSouth() != null) {
//                        adventure.player.placement = adventure.player.placement.getNeighBourSouth();
//                        System.out.println(adventure.player.getPlacement());
//                    }
//                    else if (adventure.player.placement.getNeighBourSouth() == null) {
//                        System.out.println("connot go this way");
//                    }
//                    break;
//                case "west" , "go west" , "w":
//                    if (adventure.player.placement.getNeighBourWest() != null) {
//                        adventure.player.placement = adventure.player.placement.getNeighBourWest();
//                        System.out.println(adventure.player.getPlacement());
//                    }
//                    else {
//                        System.out.println("connot go this way");
//                    }
//                    break;
//                case  "look","i":
//                    System.out.println("Having a look around!" + "\n You are in " +
//                            adventure.player.placement.getName()
//                            + " " + adventure.player.placement.getRoomDescription() + "The room has the following items: " + adventure.player.placement.getItems());
////                            adventure.player.placement.getItems());
//                    break;
                case "health" , "hp":
                    System.out.println("you are at " + adventure.player.getPlayerHealth() + " health");
                    if (adventure.player.getPlayerHealth() >= 80) {
                        System.out.println("you are in good health keep going =) ");
                    } else if (adventure.player.getPlayerHealth() >= 50) {
                        System.out.println("you  might need to be carefull ");
                    } else if (adventure.player.getPlayerHealth() < 50) {
                        System.out.println("dengors low health");
                    }
                    break;
                case "help","h":
                    System.out.println("you are in: " + adventure.player.placement.
                            getName() + "\nYou can type following: ''go'' followed by  on of the 4 compass directions\" +\n" +
                            "or their starting letter!!" +
                            "Type look to have a look at your surroundings" +
                            " Type exit to exit game  ");
                    break;


                case "inventory" , "inv" :
                    if (adventure.checkInventoryForItems()) {
                        System.out.println("Your inventory contains: ");
                        int count = 0;
                        for (Item item : adventure.seePlayerInventory()) {
                            count++;
                            System.out.println("\t" + count + ") " + item);
                        }
                    } else {
                        System.out.println("Your inventory is empty. Pick up items by using the ''take'' command!");
                    }
                    break;

                case "exit":
                    System.out.println("Game over");
                    break;
                case "look", "l":
                    ArrayList<Item> items = adventure.seeItemsInCurrentRoom();
                    System.out.println("Having a look around!" + "\nYou are in " + adventure.getCurrentRoomDescription());
                    if (items.isEmpty()) {
                        System.out.println("There is nothing exciting to pick up here...");
                    } else {
                        System.out.println("Items in this room:");
                        System.out.println("oh no they is a enemy in the room " + adventure.player.placement.getEnemyInRooms());
                        int counter = 0;
                        for (Item item : items) {
                            counter++;
                            System.out.println(counter + ". " + item);
                        }
                    }
                    break;

                default:
                    if (userChoice.startsWith("take")) {
                        String itemName = userChoice.substring(5).trim();
                        if (!itemName.isEmpty()) {
                            System.out.println(adventure.player.takeItem(itemName));
                        }
                        break;
                    }
                    if (userChoice.startsWith("drop")) {
                        String itemName = userChoice.substring(5).trim();
                        if (!itemName.isEmpty()) {
                            System.out.println(adventure.player.dropItem(itemName));
                        }
                        break;
                    }
                    if (userChoice.startsWith("equip")) {
                        String weaponName = userChoice.substring(6).trim();
                        if (!weaponName.isEmpty()) {
                            String equipResult = adventure.player.equip(weaponName);
                            System.out.println(equipResult);
                        } else {
                            System.out.println("Please specify a weapon to equip.");
                        }
                        break;
                    }

                    if (userChoice.startsWith("attack")) {
                        String[] words = userChoice.split(" ");
                        String enemyName = null;

                        if (words.length > 1) {
                            enemyName = userChoice.substring(7).trim();
                        }

                        Room currentRoom = adventure.player.getPlacement();
                        adventure.player.attack(enemyName, currentRoom);
                        break;
                    }

                    if (userChoice.startsWith("eat")) {
                        String itemName = userChoice.substring(4).trim();
                        itemName.equalsIgnoreCase(itemName);
                        if (!itemName.isEmpty()) {
                            String eatResult = adventure.eat(itemName);
                            System.out.println(eatResult);
                        }
                    } else {
                        System.out.println("invaild input");
                    }


            }
        }
    }
}
