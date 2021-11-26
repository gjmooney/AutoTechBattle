package test.java;

import main.java.siliconsim.GameLogic;
import main.java.siliconsim.attacks.TradeSecretTheftAttack;
import main.java.siliconsim.attacks.UndercutPriceAttack;
import main.java.siliconsim.decorator.InternetDestroyerStartUp;
import main.java.siliconsim.decorator.VcBaitStartUp;
import main.java.siliconsim.players.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class StartUpTest {

    GameLogic testLogic = GameLogic.getLogic();

    //Create tech giants
    TechGiant tesTg1 = new SocialMediaTechGiant("tesTg1");
    TechGiant tesTg2 = new OsTechGiant("tesTg2");

    //Create startups
    StartUp testSu1 = new RealEstateStartUp("testSu1");
    StartUp testSu2 = new HealthCareStartUp("testSu2");
    StartUp testSu3 = new FinTechStartUp("testSu3");
    StartUp testSu4 = new SocialMediaStartUp("testSu4");

    @Before
    public void setUp() throws Exception {
        testLogic.addTechGiant(tesTg1);
        testLogic.addTechGiant(tesTg2);

        testLogic.addOwnedStartUp(testSu1);
        testLogic.addOwnedStartUp(testSu2);
        testLogic.addWildStartUp(testSu3);
        testLogic.addWildStartUp(testSu4);

        tesTg1.addStartUp(testSu1);
        tesTg2.addStartUp(testSu2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAttacksBasicStartUp() {
        String expected = "1) Talent Drain"
                + "\n2) Trade Secret Theft\n";

        // Change System output for comparison
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        PrintStream old = System.out;
        System.setOut(ps);
        testSu1.listAttacks();
        System.out.flush();
        System.setOut(old);

        assertEquals(expected, output.toString());
    }

    @Test
    public void listAttacksVcStartUp() {
        testSu3.setLevel(5);
        testSu3 = testSu3.evolveCheck();

        String expected = "1) Talent Drain"
                + "\n2) Trade Secret Theft"
                + "\n3) Hire Business Consultants\n";

        // Change System output for comparison
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        PrintStream old = System.out;
        System.setOut(ps);
        testSu3.listAttacks();
        System.out.flush();
        System.setOut(old);

        assertEquals(expected, output.toString());
    }
    @Test
    public void listAttacksInternetDestroyerStartUp() {
        testSu3.setLevel(5);
        testSu3 = testSu3.evolveCheck();
        testSu3.setLevel(10);
        testSu3 = testSu3.evolveCheck();
        String expected = "1) Talent Drain"
                + "\n2) Trade Secret Theft"
                + "\n3) Hire Business Consultants"
                + "\n4) Undercut Prices\n";

        // Change System output for comparison
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output);
        PrintStream old = System.out;
        System.setOut(ps);
        testSu3.listAttacks();
        System.out.flush();
        System.setOut(old);

        assertEquals(expected, output.toString());
    }


    @Test
    public void doAttackUndercut() {
        //start-ups level is 1 and attack value is 150
        // opponents defense is 100
        testSu1.setAttackStrategy(new UndercutPriceAttack());
        //24 i think
        int damage = testSu1.doAttack(100);

        // Low end is a miss (0 damage) and high end is a critical hit
        // Same type attack bonus is applied
        assertTrue(damage >= 0 && damage <= 37);
    }

    @Test
    public void getAttacked() {
        // Starts with 100 health
        testSu1.setCurrentHealth(100);
        testSu1.getAttacked(50);
        int health = testSu1.getCurrentHealth();
        assertEquals(50, health);

    }

    @Test
    public void levelCheck() {
        // No level up
        assertFalse(testSu1.levelCheck());

        // Level up
        testSu1.setExp(20);
        assertTrue(testSu1.levelCheck());
    }

    @Test
    public void evolveCheck() {
        // No evolution
        assertTrue(testSu2 instanceof StartUp);

        // First evolution
        testSu2.setLevel(5);
        testSu2 = testSu2.evolveCheck();
        assertTrue(testSu2 instanceof VcBaitStartUp);

        // Second Evolution
        testSu2.setLevel(10);
        testSu2 = testSu2.evolveCheck();
        assertTrue(testSu2 instanceof InternetDestroyerStartUp);
    }
}