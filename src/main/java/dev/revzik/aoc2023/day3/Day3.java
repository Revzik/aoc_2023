package dev.revzik.aoc2023.day3;

import dev.revzik.aoc2023.util.FileUtils;

import java.nio.file.Path;
import java.util.Arrays;

public class Day3 {

    public static void main(String[] args) {
        String[] schematicLines = FileUtils.readFileToLineArray(Path.of("day3", "input.txt"));
        SchemaAnalyzer analyzer = new SchemaAnalyzer(schematicLines);
        System.out.println(analyzer.findPartNumbersSum());
    }
}
