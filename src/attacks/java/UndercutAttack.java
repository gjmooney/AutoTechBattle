package attacks.java;

public class UndercutAttack implements AttackStrategy{
    @Override
    public int attack(int netIncome) {
        return netIncome * 5;
    }
}
