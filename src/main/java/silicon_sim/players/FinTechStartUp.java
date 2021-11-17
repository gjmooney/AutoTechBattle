package main.java.silicon_sim.players;

import main.java.silicon_sim.attacks.AttackStrategy;

public class FinTechStartUp extends StartUp{

    public FinTechStartUp() {
        super();
        this.setName("Fin Tech");
        this.setType(Type.FIN_TECH);
        this.setNetIncome(50);
        this.setRevenue(200);
        this.setMarketShare(50);
    }

    public FinTechStartUp(String name) {
        super();
        this.setType(Type.FIN_TECH);
        this.setNetIncome(50);
        this.setRevenue(200);
        this.setMarketShare(50);
    }
}
