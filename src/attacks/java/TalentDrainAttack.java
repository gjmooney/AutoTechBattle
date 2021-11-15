package attacks.java;

import players.java.Type;

public class TalentDrainAttack implements AttackStrategy{
    Type type;

    @Override
    public int attack(int netIncome) {
        return netIncome * 2;
    }
}
