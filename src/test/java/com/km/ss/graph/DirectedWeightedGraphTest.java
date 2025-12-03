package com.km.ss.graph;

import org.junit.Assert;
import org.junit.Test;

public class DirectedWeightedGraphTest {

    @Test
    public void getCount() {
        DirectedWeightedGraph graph = buildSimple();

        Assert.assertEquals(3, graph.getCount("a"));
        Assert.assertEquals(1, graph.getCount("b"));
        Assert.assertEquals(0, graph.getCount("c"));
    }

    @Test
    public void getCountWithCycle() {
        DirectedWeightedGraph graph = buildWithCycle();

        Assert.assertEquals(2, graph.getCount("a"));
        Assert.assertEquals(2, graph.getCount("b"));
        Assert.assertEquals(1, graph.getCount("d"));
        Assert.assertEquals(0, graph.getCount("c"));
    }

    @Test
    public void getWeight() {
        DirectedWeightedGraph graph = buildSimple();

        Assert.assertEquals(2, graph.getWeight("a", "b"));
        Assert.assertEquals(1, graph.getWeight("a", "c"));
        Assert.assertEquals(0, graph.getWeight("c", "x"));
    }

    @Test
    public void getWeightWithCycle() {
        DirectedWeightedGraph graph = buildWithCycle();

        Assert.assertEquals(2, graph.getWeight("a", "b"));
        Assert.assertEquals(1, graph.getWeight("b", "a"));
        Assert.assertEquals(1, graph.getWeight("d", "a"));
        Assert.assertEquals(0, graph.getWeight("c", "x"));
    }

    @Test
    public void getConnections() {
        DirectedWeightedGraph graph = buildSimple();

        Assert.assertEquals(2, graph.getConnections("a").size());
        Assert.assertTrue(graph.getConnections("a").contains("b"));
        Assert.assertTrue(graph.getConnections("a").contains("c"));
        Assert.assertEquals(1, graph.getConnections("b").size());
        Assert.assertTrue(graph.getConnections("b").contains("d"));
        Assert.assertEquals(0, graph.getConnections("c").size());
    }

    @Test
    public void getConnectionsWithCycle() {
        DirectedWeightedGraph graph = buildWithCycle();

        Assert.assertEquals(1, graph.getConnections("a").size());
        Assert.assertTrue(graph.getConnections("a").contains("b"));
        Assert.assertEquals(2, graph.getConnections("b").size());
        Assert.assertTrue(graph.getConnections("b").contains("a"));
        Assert.assertTrue(graph.getConnections("b").contains("d"));
        Assert.assertEquals(0, graph.getConnections("c").size());
    }

    @Test
    public void getWords() {
        DirectedWeightedGraph graph = buildSimple();

        Assert.assertEquals(3, graph.getWords().size());
        Assert.assertTrue(graph.getWords().contains("a"));
        Assert.assertTrue(graph.getWords().contains("b"));
        Assert.assertTrue(graph.getWords().contains("d"));
        Assert.assertFalse(graph.getWords().contains("c"));
    }

    @Test
    public void getWordsWithCycle() {
        DirectedWeightedGraph graph = buildWithCycle();

        Assert.assertEquals(3, graph.getWords().size());
        Assert.assertTrue(graph.getWords().contains("a"));
        Assert.assertTrue(graph.getWords().contains("b"));
        Assert.assertTrue(graph.getWords().contains("d"));
        Assert.assertFalse(graph.getWords().contains("c"));
    }

    private DirectedWeightedGraph buildSimple() {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();

        graph.addConnection("a", "b");
        graph.addConnection("a", "b");
        graph.addConnection("a", "c");
        graph.addConnection("b", "d");
        graph.addConnection("d", "a");

        return graph;
    }

    private DirectedWeightedGraph buildWithCycle() {
        DirectedWeightedGraph graph = new DirectedWeightedGraph();

        graph.addConnection("a", "b");
        graph.addConnection("a", "b");
        graph.addConnection("b", "a");
        graph.addConnection("b", "d");
        graph.addConnection("d", "a");

        return graph;
    }
}