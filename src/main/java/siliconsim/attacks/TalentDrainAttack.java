package main.java.siliconsim.attacks;

import main.java.siliconsim.players.Type;

public class TalentDrainAttack implements AttackStrategy {
    Type type = Type.FIN_TECH;

    @Override
    public double attack() {
        return 1.1;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Talent Drain Attack";
    }
}
