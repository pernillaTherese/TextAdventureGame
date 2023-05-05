package com.pernillaTherese;

public class BoostHP extends Booster {
    String name;
    int plusHp;
    int numberOf;

    public BoostHP(String name, int plusHp, int numberOf) {
        super(name, plusHp, numberOf);
        this.name = name;
        this.plusHp = plusHp;
        this.numberOf = numberOf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlusHp() {
        return plusHp;
    }

    public void setPlusHp(int plusHp) {
        this.plusHp = plusHp;
    }

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }
}
