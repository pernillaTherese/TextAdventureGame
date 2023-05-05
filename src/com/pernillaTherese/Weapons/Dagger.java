package com.pernillaTherese.Weapons;

public class Dagger extends Weapon{
    private String name;
    private int lvl;
    private int weaponDmg;
    private boolean melee;
    private boolean ranged;


    public Dagger(String name, int lvl, int weaponDmg) {
        super(name, lvl, weaponDmg);
        this.name = name;
        this.lvl = lvl;
        this.weaponDmg = weaponDmg;
        final boolean melee = true;
        final boolean ranged = false;
    }

    //GETTERS, SETTERS,ToSTRINGS
    public int getWeaponDmg() {
        return weaponDmg;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
