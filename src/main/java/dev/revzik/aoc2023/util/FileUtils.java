package dev.revzik.aoc2023.util;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileUtils {

    public static List<String> readFileToLineList(Path path) {
        return readFileToStream(path).toList();
    }

    public static String[] readFileToLineArray(Path path) {
        return readFileToStream(path).toArray(String[]::new);
    }

    private static Stream<String> readFileToStream(Path path) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(String.valueOf(path));
        assert inputStream != null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines();
    }
}
