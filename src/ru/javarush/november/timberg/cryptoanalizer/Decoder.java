package ru.javarush.november.timberg.cryptoanalizer;

public class Decoder extends Encoder {
    @Override
    public void transposition(StringBuilder result, char[] alphabetChars, int j, int delta) {
        int temp = (j - delta) % alphabetChars.length;
        if (temp < 0) {
            temp = alphabetChars.length + temp;
        }
        result.append(alphabetChars[temp]);
    }
}
