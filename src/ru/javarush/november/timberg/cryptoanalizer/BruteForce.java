package ru.javarush.november.timberg.cryptoanalizer;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;


public class BruteForce extends Decoder{
    Scanner scanner = new Scanner(in);
    public StringBuilder brute(ArrayList<Character> text, String alphabet){
        int temp = 0;
        String answerCheck = "";
        temp = Math.min(text.size(), 350);
        ArrayList<Character> textDemo = new ArrayList<>();
        textDemo.addAll(text.subList(0, temp));
        for (int i = 0; i < alphabet.length(); i++) {
            StringBuilder resultDemo = enumerating(textDemo,alphabet, i);
            if ((resultDemo.substring(0,temp).contains(", "))||resultDemo.substring(0,temp).contains(". ")){
                out.println("IF RESULT IS: ");
                out.println(resultDemo.substring(0,temp));
                out.println("ENTER: 1");
                out.println("Enter another symbol, if result is not true.");
                out.println("Enter \"EXIT\", if you want.");
                out.println();
                answerCheck = scanner.nextLine();
                if (answerCheck.equalsIgnoreCase("exit")){
                    exit(0);
                }
                if (answerCheck.equals("1")){
                    return enumerating(text, alphabet, i);
                }

            }
        }
        return null;
    }
}
