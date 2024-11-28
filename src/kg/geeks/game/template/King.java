package kg.geeks.game.template;

import java.util.Random;

public class King extends Hero {
    public King(String name, int health) {
        super(name, health, 0, null);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int chance = random.nextInt(100);
        if (chance < 10) {
            System.out.println(this.getName() + "Summoned the hero of Saitama ");
            callSaitama(boss);
        }
    }

    private void callSaitama(Boss boss) {
        boss.setHealth(0);
        System.out.println("Saitama destroyed the boss with one hit ");
    }
}
