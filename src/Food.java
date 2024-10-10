public class Food extends Item{
    private final int healthPoints;

    public Food(String name, String type, int Hp) {
        super(name, type);
        this.healthPoints = Hp;
    }
    public String getName() {
        return super.getName();
    }
    public String getType() {
        return super.getType();
    }

    public int getHealthPoints() {
        return healthPoints;
    }

//    @Override
//    public int getHealthPoints() {
//        return this.healthPoints;
//    }


}
