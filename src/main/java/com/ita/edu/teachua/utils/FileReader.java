package com.ita.edu.teachua.utils;

import org.testng.reporters.Files;

import java.io.File;
import java.io.IOException;

public class FileReader {

    public static String getFileAsString(String filePath) {
        File file = new File(filePath);
        try {
            return Files.readFile(file);
        } catch (IOException e) {
            throw new RuntimeException("Error found while read file");
        }
    }
}
