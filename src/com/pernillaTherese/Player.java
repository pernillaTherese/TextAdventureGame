package com.pernillaTherese;

import com.pernillaTherese.Enemies.Enemy;
import com.pernillaTherese.Weapons.Dagger;

import java.util.Random;


public class Player {
    String name;
    private Dagger dagger;
    private Booster booster;
    private BoostHP boostHp;
    private int lvl; //1-10 When 10, ready for bossfight and then game is won.
    private int xp; //0-100 When 100 increase lvl. Incr when killing monster. Amount depends on monster.
    private int maxHp;
    private int lastLvlMaxHp;
    private int hp; //Incr. 10% each lvl + pots.
    private int averageDmg; //weaponDmg with hitChance
    private int dmg;
    private int hitChanceMelee;
    private int critChance;
    private boolean reachChapter2;
    private boolean reachChapter3;
    private boolean isDead;


    int choice;

    public Player(String name) {
        this.name = name;
        lvl = 1;
        xp = 0;
        maxHp = 1000;
        hp = 1000;
        hitChanceMelee = 80;
        critChance = 5;
        reachChapter2 = false;
        reachChapter3 = false;
        isDead = false;
        dagger = new Dagger("Flintstone dagger", 1, 200);
        boostHp = new BoostHP("Shamans healing potion",500,3);

    }


    public int meleeAttack(Dagger dagger, Enemy enemy) { //requires a dagger
        Random percentCal = new Random();
        setAverageDmg(dagger.getWeaponDmg());
        if (!enemy.isDead() && !isDead) {

            //Hit or miss based on hitchance
            int hit = 1 + percentCal.nextInt(100);
            if (hit > hitChanceMelee) {
                dmg = 0;
                System.out.println("You miss and do " + dmg + " damage to " + enemy.getName());
            } else {

                //Random damage done, crit is everything over 100%
                int randDamage = percentCal.nextInt((critChance + 100)); //random increases with critchance

                if (randDamage >= 100) {
                    double dmgTemp = (getAverageDmg() * 1.2); //crit, lvl 1 240 dmg, lvl 2 264 dmg, lvl 3 288 dmg
                    dmg = (int) dmgTemp;
                    System.out.println("You **CRIT** " + enemy.getName() + " with " + dmg + " damage.");

                } else if (randDamage >= 85) {
                    double dmgTemp = getAverageDmg() + percentCal.nextDouble((averageDmg * 1.1) - averageDmg); //strong hit, lvl 1 200-220 dmg, lvl 2 220-242 dmg, lvl 3 240-264 dmg
                    dmg = (int) dmgTemp;
                    System.out.println("You hit " + enemy.getName() + " strongly with " + dmg + " damage.");

                } else if (randDamage >= 15) {
                    double dmgTemp = (getAverageDmg() * 0.95) + percentCal.nextDouble((averageDmg * 1.05) - (averageDmg * 0.95)); //medium hit, lvl 1 190-210 dmg, lvl 2 209-231 dmg, lvl 3 228-252 dmg
                    dmg = (int) dmgTemp;
                    System.out.println("You hit " + enemy.getName() + " with " + dmg + " damage.");

                } else if (randDamage >= 0) {
                    double dmgTemp = (getAverageDmg() * 0.9); //weak hit, lvl 1 180 dmg, lvl 2 198 dmg, lvl 3 216 dmg
                    dmg = (int) dmgTemp;
                    System.out.println("You hit " + enemy.getName() + " weakly with " + dmg + " damage.");

                }
            }

            enemy.takeDamage(dmg); //enemy loose health equals to players dmg.
            System.out.println("Your health: " + hp + " | " + enemy.getName() + "'s health: " + enemy.getHp() + "\n");

            if(enemy.isDead()){ //if enemy dies, plus xp, regain health
                System.out.println("** " + enemy.getName() + " IS DEAD! **");
                System.out.println("** You gained " + enemy.getGIVEXP() + " experience from killing " + enemy.getName() + "! **\n");
                System.out.println("You take care of your wounds and gain your health back to " + maxHp);
                setHp(maxHp);
                xpUp(enemy); // if xp hits maximum, level up.

            }
        }
        return dmg;
    }

    public int takeDamage(int dmg) {
        hp = hp - dmg;
        if(hp<=0) {
            hp=0;
            isDead = true;
            System.out.println("\n** OH NO! ** YOU ARE SO DEAD! **\n");
        }
        return hp;
    }

    public void rezurrection() {
        this.lvl--;
        this.xp = 0;
        //double maxHpTemp = (getMaxHp()/1.1);
        this.maxHp = getLastLvlMaxHp();
        this.hp = maxHp;
        this.isDead = false;

        System.out.println("" +
                "** TIME TRAVELLING BACK TO LIFE **\n" +
                "** You travelled back in time till the day before and understand that you need to learn more. **\n" +
                "** You are now back to day " + getLvl() + " **\n" +
                "** Your maximum health decreased to " + getMaxHp() + " from the bad injuries **\n");
        System.out.println("Your health: " + hp + "\n");
    }

    public void levelUp() { //when xp hits 100 lvl up
        if(getLvl()<10) {
            this.lvl++;
            this.lastLvlMaxHp = getMaxHp();
            double maxHpTemp = getMaxHp() * 1.1;
            this.maxHp = (int) maxHpTemp;

            if(getLvl() < 10) {
                System.out.println("" +
                        "*********************   DING!   ********************\n" +
                        "** A day has past and you make camp for the night.**\n" +
                        "** ZZZZ [SLEEPING ALL NIGHT LONG] ZZZZ **\n" +
                        "** You're now on day " + getLvl() + "! **\n" +
                        "** Your maximum health increased to " + getMaxHp() + " **\n");
            }else if(getLvl()==10) {
                System.out.println("" +
                    "******** A day has past and you make camp for the night.********\n" +
                    "************** ZZZZ [SLEEPING ALL NIGHT LONG] ZZZZ *************\n" +
                    "****************************************************************\n" +
                    "********************** CONGRATULATIONS! ************************\n" +
                    "** You made it to day TEN and can now go back to the village! **\n" +
                    "****************************************************************\n");
            }


        }
        if(getLvl() == 4) {
            reachChapter2 = true;
        }
        if(getLvl() == 7) {
            reachChapter3 = true;
        }
    }

    public int xpUp(Enemy enemy) { //when killing a monster
        xp = xp+ enemy.getGIVEXP();
        if(getXp()>= getLvl()*100) {
            levelUp();
        }
        return xp;
    }

    public void boosting(Booster booster) {
        if(booster instanceof BoostHP) {
            if (getBoostHp().numberOf > 0) {
                int hpPlus = boostHp.plusHp;
                if (hpPlus >= getMaxHp() - getHp()) {
                    hpPlus = getMaxHp() - getHp();
                    setHp(getMaxHp());
                    System.out.println("Your " + getBoostHp().name + " heal you with " + hpPlus + " health. (" + (boostHp.plusHp - hpPlus) + " Hp Overhealed)");
                } else {
                    setHp(getHp() + hpPlus);
                    System.out.println("Your " + getBoostHp().name + " heal you with " + hpPlus + " health.");
                }
                getBoostHp().numberOf--;
                System.out.println("Your health is now: " + getHp() + "\n");
            } else {
                System.out.println("You're out of healing boosters.");
            }
        }
    }

    public void charMenu() {
        System.out.println("** " + getName() + " **");
        System.out.println("Level: " + getLvl());
        System.out.println("Current Health: " + getHp());
        System.out.println("Max Health: " + getMaxHp());
        System.out.println("Chance to critically strike: " + getCritChance());
        System.out.println("Chance to hit with melee: " + getHitChanceMelee());
        System.out.println("Equipped weapon: " + getDagger().getName());
        System.out.println("Boosters: " + getBoostHp().getName() + ", +" + getBoostHp().getPlusHp() + "Hp, Amount: " + getBoostHp().getNumberOf() + "\n");
    }

    //GETTERS, SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(Enemy enemy) {
        this.xp = xp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHitChanceMelee() {
        return hitChanceMelee;
    }

    public void setHitChance(int hitChanceMelee) {
        this.hitChanceMelee = hitChanceMelee;
    }

    public boolean isDead() {
        return isDead;
    }

    public Dagger getDagger() {
        return dagger;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getChoice() {
        return choice;
    }

    public int getAverageDmg() {
        return averageDmg;
    }

    public void setAverageDmg(int averageDmg) {
        this.averageDmg = averageDmg;
    }

    public BoostHP getBoostHp() {
        return boostHp;
    }

    public Booster getBooster() {
        return booster;
    }

    public boolean isReachChapter2() {
        return reachChapter2;
    }

    public void setReachChapter2(boolean reachChapter2) {
        this.reachChapter2 = reachChapter2;
    }

    public boolean isReachChapter3() {
        return reachChapter3;
    }

    public void setReachChapter3(boolean reachChapter3) {
        this.reachChapter3 = reachChapter3;
    }

    public int getLastLvlMaxHp() {
        return lastLvlMaxHp;
    }

    public void setLastLvlMaxHp(int lastLvlMaxHp) {
        this.lastLvlMaxHp = lastLvlMaxHp;
    }
}
