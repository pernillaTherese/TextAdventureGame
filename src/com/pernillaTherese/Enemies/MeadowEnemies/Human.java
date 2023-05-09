package com.pernillaTherese.Enemies.MeadowEnemies;

import com.pernillaTherese.Enemies.Enemy;
import com.pernillaTherese.Player;

public class Human extends Enemy {

    public Human(String name, int maxHp, int hp, int averageDmg, int hitChance, int critChance) {
        super(name, maxHp, hp, averageDmg, hitChance, critChance);

    }

    @Override
    public int attack(Player player) {
        return super.attack(player);
    }

    public void printMiss() {
        System.out.println(getName() + " shoots a bow arrow at you but it goes straight into the bushes and does " + super.getDmg() + " damage to you.");
    }

    public void printCrit() {
        System.out.println(getName() + " hits you with a poisoned arrow straight into your chest and **CRITS** you with " + super.getDmg() + " damage to you.");
    }

    public void printStrong() {
        System.out.println(getName() + " gets a full hit with an arrow into your side and does " + super.getDmg() + " damage to you.");
    }

    public void printHit() {
        System.out.println(getName() + " slips with his fingers on the bow and does weakly " + super.getDmg() + " damage to you.");
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
