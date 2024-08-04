package com.example;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FileStatistics {
    public void printShortStatistics(@NotNull List<Integer> integers, @NotNull List<Float> floats, @NotNull List<String> strings) {
        System.out.println("Integers: " + integers.size());
        System.out.println("Floats: " + floats.size());
        System.out.println("Strings: " + strings.size());
    }

    public void printFullStatistics(List<Integer> integers, List<Float> floats, List<String> strings) {
        printFullIntegerStatistics(integers);
        printFullFloatStatistics(floats);
        printFullStringStatistics(strings);
    }


    private void printFullIntegerStatistics(@NotNull List<Integer> integers) {
        if (integers.isEmpty()) {
            return;
        }

        int min = integers.get(0);
        int max = integers.get(0);
        int sum = 0;

        for(int num : integers) {

            if(num < min) {
                min = num;
            }
            if(num > max) {
                max = num;
            }

            sum += num;
        }

        double average = sum / (double) integers.size();

        System.out.println("Full integer statistics:");
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }

    private void printFullFloatStatistics(@NotNull List<Float> floats) {
        if (floats.isEmpty()) {
            return;
        }

        float min = floats.get(0);
        float max = floats.get(0);
        float sum = 0;

        for (float num : floats) {

            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }

            sum += num;
        }

        double average = sum / (double) floats.size();

        System.out.println("Full float statistics:");
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }

    private void printFullStringStatistics(@NotNull List<String> strings) {
        if (strings.isEmpty()) {
            return;
        }

        int minLength = strings.get(0).length();
        int maxLength = strings.get(0).length();

        for (String str : strings) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
            if (str.length() > maxLength) {
                maxLength = str.length();
            }
        }

        System.out.println("Full string statistics:");
        System.out.println("Min length: " + minLength);
        System.out.println("Max length: " + maxLength);
    }
}