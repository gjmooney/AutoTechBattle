package main.java.siliconsim;

import main.java.siliconsim.players.TechGiant;

public class OddQuarter extends Cycle {

    @Override
    public void doQuarterEvent(int quarter, TechGiant techGiant) {
        System.out.println("odd");
        if (quarter == 0) {
            System.out.println("It's Q1! Time for tax cuts! All Start Ups revenues increased by 20%!");
            QuarterEvents.taxCuts();
        }
        if (quarter == 2) {
            System.out.println("It's Q2! Monopolies are being busted!");
            QuarterEvents.monopolyBusting();
        }

        do {
            System.out.println("What would you like to do?"
                    +"\n1) Gain Market Share for your start ups"
                    +"\n2) Attempt to catch a new Start Up");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    techGiant.setOddQuarterStrategy(new RaiseMarketShareStrategy());
                    break;
                case 2:
                    techGiant.setOddQuarterStrategy(new CatchNewStartUpStrategy());
                    break;
                default:
                    System.out.println("Please choose one of the options");
            }
        } while (choice == 0);

        // reset choice
        choice = 0;

        techGiant.getOddQuarterStrategy().doEvent(techGiant.getStartUps());


    }
}
