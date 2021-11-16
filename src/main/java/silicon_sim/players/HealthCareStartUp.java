package main.java.silicon_sim.players;

import main.java.silicon_sim.attacks.AttackStrategy;

public class HealthCareStartUp extends StartUp {

    public HealthCareStartUp() {
        this.name = "Real Estate";
        this.type = Type.HEALTH_CARE;
        this.owner = null;
        this.level = 1;
        this.netIncome = 50;
        this.revenue = 100;
        this.marketShare = 150;
    }

    public HealthCareStartUp(String name) {
        this.name = name;
        this.type = Type.HEALTH_CARE;
        this.owner = null;
        this.level = 1;
        this.netIncome = 200;
        this.revenue = 50;
        this.marketShare = 50;
    }
}
