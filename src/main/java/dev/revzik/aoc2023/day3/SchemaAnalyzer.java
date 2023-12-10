package dev.revzik.aoc2023.day3;

class SchemaAnalyzer {

    private final int leftBoundary = 0;
    private final int rightBoundary;
    private final int topBoundary = 0;
    private final int bottomBoundary;

    SchemaAnalyzer(String[] schema) {
        bottomBoundary = schema.length - 1;
        rightBoundary = schema[0].length() - 1;
    }

    public int countPartNumberSum() {
        return 0;
    }
}
