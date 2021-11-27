package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import main.java.siliconsim.GameLogic;
import main.java.siliconsim.attacks.UndercutPriceAttack;
import main.java.siliconsim.decorator.InternetDestroyerStartUp;
import main.java.siliconsim.decorator.VcBaitStartUp;
import main.java.siliconsim.players.FinTechStartUp;
import main.java.siliconsim.players.HealthCareStartUp;
import main.java.siliconsim.players.OsTechGiant;
import main.java.siliconsim.players.RealEstateStartUp;
import main.java.siliconsim.players.SocialMediaStartUp;
import main.java.siliconsim.players.SocialMediaTechGiant;
import main.java.siliconsim.players.StartUp;
import main.java.siliconsim.players.TechGiant;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StartUpTest {
    //Create tech giants
    TechGiant tesTg1 = new SocialMediaTechGiant("tesTg1");
    TechGiant tesTg2 = new OsTechGiant("tesTg2");

    //Create startups
    StartUp testSu1 = new RealEstateStartUp("testSu1");
    StartUp testSu2 = new HealthCareStartUp("testSu2");
    StartUp testSu3 = new FinTechStartUp("testSu3");
    StartUp testSu4 = new SocialMediaStartUp("testSu4");

    /**
     * Add tech giants and start-ups to main list.
     */
    @Before
    public void setUp() {
        GameLogic.getLogic();
        GameLogic.getLogic().addTechGiant(tesTg1);
        GameLogic.getLogic().addTechGiant(tesTg2);

        GameLogic.getLogic().addOwnedStartUp(testSu1);
        GameLogic.getLogic().addOwnedStartUp(testSu2);
        GameLogic.getLogic().addOwnedStartUp(testSu3);
        GameLogic.getLogic().addOwnedStartUp(testSu4);

        tesTg1.addStartUp(testSu1);
        tesTg2.addStartUp(testSu2);
        tesTg1.addStartUp(testSu3);
        tesTg2.addStartUp(testSu4);
    }

    /**
     * Reset tech giant and start up lists.
     */
    @After
    public void tearDown() {
        GameLogic.getLogic().setAllTechGiants(null);
        GameLogic.getLogic().setOwnedStartUps(null);

        tesTg1.removeStartUp(testSu1);
        tesTg2.removeStartUp(testSu2);
        tesTg1.removeStartUp(testSu3);
        tesTg2.removeStartUp(testSu4);
        GameLogic.getLogic().setLogic(null);
    }

    @Test
    public void listAttacksBasicStartUp() throws UnsupportedEncodingException {
        // Change System output for comparison
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output, false, StandardCharsets.UTF_8.name());
        final PrintStream old = System.out;
        System.setOut(ps);
        testSu1.listAttacks();
        System.out.flush();
        System.setOut(old);
        String expected = "1) Talent Drain"
                + "\n2) Trade Secret Theft\n";

        assertEquals(expected, output.toString(StandardCharsets.UTF_8.name()));
    }

    @Test
    public void listAttacksVcStartUp() throws UnsupportedEncodingException {
        testSu3.setLevel(5);
        testSu3 = testSu3.evolveCheck();

        // Change System output for comparison
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output, false, StandardCharsets.UTF_8.name());
        final PrintStream old = System.out;
        System.setOut(ps);
        testSu3.listAttacks();
        System.out.flush();
        System.setOut(old);
        String expected = "1) Talent Drain"
                + "\n2) Trade Secret Theft"
                + "\n3) Hire Business Consultants\n";

        assertEquals(expected, output.toString(StandardCharsets.UTF_8.name()));
    }

    @Test
    public void listAttacksInternetDestroyerStartUp() throws UnsupportedEncodingException {
        for (int i = 1; i < 10; i++) {
            testSu3.setExp(i * i * i);
            testSu3.levelCheck();
            testSu3 = testSu3.evolveCheck();
        }

        // Change System output for comparison
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(output, false, StandardCharsets.UTF_8.name());
        final PrintStream old = System.out;
        System.setOut(ps);
        testSu3.listAttacks();
        System.out.flush();
        System.setOut(old);
        String expected = "1) Talent Drain"
                + "\n2) Trade Secret Theft"
                + "\n3) Hire Business Consultants"
                + "\n4) Undercut Prices\n";

        assertEquals(expected, output.toString(StandardCharsets.UTF_8.name()));
    }


    @Test
    public void doAttackUndercut() {
        // start-ups level is 1 and attack value is 150000
        // opponents defense is 100
        testSu1.setAttackStrategy(new UndercutPriceAttack());
        int damage = testSu1.doAttack(100);

        // Low end is a miss (0 damage) and high end is a critical hit
        // Same type attack bonus is applied
        assertTrue(damage >= 0 && damage <= 218);
    }

    @Test
    public void getAttacked() {
        // Starts with 100 health
        testSu1.setCurrentRevenue(100);
        testSu1.getAttacked(50);
        int health = testSu1.getCurrentRevenue();
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
        assertTrue(testSu2 instanceof HealthCareStartUp);

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