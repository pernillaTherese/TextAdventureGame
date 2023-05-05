package com.pernillaTherese.Enemies;

import com.pernillaTherese.Player;

public class Boar extends Enemy {

    public Boar(String name, int hp, int averageDmg, int hitChance, int critChance) {
        super(name, hp, averageDmg, hitChance, critChance);

    }

    @Override
    public int attack(Player player) {
        return super.attack(player);
    }


    public void printMiss() {
        System.out.println(getName() + " tries to bite you but miss and do " + super.getDmg() + " damage to you.");
    }

    public void printCrit() {
        System.out.println(getName() + " goars you with his tusks and **CRITS** you with " + super.getDmg() + " damage and\n" +
                "leaves an open bleeding wound on your leg.");
    }

    public void printStrong() {
        System.out.println(getName() + " blunts you hard with his enormous head and does " + super.getDmg() + " damage to you.");
    }

    public void printHit() {
        System.out.println(getName() + " stumbles over his own hooves and does weakly " + super.getDmg() + " damage to you.");
    }

    @Override
    public void printWeak() {
        super.printWeak();
    }

    @Override
    public int takeDamage(int dmg) {
        return super.takeDamage(dmg);
    }

    @Override
    public int randomLvl(Player player) {
        return super.randomLvl(player);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getLvl() {
        return super.getLvl();
    }

    @Override
    public void setLvl(int lvl) {
        super.setLvl(lvl);
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public int getAverageDmg() {
        return super.getAverageDmg();
    }

    @Override
    public int getHitChance() {
        return super.getHitChance();
    }

    @Override
    public int getCritChance() {
        return super.getCritChance();
    }

    @Override
    public boolean isDead() {
        return super.isDead();
    }

    @Override
    public int getGIVEXP() {
        return super.getGIVEXP();
    }
}
