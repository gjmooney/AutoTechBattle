package main.java.silicon_sim;

import main.java.silicon_sim.players.StartUp;
import main.java.silicon_sim.players.TechGiant;

public class QuarterEvents {

    /**
     * Tax Cuts give a boost to the revenue of every start up
     */
    public static void taxCuts() {
        for (TechGiant tg : TechGiant.techGiants) {
            for (StartUp su : tg.getStartUps()) {
                su.setRevenue((int) Math.ceil(su.getRevenue() * 1.2));
            }
        }
    }

    public void financialCrisis() {

    }

    public void monopolyBusting() {

    }

    public void lobbying() {

    }
}
