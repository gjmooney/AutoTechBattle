package players.java;

import attacks.java.AttackStrategy;

public class FinTechStartUp extends StartUp{

    public FinTechStartUp() {
        this.name = "Real Estate";
        this.type = Type.FIN_TECH;
        this.owner = null;
        this.level = 1;
        this.netIncome = 50;
        this.revenue = 200;
        this.marketShare = 50;
    }

    public FinTechStartUp(String name) {
        this.name = name;
        this.type = Type.FIN_TECH;
        this.owner = null;
        this.level = 1;
        this.netIncome = 50;
        this.revenue = 200;
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
