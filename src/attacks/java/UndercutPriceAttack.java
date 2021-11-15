package attacks.java;

import players.java.Type;

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
}
