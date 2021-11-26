package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;

public class QuarterEvents {

    /**
     * Tax Cuts give a boost to the revenue of every start up.
     */
    public static void taxCuts() {
        for (StartUp su : GameLogic.getLogic().getAllStartUps()) {
            su.setMaxHealth((int) Math.ceil(su.getMaxHealth() * 1.2));
            su.setCurrentHealth(su.getMaxHealth());
        }
    }

    /**
     * Financial crisis reduces Market Share and Net Income of all non-fin-tech start-ups
     */
    public static void financialCrisis() {
        for (StartUp su : GameLogic.getLogic().getAllStartUps()) {
            if (!su.getType().toString().equals("FIN_TECH")) {
                su.setDefense((int) Math.ceil(su.getDefense() * 0.8));
                su.setAttack((int) Math.ceil(su.getAttack() * 0.8));
            }
        }
    }

    /**
     * Reduce revenue for start-ups with more than 300 market share raise it otherwise
     */
    public static void monopolyBusting() {
        for (StartUp su : GameLogic.getLogic().getAllStartUps()) {
            if (su.getDefense() > 300) {
                su.setMaxHealth((int) Math.ceil(su.getMaxHealth() * 0.8));
                su.setCurrentHealth(su.getMaxHealth());
            } else {
                su.setMaxHealth((int) Math.ceil(su.getMaxHealth() * 1.2));
                su.setCurrentHealth(su.getMaxHealth());
            }
        }
    }

    /**
     * Increase Market Share
     */
    public static void lobbying() {
        for (StartUp su : GameLogic.getLogic().getAllStartUps()) {
            su.setDefense((int) Math.ceil(su.getDefense() * 1.2));
        }
    }
}
