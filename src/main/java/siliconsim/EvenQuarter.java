package main.java.siliconsim;

import main.java.siliconsim.players.TechGiant;

public class EvenQuarter extends Cycle {

    @Override
    public void doQuarterEvent(int quarter, TechGiant techGiant) {
        System.out.println("even");
        if (quarter == 1) {
            QuarterEvents.financialCrisis();
        }
        if (quarter == 3) {
            QuarterEvents.lobbying();
        }

    }
}
