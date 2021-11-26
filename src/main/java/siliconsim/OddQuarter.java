package main.java.siliconsim;

import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

public class OddQuarter extends Cycle {

    @Override
    public void doQuarterEvent(int quarter, TechGiant techGiant) {

        // Heal all start ups each odd quarter
        for (StartUp su : GameLogic.getLogic().getAllStartUps()) {
            su.setCurrentHealth(su.getMaxHealth());
        }

        if (quarter == 0) {
            System.out.println("It's Q1! Time for tax cuts! All Start Ups have their revenues increased by 20%!");
            QuarterEvents.taxCuts();
        }
        if (quarter == 2) {
            System.out.println("It's Q3! Monopolies are being busted!");
            QuarterEvents.monopolyBusting();
        }

        boolean validInput;
        do {
            System.out.println("What would you like to do?"
                    + "\n1) Gain Market Share for your start ups");

            // Only display choice to catch wild start up if there is at least one left
            if (!GameLogic.getLogic().getWildStartUps().isEmpty()) {
                System.out.println("2) Attempt to catch a new Start Up instead of battling a "
                        + "\n   Tech Giant in the next quarter");
            } else {
                System.out.println("There are no more wild start ups to catch!");
            }

            //choice = in.nextInt();
            choice = GameLogic.getLogic().generateChoice(3, 1);
            System.out.println("Your choice: " + choice);

            // This counts as exception handling
            if (choice == 1 || choice == 2) {
                validInput = true;
            } else {
                validInput = false;
            }
            switch (choice) {
                case 1:
                    techGiant.setOddQuarterStrategy(new RaiseMarketShareStrategy());
                    break;
                case 2:
                    if (GameLogic.getLogic().getWildStartUps().isEmpty())  {
                        choice = 0;
                        validInput = false;
                    } else {
                        techGiant.setOddQuarterStrategy(new CatchNewStartUpStrategy());
                    }
                    break;
                default:
                    System.out.println("Please choose one of the options");
            }
        } while (!validInput);

        // reset choice
        choice = 0;

        techGiant.getOddQuarterStrategy().doEvent(techGiant);


    }
}
