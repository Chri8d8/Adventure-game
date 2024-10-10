public abstract class Weapon extends Item {
    private  String name;
    private  String type;
    private int damage;

    public Weapon(String name , String type , int damage) {
        super(name , type);
        this.name = name;
        this.type = type;
        this.damage = damage;
    }
    public abstract boolean canUse();

    public abstract void use();


    @Override
    public String toString() {
        return name + type;
    }

    public int getDamage() {
        return damage;
    }
}

