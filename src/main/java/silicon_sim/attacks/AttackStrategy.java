package main.java.silicon_sim.attacks;

import main.java.silicon_sim.players.Type;

// Strategy pattern
public interface AttackStrategy {
    int attack(int netIncome);
    Type getType();
}
