public class MeleeWeapon extends Weapon{

    public MeleeWeapon(String name , String type , int damage) {
        super(name , type ,damage );

    }
    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void use() {
//        System.out.println("du svinger med " + this + " mod den tomme luft");
    }
}
