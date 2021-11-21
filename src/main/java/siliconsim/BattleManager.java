package main.java.siliconsim;

import java.util.Scanner;
import main.java.siliconsim.attacks.HireBusinessConsultantsStrategy;
import main.java.siliconsim.attacks.TalentDrainAttack;
import main.java.siliconsim.attacks.TradeSecretTheftAttack;
import main.java.siliconsim.attacks.UndercutPriceAttack;
import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;

public class BattleManager {
    Scanner in = new Scanner(System.in);
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
    public void startBattle(StartUp player1, StartUp player2) {
        setFightOver(false);

        // player 1 goes first
        turn = 1;
        System.out.println(player1.getName() + " is doing battle with "
                + player2.getName() + "!");
        // Prompt for attack choice
        do {
            if (turn == 1) {
                doTurn(player1, player2);
                turn = 2;
            } else {
                doTurn(player2, player1);
                turn = 1;
            }
        } while (!isFightOver());

        battleOver(winner, loser);
    }

    /**
     * Choose and perform an attack.
     * @param attacker start-up that is attacking
     * @param defender start-up that is defending
     */
    private void doTurn(StartUp attacker, StartUp defender) {
        // Prompt for attack choice
        System.out.println("Health: \n" + attacker.getName() + " : "
                + attacker.getHealth() + " | "
                + defender.getName() + " : "
                + defender.getHealth());

        System.out.println(attacker.getName() + ": Choose attack: ");
        attacker.listAttacks();
        choice = in.nextInt();
        int damage = calcAttack(attacker, choice);
        System.out.println(attacker.getName() + " used " + attacker.getAttackStrategy().toString());

        if (damage > 0) {
            System.out.println(attacker.getName() + " did " + damage + " damage to "
                    + defender.getName());
        } else {
            System.out.println(attacker.getName() + "'s attack missed!");
        }

        defender.getAttacked(damage);
        if (defender.getHealth() <= 0) {
            setFightOver(true);
            winner = attacker;
            loser = defender;
            System.out.println(defender.getName() + " has fainted!");
        }
    }

    /**
     * Award exp, handle acquisitions, and check if the game is over.
     * @param winner StartUp that won the battle
     * @param loser StartUp that lost the battle
     */
    private void battleOver(StartUp winner, StartUp loser) {
        boolean levelUp = false;
        System.out.println(winner.getName() + " has won the battle!");

        // Award exp to all startups in owners portfolio
        int expReceived = Constants.BASE_EXPERIENCE * loser.getLevel();
        for (StartUp su : winner.getOwner().getStartUps()) {
            su.setExp(su.getExp() + expReceived);

            if (su.levelCheck()) {
                System.out.println("Congratulations! " + su.getName()
                        + " has reached level " + su.getLevel());
                winner = su.evolveCheck();
                if (GameLogic.getLogic().isHasEvolved()) {
                    System.out.println(su.getName() + " has evolved into a "
                    + su.getEvolutionString() + "!");
                }
                GameLogic.getLogic().setHasEvolved(false);
            }
        }

        System.out.println("Add " + loser.getName() + " to "
                + winner.getOwnerName() + "'s portfolio?");
        System.out.println("1) Yes \n2) No");
        choice = in.nextInt();

        if (choice == 1) {
            // Startup has an owner
            if (loser.getOwner() != null) {
                loser.getOwner().removeStartUp(loser);
            }

            winner.getOwner().addStartUp(loser);
            System.out.println(loser.getName() + " has been added to "
                    + winner.getOwnerName() + "'s portfolio");
        } else {
            System.out.println(loser.getName() + " was not acquired");
        }

        if (loser.getOwner() != null) {
            gameOverCheck(loser.getOwner());
        }
    }

    /**
     * Checks if the losing tech giant is out of start-ups.
     * @param techGiant TechGiant that lost the battle
     */
    private void gameOverCheck(TechGiant techGiant) {
        if (techGiant.getStartUps().isEmpty()) {
            GameLogic.getLogic().setGameOver(true);
        }
    }

    /**
     * Assign attack strategy.
     * @param player Player that is attacking
     * @param attack Players choice of attack
     * @return Damage done by attack
     */
    private int calcAttack(StartUp player, int attack) {
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

        return player.doAttack();
    }

    public boolean isFightOver() {
        return fightOver;
    }

    public void setFightOver(boolean didFightEnd) {
        fightOver = didFightEnd;
    }
}
