package utils;

import data.Alphabet;
import data.Constants;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

public class Validator {
    static Scanner scanner = new Scanner(System.in);

    public static int isValidKey(String key) {
        int checkedKey = 0;

        while (checkedKey < 1)
            try {
                if (key.equalsIgnoreCase("exit")) {
                    System.out.println(Constants.RETURNING);
                    return 0;
                } else {
                    checkedKey = correctKeyNumber(Integer.parseInt(key));
                    if (checkedKey < 1) {
                        System.out.println(Constants.KEY_IS_ZERO);
                        key = scanner.nextLine();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(Constants.KEY_IS_NAN);
                key = scanner.nextLine();
            }

        System.out.println(Constants.KEY_IS_CORRECT);
        return checkedKey;
    }

    //если ключ больше, чем кол-во символов алфавита, то возващаем остаток от деления
    private static int correctKeyNumber(int key) {
        return key < Alphabet.ALPHABET_LENGTH ? key : key % Alphabet.ALPHABET_LENGTH;
    }

    public static Path isFileExists(String filePath) {
        while (true) {
            if (filePath.equals("3")) {
                System.out.println(Constants.RETURNING);
                return null;
            } else {
                if (filePath.startsWith("\"") && filePath.endsWith("\""))
                    filePath = filePath.substring(1, filePath.length() - 1);
                try {
                    Path file = Path.of(filePath);
                    if (Files.exists(file)) {
                        System.out.println(Constants.FILE_FOUND);
                        return file;
                    } else {
                        System.out.println(Constants.FILE_NOT_FOUND);
                        filePath = scanner.nextLine();
                    }
                } catch (InvalidPathException e) {
                    System.out.println(Constants.FILE_NOT_FOUND);
                    filePath = scanner.nextLine();
                }
            }
        }
    }

    public static Path ifFileDoesNotExist(String filePath) {
        while (true) {
            if (filePath.equals("3")) {
                System.out.println(Constants.RETURNING);
                return null;
            }
            try {
                Path file = Path.of(filePath);
                if (Files.exists(file)) {
                    System.out.println(Constants.FILE_ALREADY_EXISTS);
                    filePath = scanner.nextLine();
                } else
                    return file;
            } catch (InvalidPathException e) {
                System.out.println(Constants.FILE_WRONG_NAME);
                filePath = scanner.nextLine();
            }
        }
    }
}
