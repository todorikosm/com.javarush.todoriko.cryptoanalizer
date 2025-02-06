package utils;

import data.Alphabet;
import data.Constants;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Cipher {

    private static final int AB_S_RUS_LENGTH = Alphabet.ALPHABET_LENGTH;
    public static Scanner console = new Scanner(System.in);


    public static int getCipherKey() {
        System.out.println(Constants.ENTER_KEY);
        return Validator.isValidKey(console.nextLine());
    }


    private static char[] cipherCharArrayMechanism(char[] sourceCharArray, int key, boolean keyPlus) { //KeyPlus - true - шифруем, false - дешифруем
        char[] decryptedCharArray = new char[sourceCharArray.length];
        for (int i = 0; i < sourceCharArray.length; i++) {
            if (Alphabet.ALPHABET.contains(Character.toLowerCase(sourceCharArray[i]))) {
                int origIndex = Alphabet.ALPHABET.indexOf(Character.toLowerCase(sourceCharArray[i]));
                int destinationIndex = keyPlus ?
                        ((origIndex + key) < AB_S_RUS_LENGTH ? (origIndex + key) : (origIndex + key) % AB_S_RUS_LENGTH) :
                        ((origIndex - key) >= 0 ? (origIndex - key) : AB_S_RUS_LENGTH + origIndex - key);
                decryptedCharArray[i] = Alphabet.ALPHABET.get(destinationIndex);
            } else
                decryptedCharArray[i] = '-';
        }
        return decryptedCharArray;
    }


    public static void cipherText(Path sourceFile, int key, Path destinationFile, boolean keyPlus) throws IOException {

        if (keyPlus) System.out.println(Constants.ENCRYPTING);
        else System.out.println(Constants.DECRYPTING);

        if (FileManager.isFileSmall(sourceFile)) {
            char[] sourceCharArray = FileManager.readSmallFile(sourceFile);
            char[] decryptedCharArray = cipherCharArrayMechanism(sourceCharArray, key, keyPlus);
            FileManager.createFile(destinationFile);
            FileManager.writeToSmallFile(destinationFile, decryptedCharArray);
        } else {
            ArrayList<char[]> listOfCharLines = FileManager.readBigFile(sourceFile);
            ArrayList<char[]> resultCharArray = new ArrayList<>();
            for (char[] line : listOfCharLines) {
                resultCharArray.add(cipherCharArrayMechanism(line, key, keyPlus));
            }
            FileManager.createFile(destinationFile);
            FileManager.writeToBigFile(destinationFile, resultCharArray);
        }
    }
}
