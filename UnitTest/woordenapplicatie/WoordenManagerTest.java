package woordenapplicatie;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class WoordenManagerTest {

    private WoordenManager manager;
    private String testString1;
    private String testString2;
    private String testString3;
    private String testString4;

    @Before
    public void setUp() throws Exception {
        manager = new WoordenManager();
        testString1 = "This is a test string, randomly.\n allocated characters and words";
        testString2 = "this is a test string";
        testString3 = "This is a test, a test this is";
        testString4 = "Een, twee, drie, vier\n" +
                "Hoedje van, hoedje van\n" +
                "Een, twee, drie, vier\n";
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
        HashMap<String, Integer> frequency1 = new LinkedHashMap<>();
        frequency1.put("this", 2);
        frequency1.put("is", 2);
        frequency1.put("a", 2);
        frequency1.put("test", 2);

        HashMap<String, Integer> frequency2 = new LinkedHashMap<>();
        frequency2.put("this", 1);
        frequency2.put("is", 1);
        frequency2.put("a", 1);
        frequency2.put("test", 1);
        frequency2.put("string", 1);

        String[] test1 = manager.splitString(testString3);
        String[] test2 = manager.splitString(testString2);

        Map<String, Integer> result1 = manager.getFrequency(test1);
        Map<String, Integer> result2 = manager.getFrequency(test2);

        assertTrue(frequency1.equals(result1));
        assertTrue(frequency2.equals(result2));

        assertFalse(frequency1.equals(result2));
        assertFalse(frequency2.equals(result1));
    }

    @Test
    public void getConcordatie() throws Exception {
        TreeMap<String, Set<Integer>> concordatie = new TreeMap<>();
        Set set1 = new HashSet();
        set1.add(1);
        set1.add(3);
        concordatie.put("een", set1);
        concordatie.put("twee", set1);
        concordatie.put("drie", set1);
        concordatie.put("vier", set1);
        Set set2 = new HashSet();
        set2.add(2);
        concordatie.put("hoedje", set2);
        concordatie.put("van", set2);

        Map<String, Set<Integer>> test = manager.getConcordatie(testString4);

        assertTrue(concordatie.equals(test));
    }
}