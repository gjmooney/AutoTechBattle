package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

public class EvenQuarter extends Cycle {

    @Override
    public void doQuarterEvent(int quarter, TechGiant techGiant) {
        System.out.println("even");

        if (quarter == 1) {
            System.out.println("It's Q2! Oh no! Another financial crisis! "
                    + "\nAll starts ups lost 20% of their market share and income");
            System.out.println("Wait, what's this? Fin Techs are getting bailed out!"
                    + "\nThey avoided any losses!");
            QuarterEvents.financialCrisis();
        }
        if (quarter == 3) {
            System.out.println("It's Q4! Those legal departments have been busy in DC!"
                    + "They're lobbying efforts have increased market share for all start ups by 20%!");
            QuarterEvents.lobbying();
        }

        System.out.print("You chose to battle a ");
        if (techGiant.isCatchWildStartUp()) {
            System.out.print("wild start up!\n");
        } else {
            System.out.print("another tech giant!\n");
        }

        StartUp opponent = pickStartUpToBattleAgainst(techGiant.isCatchWildStartUp());
        //reset isCatchWild selection
        techGiant.setCatchWildStartUp(false);
        GameLogic.getLogic().getBattleManager().startBattle(techGiant.getStartUps().get(0), opponent);

    }

    private StartUp pickStartUpToBattleAgainst(boolean isWild) {
        if (isWild) {
            // Choose a random wild startup
            int wildStartUps = GameLogic.getLogic().getWildStartUps().size();
            // Choose a random wild start up to battle
            int num = GameLogic.getLogic().getRandom().nextInt(wildStartUps);
            return GameLogic.getLogic().getWildStartUps().get(num);
        } else {
            // Choose a random tech giant to battle, ignores 0 index because that is the player
            int techGiantNumber = GameLogic.getLogic().getAllTechGiants().size();
            int techGiantNum = GameLogic.getLogic().generateChoice(techGiantNumber, 1);
            // Choose a random start up owned by that tech giant
            int startUpIndexNum = GameLogic.getLogic().getAllTechGiants().get(techGiantNum).getStartUps().size();
            System.out.println("SUINDEX" + startUpIndexNum);
            int startUpNum = GameLogic.getLogic().getRandom().nextInt(startUpIndexNum);
            return GameLogic.getLogic().getAllTechGiants().get(techGiantNum).getStartUps().get(startUpNum);
        }
    }
}
