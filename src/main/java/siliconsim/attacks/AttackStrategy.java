package main.java.siliconsim.attacks;

import main.java.siliconsim.players.Type;

// Strategy pattern
public interface AttackStrategy {
    int attack(int netIncome);

    Type getType();

    String toString();
}
