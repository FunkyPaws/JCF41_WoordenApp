package woordenapplicatie;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WoordenManager {
    private static final Logger logger = Logger.getLogger(WoordenManager.class.getName());

    public WoordenManager() {
    }

    public String[] splitString(String string) {
        //O(n)
        String[] returnString = string.toLowerCase().split("[,\n .]+");
        return returnString;
    }

    public Integer getAmountAllWords(String string) {
        //O(n)
        String[] strings = this.splitString(string);
        Integer returnInt = strings.length;
        return returnInt;
    }

    public Integer getAmountDistinctWords(String string) {
        //O(n)
        String[] strings = this.splitString(string);
        //O(log n)
        Set<String> woorden = new TreeSet<>();
        Collections.addAll(woorden, strings);
        Integer returnInt = woorden.size();
        return returnInt;
    }

    public Map<String, Integer> getFrequency(String text) {
        String[] strings = this.splitString(text);

        HashMap<String, Integer> frequency = new HashMap<>();
        for (String string : strings) {
            if (frequency.containsKey(string)) {
                frequency.put(string, frequency.get(string) + 1);
            } else {
                frequency.put(string, 1);
            }
        }
        return frequency;
    }

    public Map<String, Set<Integer>> getConcordatie(String string) {
        //O(logn)
        HashMap<String, Set<Integer>> concordatie = new HashMap<>();
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
        }//O(logn) * O(1)
        return concordatie;
    }
}