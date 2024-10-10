import java.util.ArrayList;

public class Room {
    private String name;
    private String roomDescription;
    private ArrayList<Item>items = null;
    private ArrayList<Enemy>enemyInRooms;


    private Room neighbourNorth,neighBourSouth,neighBourWest,neighBourEast;
    public Room(String name , String roomDescription ) {
        this.name = name;
        this.roomDescription = roomDescription;
        this.items = new ArrayList<>();
        this.enemyInRooms  = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Room getNeighbourNorth() {
        return neighbourNorth;
    }

    public void setNeighbourNorth(Room neighbourNorth) {
        this.neighbourNorth = neighbourNorth;
    }

    public Room getNeighBourSouth() {
        return neighBourSouth;
    }

    public void setNeighBourSouth(Room neighBourSouth) {
        this.neighBourSouth = neighBourSouth;
    }

    public Room getNeighBourWest() {
        return neighBourWest;
    }

    public void setNeighBourWest(Room neighBourWest) {
        this.neighBourWest = neighBourWest;
    }

    public Room getNeighBourEast() {
        return neighBourEast;
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public void remmoveIte(Item item) {
        items.remove(item);
    }

    public ArrayList<Enemy> getEnemyInRooms() {
        return enemyInRooms;
    }

    public void setEnemyInRooms(ArrayList<Enemy> enemyInRooms) {
        this.enemyInRooms = enemyInRooms;
    }
    public void addEnemyInRooms(Enemy enemy) {
        enemyInRooms.add(enemy);
    }
    public void removeEnemy(Enemy enemy) {
        enemyInRooms.remove(enemy);
    }
    public Enemy getClosestEnemy() {
        return enemyInRooms.isEmpty() ? null : enemyInRooms.get(0);
    }

    public void setNeighBourEast(Room neighBourEast) {
        this.neighBourEast = neighBourEast;
    }
    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getName().trim().equalsIgnoreCase(itemName)) {
                return item;
            }

        }
        return null;
    }


    @Override
    public String toString() {
        return name + " " + roomDescription;
    }


}
