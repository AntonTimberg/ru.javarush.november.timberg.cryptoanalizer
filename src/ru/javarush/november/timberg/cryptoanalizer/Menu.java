package ru.javarush.november.timberg.cryptoanalizer;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Menu {

    public static String alphabet = "abcdefghijklmnopqrstuvwxyz (.,\":-!?)";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        MyReader myReader = new MyReader();
        MyWriter myWriter = new MyWriter();
        Encoder coder = new Encoder();
        Decoder decoder = new Decoder();
        BruteForce bruteForce = new BruteForce();
        int choiceMode = 0;
        int delta = 0;
        do {
            out.println("Please select mode.");
            out.println("1: ENCRYPT");
            out.println("2: DECRYPT");
            out.println("3: BRUTE FORCE");
            out.println("4: EXIT");
            choiceMode = scanner.nextInt();

            switch (choiceMode) {
                case (1):
                    myReader.enterPaths();
                    myReader.reader();
                    out.println("Please enter delta for encryption");
                    delta = Math.abs(scanner.nextInt());
                    myWriter.fileName = "encrypted.txt";
                    myWriter.output(myReader.pathOfText, coder.enumerating(myReader.reader(),alphabet, delta));
                    break;

                case (2):
                    myReader.enterPaths();
                    myReader.reader();
                    out.println("Please enter delta for decryption");
                    delta = Math.abs(scanner.nextInt());
                    myWriter.fileName = "decrypted.txt";
                    myWriter.output(myReader.pathOfText, decoder.enumerating(myReader.reader(),alphabet, delta));
                    break;

                case (3):
                    myReader.enterPaths();
                    myReader.reader();
                    myWriter.fileName = "bruteForce.txt";
                    myWriter.output(myReader.pathOfText, bruteForce.brute(myReader.reader(),alphabet));
                    break;

                default:
                    break;
            }

        } while (choiceMode != 4);
    }
}

