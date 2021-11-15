package attacks.java;

import players.java.Type;

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
