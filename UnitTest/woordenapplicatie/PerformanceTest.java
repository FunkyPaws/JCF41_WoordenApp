package woordenapplicatie;

import org.junit.Before;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PerformanceTest {
    private WoordenManager manager;

    private static final Logger logger = Logger.getLogger(WoordenManager.class.getName());

    private static final String DEFAULT_TEXT = "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Heb je dan geen hoedje meer\n" +
            "Maak er één van bordpapier\n" +
            "Eén, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "En als het hoedje dan niet past\n" +
            "Zetten we 't in de glazenkas\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier";

    @Before
    public void setUp() throws Exception {
        manager = new WoordenManager();
    }

    @Test
    public void splitString() throws Exception {
        long startTime = System.nanoTime();

        manager.splitString(DEFAULT_TEXT);

        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);
    }

    @Test
    public void getAmountAllWords() throws Exception {
        long startTime = System.nanoTime();

        manager.getAmountAllWords(DEFAULT_TEXT);

        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);
    }

    @Test
    public void getAmountDistinctWords() throws Exception {
        long startTime = System.nanoTime();

        manager.getAmountDistinctWords(DEFAULT_TEXT);

        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);
    }

    @Test
    public void getFrequency() throws Exception {
        long startTime = System.nanoTime();

        manager.getFrequency(DEFAULT_TEXT);

        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);
    }

    @Test
    public void getConcordatie() throws Exception {
        long startTime = System.nanoTime();

        manager.getConcordatie(DEFAULT_TEXT);

        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);
    }
}