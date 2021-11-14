package players.java;

import main.java.AttackStrategy;
import main.java.Type;

public class HealthCareStartUp extends StartUp{

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

    @Override
    void attack(AttackStrategy strategy) {

    }

    @Override
    void getAttacked(StartUp attacker) {

    }

    @Override
    void battleOver() {

    }

    @Override
    void evolve() {

    }
}
