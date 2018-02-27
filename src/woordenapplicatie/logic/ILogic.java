package woordenapplicatie.logic;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public interface ILogic {

    Integer getAmountAllWords(String string);
    Integer getAmountDistinctWords(String string);
    Iterator<String> getSorteerAction(String string);
    Map<String, Integer> getFrequency(String text);
    Map<String, Set<Integer>> getConcordatie(String string);
}
