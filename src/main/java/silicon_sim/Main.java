package main.java.silicon_sim;

import main.java.silicon_sim.players.*;
import main.java.silicon_sim.Cycle;

public class Main {
    public static void main(String[] args) {
        System.out.println("Setup");

        //Set up player 1
        TechGiant evilInc = new SocialMediaTechGiant("Evil Inc.");
        StartUp willow = new RealEstateStartUp("Willow");
        evilInc.addStartUp(willow);
        TechGiant.techGiants.add(evilInc);

        //Set up player 2
        TechGiant tepid = new OsTechGiant("Tepid");
        StartUp markHealth = new HealthCareStartUp("MarkHealth");
        tepid.addStartUp(markHealth);
        TechGiant.techGiants.add(tepid);

        //Wild start ups
        StartUp greyRock = new FinTechStartUp("GreyRock");
        StartUp xulin = new SocialMediaStartUp("Xulin");

        //Set up game
        Cycle.setQuarter(1);

        System.out.println("Evil");
        for (StartUp su : evilInc.getStartUps()) {
            System.out.println(su.getRevenue());
            System.out.println(su.getOwner());
        }

        System.out.println("Tepid");
        for (StartUp su : tepid.getStartUps()) {
            System.out.println(su.getRevenue());
            System.out.println(su.getOwner());
        }

        QuarterEvents.taxCuts();

        for (StartUp su : evilInc.getStartUps()) {
            System.out.println(su.getRevenue());
        }

    }
}