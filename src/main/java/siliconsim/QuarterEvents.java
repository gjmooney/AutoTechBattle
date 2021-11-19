package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;

public class QuarterEvents {

    /**
     * Tax Cuts give a boost to the revenue of every start up
     */
    public static void taxCuts() {
        System.out.println("tax cuts");
        for (StartUp su : GameLogic.getLogic().getAllStartUps()) {
            su.setHealth((int) Math.ceil(su.getHealth() * 1.2));
        }
    }

    public static void financialCrisis() {
        System.out.println("financial crisis");
    }

    public static void monopolyBusting() {
        System.out.println("monopoly busting");

    }

    public static void lobbying() {
        System.out.println("lobbying");

    }
}
