package ru.javarush.november.timberg.cryptoanalizer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyWriter {
    public String fileName = "";

    public void output(String pathOfText, StringBuilder result) {
        Path directoryPath = Paths.get(pathOfText).getParent();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(String.valueOf(directoryPath), fileName)))) {
            System.out.println("Directory: " + (directoryPath));
            System.out.println("FileName: " + fileName);
            bufferedWriter.write(String.valueOf(result));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
