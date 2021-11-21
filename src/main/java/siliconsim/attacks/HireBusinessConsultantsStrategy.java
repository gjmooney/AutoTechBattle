package main.java.siliconsim.attacks;

import main.java.siliconsim.players.Type;

public class HireBusinessConsultantsStrategy implements AttackStrategy {
    Type type = Type.SOCIAL_MEDIA;

    @Override
    public int attack(int netIncome) {
        return netIncome * 6;
    }

    @Override
    public Type getType() {
        return type;
    }
}
