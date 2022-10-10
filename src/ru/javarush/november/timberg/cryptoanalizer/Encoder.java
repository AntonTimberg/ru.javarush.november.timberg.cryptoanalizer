package ru.javarush.november.timberg.cryptoanalizer;

import java.util.ArrayList;

public class Encoder {
    public StringBuilder enumerating(ArrayList<Character> text, String alphabet, int delta) { //метод перебора символов
        StringBuilder result = new StringBuilder();
        char[] alphabetChars = alphabet.toCharArray();
        for (int i = 0; i < text.size(); i++) {
            int availabilityChecker = 0; //для проверки наличия текущего символа в алфавите.
            for (int j = 0; j < alphabet.length(); j++) {
                Character textChar = Character.toLowerCase(text.get(i));
                Character alphabetChar = Character.toLowerCase(alphabetChars[j]);
                if (textChar.equals(alphabetChar)) {
                    // //кодируемся
                    transposition(result, alphabetChars, j, delta);
                    //
                    availabilityChecker = 1; //Если символ был найден
                }
            }
            if (availabilityChecker == 0) result.append(text.get(i)); //на случай НЕнахождения символа в алфавите
        }

        return result;
    }

    public void transposition(StringBuilder result, char[] alphabetChars, int j, int delta) { //метод замены символов
        result.append(alphabetChars[(j + delta) % alphabetChars.length]);
    }

}
