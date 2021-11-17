package main.java.silicon_sim.players;

import main.java.silicon_sim.attacks.AttackStrategy;

public class HealthCareStartUp extends StartUp {

    public HealthCareStartUp() {
        super();
        this.setName("Health Care");
        this.setType(Type.HEALTH_CARE);
        this.setNetIncome(100);
        this.setRevenue(100);
        this.setMarketShare(100);
    }

    public HealthCareStartUp(String name) {
        super();
        this.setType(Type.HEALTH_CARE);
        this.setNetIncome(100);
        this.setRevenue(100);
        this.setMarketShare(100);
    }
}
