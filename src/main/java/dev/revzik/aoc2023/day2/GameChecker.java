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

            String[] colors = round.split(",");
            for (String color : colors) {
                if (color.contains(RED_STR)) {
                    int amount = Integer.parseInt(color.replace(RED_STR, "").trim());
                    if (amount > redAmount) {
                        return false;
                    }
                    totalPulledOut += amount;
                }

                if (color.contains(GREEN_STR)) {
                    int amount = Integer.parseInt(color.replace(GREEN_STR, "").trim());
                    if (amount > greenAmount) {
                        return false;
                    }
                    totalPulledOut += amount;
                }

                if (color.contains(BLUE_STR)) {
                    int amount = Integer.parseInt(color.replace(BLUE_STR, "").trim());
                    if (amount > blueAmount) {
                        return false;

                    }
                    totalPulledOut += amount;
                }
            }

            if (totalPulledOut > maxPulledOut) {
                maxPulledOut = totalPulledOut;
            }
        }

        return maxPulledOut < redAmount + greenAmount + blueAmount;
    }
}
