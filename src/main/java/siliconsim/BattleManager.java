package main.java.siliconsim;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import main.java.siliconsim.attacks.HireBusinessConsultantsStrategy;
import main.java.siliconsim.attacks.TalentDrainAttack;
import main.java.siliconsim.attacks.TradeSecretTheftAttack;
import main.java.siliconsim.attacks.UndercutPriceAttack;
import main.java.siliconsim.decorator.InternetDestroyerStartUp;
import main.java.siliconsim.decorator.VcBaitStartUp;
import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

public class BattleManager {
    //Scanner in = new Scanner(System.in, StandardCharsets.UTF_8.name());
    int turn;
    int choice;
    boolean fightOver;
    StartUp winner;
    StartUp loser;

    /**
     * Start a battle between two start-ups.
     * @param player1 first tech giants start-up
     * @param player2 second tech giants start-up
     */
    public StartUp startBattle(StartUp player1, StartUp player2) {
        setFightOver(false);

        // player 1 goes first
        turn = 1;
        System.out.println(player1.getName() + " is doing battle with "
                + player2.getName() + "!");
        // Prompt for attack choice
        do {
            if (turn == 1) {
                doTurn(player1, player2, true);
                turn = 2;
            } else {
                doTurn(player2, player1, false);
                turn = 1;
            }
        } while (!isFightOver());

        return battleOver(winner, loser);
    }

    /**
     * Choose and perform an attack.
     * @param attacker start-up that is attacking
     * @param defender start-up that is defending
     */
    private void doTurn(StartUp attacker, StartUp defender, boolean player) {
        // Prompt for attack choice
        int damage = 0;
        if (player) {
            System.out.println("Health: \n" + attacker.getName() + " : "
                    + attacker.getCurrentHealth() + "/" + attacker.getMaxHealth()
                    + " " + defender.getName() + " : "
                    + defender.getCurrentHealth() + "/" + defender.getMaxHealth());

            System.out.println(attacker.getName() + ": Choose attack: ");
            attacker.listAttacks();

            //choice = in.nextInt();
            int numOfChoices = findNumberOfAttacks(attacker);
            choice = GameLogic.getLogic().generateChoice((numOfChoices + 1), 2);
            System.out.println("Your choice: " + choice);

            damage = calcAttack(attacker, choice, defender.getDefense());
            System.out.println(attacker.getName() + " used " + attacker.getAttackStrategy().toString());

            if (damage > 0) {
                System.out.println(attacker.getName() + " did " + damage + " damage to "
                        + defender.getName());
            } else {
                System.out.println(attacker.getName() + "'s attack missed!");
            }
        } else {
            int numOfChoices = findNumberOfAttacks(attacker);
            choice = GameLogic.getLogic().generateChoice(numOfChoices + 1, 1);
            damage = calcAttack(attacker, choice, defender.getDefense());
            System.out.println(attacker.getName() + " used " + attacker.getAttackStrategy().toString());

            if (damage > 0) {
                System.out.println(attacker.getName() + " did " + damage + " damage to "
                        + defender.getName());
            } else {
                System.out.println(attacker.getName() + "'s attack missed!");
            }
        }

        System.out.println();
        defender.getAttacked(damage);
        if (defender.getCurrentHealth() <= 0) {
            setFightOver(true);
            winner = attacker;
            loser = defender;
            System.out.println(defender.getName() + " has fainted!");
        }
    }

    /**
     * Helper method to get an int for the number of attacks a stat-up has.
     * @param startUp The start-up being queried
     * @return Number of attacks a start-up has
     */
    private int findNumberOfAttacks(StartUp startUp) {
        int numberOfAttacks;
        if (startUp instanceof InternetDestroyerStartUp) {
            numberOfAttacks = 4;
        } else if (startUp instanceof VcBaitStartUp) {
            numberOfAttacks = 3;
        } else {
            numberOfAttacks = 2;
        }
        return numberOfAttacks;
    }

    /**
     * Award exp, handle acquisitions, and check if the game is over.
     * @param winner StartUp that won the battle
     * @param loser StartUp that lost the battle
     */
    private StartUp battleOver(StartUp winner, StartUp loser) {
        boolean levelUp = false;
        System.out.println(winner.getName() + " has won the battle!");

        // Award exp to all startups in owners portfolio
        int expReceived = Constants.BASE_EXPERIENCE * loser.getLevel();

        winner.setExp(winner.getExp() + expReceived);
        if (winner.levelCheck()) {
            System.out.println("Congratulations! " + winner.getName()
                    + " has reached level " + winner.getLevel());
            winner = winner.evolveCheck();
            if (GameLogic.getLogic().isHasEvolved()) {
                System.out.println(winner.getName() + " has evolved into a "
                        + winner.getEvolutionString() + "!");
            }
            GameLogic.getLogic().setHasEvolved(false);
        }

        // Wild start ups can't acquire start ups
        if (winner.getOwner() != null) {
            System.out.println("Add " + loser.getName() + " to "
                    + winner.getOwnerName() + "'s portfolio?");
            System.out.println("1) Yes \n2) No");
            //choice = in.nextInt();
            choice = GameLogic.getLogic().generateChoice(3, 1);
            System.out.println("Your choice: " + choice);

            if (choice == 1) {
                // Startup has an owner
                if (loser.getOwner() != null) {
                    TechGiant losingTechGiant = loser.getOwner();
                    loser.getOwner().removeStartUp(loser);
                    gameOverCheck(losingTechGiant);
                } else {
                    // Wild Start up
                    GameLogic.getLogic().removeWildStartUp(loser);
                    GameLogic.getLogic().addOwnedStartUp(loser);
                }

                winner.getOwner().addStartUp(loser);
                System.out.println(loser.getName() + " has been added to "
                        + winner.getOwnerName() + "'s portfolio");
            } else {
                System.out.println(loser.getName() + " was not acquired");
            }

        }
        return winner;
    }

    /**
     * Checks if the losing tech giant is out of start-ups.
     * @param techGiant TechGiant that lost the battle
     */
    private void gameOverCheck(TechGiant techGiant) {
        if (techGiant.getStartUps().isEmpty()) {
            GameLogic.getLogic().setGameOver(true);
            System.out.println(techGiant.getName() + "has no more start-ups!"
                    + "\n" + techGiant.getName() + " is out of the game!");
        }
    }

    /**
     * Assign attack strategy.
     * @param player Player that is attacking
     * @param attack Players choice of attack
     * @param opponentsDefense Defense of Start-Up being attacked
     * @return Damage done by attack
     */
    private int calcAttack(StartUp player, int attack, int opponentsDefense) {
        switch (attack) {
            case 1:
                player.setAttackStrategy(new TalentDrainAttack());
                break;
            case 2:
                player.setAttackStrategy(new TradeSecretTheftAttack());
                break;
            case 3:
                player.setAttackStrategy(new HireBusinessConsultantsStrategy());
                break;
            case 4:
                player.setAttackStrategy(new UndercutPriceAttack());
                break;
            default:
                System.out.println("Not an attack");
        }

        return player.doAttack(opponentsDefense);
    }

    public boolean isFightOver() {
        return fightOver;
    }

    public void setFightOver(boolean didFightEnd) {
        fightOver = didFightEnd;
    }
}
