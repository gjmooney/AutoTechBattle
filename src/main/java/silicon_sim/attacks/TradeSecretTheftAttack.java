package main.java.silicon_sim.attacks;

import main.java.silicon_sim.players.Type;

public class TradeSecretTheftAttack implements AttackStrategy{
    Type type = Type.OPERATING_SYSTEM;

    @Override
    public int attack(int netIncome) {
        return netIncome * 5;
    }

    @Override
    public Type getType() {
        return type;
    }
}
