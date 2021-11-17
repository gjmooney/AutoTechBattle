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
        logic.addStartUp(willow);
        logic.addStartUp(markHealth);
        logic.addStartUp(greyRock);
        logic.addStartUp(xulin);

        //Tech giants acquire startups
        evilInc.addStartUp(willow);
        tepid.addStartUp(markHealth);

        //Set up game
        Cycle.setQuarter(1);

        /*System.out.println("Evil");
        for (StartUp su : evilInc.getStartUps()) {
            System.out.println(su.getHealth());
            System.out.println(su.getOwnerName());
        }

        System.out.println("Tepid");
        for (StartUp su : tepid.getStartUps()) {
            System.out.println(su.getHealth());
            System.out.println(su.getOwnerName());
        }

        for (StartUp su : GameLogic.getAllStartUps()) {
            System.out.println(su.getName() + " : "+ su.getHealth());
        }

        QuarterEvents.taxCuts();

        for (StartUp su : GameLogic.getAllStartUps()) {
            System.out.println(su.getName() + " : "+ su.getHealth());
        }*/

        logic.getBattleManager().startBattle(willow, markHealth);

    }
}
