package woordenapplicatie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WoordenManagerTest {

    private WoordenManager manager;
    private String testString1;
    private String testString2;


    @Before
    public void setUp() throws Exception {
        manager = new WoordenManager();
        testString1 = "This is the test string, randomly. allocated characters and words";
        testString2 = "this is a test string";
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
    }

    @Test
    public void getAmountDistinctWords() throws Exception {
    }

    @Test
    public void getFrequency() throws Exception {
    }

    @Test
    public void getConcordatie() throws Exception {
    }

}