package main.java.silicon_sim;

public abstract class Cycle {
    static int quarter;

    public static void doQuarterEvent(int quarter) {
        switch (quarter) {
            case 1:
                QuarterEvents.taxCuts();
                break;
        }
    }

    public static void setQuarter(int quarter) {
        Cycle.quarter = quarter;
    }
    
    public static int getQuarter() {
        return quarter;
    }

    public void incrementQuarter() {
        quarter++;
    }


}
