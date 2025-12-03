package com.km.ss.graph;

import java.util.*;

public class DirectedGraph {
    private final Map<String, Map<String, Integer>> dictionary = new HashMap<>();

    public void addConnection(String word1, String word2) {
        Map<String, Integer> map = dictionary.get(word1);
        if (map == null) {
            map = new HashMap<>();
            map.put(word2, 1);
            dictionary.put(word1, map);
        }
        else
            map.merge(word2, 1, Integer::sum);
    }

    public int getCount(String word1) {
        Map<String, Integer> map = dictionary.get(word1);
        if (map == null)
            return 0;
        else
            return map.values().stream().reduce(0, Integer::sum);
    }

    public int getWeight(String word1, String word2) {
        Map<String, Integer> map = dictionary.get(word1);
        if (map == null)
            return 0;
        else
            return map.getOrDefault(word2, 0);
    }

    public Set<String> getConnections(String word1) {
        Map<String, Integer> map = dictionary.get(word1);
        if (map == null)
            return Collections.emptySet();
        else
            return map.keySet();
    }

    public Set<String> getWords() {
        return dictionary.keySet();
    }
}
