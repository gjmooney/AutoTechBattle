package test.java;

import main.java.siliconsim.Cycle;
import main.java.siliconsim.EvenQuarter;
import main.java.siliconsim.GameLogic;
import main.java.siliconsim.players.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class EvenQuarterTest {
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
    public void doQuarterEventOne() {
        GameLogic.getLogic().setCycleState(new EvenQuarter());

        testSu1.setAttack(100);
        testSu1.setDefense(100);
        testSu2.setAttack(100);
        testSu2.setDefense(100);
        testSu3.setAttack(100);
        testSu3.setDefense(100);
        testSu4.setAttack(100);
        testSu4.setDefense(100);

        GameLogic.getLogic().getCycleState().doQuarterEvent(1, tesTg1);

        assertEquals(80, testSu1.getDefense());
        assertEquals(80, testSu1.getAttack());
        assertEquals(80, testSu2.getDefense());
        assertEquals(80, testSu2.getAttack());
        assertEquals(100, testSu3.getDefense());
        assertEquals(100, testSu3.getAttack());
        assertEquals(80, testSu4.getDefense());
        assertEquals(80, testSu4.getAttack());
        assertFalse(tesTg1.isCatchWildStartUp());
    }

    @Test
    public void doQuarterEventThree() {
        GameLogic.getLogic().setCycleState(new EvenQuarter());

        testSu1.setDefense(100);
        testSu2.setDefense(100);
        testSu3.setDefense(100);
        testSu4.setDefense(100);

        GameLogic.getLogic().getCycleState().doQuarterEvent(3, tesTg1);

        assertEquals(120, testSu1.getDefense());
        assertEquals(120, testSu2.getDefense());
        assertEquals(120, testSu3.getDefense());
        assertEquals(120, testSu4.getDefense());
        assertFalse(tesTg1.isCatchWildStartUp());

    }
}