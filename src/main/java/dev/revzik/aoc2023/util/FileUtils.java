package dev.revzik.aoc2023.util;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {

    public static List<String> readFileToLines(Path path) {
        ClassLoader classLoader = FileUtils.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(String.valueOf(path));
        assert inputStream != null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.lines().toList();
    }
}
