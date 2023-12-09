package dev.revzik.aoc2023.day2;

import dev.revzik.aoc2023.util.FileUtils;

import java.nio.file.Path;

public class Day2 {

    public static void main(String[] args) {
        int sum = 0;
        GameChecker checker = new GameChecker(12, 13, 14);

        for (String line : FileUtils.readFileToLines(Path.of("day2", "input.txt"))) {
            String[] splitLine = line.split(":");
            int gameId = Integer.parseInt(splitLine[0].replace("Game", "").trim());

            if (checker.isGamePossible(splitLine[1].trim())) {
                sum += gameId;
            }
        }

        System.out.println(sum);
    }
}
