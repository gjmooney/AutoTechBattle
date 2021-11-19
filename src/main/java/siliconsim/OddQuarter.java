package main.java.siliconsim;

public class OddQuarter extends Cycle {

    @Override
    public void doQuarterEvent(int quarter) {
        System.out.println("odd");
        if (quarter == 0) {
            QuarterEvents.taxCuts();
        }
        if (quarter == 2) {
            QuarterEvents.monopolyBusting();
        }

    }
}
