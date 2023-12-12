package dev.revzik.aoc2023.day3;

import java.util.*;

public class SchemaAnalyzer {

    private final String[] schema;

    public SchemaAnalyzer(String[] schema) {
        this.schema = expandSchema(schema);
    }

    private String[] expandSchema(String[] schema) {
        int newWidth = schema[0].length() + 2;
        int newHeight = schema.length + 2;
        String emptyLine = ".".repeat(newWidth);

        String[] newSchema = new String[newHeight];
        newSchema[0] = emptyLine;
        newSchema[newHeight - 1] = emptyLine;
        for (int i = 0; i < schema.length; i++) {
            newSchema[i + 1] = "." + schema[i] + ".";
        }
        return newSchema;
    }

    public int findPartNumbersSum() {
        int sum = 0;
        for (int i = 1; i < schema.length - 1; i++) {
            String schematicLine = schema[i];
            for (int j = 1; j < schematicLine.length() - 1; j++) {
                if (isEmpty(schematicLine.charAt(j))) {
                    continue;
                }
                if (SchemaAnalyzer.isDigit(schematicLine.charAt(j))) {
                    int end = findEndOfNumber(schematicLine, j);
                    if (checkIfValidNumber(i, j, end - 1)) {
                        sum += Integer.parseInt(schematicLine.substring(j, end));
                    }
                    j = end;
                }
            }
        }
        return sum;
    }

    public int findGearRatioSum() {
        Map<Coordinate, Integer> gearRatios = new HashMap<>();
        Map<Coordinate, Integer> usedGears = new HashMap<>();

        for (int i = 1; i < schema.length - 1; i++) {
            String schematicLine = schema[i];
            for (int j = 1; j < schematicLine.length() - 1; j++) {
                if (isEmpty(schematicLine.charAt(j))) {
                    continue;
                }
                if (SchemaAnalyzer.isDigit(schematicLine.charAt(j))) {
                    int end = findEndOfNumber(schematicLine, j);
                    Optional<Coordinate> gear = checkIfNextToGearSymbol(i, j, end - 1);
                    if (gear.isPresent()) {
                        int currentNumber = Integer.parseInt(schematicLine.substring(j, end));
                        usedGears.merge(gear.get(), 1, Integer::sum);
                        gearRatios.merge(gear.get(), currentNumber, (ov, nv) -> ov * nv);
                    }
                    j = end;
                }
            }
        }
        usedGears.forEach((k, v) -> {
            if (v != 2) {
                gearRatios.remove(k);
            }
        });
        return gearRatios.values().stream().reduce(Integer::sum).orElse(0); // the number returned is too low
    }

    private boolean checkIfValidNumber(int row, int begin, int end) {
        if (isPart(schema[row].charAt(begin - 1)) || isPart(schema[row].charAt(end + 1))) {
            return true;
        }

        for (int i = begin - 1; i <= end + 1; i++) {
            if (isPart(schema[row - 1].charAt(i)) || isPart(schema[row + 1].charAt(i))) {
                return true;
            }
        }

        return false;
    }

    private Optional<Coordinate> checkIfNextToGearSymbol(int row, int begin, int end) {
        if (isGearSymbol(schema[row].charAt(begin - 1))) {
            return Optional.of(new Coordinate(begin - 1, row));
        }
        if (isGearSymbol(schema[row].charAt(end + 1))) {
            return Optional.of(new Coordinate(end + 1, row));
        }

        for (int i = begin - 1; i <= end + 1; i++) {
            if (isGearSymbol(schema[row - 1].charAt(i))) {
                return Optional.of(new Coordinate(i, row - 1));
            }
            if (isGearSymbol(schema[row + 1].charAt(i))) {
                return Optional.of(new Coordinate(i, row + 1));
            }
        }

        return Optional.empty();
    }

    private int findEndOfNumber(String schematicLine, int i) {
        int end = i + 1;
        while (end != schematicLine.length() && SchemaAnalyzer.isDigit(schematicLine.charAt(end))) {
            end++;
        }
        return end;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isEmpty(char c) {
        return c == '.';
    }

    public static boolean isPart(char c) {
        return !isDigit(c) && !isEmpty(c);
    }

    public static boolean isGearSymbol(char c) {
        return c == '*';
    }
}
