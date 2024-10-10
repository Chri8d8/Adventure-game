import java.util.ArrayList;

public class Adventure {

    Player player;
    map map;

    public Adventure() {
        map = new map();
        player = new Player(map.getCurrentRoom());
    }


    public String move(String direction) {
        Room room = player.move(direction);
        if (room != null) {
            return "you move to " + player.placement.getName() + " " +
                    player.placement.getRoomDescription();
        } else {
            return "connot go this way";
        }
    }
    public void takeItem(String itemName) {
        Item item = player.placement.findItem(itemName);
        if (item != null) {
            player.placement.remmoveIte(item);
            player.addItem(item);
            System.out.println("you have taken the " + itemName);
        } else {
            System.out.println("there is nothing like " + itemName + " to take around here.");
        }
    }
    public void removeItem(String itemName) {
        Item item = player.findItemInInventory(itemName);
        if (item != null) {
            player.placement.addItem(item);
            player.dropItem(item);
            System.out.println("you have dropped the " + itemName);
        } else {
            System.out.println("there is nothing like " + itemName + " to take around here.");
        }
    }
    public ArrayList<Item> seePlayerInventory() {
        return player.getInventory();
    }
    public boolean checkRoomForItems() {
        return !player.getPlacement().getItems().isEmpty();
    }


    public boolean checkInventoryForItems() {
        if (player.getInventory().isEmpty()) {
            return false;
        }
        return true;
    }
    public String getCurrentRoomName() {
        return player.placement.getName();

    }


    public String  getCurrentRoomDescription() {
        return player.placement.getRoomDescription();
    }

    public ArrayList<Item> seeItemsInCurrentRoom() {
        ArrayList<Item> itemsInRoom = new ArrayList<>();
        itemsInRoom = player.getPlacement().getItems();
        return itemsInRoom;
    }

    public String eat(String foodName) {
        FoodStatus status = player.eat(foodName);
        switch (status) {
            case GOOD:
                return "You ate the " + foodName + "You have gained " + player.getPlayerHealth() + " healthponints. ";

            case BAD:
                return "No good you lost " + player.getPlayerHealth() + " hp";
            case NOT_FOOD:
                return  "no";
            case NOT_HERE:
                return "not here " + foodName;

            default:
                return "invalid input";
        }

    }

}
