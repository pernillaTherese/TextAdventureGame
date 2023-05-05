package com.pernillaTherese;

import java.util.Random;

public class StoryLine {

    public StoryLine() {

    }
    public void storyIntroduction() {
        System.out.println(""+
                "\n" +
                "=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=\n" +
                "=                                                                                                 =\n" +
                "=                                 THE HERMIT TRIAL OF THE VINGHU                                  =\n" +
                "=                                                                                                 =\n" +
                "=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=\n");
        System.out.println("" +
                "In this story, you get to be a 14 year old youth, born and raised among the people of the Vinghu.\n" +
                "You are about to take out for a ten day trial, alone in the wilderness. When you come back to your\n" +
                "people ( ...if you come back...) you will be considered an adult and a warrior of your tribe.\n\n" +
                "=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=\n");

    }

    public void storyInitialize() {
        System.out.println(""+
            "You leave the big feast that has been held in your honor, to bring you luck in the great trial to come.\n" +
            "You hear drums beating and people who are singing and laughing. You feel the warmth and comfort from the\n" +
            "big campfire, the one that you're about to leave behind you. For ten days and nights, you will have to be,\n" +
            "totally on your own. Surviving. All to prove that you're worthy to be treated as an adult and a warrior.\n\n" +
            "Your family and closest friends brought you gifts to get you started on you journey.\n" +
            "You got a backpack from your sister, beautifully braided from diffrent kinds of grass.\n" +
            "In the backpack you've put your other gifts: A flintstone knife, some bean bread, a couple of bandages \n" +
            "and for emergencies, 3 bottles of the shamans healingpotions.\n\n" +
            "The sun is on it's way down, so your first accomplishment must be to find somewhere to spend the night.\n\n" +
            "=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=_=\n");
    }

    public void firstChapter() {
        System.out.println(""+
             "You head into to forest. So far, you know your way. It's practically home. You know about a cave further in,\n" +
             "wich you've visited together with your father many years ago. It should'nt take more than a couple of hours\n" +
             "to reach it.\n\n");
    }

    public void firstEnemy() {
        System.out.println(""+
                "Suddenly you hear a grunting noice and shortly after, cracking branches and heavy steps coming towards you.\n"+
                "You stand face to face with a big black boar. One of it's tusks is broken but the other one looks pretty\n" +
                "hurtful.");
    }

    public void firstMeadow() {
        System.out.println("You have come to a meadow. You stand by it's border and look out over the plain wich\n" +
                "is filled with wild flowers and you stop for a while to watch the bumblebees and butterflies dance\n" +
                "among them.");
    }

    public void firstRiver() {
        System.out.println("You have reached the river. The wild river of Hanghal! It's wide, wild and according to\n" +
                "the fairytales, filled with seamonsters.");
    }

    public void randForest() {
        String forestIntro1 = "You are getting deeper into the forest. It's silent and dark. When you look up, you see\n" +
                "nothing but treetops.";
        String forestIntro2 = "You've reached a forest lake. It's peaceful and beautiful with water lilys floating on\n" +
                "the surface. You sit down to rest for a moment.";
        String riverIntro3 = "You've come to a small glade surrounded by tall trees. How nice to be able to see the sky again.";

        Random percentCal = new Random();
        int rand = 1 + percentCal.nextInt(3);
        if(rand == 1) {
            System.out.println(forestIntro1);
        }else if(rand == 2) {
            System.out.println(forestIntro2);
        }else if(rand == 3) {
            System.out.println(riverIntro3);
        }
    }
    public void randMeadow() {
        String meadowIntro1 = "You strife along the border of the meadow, enjoying the sun on your face.";
        String meadowIntro2 = "You stop for a while to watch a hare jumping about among the tall grass.";
        String meadowIntro3 = "You find a nice round boulder on wich you sit down for a while to rest.";

        Random percentCal = new Random();
        int rand = 1 + percentCal.nextInt(3);
        if(rand == 1) {
            System.out.println(meadowIntro1);
        }else if(rand == 2) {
            System.out.println(meadowIntro2);
        }else if(rand == 3) {
            System.out.println(meadowIntro3);
        }
    }

    public void randRiver() {
        String riverIntro1 = "You see seashells laying about on the river beach. You collect some of them.";
        String riverIntro2 = "You take of your leather sandals to feel the sand between your toes. How you wish it would\n" +
                "be safe to swim in this water.";
        String riverIntro3 = "You spot a small lizard that quickly rushes into the reed.";

        Random percentCal = new Random();
        int rand = 1 + percentCal.nextInt(3);
        if(rand == 1) {
            System.out.println(riverIntro1);
        }else if(rand == 2) {
            System.out.println(riverIntro2);
        }else if(rand == 3) {
            System.out.println(riverIntro3);
        }
    }
}
