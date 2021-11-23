package main.java.siliconsim.players;

import main.java.siliconsim.OddQuarterStrategy;

import java.util.LinkedList;

public abstract class TechGiant {
    String name;
    Type type;
    int totalRevenue = 0;
    LinkedList<StartUp> startUps;
    private OddQuarterStrategy oddQuarterStrategy;

    /**
     * Acquire new start ups.
     */
    public void rally() {

    }

    /**
     * Add a new start up to tech giants portfolio.
     * @param startUp start up to add
     */
    public void addStartUp(StartUp startUp) {
        startUp.setOwner(this);
        startUps.add(startUp);
    }

    public void removeStartUp(StartUp startUp) {
        startUps.remove(startUp);
        startUp.setOwner(null);
    }

    /**
     * Calculate total revenue.
     */
    public void calcTotalRevenue() {
        for (StartUp startUp : startUps) {
            totalRevenue += startUp.getMaxHealth();
        }
    }

    public OddQuarterStrategy getOddQuarterStrategy() {
        return oddQuarterStrategy;
    }

    public void setOddQuarterStrategy(OddQuarterStrategy oddQuarterStrategy) {
        this.oddQuarterStrategy = oddQuarterStrategy;
    }

    public LinkedList<StartUp> getStartUps() {
        return startUps;
    }

    public String getName() {
        return name;
    }
}
