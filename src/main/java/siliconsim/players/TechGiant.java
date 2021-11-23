package main.java.siliconsim.players;

import java.util.LinkedList;
import main.java.siliconsim.OddQuarterStrategy;

public abstract class TechGiant {
    private String name;
    private Type type;
    private int totalRevenue = 0;
    private LinkedList<StartUp> startUps;
    private OddQuarterStrategy oddQuarterStrategy;
    private boolean catchWildStartUp;

    /**
     * Basic constructor for tech giants.
     */
    public TechGiant() {
        this.setStartUps(new LinkedList<>());
        this.setCatchWildStartUp(false);
    }

    /**
     * Tech giant constructor to set name.
     * @param name Name of tech giant
     */
    public TechGiant(String name) {
        this.setName(name);
        this.setStartUps(new LinkedList<>());
        this.setCatchWildStartUp(false);
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(int totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public void setStartUps(LinkedList<StartUp> startUps) {
        this.startUps = startUps;
    }

    public boolean isCatchWildStartUp() {
        return catchWildStartUp;
    }

    public void setCatchWildStartUp(boolean catchWildStartUp) {
        this.catchWildStartUp = catchWildStartUp;
    }
}
