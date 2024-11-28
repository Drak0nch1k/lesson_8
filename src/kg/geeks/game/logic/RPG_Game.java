package kg.geeks.game.logic;

import kg.geeks.game.template.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    public static int roundNumber = 0;

    public static void startGame() {
        Boss boss = new Boss("Gimmel", 1500, 100);

        Warrior warrior1 = new Warrior("Kratos", 290, 10);
        Warrior warrior2 = new Warrior("Harlequin", 280, 15);
        Magic magic = new Magic("Merlin", 280, 10);
        Berserk berserk = new Berserk("Olaf", 240, 10);
        Medic doc = new Medic("Lisa", 250, 5, 15);
        Medic assistant = new Medic("Barbara", 300, 5, 5);
        Magic magic1 = new Magic("Vanda", 250, 10);
        Hacker hacker = new Hacker("Stark", 150, 7);
        King king = new King("Arthur", 200);
        Boomber boomber = new Boomber("Mr.T", 170, 14);

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant, magic1, hacker, king, boomber};
        printStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0
                    && boss.getDefence() != hero.getAbility()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        printStatistics(boss, heroes);
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
