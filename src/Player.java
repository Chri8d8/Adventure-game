import java.util.ArrayList;

public class Player {
    Room placement;
    ArrayList<Item> inventory = new ArrayList<>();
    private int playerHealth = 100;

    private Weapon equippedWeapon;

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public Player(Room placement) {
        this.placement = placement;
        this.inventory = new ArrayList<>();

    }



    public int getPlayerHealth() {
        return playerHealth;
    }

    public void increaseHealth(int healthIncrease) {
        this.playerHealth += healthIncrease;
    }

    public void decreaseHealth(int healthDecrease) {
        this.playerHealth -= healthDecrease;
    }
    public FoodStatus eat(String foodName) {
        Item itemToEat = findItemInInventory(foodName);
        if (itemToEat == null) {
            itemToEat = placement.findItem(foodName);
            if (itemToEat == null) {
                return FoodStatus.NOT_HERE;
            }
        }
        if (itemToEat instanceof Food) {
            Food food = (Food) itemToEat;
            if (food.getHealthPoints() > 0) {
                increaseHealth(food.getHealthPoints());
                inventory.remove(food);
                placement.remmoveIte(food);
                return FoodStatus.GOOD;
            } else if (food.getHealthPoints() < 0) {
                decreaseHealth(- food.getHealthPoints());
                inventory.remove(food);
                placement.remmoveIte(food);
                return FoodStatus.BAD;
            }
        }
        return FoodStatus.NOT_FOOD;

    }



    public Room getPlacement() {
        return placement;
    }

    public void setPlacement(Room placement) {
        this.placement = placement;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
    public void addItem(Item item) {
        inventory.add(item);
    }
    public void dropItem(Item item) {
        inventory.remove(item);
    }





    public Room move(String movement) {
        if (movement.equalsIgnoreCase("go north")&&
                placement.getNeighbourNorth()!= null) {
            placement = placement.getNeighbourNorth();
        } else if (movement.equalsIgnoreCase("go south") &&
                placement.getNeighBourSouth() != null) {
            placement = placement.getNeighBourSouth();
        } else if (movement.equalsIgnoreCase("go west") &&
                placement.getNeighBourWest() != null) {
            placement = placement.getNeighBourWest();
        } else if (movement.equalsIgnoreCase("go east") &&
                placement.getNeighBourEast() != null) {
            placement = placement.getNeighBourEast();
        } else {
            return null;
        }
        return placement;
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)  || item.getType().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
    public String getInventoryDescription() {
        if (inventory.isEmpty()) {
            return "You are not carrying any items.";
        }
        StringBuilder invDesc = new StringBuilder("You are carrying: ");
        for (Item item : inventory) {
            invDesc.append(item.getName()).append(",");
            invDesc.append(item.getType()).append(",");
        }
        return invDesc.toString();
    }


    public String takeItem(String itemName) {
        Item foundItem = placement.findItem(itemName);

        if (foundItem != null) {
            inventory.add(foundItem);
            placement.remmoveIte(foundItem);
            return "You took the " + foundItem.getType();
        } else {
            return "There is no " + itemName + " here.";
        }

    }
    public String dropItem(String itemName) {
        Item foundItem = findItemInInventory(itemName);

        if (foundItem != null) {
            inventory.remove(foundItem);
            placement.addItem(foundItem);
            return "You dropped the " + foundItem.getName();
        } else {
            return "There is no " + itemName + " in your inventory";

        }
    }
    public String equip(String weaponName) {
        Item item = findItemInInventory(weaponName);
        if (item == null) {
            System.out.println("you don't have such a weapon.");
        } else if (!(item instanceof Weapon)) {
            System.out.println(item.getName() + " is not a weapon.");
        } else {
            equippedWeapon = (Weapon) item;
            System.out.println("you have now equipped " + equippedWeapon.getName() + ".");
        }
        return weaponName;
    }

    public void takeDamage(int damage) {
        playerHealth -= damage;
        System.out.println("you took " + damage + " damage. yours health is now " + playerHealth);
        if (playerHealth <= 0) {
            System.out.println("you are dead!");
            // Implementer logik for død (fx genstart eller game over)
        }
    }
    public void showInventory() {
        System.out.println("you are carrying the following:");
        for (Item item : inventory) {
            System.out.println(item.getName());
        }

        if (equippedWeapon != null) {
            System.out.println("equipping weapon: " + equippedWeapon.getName());
        } else {
            System.out.println("you haven't equipped anything.");
        }
    }
    public void attack(String enemyName, Room room) {
        Enemy target = null;

        if (enemyName != null) {
            for (Enemy enemy : room.getEnemyInRooms()) {
                if (enemy.getName().equalsIgnoreCase(enemyName)) {
                    target = enemy;
                    break;
                }
            }
        } else {
            target = room.getClosestEnemy();
        }


        if (target == null) {
            System.out.println("you are attacking the tiny air.");
            return;
        }


        if (equippedWeapon == null) {
            System.out.println("you have no weapon equip.");
            return;
        }


        if (!equippedWeapon.canUse()) {
            System.out.println("you can' use your weapon.");
            return;
        }


        System.out.println("you attack " + target.getName() + " with " + equippedWeapon.getName());
        equippedWeapon.use();
        target.hit(equippedWeapon.getDamage());


        if (target.isAlive()) {
            System.out.println(target.getName() + " attack you back !");
            target.attack(this);
        } else {
            System.out.println("you have killed " + target.getName() + "!");
            room.removeEnemy(target);
            room.addItem(target.dropWeapon());
        }
    }

}
