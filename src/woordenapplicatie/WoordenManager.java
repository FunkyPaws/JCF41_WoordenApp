package woordenapplicatie;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WoordenManager {
    private static final Logger logger = Logger.getLogger(WoordenManager.class.getName());

    public WoordenManager() {
    }

    public String[] splitString(String string) {
        long startTime = System.nanoTime();

        String[] returnString = string.toLowerCase().split("[,\n .]+");

        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        return returnString;
    }

    public Integer getAmountAllWords(String[] strings) {
        long startTime = System.nanoTime();

        Integer returnInt = strings.length;

        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        return returnInt;
    }

    public Integer getAmountDistinctWords(String[] strings) {
        long startTime = System.nanoTime();

        Set<String> woorden = new TreeSet<>();
        Collections.addAll(woorden, strings);
        Integer returnInt = woorden.size();

        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        return returnInt;
    }

    public Map<String, Integer> getFrequency(String[] strings) {
        long startTime = System.nanoTime();

        HashMap<String, Integer> frequency = new LinkedHashMap<>();
        for (String string : strings) {
            if (frequency.containsKey(string)) {
                frequency.put(string, frequency.get(string) + 1);
            } else {
                frequency.put(string, 1);
            }
        }

        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        return frequency;
    }

    public Map<String, Set<Integer>> getConcordatie(String string) {
        long startTime = System.nanoTime();

        TreeMap<String, Set<Integer>> concordatie = new TreeMap<>();
        int lines = 0;
        for (String line : string.toLowerCase().split("[\n]+")) {
            lines++;
            for (String word : line.split("[,\n .]+")) {
                if (word.isEmpty()) {
                    continue;
                }
                if (!concordatie.containsKey(word)) {
                    concordatie.put(word, new HashSet<>());
                }
                Set<Integer> set = concordatie.get(word);
                set.add(lines);
            }
        }

        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - Time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        return concordatie;
    }
}
