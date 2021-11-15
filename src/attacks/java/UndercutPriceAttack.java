package attacks.java;

public class UndercutPriceAttack implements AttackStrategy{
    @Override
    public int attack(int netIncome) {
        return netIncome * 3;
    }
}
