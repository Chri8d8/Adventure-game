import java.util.ArrayList;

public class map {
    private Room currentRoom;





    map() {
        buildMap();
    }

    public void buildMap() {
        ArrayList<Item> itemArrayList = new ArrayList<>();
//        ArrayList<Item> room1Item = new ArrayList<>();
//        ArrayList<Item> room2Item = new ArrayList<>();
//        ArrayList<Item> room3Item = new ArrayList<>();
//        ArrayList<Item> room4Item = new ArrayList<>();
//        ArrayList<Item> room5Item = new ArrayList<>();
//        ArrayList<Item> room6Item = new ArrayList<>();
//        ArrayList<Item> room7Item = new ArrayList<>();
//        ArrayList<Item> room8Item = new ArrayList<>();
//        ArrayList<Item> room9Item = new ArrayList<>();

//        ArrayList<Food> foodArrayList = new ArrayList<>();
//        ArrayList<Food> room1Food = new ArrayList<>();
//        ArrayList<Food> room2Food = new ArrayList<>();
//        ArrayList<Food> room3Food = new ArrayList<>();
//        ArrayList<Food> room4Food = new ArrayList<>();
//        ArrayList<Food> room5Food = new ArrayList<>();
//        ArrayList<Food> room6Food = new ArrayList<>();
//        ArrayList<Food> room7Food = new ArrayList<>();
//        ArrayList<Food> room8Food = new ArrayList<>();
//        ArrayList<Food> room9Food = new ArrayList<>();


        Room room1 = new Room("room1 " , "This room is empty,but there are two big doors. " );
        Item item1 = new Item("pipe" , "item");
        Food food1 = new Food("Stake" , "food?" , 30);
        MeleeWeapon meleeWeapon1 = new MeleeWeapon("axe " , "weapon" , 15);
        room1.addItem(meleeWeapon1);
//        room1Food.add(food1);
//        room1Item.add(item1);
        room1.addItem(item1);
        room1.addItem(food1);
//        itemArrayList.add(item1);
//        itemArrayList.add(food1);

        Room room2 = new Room("room2 " , "This is a quiet library. " );
        Item item2 = new Item("red and blue flag " , "item");
        Food food2 = new Food("rotten flesh " , "food?" , -20);
        MeleeWeapon meleeWeapon2 = new MeleeWeapon("blade " , "sword" , 15);
        Enemy enemy2 = new Enemy("evil man " , "human " , 15 , meleeWeapon2);
        room2.addEnemyInRooms(enemy2);
//        room2Food.add(food2);
//        room2Item.add(item2);
        room2.addItem(item2);
        room2.addItem(food2);
//        foodArrayList.add(food2);
//        itemArrayList.add(food2);
//        itemArrayList.add(item2);
//       room2Item.add(item2);
//       room2Item.add(food2);


        Room room3 = new Room("room3 " , "You are in a bright room with large windows. " );
        Item item3 = new Item("very old book" , "item");
        Food food3 = new Food("chocolate" , "food?" , 15 );
//        room3Food.add(food3);
//        room3Item.add(item3);
        room3.addItem(item3);
        room3.addItem(food3);
//        itemArrayList.add(food3);
//        itemArrayList.add(item3);

        Room room4 = new Room("room4 " , "A damp cave with dripping water. "  );
        Food food4 = new Food("pink water " , "drink?" , -40);
        Enemy enemy1 = new Enemy("ork" , "monster" , 30 , meleeWeapon1);
        RangedWeapon rangedWeapon1 = new RangedWeapon("kurt " ,"bow" , 15 , 3 );
        room4.addItem(rangedWeapon1);
        room4.addEnemyInRooms(enemy1);
//        room4Food.add(food4);
//        room4Item.add(item4);
        room4.addItem(food4);
//        itemArrayList.add(item4);
//        itemArrayList.add(food4);


        Room room5 = new Room("room5 " , "A mystical room with strange symbols. "  );
        Item item5 = new Item("dusty letters" , "item");
        Food food5 = new Food("te ", "drink? " , 25);
        MeleeWeapon weapon3 = new MeleeWeapon("demon sword " , "evil blade" ,40);
        Enemy enemy4 = new Enemy("demon" , "monster" , 45 , weapon3);
        room5.addEnemyInRooms(enemy4);
//        room5Food.add(food5);
//        room5Item.add(item5);
        room5.addItem(item5);
        room5.addItem(food5);
//        itemArrayList.add(item5);
//        itemArrayList.add(food5);


        Room room6 = new Room("room6 ", "An empty room with an old chair. " );
        Food food6 = new Food("bread " , "food? " , 20);
//        room6Item.add(item6);
//        room6Food.add(food6);
        room6.addItem(food6);
//        itemArrayList.add(item6);
//        itemArrayList.add(food6);

        Room room7 = new Room("room7 " , "A dark room with no visible exits. " );
        Item item7 = new Item("bo" , "kurt");
        Food food7 = new Food("blue liquid " , "drink? " , 15);
//        room7Item.add(item7);
//        room7Food.add(food7);
        room7.addItem(item7);
        room7.addItem(food7);
//        itemArrayList.add(item7);
//        itemArrayList.add(food7);

        Room room8 = new Room("room8 " , "A dimly lit room with a flickering lantern. " );
        Item item8 = new Item("gold ring" , " item ");
        Food food8 = new Food("green liquid " , "drink?" , 80);
//        room8Food.add(food8);
//        room8Item.add(item8);
        room8.addItem(item8);
        room8.addItem(food8);
//        itemArrayList.add(item8);
//        itemArrayList.add(food8);

        Room room9 = new Room("room9 " , "A cold, quiet room with stone walls. " );
        Item item9 = new Item("tor " , " ls" );
        Food food9 = new Food("red liquid " , "drink" , -25);
//        room9Food.add(food9);
//        room9Item.add(item9);
        room9.addItem(item9);
        room9.addItem(food9);
//        itemArrayList.add(item9);
//        itemArrayList.add(food9);


        room1.setNeighBourEast(room2);
        room1.setNeighBourSouth(room4);

        room2.setNeighBourEast(room3);
        room2.setNeighBourWest(room1);

        room3.setNeighBourSouth(room6);
        room3.setNeighBourWest(room2);

        room4.setNeighBourSouth(room7);
        room4.setNeighbourNorth(room1);

        room5.setNeighBourSouth(room8);

        room6.setNeighbourNorth(room3);
        room6.setNeighBourSouth(room9);

        room7.setNeighbourNorth(room4);
        room7.setNeighBourEast(room8);

        room8.setNeighbourNorth(room5);
        room8.setNeighBourWest(room7);
        room8.setNeighBourEast(room9);

        room9.setNeighbourNorth(room6);
        room9.setNeighBourWest(room8);

        currentRoom = room1;

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

}
