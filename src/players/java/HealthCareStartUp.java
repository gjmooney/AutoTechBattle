package players.java;

import attacks.java.AttackStrategy;

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
    void setAttackStrategy(AttackStrategy strategy) {

    }

    @Override
    void doAttack() {

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
