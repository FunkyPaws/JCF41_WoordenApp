package woordenapplicatie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WoordenManagerTest {

    private WoordenManager manager;
    private String testString1;
    private String testString2;
    private String testString3;

    @Before
    public void setUp() throws Exception {
        manager = new WoordenManager();
        testString1 = "This is the test string, randomly. allocated characters and words";
        testString2 = "this is a test string";
        testString3 = "This is a test, a test this is";
    }

    @Test
    public void splitString() throws Exception {
        String[] result1 = manager.splitString(testString2);
        String[] result2 = testString2.split(" ");

        String[] result3 = manager.splitString(testString1);
        String[] result4 = testString1.split("[,\n .]+");

        assertEquals(result2.length, result1.length);
        assertEquals(result4.length, result3.length);

        assertNotEquals(result2.length, result3.length);
        assertNotEquals(result4.length, result1.length);
    }

    @Test
    public void getAmountAllWords() throws Exception {
        int amount1 = 10;
        int amount2 = 5;

        String[] test1 = manager.splitString(testString1);
        String[] test2 = manager.splitString(testString2);

        int result1 = manager.getAmountAllWords(test1);
        int result2 = manager.getAmountAllWords(test2);

        assertEquals(amount1, result1);
        assertEquals(amount2, result2);

        assertNotEquals(amount1, result2);
        assertNotEquals(amount2, result1);
    }

    @Test
    public void getAmountDistinctWords() throws Exception {
        int amount1 = 5;
        int amount2 = 4;

        String[] test1 = manager.splitString(testString2);
        String[] test2 = manager.splitString(testString3);

        int result1 = manager.getAmountDistinctWords(test1);
        int result2 = manager.getAmountDistinctWords(test2);

        assertEquals(amount1, result1);
        assertEquals(amount2, result2);

        assertNotEquals(amount1, result2);
        assertNotEquals(amount2, result1);

    }

    @Test
    public void getFrequency() throws Exception {
    }

    @Test
    public void getConcordatie() throws Exception {
    }

}