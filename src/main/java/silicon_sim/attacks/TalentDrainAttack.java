package main.java.silicon_sim.attacks;

import main.java.silicon_sim.players.Type;

public class TalentDrainAttack implements AttackStrategy{
    Type type = Type.FIN_TECH;

    @Override
    public int attack(int netIncome) {
        return netIncome * 2;
    }

    @Override
    public Type getType() {
        return type;
    }
}
