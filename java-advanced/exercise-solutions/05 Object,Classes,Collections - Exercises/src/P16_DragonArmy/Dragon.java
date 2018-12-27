package P16_DragonArmy;

public class Dragon {

    private String name;
    private int damage;
    private int health;
    private int armor;

    public Dragon(String name, String damage, String health, String armor) {
        this.name = name;
        if(damage.equals("null")){
            this.damage = 45;
        }else {
            this.damage = Integer.parseInt(damage);
        }
        if(health.equals("null")){
            this.health = 250;
        }else {
            this.health = Integer.parseInt(health);
        }
        if(armor.equals("null")){
            this.armor = 10;
        }else {
            this.armor = Integer.parseInt(armor);
        }
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }public String getName() {
        return name;
    }
}
