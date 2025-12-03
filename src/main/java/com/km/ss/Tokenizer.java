package com.km.ss;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    public static final String START = "<<START>>";
    public static final String END = "<<END>>";

    public static List<String> tokenize(List<String> input) {
        List<String> output = new ArrayList<>();

        output.add(START);

        for (String s : input) {
            if (s.equals(".")) {
                output.add(END);
                output.add(START);
                continue;
            }

            if (s.endsWith(".")) {
                output.add(s.substring(0, s.length() - 1));
                output.add(END);
                output.add(START);
            } else
                output.add(s);
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

        for (String s : input) {
            if (s.equals(START))
                continue;

            if (s.equals(END)) {
                output.set(output.size() - 1, output.get(output.size() - 1) + ".");
                continue;
            }

            output.add(s);
        }

        return output;
    }
}
