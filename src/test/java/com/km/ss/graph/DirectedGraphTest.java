package com.km.ss.graph;

import org.junit.Assert;
import org.junit.Test;

public class DirectedGraphTest {

    @Test
    public void getCount() {
        DirectedGraph directedGraph = buildSimple();

        Assert.assertEquals(3, directedGraph.getCount("a"));
        Assert.assertEquals(1, directedGraph.getCount("b"));
        Assert.assertEquals(0, directedGraph.getCount("c"));
    }

    @Test
    public void getWeight() {
        DirectedGraph directedGraph = buildSimple();

        Assert.assertEquals(2, directedGraph.getWeight("a", "b"));
        Assert.assertEquals(1, directedGraph.getWeight("a", "c"));
        Assert.assertEquals(0, directedGraph.getWeight("c", "x"));
    }

    @Test
    public void getConnections() {
        DirectedGraph directedGraph = buildSimple();

        Assert.assertEquals(2, directedGraph.getConnections("a").size());
        Assert.assertTrue(directedGraph.getConnections("a").contains("b"));
        Assert.assertTrue(directedGraph.getConnections("a").contains("c"));
        Assert.assertEquals(1, directedGraph.getConnections("b").size());
        Assert.assertTrue(directedGraph.getConnections("b").contains("d"));
        Assert.assertEquals(0, directedGraph.getConnections("c").size());
    }

    @Test
    public void getWords() {
        DirectedGraph directedGraph = buildSimple();

        Assert.assertEquals(3, directedGraph.getWords().size());
        Assert.assertTrue(directedGraph.getWords().contains("a"));
        Assert.assertTrue(directedGraph.getWords().contains("b"));
        Assert.assertTrue(directedGraph.getWords().contains("d"));
        Assert.assertFalse(directedGraph.getWords().contains("c"));
    }

    private DirectedGraph buildSimple() {
        DirectedGraph directedGraph = new DirectedGraph();

        directedGraph.addConnection("a", "b");
        directedGraph.addConnection("a", "b");
        directedGraph.addConnection("a", "c");
        directedGraph.addConnection("b", "d");
        directedGraph.addConnection("d", "a");

        return directedGraph;
    }
}