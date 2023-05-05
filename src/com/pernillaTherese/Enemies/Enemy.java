package com.pernillaTherese.Enemies;

import com.pernillaTherese.Player;

import java.util.Random;

public class Enemy {
    private final int GIVEXP = 25;
    private String name;
    private int lvl;
    private int hp;
    private int averageDmg; //Average damage. Actually hits +-5% of average. Lvl 1 = 200. Makes each kill about 5 rounds.
    private int dmg;
    private int hitChance; //Meaning % chance to hit. Else is miss.
    private int critChance; //Meaning % chance to crit.
    private boolean isDead = false;


    public Enemy(String name, int hp, int averageDmg, int hitChance, int critChance) {
        this.name = name;
        this.hp = hp;
        this.averageDmg = averageDmg;
        this.hitChance = hitChance;
        this.critChance = critChance;
    }

    public int attack(Player player) {
        Random percentCal = new Random();

        //Hit or miss based on hitchance
        int hit = 1 + percentCal.nextInt(100);
        if (!player.isDead() && !isDead) {

            if (hit > getHitChance()) {
                dmg = 0;
                printMiss();

            } else {

                //Random damage done, crit is everything over 100%
                int randDamage = 1 + percentCal.nextInt((getCritChance() + 100)); //random increases with critchance

                if (randDamage >= 100) {
                    double dmgTemp = (getAverageDmg() * 1.2); //crit, example for calcCheck: lvl 1 240 dmg, lvl 2 264 dmg, lvl 3 288 dmg
                    dmg = (int) dmgTemp;
                    printCrit();

                } else if (randDamage >= 85) {
                    double dmgTemp = getAverageDmg() + percentCal.nextDouble((getAverageDmg() * 1.1) - getAverageDmg()); //strong hit, example for calcCheck: lvl 1 200-220 dmg, lvl 2 220-242 dmg, lvl 3 240-264 dmg
                    dmg = (int) dmgTemp;
                    printStrong();

                } else if (randDamage >= 15) {
                    double dmgTemp = (getAverageDmg() * 0.95) + percentCal.nextDouble((getAverageDmg() * 1.05) - (getAverageDmg() * 0.95)); //medium hit, example for calcCheck: lvl 1 190-210 dmg, lvl 2 209-231 dmg, lvl 3 228-252 dmg
                    dmg = (int) dmgTemp;
                    printHit();

                } else if (randDamage >= 0) {
                    double dmgTemp = (getAverageDmg() * 0.9); //weak hit, example for calcCheck: lvl 1 180 dmg, lvl 2 198 dmg, lvl 3 216 dmg
                    dmg = (int) dmgTemp;
                    printWeak();

                }
            }
            player.takeDamage(dmg);
            System.out.println("Your health: " + player.getHp() + " | " + getName() + "'s health: " + hp + "\n");
        }

        return dmg;
    }

    //methods for the printouts so it'll be easier to change for each enemy class.
    public void printMiss() {
        System.out.println(getName() + " misses and does " + dmg + " damage to you.");
    }
    public void printCrit() {
        System.out.println(getName() + " **CRITS** you with " + dmg + " damage.");
    }
    public void printStrong() {
        System.out.println(getName() + " hits you strongly with " + dmg + " damage.");
    }
    public void printHit() {
        System.out.println(getName() + " hits you with " + dmg + " damage.");
    }
    public void printWeak() {
        System.out.println(getName() + " hits you weakly with " + dmg + " damage.");
    }

    //if hp is 0 --> dead.
    public int takeDamage(int dmg) {
        hp = hp - dmg;
        if (hp <= 0) {
            hp = 0;
            isDead = true;
        }
        return hp;
    }

    //Level of enemy depends on level of player.
    public int randomLvl(Player player) {
        Random leveler = new Random();
        if (player.getLvl() <= 3) {
            lvl = 1 + leveler.nextInt(3);
        } else if (player.getLvl() <= 6) {
            lvl = 4 + leveler.nextInt(3);
        } else if (player.getLvl() <= 10) {
            lvl = 7 + leveler.nextInt(3);
        }
        return lvl;
    }


    //GETTERS, SETTERS
    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getHp() {
        return hp;
    }

    public int getAverageDmg() {
        for (int i = 1; i <= getLvl(); i++) {
            //init AveragDmg = 180 / lvl 1 dmg=180-200-220 / lvl 2 dmg=198-220-242 / lvl 3 dmg=216-240-264
            double dmgTemp = averageDmg + 20;
            averageDmg = (int) dmgTemp;
        }
        return averageDmg;
    }

    public int getHitChance() {
        return hitChance;
    }

    public int getCritChance() {
        return critChance;
    }

    public boolean isDead() {
        return isDead;


    }

    public int getGIVEXP() {
        return GIVEXP;
    }

    public int getDmg() {
        return dmg;
    }
}
