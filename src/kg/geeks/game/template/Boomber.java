package kg.geeks.game.template;

public class Boomber extends Hero{
    public Boomber(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOM);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (this.getHealth() <= 0){
            System.out.println(this.getName() + "Explodes and deals 100 damage to the boss");
            boss.setHealth(boss.getHealth() - 100);
        }
    }
}
