package com.pernillaTherese;

//Boosters can be used while fighting

public class Booster {

    private String name;
    private int numberOf;

    public Booster(String name, int plusHp, int numberOf) {
        this.name = name;
        this.numberOf = numberOf;
    }

    //GETTERS, SETTERS,ToSTRINGS
    public String getName() {
        return name;
    }

    public int getNumberOf() {
        return numberOf;
    }

    @Override
    public String toString() {
        return name;
    }
}
