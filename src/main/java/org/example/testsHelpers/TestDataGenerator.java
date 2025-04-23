package org.example.testsHelpers;

import java.io.*;
import java.util.Random;

public class TestDataGenerator {
    private static final String DATA_DIR = "C:\\Users\\User\\IdeaProjects\\IntroSort\\src\\main\\java\\org\\example\\data_for_tests";
    private static final int MIN_SIZE = 100;
    private static final int MAX_SIZE = 10000;
    private static final int DATA_SETS_COUNT = 100;

    public static void main(String[] args) {
        createDataDirectory();
        generateTestDataFiles();
        System.out.println("Generated " + DATA_SETS_COUNT + " test files in directory: " + DATA_DIR);
    }

    private static void createDataDirectory() {
        File directory = new File(DATA_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    private static void generateTestDataFiles() {
        for (int i = 0; i < DATA_SETS_COUNT; i++) {
            int size = MIN_SIZE + (i * (MAX_SIZE - MIN_SIZE) / DATA_SETS_COUNT);
            if (i == DATA_SETS_COUNT - 1) size = MAX_SIZE;

            int[] array = generateRandomArray(size);
            saveArrayToFile(array, i);
        }
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(-20000,50000);
        }
        return array;
    }

    private static void saveArrayToFile(int[] array, int fileIndex) {
        String fileName = DATA_DIR + "/test_data_" + fileIndex + ".txt";
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.println(array.length); // Первая строка - размер массива
            for (int num : array) {
                writer.println(num);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error writing to file: " + fileName);
            e.printStackTrace();
        }
    }
}