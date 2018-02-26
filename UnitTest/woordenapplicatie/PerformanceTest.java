package woordenapplicatie;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerformanceTest {
    private WoordenManager manager;
    private String string10k;
    private String string1m;

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
        string10k = generateString(10000);
        string1m = generateString(1000000);
    }

    @Test
    public void splitString() throws Exception {
        long startTime = System.nanoTime();
        manager.splitString(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        manager.splitString(string10k);
        long resultTime10k = System.nanoTime() - startTime10k;
        String logMessage10k = String.format("getSplitText 10k - Time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1m = System.nanoTime();
        manager.splitString(string1m);
        long resultTime1m = System.nanoTime() - startTime1m;
        String logMessage1m = String.format("getSplitText 1m - Time measured: %d nanoseconds", resultTime1m);
        logger.log(Level.INFO, logMessage1m);
    }

    @Test
    public void getAmountAllWords() throws Exception {
        long startTime = System.nanoTime();
        manager.getAmountAllWords(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("all amount - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        manager.getAmountAllWords(string10k);
        long resultTime10k = System.nanoTime() - startTime10k;
        String logMessage10k = String.format("all amount 10k- Time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1m = System.nanoTime();
        manager.getAmountAllWords(string1m);
        long resultTime1m = System.nanoTime() - startTime1m;
        String logMessage1m = String.format("all amount 1m - Time measured: %d nanoseconds", resultTime1m);
        logger.log(Level.INFO, logMessage1m);
    }

    @Test
    public void getAmountDistinctWords() throws Exception {
        long startTime = System.nanoTime();
        manager.getAmountDistinctWords(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("distinct amount - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        manager.getAmountDistinctWords(string10k);
        long resultTime10k = System.nanoTime() - startTime10k;
        String logMessage10k = String.format("distinct amount 10k - Time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1m = System.nanoTime();
        manager.getAmountDistinctWords(string1m);
        long resultTime1m = System.nanoTime() - startTime1m;
        String logMessage1m = String.format("distinct amount 1m - Time measured: %d nanoseconds", resultTime1m);
        logger.log(Level.INFO, logMessage1m);
    }

    @Test
    public void getFrequency() throws Exception {
        long startTime = System.nanoTime();
        manager.getFrequency(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("frequency - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        manager.getFrequency(string10k);
        long resultTime10k = System.nanoTime() - startTime10k;
        String logMessage10k = String.format("frequency 10k - Time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1m = System.nanoTime();
        manager.getFrequency(string1m);
        long resultTime1m = System.nanoTime() - startTime1m;
        String logMessage1m = String.format("frequency 1m - Time measured: %d nanoseconds", resultTime1m);
        logger.log(Level.INFO, logMessage1m);
    }

    @Test
    public void getConcordatie() throws Exception {
        long startTime = System.nanoTime();
        manager.getConcordatie(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("concordatie - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        manager.getConcordatie(string10k);
        long resultTime10k = System.nanoTime() - startTime10k;
        String logMessage10k = String.format("concordatie 10k - Time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1m = System.nanoTime();
        manager.getConcordatie(string1m);
        long resultTime1m = System.nanoTime() - startTime1m;
        String logMessage1m = String.format("concordatie 1m - Time measured: %d nanoseconds", resultTime1m);
        logger.log(Level.INFO, logMessage1m);
    }

    private String generateString(int numberOfWords)
    {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfWords; i++)
        {
            String name = " " + rnd.nextInt();
            if ((i % 5) == 0)
            {
                sb.append("\n");
            }
            sb.append(name + "");
        }

        return sb.toString();
    }




}