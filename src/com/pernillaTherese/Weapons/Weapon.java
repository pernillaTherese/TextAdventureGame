package com.pernillaTherese.Weapons;

public class Weapon {
    private String name;
    private int lvl;
    private int weaponDmg;
    private boolean melee;
    private boolean ranged;

    public Weapon(String name, int lvl, int weaponDmg) {
        this.name = name;
        this.lvl = lvl;
        this.weaponDmg = weaponDmg;
    }

    //GETTERS, SETTERS,ToSTRINGS
    public int getWeaponDmg() {
        return weaponDmg;
    }


    @Override
    public String toString() {
        return name;
    }
}

