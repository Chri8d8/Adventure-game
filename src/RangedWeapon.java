public class RangedWeapon extends Weapon{
    private int ammunition;

    public RangedWeapon(String name , String type , int damage , int ammunition) {
        super(name , type , damage);
        this.ammunition = ammunition;
    }

    @Override
    public boolean canUse() {
        return ammunition > 0;
    }

    @Override
    public void use() {
        if (canUse()) {
            ammunition--;
//            System.out.println("you are shooting in tiny air");
        } else {
            System.out.println("Dit våben " + this + " er løbet tør for ammunition.");
        }
    }
}
