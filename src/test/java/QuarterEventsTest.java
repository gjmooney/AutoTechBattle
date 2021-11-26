package test.java;

import static org.junit.Assert.assertEquals;

import main.java.siliconsim.GameLogic;
import main.java.siliconsim.QuarterEvents;
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

public class QuarterEventsTest {
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
    public void taxCuts() {
        testSu1.setMaxHealth(100);
        testSu2.setMaxHealth(100);
        testSu3.setMaxHealth(100);
        testSu4.setMaxHealth(100);
        QuarterEvents.taxCuts();
        assertEquals(120, testSu1.getMaxHealth());
        assertEquals(120, testSu2.getMaxHealth());
        assertEquals(120, testSu3.getMaxHealth());
        assertEquals(120, testSu4.getMaxHealth());
    }

    @Test
    public void financialCrisis() {
        testSu1.setAttack(100);
        testSu1.setDefense(100);
        testSu2.setAttack(100);
        testSu2.setDefense(100);
        testSu3.setAttack(100);
        testSu3.setDefense(100);
        testSu4.setAttack(100);
        testSu4.setDefense(100);

        QuarterEvents.financialCrisis();

        assertEquals(80, testSu1.getDefense());
        assertEquals(80, testSu1.getAttack());
        assertEquals(80, testSu2.getDefense());
        assertEquals(80, testSu2.getAttack());
        assertEquals(100, testSu3.getDefense());
        assertEquals(100, testSu3.getAttack());
        assertEquals(80, testSu4.getDefense());
        assertEquals(80, testSu4.getAttack());
    }

    @Test
    public void monopolyBusting() {
        testSu1.setMaxHealth(100);
        testSu2.setMaxHealth(100);
        testSu1.setDefense(400);
        testSu2.setDefense(400);

        testSu3.setMaxHealth(100);
        testSu4.setMaxHealth(100);
        QuarterEvents.monopolyBusting();
        assertEquals(80, testSu1.getMaxHealth());
        assertEquals(80, testSu2.getMaxHealth());
        assertEquals(120, testSu3.getMaxHealth());
        assertEquals(120, testSu4.getMaxHealth());
    }

    @Test
    public void lobbying() {
        testSu1.setDefense(100);
        testSu2.setDefense(100);
        testSu3.setDefense(100);
        testSu4.setDefense(100);

        QuarterEvents.lobbying();

        assertEquals(120, testSu1.getDefense());
        assertEquals(120, testSu2.getDefense());
        assertEquals(120, testSu3.getDefense());
        assertEquals(120, testSu4.getDefense());
    }
}