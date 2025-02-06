package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public static void createFile(Path file) {
        try {
            Files.createFile(file);
            System.out.println("Выполнено создание файла.");
        } catch (IOException e) {
            System.out.println("Ошибка! Файл не создан!");
        }
    }
}
