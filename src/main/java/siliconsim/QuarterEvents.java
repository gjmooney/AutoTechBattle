package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;

public class QuarterEvents {

    /**
     * Tax Cuts give a boost to the revenue of every start up
     */
    public static void taxCuts() {
        for (StartUp su : GameLogic.getAllStartUps()) {
            su.setHealth((int) Math.ceil(su.getHealth() * 1.2));
        }
    }

    public void financialCrisis() {

    }

    public void monopolyBusting() {

    }

    public void lobbying() {

    }
}
