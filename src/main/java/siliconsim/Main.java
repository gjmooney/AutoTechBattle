package main.java.siliconsim;

import main.java.siliconsim.decorator.InternetDestroyerStartUp;
import main.java.siliconsim.decorator.VcBaitStartUp;
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

        System.out.println("Willow" + willow.getDefense() + " " + willow.getLevel() + " " + willow.getType());
        //Tech giants acquire startups
        evilInc.addStartUp(willow);
        tepid.addStartUp(markHealth);

        System.out.println(willow.getHealth());
        QuarterEvents.taxCuts();
        System.out.println(willow.getHealth());

        //TODO: implement turn changing
        TechGiant playersTurn = logic.getAllTechGiants().get(0);

        willow.listAttacks();
        System.out.println("1 " + willow.getAttack());
        willow.setLevel(4);
        willow.setExp(124);

        markHealth.setHealth(1);
        willow = logic.getBattleManager().startBattle(willow, markHealth);
        willow.listAttacks();
        willow.setLevel(9);
        willow.setExp(728);

        markHealth.setHealth(12);
        willow.setHealth(120);
        willow = logic.getBattleManager().startBattle(willow, markHealth);
        willow.listAttacks();


        do {
            // 0 and 1 are the odd quarters OKAY
            if (logic.getQuarter() == 0 || logic.getQuarter() == 2) {
                logic.setQuarter(new OddQuarter());
                logic.getCycleState().doQuarterEvent(logic.getQuarter(), playersTurn);
                logic.changeQuarter();
            }
            // 1 and 3 are EVEN OKAY
            if (logic.getQuarter() == 1 || logic.getQuarter() == 3) {
                logic.setQuarter(new EvenQuarter());
                logic.getCycleState().doQuarterEvent(logic.getQuarter(), playersTurn);
                logic.changeQuarter();
            }
        } while (!logic.isGameOver());

        //logic.getBattleManager().startBattle(willow, markHealth);

    }
}
