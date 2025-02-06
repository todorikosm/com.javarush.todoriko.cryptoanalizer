package data;

import java.util.ArrayList;
import java.util.Arrays;

public class Alphabet {
    public static final ArrayList<Character> ALPHABET = new ArrayList<>(Arrays.asList(
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т',
            'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':',
            '!', '?', ' ', '\n', '\r', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    );
    public static final int ALPHABET_LENGTH = ALPHABET.size();
}
