package main.java.silicon_sim.players;

import java.util.LinkedList;

public abstract class TechGiant {
    String name;
    Type type;
    int totalRevenue = 0;
    LinkedList<StartUp> startUps;
    public static LinkedList<TechGiant> techGiants = new LinkedList<TechGiant>();

    /**
     * Acquire new start ups
     */
    public abstract void rally();

    public void addStartUp(StartUp startUp) {
        startUp.setOwner(this.name);
        startUps.add(startUp);
    }

    /**
     * Calculate total revenue
     */
    public void calcTotalRevenue() {
        for (StartUp startUp : startUps) {
            totalRevenue += startUp.getRevenue();
        }
    }

    public LinkedList<StartUp> getStartUps() {
        return startUps;
    }
}
