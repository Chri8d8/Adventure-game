public class Enemy {
    private String name;
    private String type;
    private int enemyHealth;
    private Weapon enemyWeapon;

    public Enemy(String name , String type , int enemyHealth , Weapon enemyWeapon) {
        this.name = name;
        this.type = type;
        this.enemyHealth = enemyHealth;
        this.enemyWeapon = enemyWeapon;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isAlive() {
        return enemyHealth > 0;
    }

    public void hit(int damage) {
        enemyHealth -=  damage;
        System.out.println(name + " got hit and took " + damage + " damage. " + "has " + enemyHealth + " hp left.");
        if (!isAlive()) {
            die();
        }
    }
    public void attack(Player player) {
        if (enemyWeapon.canUse()) {
            System.out.println(name + " attacks you with " + enemyWeapon.getName() + "!");
            enemyWeapon.use();
            player.takeDamage(enemyWeapon.getDamage());
        } else {
            System.out.println(name + "s has run out of ammunition.");
        }
    }

    private void die() {
        System.out.println(name + " is dead.");
    }
    public Weapon dropWeapon() {
        System.out.println(name + " and has lift behind " +enemyWeapon.getName());
        return enemyWeapon;
    }

    @Override
    public String toString() {
        return "a " + name + " and it is a " + type + " with a " + enemyWeapon;
    }
}
