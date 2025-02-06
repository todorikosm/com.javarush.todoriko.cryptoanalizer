package data;

public class Constants {
    public static final String[] menuText = {
            "",
            "Вас приветствует Криптоанализатор!",
            "Введите цифру для выбора действия:",
            "1. Зашифровать файл",
            "2. Расшифровать файл с помощью ключа",
            "3. Выход"
    };
    public static final String MENU_ERROR_TEXT = "Такого варианта нет! Введите целое число от 1 до 3.";
    public static final String IO_ERROR_TEXT = "IO ошибка";
    public static final String MENU_1 = "Вы выбрали зашифровать файл.";
    public static final String MENU_2 = "Вы выбрали расшифровать файл.";
    public static final String MENU_3 = "Программа завершена.";
    public static final String ENTER_FILE = "Введите адрес и имя исходного файла:";
    public static final String ENTER_KEY = "Введите ключ шифрования (целое число больше 0) или exit для выхода в главное меню:";
    public static final String ENTER_RESULT_FILE = "Введите имя файла для создания файла с результатом:";
    public static final String ENCRYPTING = "Шифрую.....";
    public static final String DECRYPTING = "Расшифровываю.....";
    public static final String ENTER_NEXT_NUMBER = "Введите от 1 до 3 для выбора следующего действия (1 - зашифровать, " +
            "2 - расшифровать с ключом, 3 - выход)";

    //validator
    public static final String KEY_IS_NAN = "Ошибка ввода! Нужно ввести целое число больше 0 или exit для выхода в главное меню";
    public static final String KEY_IS_ZERO = "Ошибка ввода! Число должно быть больше 0 и не кратно " +
            Alphabet.ALPHABET_LENGTH + " иначе ничего не произойдет";
    public static final String KEY_IS_CORRECT = "Ключ принят";
    public static final String FILE_NOT_FOUND = "Ошибка! Файл не найден. Введите корректный путь или цифру 3 для выхода в главное меню";
    public static final String FILE_WRONG_NAME = "Некорректное имя! Введите другое!";
    public static final String FILE_FOUND = "Файл найден!";
    public static final String RETURNING = "Выход в главное меню.";
    public static final String FILE_ALREADY_EXISTS = "Такой файл уже существует! " +
            "Укажите другой или введите 3 для выхода в главное меню ";

    //fileManager
    public static final String SUCCESS_ENCRYPTION_TEXT = "Успех! Результат записан в файле по адресу: ";
    public static final String SUCCESS_READ = "Файл успешно прочитан...";
    public static final String SUCCESS_READ_FIRST_LINE = "Первая строка файла успешно прочитана...";
    public static final String ERROR_READ_SMALL_FILE = "Что-то пошло не так при чтении маленького файла.";
    public static final String ERROR_WRITE_SMALL_FILE = "Что-то пошло не так при записи маленького файла.";
    public static final String ERROR_READ_BIG_FILE = "Что-то пошло не так при чтении большого файла.";
    public static final String ERROR_WRITE_BIG_FILE = "Что-то пошло не так при записи большого файла.";
    public static final String FILE_IS_EMPTY = "Ошибка! Файл пустой.";
    public static final String LESS_THEN_1000 = "Ошибка! В файле меньше 1000 символов.";
}
