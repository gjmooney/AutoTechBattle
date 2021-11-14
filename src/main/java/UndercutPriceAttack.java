package main.java;

public class UndercutPriceAttack implements AttackStrategy{
    @Override
    public int calcAttack(int netIncome) {
        return netIncome * 3;
    }
}
