package main.java.siliconsim;

public class EvenQuarter extends Cycle {


    @Override
    public void doQuarterEvent(int quarter) {
        System.out.println("even");
        if (quarter == 1) {
            QuarterEvents.financialCrisis();
        }
        if (quarter == 3) {
            QuarterEvents.lobbying();
        }

    }
}
