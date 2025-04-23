package org.example;

import org.example.testsHelpers.TestDataReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем файл для записи результатов
        String outputFile = "C:\\Users\\User\\IdeaProjects\\IntroSort\\src\\main\\java\\org\\example\\results";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            // Записываем заголовок
            writer.write("Size Operations Time(ns)");
            writer.newLine();

            List<int[]> testData = TestDataReader.readAllTestData();
            for (int[] data : testData) {
                IntroSort introSort = new IntroSort();
                int[] arr = data.clone();

                long startTime = System.nanoTime();
                introSort.sort(arr);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                // Записываем данные в файл
                writer.write(String.format("%d %d %d", arr.length, introSort.getIterations(), duration));
                writer.newLine();
            }

            System.out.println("Результаты успешно записаны в файл: " + outputFile);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}