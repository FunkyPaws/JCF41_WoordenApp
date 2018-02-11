package woordenapplicatie;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WoordenManager {

    public WoordenManager() {
    }

    public String[] splitString(String string) {
        return string.toLowerCase().split("[,\n ]+");
    }

    public Integer getAmountAllWords(String[] strings) {
        return strings.length;
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
}
