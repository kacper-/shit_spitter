package com.km.ss;

import com.km.ss.graph.DirectedWeightedGraph;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GeneratorTest {

    @Test
    public void listToGraph() {
        DirectedWeightedGraph graph = Generator.listToGraph(buildSimple());
        Assert.assertEquals(4, graph.getWords().size());
    }

    @Test
    public void graphToList() {

    }

    private List<String> buildSimple() {
        return Arrays.asList("a", "b", "c", "d", "a");
    }
}