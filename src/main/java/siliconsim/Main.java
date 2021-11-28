package main.java.siliconsim;

import main.java.siliconsim.players.FinTechStartUp;
import main.java.siliconsim.players.HealthCareStartUp;
import main.java.siliconsim.players.OsTechGiant;
import main.java.siliconsim.players.RealEstateStartUp;
import main.java.siliconsim.players.SocialMediaStartUp;
import main.java.siliconsim.players.SocialMediaTechGiant;
import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

public class Main {
    /**
     * Main entry point for game.
     * @param args no args used
     */
    public static void main(String[] args) {
        //Create tech giants
        TechGiant evilInc = new SocialMediaTechGiant("Evil Inc.");
        TechGiant tepid = new OsTechGiant("Tepid");
        GameLogic.getLogic().addTechGiant(evilInc);
        GameLogic.getLogic().addTechGiant(tepid);

        //Create startups
        StartUp willow = new RealEstateStartUp("Willow");
        StartUp markHealth = new HealthCareStartUp("MarkHealth");
        StartUp darkRock = new FinTechStartUp("DarkRock");
        StartUp noSpace = new SocialMediaStartUp("NoSpace");

        System.out.println("TEST");

        //Set up some startups to evolve after next win
        for (int i = 1; i < 4; i++) {
            willow.setExp(i * i * i);
            willow.levelCheck();
            willow = willow.evolveCheck();

            markHealth.setExp(i * i * i);
            markHealth.levelCheck();
            markHealth = markHealth.evolveCheck();
        }
        willow.setExp(63);
        markHealth.setExp(63);

        // Set some start-ups to evolve to max level after next win
        for (int i = 1; i < 9; i++) {
            darkRock.setExp(i * i * i);
            darkRock.levelCheck();
            darkRock = darkRock.evolveCheck();

            noSpace.setExp(i * i * i);
            noSpace.levelCheck();
            noSpace = noSpace.evolveCheck();
        }
        darkRock.setExp(728);
        noSpace.setExp(728);

        //Tech giants acquire startups
        evilInc.addStartUp(willow);
        evilInc.addStartUp(darkRock);
        tepid.addStartUp(markHealth);
        tepid.addStartUp(noSpace);
        GameLogic.getLogic().addOwnedStartUp(darkRock);
        GameLogic.getLogic().addOwnedStartUp(noSpace);
        GameLogic.getLogic().addOwnedStartUp(willow);
        GameLogic.getLogic().addOwnedStartUp(markHealth);

        // Create wild start-ups
        StartUp greyRock = new FinTechStartUp("GreyRock");
        StartUp xulin = new SocialMediaStartUp("Xulin");
        GameLogic.getLogic().addWildStartUp(greyRock);
        GameLogic.getLogic().addWildStartUp(xulin);

        //Player is the first tech giant
        TechGiant playersTurn = GameLogic.getLogic().getAllTechGiants().get(0);
        do {
            // 0 and 1 are the odd quarters OKAY
            if (GameLogic.getLogic().getQuarter() == 0 || GameLogic.getLogic().getQuarter() == 2) {
                GameLogic.getLogic().setCycleState(new OddQuarter());
                GameLogic.getLogic().getCycleState()
                        .doQuarterEvent(GameLogic.getLogic().getQuarter(), playersTurn);
                GameLogic.getLogic().changeQuarter();
            }
            // 1 and 3 are EVEN OKAY
            if (GameLogic.getLogic().getQuarter() == 1 || GameLogic.getLogic().getQuarter() == 3) {
                GameLogic.getLogic().setCycleState(new EvenQuarter());
                GameLogic.getLogic().getCycleState()
                        .doQuarterEvent(GameLogic.getLogic().getQuarter(), playersTurn);
                GameLogic.getLogic().changeQuarter();
            }
        } while (!GameLogic.getLogic().isGameOver());
    }
}
