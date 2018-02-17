package woordenapplicatie;

import java.util.*;

public class WoordenManager {

    public WoordenManager() {
    }

    public String[] splitString(String string) {
        return string.toLowerCase().split("[,\n .]+");
    }

    public Integer getAmountAllWords(String[] strings) {
        return strings.length;
    }

    public Integer getAmountDistinctWords(String[] strings){
        Set<String> woorden = new TreeSet<>();
        Collections.addAll(woorden, strings);
        return woorden.size();
    }

    public Map<String, Integer> getFrequency(String[] strings) {
        HashMap<String, Integer> frequency = new LinkedHashMap<>();
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
        TreeMap<String, Set<Integer>> concordatie = new TreeMap<>();
        int lines = 0;
        for (String line : string.toLowerCase().split("[\n]+")) {
            lines++;
            for(String word: line.split("[,\n .]+")){
                if(word.isEmpty()){
                    continue;
                }
                if(!concordatie.containsKey(word)){
                    concordatie.put(word, new HashSet<>());
                }
                Set<Integer>set = concordatie.get(word);
                set.add(lines);
            }
        }
        return concordatie;
    }
}
