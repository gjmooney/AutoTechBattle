package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

public class EvenQuarter extends Cycle {

    @Override
    public void doQuarterEvent(int quarter, TechGiant techGiant) {
        System.out.println("even");

        if (quarter == 1) {
            System.out.println("It's Q2!");
            QuarterEvents.financialCrisis();
        }
        if (quarter == 3) {
            System.out.println("It's Q4!");
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
            //int num = (int) (Math.random() * (wildStartUps));
            int num = GameLogic.getLogic().getRandom().nextInt(wildStartUps);
            return GameLogic.getLogic().getWildStartUps().get(num);
        } else {
            // Choose a random tech giant to battle, ignores 0 index because that is the player
            int techGiantNumber = GameLogic.getLogic().getAllTechGiants().size() - 1;
            //int techGiantNum = (int) (Math.random() * (techGiantNumber - 1)) + 1;
            int techGiantNum = GameLogic.getLogic().getRandom().nextInt((techGiantNumber - 1) + 1) + 1;
            // Choose a random start up owned by that tech giant
            int startUpIndexNum = GameLogic.getLogic().getAllTechGiants().get(techGiantNum).getStartUps().size();
            int startUpNum = GameLogic.getLogic().getRandom().nextInt(startUpIndexNum);
            return GameLogic.getLogic().getAllTechGiants().get(techGiantNum).getStartUps().get(startUpNum);
        }
    }
}
