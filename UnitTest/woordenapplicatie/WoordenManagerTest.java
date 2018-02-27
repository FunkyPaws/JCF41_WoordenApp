package woordenapplicatie;

import org.junit.Before;
import org.junit.Test;
import woordenapplicatie.logic.ILogic;
import woordenapplicatie.logic.WoordenManager;

import java.util.*;

import static org.junit.Assert.*;

public class WoordenManagerTest {

    private ILogic logic;
    private String testString1;
    private String testString2;
    private String testString3;
    private String testString4;

    @Before
    public void setUp() throws Exception {
        logic = new WoordenManager();
        testString1 = "This is a test string, randomly.\n allocated characters and words";
        testString2 = "this is a test string";
        testString3 = "This is a test, a test this is";
        testString4 = "Een, twee, drie, vier\n" +
                "Hoedje van, hoedje van\n" +
                "Een, twee, drie, vier\n";
    }

    @Test
    public void getSorteerAction() throws Exception {
//        String[] result1 = manager.splitString(testString2);
//        String[] result2 = testString2.split(" ");
//
//        String[] result3 = manager.splitString(testString1);
//        String[] result4 = testString1.split("[,\n .]+");
//
//        assertEquals(result2.length, result1.length);
//        assertEquals(result4.length, result3.length);
//
//        assertNotEquals(result2.length, result3.length);
//        assertNotEquals(result4.length, result1.length);
    }

    @Test
    public void getAmountAllWords() throws Exception {
        int amount1 = 10;
        int amount2 = 5;

        int result1 = logic.getAmountAllWords(testString1);
        int result2 = logic.getAmountAllWords(testString2);

        assertEquals(amount1, result1);
        assertEquals(amount2, result2);

        assertNotEquals(amount1, result2);
        assertNotEquals(amount2, result1);
    }

    @Test
    public void getAmountDistinctWords() throws Exception {
        int amount1 = 5;
        int amount2 = 4;

        int result1 = logic.getAmountDistinctWords(testString2);
        int result2 = logic.getAmountDistinctWords(testString3);

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

        Map<String, Integer> result1 = logic.getFrequency(testString3);
        Map<String, Integer> result2 = logic.getFrequency(testString2);

        assertTrue(frequency1.equals(result1));
        assertTrue(frequency2.equals(result2));

        assertFalse(frequency1.equals(result2));
        assertFalse(frequency2.equals(result1));
    }

    @Test
    public void getConcordatie() throws Exception {
        HashMap<String, Set<Integer>> concordatie = new HashMap<>();
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

        Map<String, Set<Integer>> test = logic.getConcordatie(testString4);

        assertTrue(concordatie.equals(test));
    }
}