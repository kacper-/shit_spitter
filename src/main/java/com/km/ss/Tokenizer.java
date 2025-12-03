package com.km.ss;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public static final String START = "<<START>>";
    public static final String END = "<<END>>";

    public static List<String> tokenize(List<String> input) {
        List<String> output = new ArrayList<>();

        output.add(START);

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals(".")) {
                output.add(END);
                output.add(START);
                continue;
            }

            if (input.get(i).endsWith(".")) {
                output.add(input.get(i).substring(0, input.get(i).length() - 1));
                output.add(END);
                output.add(START);
            } else
                output.add(input.get(i));
        }

        if (output.getLast().equals(START))
            output.removeLast();

        if (output.getLast().equals(END))
            return output;

        output.add(END);

        return output;
    }

    public static List<String> detokenize(List<String> input) {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals(START))
                continue;

            if (input.get(i).equals(END)) {
                output.set(output.size() - 1, output.get(output.size() - 1) + ".");
                continue;
            }

            output.add(input.get(i));
        }

        return output;
    }
}
