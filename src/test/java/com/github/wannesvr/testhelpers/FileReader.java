package com.github.wannesvr.testhelpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileReader {
    public static String readFileAsString(String fileName) {
        InputStream resourceAsStream = FileReader.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            System.err.println("Couldn't read JSON file: " + e.getMessage());
            System.exit(1);
        }

        return stringBuilder.toString();
    }
}
