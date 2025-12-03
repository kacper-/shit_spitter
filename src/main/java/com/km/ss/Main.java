package com.km.ss;

import com.km.ss.graph.DirectedWeightedGraph;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            usage();
            System.out.println("\nWrong number of arguments");
            System.exit(1);
        }

        int length = 0;
        String path = "";

        try {
            length = Integer.parseInt(args[0]);
            path = args[1];
        } catch (Exception e) {
            usage();
            System.out.println("\nError parsing arguments");
            System.exit(1);
        }

        List<String> input = Loader.readFromPath(path);
        List<String> tokenized = Tokenizer.tokenize(input);
        DirectedWeightedGraph graph = Generator.listToGraph(tokenized);
        List<String> output = Generator.graphToList(graph, Tokenizer.START, length, Tokenizer.END);
        List<String> detokenized = Tokenizer.detokenize(output);

        System.out.println("\n");
        for (int i = 0; i < detokenized.size(); i++) {
            if ((i % 10) == 0)
                System.out.print("\n");
            System.out.print(detokenized.get(i) + " ");
        }
        System.out.println("\n");
    }

    private static void usage() {
        System.out.println("Usage:");
        System.out.println("\texample   > java -jar shit_spitter.jar length file");
        System.out.println("\tlength    - expected number of sentences in the output");
        System.out.println("\tfile      - file to populate generator graph");
    }
}
