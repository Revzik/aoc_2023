package dev.revzik.aoc2023;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Day3Test {
    private static final String[] INPUT = {
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598.."
    };
    private final List<Character> digits = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    @Test
    void tmpTest() {
        //          0123456789
        String a = "..35..633"; // fix this case
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '.') {
                continue;
            }
            if (digits.contains(a.charAt(i))) {
                int end = a.indexOf('.', i) - 1;
                System.out.printf("Beginning: %d, End %d\n", i, end);
                i = end + 1;
            }
        }

    }
}
