package utils;

import data.Constants;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    static Scanner scanner = new Scanner(System.in);
    private static final long SIZE_OF_BIG_FILE = 10 * 1024 * 1024;

    public static void createFile(Path file) {
        try {
            Files.createFile(file);
            System.out.println("Выполнено создание файла.");
        } catch (IOException e) {
            System.out.println("Ошибка! Файл не создан!");
        }
    }

    public static Path getSourceFilePath() {
        System.out.println(Constants.ENTER_FILE);
        return Validator.isFileExists(scanner.nextLine());
    }

    public static Path getDestinationFilePath() {
        System.out.println(Constants.ENTER_RESULT_FILE);
        return Validator.ifFileDoesNotExist(scanner.nextLine());
    }

    public static char[] readSmallFile(Path file) {
        byte[] byteArray;
        try {
            byteArray = Files.readAllBytes(file);
            if (byteArray.length == 0) {
                System.out.println(Constants.FILE_IS_EMPTY);
                return new char[0];
            }
            String stringLine = new String(byteArray, StandardCharsets.UTF_8);
            System.out.println(Constants.SUCCESS_READ);
            return stringLine.toCharArray();
        } catch (IOException e) {
            System.out.println(Constants.ERROR_READ_SMALL_FILE);
            return new char[0];
        }
    }

    public static ArrayList<char[]> readBigFile(Path file) {
        ArrayList<char[]> listOfCharLines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                listOfCharLines.add(line.toCharArray());
            }
            System.out.println(Constants.SUCCESS_READ);
        } catch (IOException e) {
            System.out.println(Constants.ERROR_READ_BIG_FILE);
        }
        return listOfCharLines;
    }

    public static void writeToSmallFile(Path file, char[] sourseCharArray) {
        try (Writer writer = new FileWriter(String.valueOf(file.getFileName()))) {
            writer.write(sourseCharArray);
            System.out.println(Constants.SUCCESS_ENCRYPTION_TEXT + file.toAbsolutePath() + "\n" + "\n" + Constants.ENTER_NEXT_NUMBER);
        } catch (IOException e) {
            System.out.println(Constants.ERROR_WRITE_SMALL_FILE);
        }
    }

    public static void writeToBigFile(Path file, ArrayList<char[]> sourseCharArrayList) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file)) {
            for (char[] line : sourseCharArrayList) {
                bufferedWriter.write(line);
            }
            System.out.println(Constants.SUCCESS_ENCRYPTION_TEXT + file.toAbsolutePath() + "\n" + "\n" + Constants.ENTER_NEXT_NUMBER);
        } catch (IOException e) {
            System.out.println(Constants.ERROR_WRITE_BIG_FILE);
        }
    }

    public static boolean isFileSmall(Path file) throws IOException {
        return Files.size(file) < SIZE_OF_BIG_FILE;
    }
}
