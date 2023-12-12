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
            "....35.633",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            ".598..755.",
            "...$*598..",
            ".664......"
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

    private static final String[] INPUT3 = {
            "467..114..",
            "...*......",
            "....35.633",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "...1..755.",
            "...$*.....",
            ".664......"
    };

    private static final String[] INPUT4 = {
            "12.......*..",
            "+.........34",
            ".......-12..",
            "..78........",
            "..*....60...",
            "78..........",
            ".......23...",
            "....90*12...",
            "............",
            "2.2......12.",
            ".*.........*",
            "1.1.......56"
    };

    private static final String[] INPUT5 = {
            "12.......*..",
            "+.........34",
            ".......-12..",
            "..78........",
            "..*....60...",
            "78.........9",
            ".5.....23..$",
            "8...90*12...",
            "............",
            "2.2......12.",
            ".*.........*",
            "1.1..503+.56"
    };

    @Test
    void findPartsTest() {
        SchemaAnalyzer analyzer = new SchemaAnalyzer(INPUT2);
        Assertions.assertEquals(4361, analyzer.findPartNumbersSum());

        analyzer = new SchemaAnalyzer(INPUT4);
        Assertions.assertEquals(413, analyzer.findPartNumbersSum());

        analyzer = new SchemaAnalyzer(INPUT4);
        Assertions.assertEquals(925, analyzer.findPartNumbersSum());
    }

    @Test
    void findGearRatiosTest() {
        SchemaAnalyzer analyzer = new SchemaAnalyzer(INPUT1);
        Assertions.assertEquals(16345, analyzer.findGearRatioSum());

        analyzer = new SchemaAnalyzer(INPUT2);
        Assertions.assertEquals(467835, analyzer.findGearRatioSum());

        analyzer = new SchemaAnalyzer(INPUT3);
        Assertions.assertEquals(17009, analyzer.findGearRatioSum());

        analyzer = new SchemaAnalyzer(INPUT4);
        Assertions.assertEquals(6756, analyzer.findGearRatioSum());

        analyzer = new SchemaAnalyzer(INPUT5);
        Assertions.assertEquals(6756, analyzer.findGearRatioSum());
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
