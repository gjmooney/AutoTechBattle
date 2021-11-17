package main.java.siliconsim.attacks;

import main.java.siliconsim.players.Type;

public class UndercutPriceAttack implements AttackStrategy{
    Type type = Type.REAL_ESTATE;

    @Override
    public int attack(int netIncome) {
        return netIncome * 3;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Undercut Price Attack";
    }
}

