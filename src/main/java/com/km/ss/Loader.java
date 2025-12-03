package com.km.ss;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loader {
    public static List<String> readFromPath(String path) {
        List<String> list = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();

            while (line != null) {
                list.addAll(Arrays.asList(line.split(" ")));
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file");
            System.exit(1);
        }

        return list;
    }
}
