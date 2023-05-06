package com.pernillaTherese.Enemies;

import com.pernillaTherese.Player;

public class Troll extends Enemy {
    public Troll(String name, int maxHp, int hp, int averageDmg, int hitChance, int critChance) {
        super(name, maxHp, hp, averageDmg, hitChance, critChance);
    }

    @Override
    public int attack(Player player) {
        return super.attack(player);
    }


    public void printMiss() {
        System.out.println(getName() + "'s staff slips out of his hand so it does " + super.getDmg() + " damage to you.");
    }


    public void printCrit() {
        System.out.println(getName() + " rushes forward and **CRITS** you with a roundkick in your cheek with " +
                "" + super.getDmg() + " damage.");
    }

    @Override
    public void printStrong() {
        System.out.println(getName() + " pokes you with the end of his sticks you badly with " + super.getDmg() + " " +
                "damage.");
    }

    @Override
    public void printHit() {
        System.out.println(getName() + " gives you a fist blow on your nose and does " + super.getDmg() + " " +
                "damage to you.");
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

    @Override
    public int getDmg() {
        return super.getDmg();
    }
}
