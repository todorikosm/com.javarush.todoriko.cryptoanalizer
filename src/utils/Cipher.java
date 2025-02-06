package utils;

import data.Alphabet;

import java.util.Scanner;

public class Cipher {

    private static final int ABS = Alphabet.ALPHABET_LENGTH;

    public static Scanner scanner = new Scanner(System.in);


    public static int getKey() {
        System.out.println("Введите ключ");
        return 1;
    }
}
