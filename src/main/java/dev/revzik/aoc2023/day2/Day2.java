package dev.revzik.aoc2023.day2;

import dev.revzik.aoc2023.util.FileUtils;

import java.nio.file.Path;

public class Day2 {

    public static void main(String[] args) {
        int sum = 0;
        GameChecker checker = new GameChecker(12, 13, 14);

        for (String line : FileUtils.readFileToLineList(Path.of("day2", "input.txt"))) {
            String[] splitLine = line.split(":");

            // part 1
//            sum += getIdIfPossible(splitLine, checker);

            // part 2
            sum += checker.findSetPower(splitLine[1].trim());
        }

        System.out.println(sum);
    }

    private static int getIdIfPossible(String[] splitLine, GameChecker checker) {
        if (checker.isGamePossible(splitLine[1].trim())) {
            return Integer.parseInt(splitLine[0].replace("Game", "").trim());
        }
        return 0;
    }
}
