package dev.revzik.aoc2023;

import dev.revzik.aoc2023.day3.SchemaAnalyzer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Day3Test {
    private static final String[] INPUT1 = {
            "467..114..",
            "...*......",
            "...35..633",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598.."
    };

    private static final String[] INPUT2 = {
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598..",
    };

    @Test
    void findPartsTest() {
        SchemaAnalyzer analyzer = new SchemaAnalyzer(INPUT2);
        Assertions.assertEquals(4361, analyzer.findPartNumbersSum());
    }

    @Test
    void charAttemptTest() {
        //          0123456789
        char[] a = "...35..633".toCharArray(); // fix this case
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '.') {
                continue;
            }
            if (SchemaAnalyzer.isDigit(a[i])) {
                int length = 1;
                while (i + length != a.length && SchemaAnalyzer.isDigit(a[i + length])) {
                    length++;
                }
                System.out.printf("Number: %s, Beginning: %d, End %d\n", String.valueOf(a, i, length), i, i + length - 1);
                i += length;
            }
        }
    }

    @Test
    void stringAttemptTest() {
        //          0123456789
        String a = "...35..633";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '.') {
                continue;
            }
            if (SchemaAnalyzer.isDigit(a.charAt(i))) {
                int end = i + 1;
                while (end != a.length() && SchemaAnalyzer.isDigit(a.charAt(end))) {
                    end++;
                }
                System.out.printf("Number: %s, Beginning: %d, End %d\n", a.substring(i, end), i, end - 1);
                i = end;
            }
        }
    }
}
