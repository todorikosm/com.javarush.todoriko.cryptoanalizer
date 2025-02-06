package utils;

import data.Alphabet;

import java.util.Scanner;

public class Validator {

    public static int isValidKey(String key) {
        Scanner scanner = new Scanner(System.in);

        int inputKey = 0;

        while (inputKey < 1)
            try {
                if (key.equalsIgnoreCase("exit")) {
                    System.out.println("Возврат в главное меню.");
                    return 0;
                } else {
                    inputKey = correctKeyNumber(Integer.parseInt(key));
                    if (inputKey < 1) {
                        System.out.println("Ошибка! Вы ввели 0, значение должно быть положительным!");
                        key = scanner.nextLine();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Вы ввели пустое значение!");
                key = scanner.nextLine();
            }

        System.out.println("Ключ принят!");
        return inputKey;
    }

    //если ключ больше, чем кол-во символов алфавита, то возващаем остаток от деления
    private static int correctKeyNumber(int key) {
        return key < Alphabet.ALPHABET_LENGTH ? key : key % Alphabet.ALPHABET_LENGTH;
    }
}
