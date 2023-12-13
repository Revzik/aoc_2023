package dev.revzik.aoc2023;

import dev.revzik.aoc2023.day4.Day4;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day4Test {

    private String[] EXAMPLE_GAME1 = {
            "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53", // 1    4m
            "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19", // 2    2m
            "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1", // 4    2m
            "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83", // 8    1m
            "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36", // 14
            "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"  // 1
    };                                                          // 30

    private String[] EXAMPLE_GAME2 = {
            "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53", // 1    5m
            "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19", // 2    2m
            "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1", // 4    2m
            "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83", // 8    1m
            "Card 5: 87 83 26 28 32 | 87 30 70 12 93 22 82 36", // 14   1m
            "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"  // 15
    };                                                          // 44

    private List<Integer> CARD1_WINNING = List.of(41, 48, 83, 86, 17);
    private List<Integer> CARD1_PLAYER = List.of(83, 86,  6, 31, 17,  9, 48, 53);

    private List<Integer> CARD2_WINNING = List.of(31, 18, 13, 56, 72);
    private List<Integer> CARD2_PLAYER = List.of(74, 77, 10, 23, 35, 67, 36, 11);



    @Test
    void singleGameTest() {
        Assertions.assertEquals(8, Day4.calculateCardValue(CARD1_WINNING, CARD1_PLAYER));
        Assertions.assertEquals(0, Day4.calculateCardValue(CARD2_WINNING, CARD2_PLAYER));
    }

    @Test
    void wholeGameSumTest() {
        Assertions.assertEquals(13, Day4.countGameSum(EXAMPLE_GAME1));
    }

    @Test
    void wholeGameCopiesTest() {
        Assertions.assertEquals(30, Day4.countCopySum(EXAMPLE_GAME1));
        Assertions.assertEquals(44, Day4.countCopySum(EXAMPLE_GAME2));
    }
}
