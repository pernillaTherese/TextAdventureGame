package com.pernillaTherese;

import com.pernillaTherese.Enemies.Boar;
import com.pernillaTherese.Enemies.Enemy;
import com.pernillaTherese.Enemies.Troll;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ActionBoard {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    StoryLine s1 = new StoryLine();


    Player player;
    Enemy enemy = new Boar("Black Boar",150,150,150,75,2);
    ArrayList<Enemy> forestEnemyList = addForestEnemies();
    ArrayList<Enemy> meadowEnemyList = addMeadowEnemies();
    ArrayList<Enemy> riverEnemyList = addRiverEnemies();

    //Here's where it all happens
    public ActionBoard() {

        s1.storyIntroduction();
        mainMenue();

    }

    //Fighting as long as no one is dead
    public void fight(Player player, Enemy enemy) {

        while (!player.isDead() && !enemy.isDead()) {
            player.meleeAttack(getPlayer().getDagger(), getEnemy());
            enemy.attack(getPlayer());

            if(!player.isDead() && !enemy.isDead()) {
                actionMenue();
                continue;
            } else if(player.isDead()) {
                deadMenue();
            } else {
                promptEnter();
                if(player.isReachChapter2()){
                    s1.firstMeadow();
                    player.setReachChapter2(false);
                    promptEnter();
                }
                if(player.isReachChapter3()){
                    s1.firstRiver();
                    player.setReachChapter3(false);
                    promptEnter();
                }
                if(player.getLvl() == 10) {
                    mainMenue();
                }
            }
        }
        enemy.setDead(false);
        enemy.setHp(enemy.getMaxHp());
        createEnemy();
    }

    //Main menue
    public void mainMenue() {
        System.out.println
                ("** [1] NEW GAME * [2] EXIT GAME  **\n");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                createPlayer();
                promptEnter();
                s1.storyInitialize();
                promptEnter();
                s1.firstChapter();
                promptEnter();
                s1.firstEnemy();
                actionMenue();
                break;
            case 2:
                System.out.println("** GAME OVER **");
                break;
        }
    }

    //Keeps the fight going.
    public void actionMenue() {
        System.out.println("[A]ttack | [B]oost");
        String choice = sc.next();
        switch (choice) {
            case "A":
            case "a":
                fight(player,enemy);
                break;
            case "B":
            case "b":
                player.boosting(player.getBoostHp());
                promptEnter();
                fight(player,enemy);
                break;
        }
    }

    //Pops up when dead
    public void deadMenue() {
        if (getPlayer().getLvl() == 1) {
            System.out.println("You're to unexperienced to time travel. You'll have to start from the beginning\n" +
                    "** GAME OVER **");
            mainMenue();
        } else {
            System.out.println("" +
                    "What will you do?\n" +
                    "[T]ime travel back to life | [M]ain Menue (GAME OVER)\n");

            String choice = sc.next();
            switch (choice) {
                case "T":
                case "t":
                    player.rezurrection();
                    break;
                case "M":
                case "m":
                    mainMenue();
                    break;
            }
        }
    }

    // Asks for ENTER to continue story
    public void promptEnter() {

        System.out.println("[Press Enter to continue]");
        try {
            System.in.read();
        } catch(Exception e) {

        }
    }

    // Random enemies depending on environment and player level. 10% chance that no enemy appears.>
    public void createEnemy(){
        boolean noEnemy = random.nextInt(9) == 0;
        if(noEnemy){
            addEnvironment();
        }else {
            if (getPlayer().getLvl() <= 3) {
                System.out.println("player level 1-3 " + getPlayer().getLvl());
                int chance = random.nextInt(getForestEnemyList().size());
                Enemy e = getForestEnemyList().get(chance);
                this.enemy = e;
                if (e instanceof Boar) {
                    System.out.println("You're standing face to face with a " + getEnemy().getName() + ". It looks disturbed by your presence.\n");
                } else if (e instanceof Troll) {
                    System.out.println("A hideous " + getEnemy().getName() + " is sneaking around you behind the trees. He smells like crap!\n");
                }
            } else if ((getPlayer().getLvl()) > 3 && (getPlayer().getLvl()) < 7) {
                System.out.println("player level 4-6 " + getPlayer().getLvl());
                int chance = random.nextInt(getMeadowEnemyList().size());
                Enemy e = getMeadowEnemyList().get(chance);
                this.enemy = e;
                if (e instanceof Boar) {
                    System.out.println("You're standing face to face with a " + getEnemy().getName() + ". It looks disturbed by your presence.\n");
                } else if (e instanceof Troll) {
                    System.out.println("A hideous " + getEnemy().getName() + " is sneaking around you behind the trees. He smells like crap!\n");
                }
            } else if ((getPlayer().getLvl()) > 6 && (getPlayer().getLvl()) < 10) {
                System.out.println("player level 7-9 " + getPlayer().getLvl());
                int chance = random.nextInt(getRiverEnemyList().size());
                Enemy e = getRiverEnemyList().get(chance);
                this.enemy = e;
                if (e instanceof Boar) {
                    System.out.println("You're standing face to face with a " + getEnemy().getName() + ". It looks disturbed by your presence.\n");
                } else if (e instanceof Troll) {
                    System.out.println("A hideous " + getEnemy().getName() + " is sneaking around you behind the trees. He smells like crap!\n");
                }
            }
        }
            actionMenue();

    }

    // Asks for nickname and creates the player. >
    public void createPlayer() {
        sc.nextLine();
        System.out.println("What's the name of your character?");
        player = new Player(sc.nextLine());
        System.out.println("\nGood Luck " + player.getName() + "!");
        System.out.println("This is your character sheet:\n");
        player.charMenue();

    }

    //<Random storytexts depending on environment.  Forest lvl 1-3, Meadow lvl 4-6, River lvl 7-9.>
    public void addEnvironment() {
        if(getPlayer().getLvl() <= 3) {
            s1.randForest();
        } else if(getPlayer().getLvl() <= 6) {
            s1.randMeadow();
        } else if(getPlayer().getLvl() <= 9) {
            s1.randRiver();
        }
        promptEnter();
        createEnemy();
    }

    public ArrayList<Enemy> addForestEnemies() {
        ArrayList<Enemy> forestEnemyList = new ArrayList<>();
        forestEnemyList.add(new Troll("Senil Tribe Troll", 190,190,190,80,4));
        forestEnemyList.add(new Boar("Uggly-as-Hell Boar",185,185,185,90,5));
        forestEnemyList.add(new Boar("Big Black Boar",150,150,150,75,3));
        return forestEnemyList;
    }

    public ArrayList<Enemy> addMeadowEnemies() {
        ArrayList<Enemy> meadowEnemyList = new ArrayList<>();
        meadowEnemyList.add(new Troll("Meadow Troll", 600,600,190,80,4));
        meadowEnemyList.add(new Boar("Meadow Boar",550,550,185,90,5));
        return meadowEnemyList;
    }

    public ArrayList<Enemy> addRiverEnemies() {
        ArrayList<Enemy> riverEnemyList = new ArrayList<>();
        riverEnemyList.add(new Troll("River Troll", 600,600,190,80,4));
        riverEnemyList.add(new Boar("River Boar",550,550,185,90,5));
        return riverEnemyList;
    }


    //GETTERS/SETTERS
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public ArrayList<Enemy> getForestEnemyList() {
        return forestEnemyList;
    }

    public ArrayList<Enemy> getMeadowEnemyList() {
        return meadowEnemyList;
    }

    public ArrayList<Enemy> getRiverEnemyList() {
        return riverEnemyList;
    }
}
