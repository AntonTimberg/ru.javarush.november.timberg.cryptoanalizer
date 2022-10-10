package ru.javarush.november.timberg.cryptoanalizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MyReader {
    Scanner scanner = new Scanner(System.in);
    String pathOfText = "";

    public void enterPaths() {
        System.out.println("Please, enter the \"path of textFile\"");
        pathOfText = scanner.nextLine();
    }

    public ArrayList<Character> reader() {
        ArrayList<Character> text = new ArrayList<>();
        try (BufferedReader textReader = new BufferedReader(new java.io.FileReader(this.pathOfText));
        ) {
            while (textReader.ready()) {
                text.add((char) textReader.read());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }

}