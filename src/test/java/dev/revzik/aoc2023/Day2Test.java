package dev.revzik.aoc2023;

import dev.revzik.aoc2023.day2.GameChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day2Test {

    @Test
    void gamePossibleTest() {
        GameChecker checker = new GameChecker(12, 13, 14);

        Assertions.assertTrue(checker.isGamePossible("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
        Assertions.assertTrue(checker.isGamePossible("1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
        Assertions.assertFalse(checker.isGamePossible("8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"));
        Assertions.assertFalse(checker.isGamePossible("1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"));
        Assertions.assertTrue(checker.isGamePossible("6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"));
    }

    @Test
    void setPowerTest() {
        GameChecker checker = new GameChecker(12, 13, 14);

        Assertions.assertEquals(48, checker.findSetPower("3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"));
        Assertions.assertEquals(12, checker.findSetPower("1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue"));
        Assertions.assertEquals(1560, checker.findSetPower("8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red"));
        Assertions.assertEquals(630, checker.findSetPower("1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"));
        Assertions.assertEquals(36, checker.findSetPower("6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"));
    }
}
