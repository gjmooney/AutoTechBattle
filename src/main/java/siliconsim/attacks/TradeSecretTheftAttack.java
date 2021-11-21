package main.java.siliconsim.attacks;

import main.java.siliconsim.players.Type;

public class TradeSecretTheftAttack implements AttackStrategy {
    Type type = Type.OPERATING_SYSTEM;

    @Override
    public double attack() {
        return 1.2;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Trade Secret Theft Attack";
    }
}
