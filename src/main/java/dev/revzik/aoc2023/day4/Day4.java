package dev.revzik.aoc2023.day4;

import dev.revzik.aoc2023.util.FileUtils;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 {

    public static void main(String[] args) {
        String[] cards = FileUtils.readFileToLineArray(Path.of("day4", "input.txt"));
//        System.out.println(countGameSum(cards));
        System.out.println(countCopySum(cards));
    }

    public static int countGameSum(String[] cards) {
        int sum = 0;

        for (String card : cards) {
            String content = card.split(":")[1];
            String[] numbers = content.split("\\|");
            sum += calculateCardValue(getNumberList(numbers[0]), getNumberList(numbers[1]));
        }

        return sum;
    }

    public static long countCopySum(String[] cards) {
        long[] cardCopies = new long[cards.length];
        Arrays.fill(cardCopies, 1);

        for (String card : cards) {
            String[] splitCard = card.split(":");
            int cardId = Integer.parseInt(splitCard[0].replace("Card", "").trim()) - 1;
            String[] numbers = splitCard[1].split("\\|");
            long cardValue = getNumberList(numbers[0]).stream()
                    .filter(getNumberList(numbers[1])::contains)
                    .count();
            for (int i = 1; i <= cardValue && cardId + i < cards.length - 1; i++) {
                int nextCardId = cardId + i;
                long currentCopyAmount = cardCopies[cardId];
                cardCopies[nextCardId] += currentCopyAmount;
            }
        }

        return Arrays.stream(cardCopies).reduce(Long::sum).orElse(0L); // returns too low somehow
    }

    private static List<Integer> getNumberList(String numberString) {
        return Arrays.stream(numberString.trim().split(" +"))
                .map(Integer::parseInt)
                .toList();
    }

    public static int calculateCardValue(List<Integer> winningNumbers, List<Integer> playerNumbers) {
        long winningCount = winningNumbers.stream()
                .filter(playerNumbers::contains)
                .count();
        return winningCount == 0 ? 0 : (int) Math.pow(2, winningCount - 1);
    }

    private static Map<Integer, Long> initializeCardMap(int cardAmount) {
        // Assumes cards are ordered from 1 to cardAmount, with no empty spaces between numbers
        Map<Integer, Long> cardMap = new HashMap<>();
        for (int i = 1; i <= cardAmount; i++) {
            cardMap.put(i, 1L);
        }
        return cardMap;
    }
}
