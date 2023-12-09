package dev.revzik.aoc2023.day1;

import dev.revzik.aoc2023.util.FileUtils;

import java.nio.file.Path;
import java.util.Map;

public class Day1 {

    private static final Map<String, Integer> STRING_TO_DIGIT = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );
    public static void main(String[] args) {
        int sum = 0;

        for (String line : FileUtils.readFileToLines(Path.of("day1", "input.txt"))) {
            sum += findValue(line);
        }

        System.out.println(sum);
    }

    public static int findValue(String line) {
        return findFirstDigit(line) * 10 + findLastDigit(line);
    }

    private static int findFirstDigit(String line) {
        for (int i = 0; i < line.length(); i++) {
            try {
                return Integer.parseInt(String.valueOf(line.charAt(i)));
            } catch (NumberFormatException ignored) {
                String subLine = line.substring(i);
                for (String s : STRING_TO_DIGIT.keySet()) {
                    if (subLine.startsWith(s)) {
                        return STRING_TO_DIGIT.get(s);
                    }
                }
            }
        }

        throw new NumberFormatException("No digit present in the string");
    }

    private static int findLastDigit(String line) {
        for (int i = line.length() - 1; i >= 0; i--) {
            try {
                return Integer.parseInt(String.valueOf(line.charAt(i)));
            } catch (NumberFormatException ignored) {
                String subLine = line.substring(0, i + 1);
                for (String s : STRING_TO_DIGIT.keySet()) {
                    if (subLine.endsWith(s)) {
                        return STRING_TO_DIGIT.get(s);
                    }
                }
            }
        }

        throw new NumberFormatException("No digit present in the string");
    }
}
