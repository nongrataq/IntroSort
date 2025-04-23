package org.example.testsHelpers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestDataReader {
    private static final String DATA_DIR = "C:\\Users\\User\\IdeaProjects\\IntroSort\\src\\main\\java\\org\\example\\data_for_tests";

    public static List<int[]> readAllTestData() {
        List<int[]> testData = new ArrayList<>();
        File directory = new File(DATA_DIR);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles((_, name) -> name.startsWith("test_data_") && name.endsWith(".txt"));

            if (files != null) {
                for (File file : files) {
                    int[] data = readTestDataFile(file);
                    if (data != null) {
                        testData.add(data);
                    }
                }
            }
        }

        return testData;
    }

    private static int[] readTestDataFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int size = Integer.parseInt(reader.readLine());
            int[] array = new int[size];

            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(reader.readLine());
            }
            return array;
        } catch (IOException e) {
            System.err.println("Error reading file: " + file.getName());
            e.printStackTrace();
            return null;
        }
    }
}