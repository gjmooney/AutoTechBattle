package players.java;

import attacks.java.AttackStrategy;

public class RealEstateStartUp extends StartUp {

    public RealEstateStartUp() {
        this.name = "Real Estate";
        this.type = Type.REAL_ESTATE;
        this.owner = null;
        this.level = 1;
        this.netIncome = 50;
        this.revenue = 100;
        this.marketShare = 150;
    }

    public RealEstateStartUp(String name) {
        this.name = name;
        this.type = Type.REAL_ESTATE;
        this.owner = null;
        this.level = 1;
        this.netIncome = 50;
        this.revenue = 100;
        this.marketShare = 150;
    }
}

