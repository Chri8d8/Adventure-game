public class Item {
    //    private ArrayList<Item> items;
    private String name;
    private String type;


    public Item(String name , String type) {
        this.name = name;
        this.type = type;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //    public int getHealthPoint() {
//        return this.getHealthPoint();
//    }
    //
//    public ArrayList<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(ArrayList<Item> items) {
//        this.items = items;
//    }
//    public void addItem(Item item) {
//        items.add(item);
//    }
//    public void removeItem(Item item) {
//        items.remove(item);
//    }
//
//    public Item findItem(String itemName ) {
//        for (Item item : items) {
//            if (item.getName().equalsIgnoreCase(itemName)) {
//                return item;
//            }
//        }
//        return null;
//    }
//
    @Override
    public String toString() {
        return name + " " + type;
    }

}
