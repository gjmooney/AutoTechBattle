package attacks.java;

import players.java.Type;

// Strategy pattern
public interface AttackStrategy {
    int attack(int netIncome);
    Type getType();
}
