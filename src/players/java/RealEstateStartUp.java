package players.java;

import main.java.AttackStrategy;
import main.java.Type;

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

    @Override
    public void attack(AttackStrategy strategy) {

    }

    @Override
    public void getAttacked(StartUp attacker) {

    }

    @Override
    public void battleOver() {

    }

    @Override
    public void evolve() {

    }
}

