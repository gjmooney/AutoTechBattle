package main.java.silicon_sim.players;

import main.java.silicon_sim.attacks.AttackStrategy;

public class RealEstateStartUp extends StartUp {

    public RealEstateStartUp() {
        super();
        this.setName("Real Estate");
        this.setType(Type.REAL_ESTATE);
        this.setNetIncome(150);
        this.setRevenue(100);
        this.setMarketShare(50);
    }

    public RealEstateStartUp(String name) {
        super();
        this.setType(Type.REAL_ESTATE);
        this.setNetIncome(150);
        this.setRevenue(100);
        this.setMarketShare(50);
    }
}

