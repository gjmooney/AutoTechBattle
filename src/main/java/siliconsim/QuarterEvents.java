package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;

public class QuarterEvents {

    /**
     * Tax Cuts give a boost to the revenue of every start up.
     */
    public static void taxCuts() {
        for (StartUp su : GameLogic.getLogic().getAllStartUps()) {
            su.setMaxRevenue((int) Math.ceil(su.getMaxRevenue() * 1.2));
            su.setCurrentRevenue(su.getMaxRevenue());
        }
    }

    /**
     * Financial crisis reduces Market Share and Net Income of all non-fin-tech start-ups.
     */
    public static void financialCrisis() {
        for (StartUp su : GameLogic.getLogic().getAllStartUps()) {
            if (!su.getType().toString().equals("FIN_TECH")) {
                su.setMarketShare((int) Math.ceil(su.getMarketShare() * 0.8));
                su.setNetIncome((int) Math.ceil(su.getNetIncome() * 0.8));
            }
        }
    }

    /**
     * Reduce revenue for start-ups with more than 300 market share raise it otherwise.
     */
    public static void monopolyBusting() {
        for (StartUp su : GameLogic.getLogic().getAllStartUps()) {
            if (su.getMarketShare() > 300) {
                su.setMaxRevenue((int) Math.ceil(su.getMaxRevenue() * 0.8));
                su.setCurrentRevenue(su.getMaxRevenue());
            } else {
                su.setMaxRevenue((int) Math.ceil(su.getMaxRevenue() * 1.2));
                su.setCurrentRevenue(su.getMaxRevenue());
            }
        }
    }

    /**
     * Increase Market Share.
     */
    public static void lobbying() {
        for (StartUp su : GameLogic.getLogic().getAllStartUps()) {
            su.setMarketShare((int) Math.ceil(su.getMarketShare() * 1.2));
        }
    }
}
