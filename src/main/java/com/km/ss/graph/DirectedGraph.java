package com.km.ss.graph;

import java.util.*;

public class DirectedGraph {
    private final Map<String, Map<String, Integer>> dictionary = new HashMap<>();

    public void addConnection(String word1, String word2) {
        Map<String, Integer> map = dictionary.get(word1);
        if (map == null) {
            dictionary.put(word1, Map.of(word2, 1));
        } else {
            if (map.containsKey(word2))
                map.compute(word2, (k, v) -> v + 1);
            else
                map.put(word2, 1);
        }
    }

    public int getCount(String word1) {
        Map<String, Integer> map = dictionary.get(word1);
        if (map == null) {
            return 0;
        } else {
            return map.values().stream().reduce(0, Integer::sum);
        }
    }

    public int getWeight(String word1, String word2) {
        Map<String, Integer> map = dictionary.get(word1);
        if (map == null) {
            return 0;
        } else {
            return map.getOrDefault(word2, 0);
        }
    }

    public Set<String> getConnections(String word1) {
        Map<String, Integer> map = dictionary.get(word1);
        if (map == null) {
            return Collections.emptySet();
        } else {
            return map.keySet();
        }
    }
}
