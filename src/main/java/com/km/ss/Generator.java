package com.km.ss;

import com.km.ss.graph.DirectedWeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    public static DirectedWeightedGraph listToGraph(List<String> input) {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();

        for (int i = 1; i < input.size(); i++)
            graph.addConnection(input.get(i - 1), input.get(i));

        return graph;
    }

    public static List<String> graphToList(DirectedWeightedGraph graph, String start, int size) {
        List<String> output = new ArrayList<>();

        String lastWord = start;
        output.add(lastWord);

        while (output.size() < size) {
            List<String> connections = List.copyOf(graph.getConnections(lastWord));
            int count = graph.getCount(lastWord);
            int random = new Random().nextInt(count);

            int sum = 0;
            for (String connection : connections) {
                sum += graph.getWeight(lastWord, connection);
                if (sum > random) {
                    lastWord = connection;
                    break;
                }
            }

            output.add(lastWord);
        }

        return output;
    }
}
