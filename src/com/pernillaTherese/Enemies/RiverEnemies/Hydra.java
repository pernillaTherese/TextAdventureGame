package com.pernillaTherese.Enemies.RiverEnemies;

import com.pernillaTherese.Enemies.Enemy;
import com.pernillaTherese.Player;

public class Hydra extends Enemy {
    public Hydra(String name, int maxHp, int hp, int averageDmg, int hitChance, int critChance) {
        super(name, maxHp, hp, averageDmg, hitChance, critChance);
    }

    @Override
    public int attack(Player player) {
        return super.attack(player);
    }


    public void printMiss() {
        System.out.println(getName() + " tries to spray poison on you but chokes and does " + super.getDmg() + " damage to you.");
    }

    public void printCrit() {
        System.out.println(getName() + " bites you with all of its mouths at once and **CRITS** you with " + super.getDmg() + " damage and\n" +
                "leaves several bleeding wounds all over your body.");
    }

    public void printStrong() {
        System.out.println(getName() + " bites deep into your flesh and does " + super.getDmg() + " damage to you.");
    }

    public void printHit() {
        System.out.println(getName() + " gets its heads tangled up and does weakly " + super.getDmg() + " damage to you.");
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
