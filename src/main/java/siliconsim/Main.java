package main.java.siliconsim;

import main.java.siliconsim.players.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Setup");
        GameLogic logic = GameLogic.getLogic();

        //Create tech giants
        TechGiant evilInc = new SocialMediaTechGiant("Evil Inc.");
        TechGiant tepid = new OsTechGiant("Tepid");
        logic.addTechGiant(evilInc);
        logic.addTechGiant(tepid);

        //Create startups
        StartUp willow = new RealEstateStartUp("Willow");
        StartUp markHealth = new HealthCareStartUp("MarkHealth");
        StartUp greyRock = new FinTechStartUp("GreyRock");
        StartUp xulin = new SocialMediaStartUp("Xulin");
        logic.addOwnedStartUp(willow);
        logic.addOwnedStartUp(markHealth);
        logic.addWildStartUp(greyRock);
        logic.addWildStartUp(xulin);

        //Tech giants acquire startups
        evilInc.addStartUp(willow);
        tepid.addStartUp(markHealth);

        //TODO: implement turn changing
        TechGiant playersTurn = logic.getAllTechGiants().get(0);
        do {
            // 0 and 1 are the odd quarters OKAY
            if (logic.getQuarter() == 0 || logic.getQuarter() == 2) {
                logic.setCycleState(new OddQuarter());
                logic.getCycleState().doQuarterEvent(logic.getQuarter(), playersTurn);
                logic.changeQuarter();
            }
            // 1 and 3 are EVEN OKAY
            if (logic.getQuarter() == 1 || logic.getQuarter() == 3) {
                logic.setCycleState(new EvenQuarter());
                logic.getCycleState().doQuarterEvent(logic.getQuarter(), playersTurn);
                logic.changeQuarter();
            }
        } while (!logic.isGameOver());

        //logic.getBattleManager().startBattle(willow, markHealth);

    }
}
