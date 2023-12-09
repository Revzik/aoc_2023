package dev.revzik.aoc2023;

import dev.revzik.aoc2023.day1.Day1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class Day1Test {

    @Test
    void simpleEntriesTest() {
        Map<String, Integer> testData = Map.of(
                "7", 77,
                "dasda8oeldkrfcssbft", 88,
                "asd55", 55,
                "sxrchq3the911231", 31,
                "lnxms8", 88
        );

        for (String s : testData.keySet()) {
            Assertions.assertEquals(testData.get(s), Day1.findValue(s));
        }
    }

    @Test
    void complexEntriesTest() {
        Map<String, Integer> testData = Map.of(
                "7tf", 77,
                "8oneldkrfcssbfeight", 88,
                "four5ninebvvfv", 49,
                "sixrhxkzcgfhltrchq3three91", 61,
                "lnxms8", 88
        );

        for (String s : testData.keySet()) {
            Assertions.assertEquals(testData.get(s), Day1.findValue(s));
        }
    }
}
