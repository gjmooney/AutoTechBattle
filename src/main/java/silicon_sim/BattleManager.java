package main.java.silicon_sim;

import main.java.silicon_sim.attacks.TalentDrainAttack;
import main.java.silicon_sim.attacks.TradeSecretTheftAttack;
import main.java.silicon_sim.attacks.UndercutPriceAttack;
import main.java.silicon_sim.players.StartUp;

import java.util.Scanner;

public class BattleManager {
    static Scanner in = new Scanner(System.in);
    static int turn;

    public void startBattle(StartUp player1, StartUp player2) {
        // player 1 goes first
        turn = 1;
        int choice = 0;
        boolean fightOver = false;

        // Prompt for attack choice
        do {
            System.out.println("Choose attack: ");
            System.out.println("1) Talent Drain"
            + "\n2) Trade Secret Theft"
            + "\n3) Undercut Prices");

            choice = in.nextInt();
            //choice = 1;

            int damage = calcAttack(player1, choice);
            player2.getAttacked(damage);

            if (damage < Constants.MINIMUM_DAMAGE_DONE) {
                damage = Constants.MINIMUM_DAMAGE_DONE;
            }

            // if hp < 0 fight is over

        } while (!fightOver);
    }

    public int calcAttack(StartUp player, int attack) {

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
