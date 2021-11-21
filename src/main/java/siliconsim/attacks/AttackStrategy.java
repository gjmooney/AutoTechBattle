package main.java.siliconsim.attacks;

import main.java.siliconsim.players.Type;

// Strategy pattern
public interface AttackStrategy {
    double attack();

    Type getType();

    String toString();
}
