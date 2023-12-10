package dev.revzik.aoc2023.day2;

public class GameChecker {

    private static final String RED_STR = "red";
    private static final String GREEN_STR = "green";
    private static final String BLUE_STR = "blue";

    private final int redAmount;
    private final int greenAmount;
    private final int blueAmount;

    public GameChecker(int redAmount, int greenAmount, int blueAmount) {
        this.redAmount = redAmount;
        this.greenAmount = greenAmount;
        this.blueAmount = blueAmount;
    }

    public boolean isGamePossible(String game) {
        String[] rounds = game.split(";");
        int maxPulledOut = 0;

        for (String round : rounds) {
            int totalPulledOut = 0;

            String[] cubeSets = round.split(",");
            try {
                for (String cubes : cubeSets) {
                    if (cubes.contains(RED_STR)) {
                        totalPulledOut += checkIfExceedsAmount(cubes, RED_STR, redAmount);
                    }
                    if (cubes.contains(GREEN_STR)) {
                        totalPulledOut += checkIfExceedsAmount(cubes, GREEN_STR, greenAmount);
                    }
                    if (cubes.contains(BLUE_STR)) {
                        totalPulledOut += checkIfExceedsAmount(cubes, BLUE_STR, blueAmount);
                    }
                }
            } catch (ImpossibleGameException e) {
                return false;
            }

            if (totalPulledOut > maxPulledOut) {
                maxPulledOut = totalPulledOut;
            }
        }

        return maxPulledOut < redAmount + greenAmount + blueAmount;
    }

    private int checkIfExceedsAmount(String cubes, String color, int targetAmount) {
        int amount = Integer.parseInt(cubes.replace(color, "").trim());
        if (amount > targetAmount) {
            throw new ImpossibleGameException("Exceeded amount for color " + color);
        }
        return amount;
    }

    public int findSetPower(String game) {
        String[] rounds = game.split(";");

        int maxRed = 0;
        int maxGreen = 0;
        int maxBlue = 0;

        for (String round : rounds) {
            String[] cubeSets = round.split(",");
            for (String cubes : cubeSets) {
                if (cubes.contains(RED_STR)) {
                    maxRed = getColorMaximum(cubes, RED_STR, maxRed);
                }
                if (cubes.contains(GREEN_STR)) {
                    maxGreen = getColorMaximum(cubes, GREEN_STR, maxGreen);
                }
                if (cubes.contains(BLUE_STR)) {
                    maxBlue = getColorMaximum(cubes, BLUE_STR, maxBlue);
                }
            }
        }

        return maxRed * maxGreen * maxBlue;
    }

    private static int getColorMaximum(String cubes, String color, int currentMax) {
        int amount = Integer.parseInt(cubes.replace(color, "").trim());
        if (amount > currentMax) {
            currentMax = amount;
        }
        return currentMax;
    }

    private static class ImpossibleGameException extends RuntimeException {
        ImpossibleGameException(String message) {
            super(message);
        }
    }
}
