package main.java.silicon_sim;

import main.java.silicon_sim.attacks.TalentDrainAttack;
import main.java.silicon_sim.attacks.TradeSecretTheftAttack;
import main.java.silicon_sim.attacks.UndercutPriceAttack;
import main.java.silicon_sim.players.StartUp;

import java.util.Scanner;

public class BattleManager {
    static Scanner in = new Scanner(System.in);
    static int turn;
    static int choice;
    static boolean fightOver;
    StartUp winner, loser;

    /**
     * Start a battle between two start-ups
     * @param player1 first tech giants start-up
     * @param player2 second tech giants start-up
     */
    public void startBattle(StartUp player1, StartUp player2) {
        fightOver = false;

        // player 1 goes first
        turn = 1;

        System.out.println(player1.getName() + " is doing battle with " +
                player2.getName() + "!");
        // Prompt for attack choice
        do {
            if (turn == 1) {
                doTurn(player1, player2);
                turn = 2;
            } else {
                doTurn(player2, player1);
                turn = 1;
            }
        } while (!fightOver);

        battleOver(winner, loser);
    }

    /**
     * Choose and perform an attack
     * @param attacker start-up that is attacking
     * @param defender start-up that is defending
     */
    private void doTurn(StartUp attacker, StartUp defender) {
        // Prompt for attack choice
        System.out.println("Health: " + attacker.getName() + " : " + attacker.getHealth());
        System.out.println("Health: " + defender.getName() + " : " + defender.getHealth());

        System.out.println(attacker.getName() + ": Choose attack: ");
        System.out.println("1) Talent Drain" +
                "\n2) Trade Secret Theft" +
                "\n3) Undercut Prices");

        choice = in.nextInt();

        int damage = calcAttack(attacker, choice);
        System.out.println(attacker.getName() + " used " + attacker.getAttackStrategy().toString());
        System.out.println(attacker.getName() + " did " + damage + " damage to " +
                defender.getName());

        defender.getAttacked(damage);
        if (defender.getHealth() <= 0) {
            fightOver = true;
            winner = attacker;
            loser = defender;
        }
    }

    private void battleOver(StartUp winner, StartUp loser) {
        boolean levelUp = false;
        System.out.println(winner.getName() + " has won the battle!");

        // Award exp to all startups in owners portfolio
        int expReceived = Constants.BASE_EXPERIENCE * loser.getLevel();
        for (StartUp su : winner.getOwner().getStartUps()) {
            su.setExp(su.getExp() + expReceived);
            levelUp = su.levelCheck();
            if (levelUp) {
                System.out.println("Congratulations! " + su.getName() +
                        "has reached level " + su.getLevel());
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
            System.out.println(loser.getName() + " has been added to" +
                    winner.getOwnerName() + "'s portfolio");
        } else {
            System.out.println(loser.getName() + " was not acquired");
        }

    }

    private int calcAttack(StartUp player, int attack) {

        switch (attack) {
            case 1:
                player.setAttackStrategy(new TalentDrainAttack());
                break;
            case 2:
                player.setAttackStrategy(new TradeSecretTheftAttack());
                break;
            case 3:
                player.setAttackStrategy(new UndercutPriceAttack());
                break;
            default:
                System.out.println("Not an attack");
        }

        return player.doAttack();
    }


}
