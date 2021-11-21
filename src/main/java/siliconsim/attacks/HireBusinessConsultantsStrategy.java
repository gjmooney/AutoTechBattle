package main.java.siliconsim.attacks;

import main.java.siliconsim.players.Type;

public class HireBusinessConsultantsStrategy implements AttackStrategy {
    Type type = Type.SOCIAL_MEDIA;

    @Override
    public double attack() {
        return 1.3;
    }

    @Override
    public Type getType() {
        return type;
    }
}
