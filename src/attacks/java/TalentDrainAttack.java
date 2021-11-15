package attacks.java;

public class TalentDrainAttack implements AttackStrategy{

    @Override
    public int calcAttack(int netIncome) {
        return netIncome * 2;
    }
}
