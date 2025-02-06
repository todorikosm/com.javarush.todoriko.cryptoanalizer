import data.Constants;
import utils.Cipher;
import utils.FileManager;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int menuNumberInput = 0;
        int cipherKey;
        Path sourseFile, destinationFile;

        drawMainMenu();

        do {
            try {
                menuNumberInput = Integer.parseInt(console.nextLine());

                switch (menuNumberInput) {
                    case 1:
                        System.out.println(Constants.MENU_1);
                        sourseFile = FileManager.getSourceFilePath();
                        if (sourseFile == null){
                            drawMainMenu();
                            continue;
                        }
                        cipherKey = Cipher.getCipherKey();
                        if (cipherKey == 0) {
                            drawMainMenu();
                            continue;
                        }
                        destinationFile = FileManager.getDestinationFilePath();
                        if (destinationFile == null){
                            drawMainMenu();
                            continue;
                        }
                        Cipher.cipherText(sourseFile, cipherKey, destinationFile, true);
                        break;

                    case 2:
                        System.out.println(Constants.MENU_2);
                        sourseFile = FileManager.getSourceFilePath();
                        if (sourseFile == null){
                            drawMainMenu();
                            continue;
                        }
                        cipherKey = Cipher.getCipherKey();
                        if (cipherKey == 0) {
                            drawMainMenu();
                            continue;
                        }
                        destinationFile = FileManager.getDestinationFilePath();
                        if (destinationFile == null){
                            drawMainMenu();
                            continue;
                        }
                        Cipher.cipherText(sourseFile, cipherKey, destinationFile, false);
                        break;

                    case 3:
                        System.out.println(Constants.MENU_3);
                        console.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println(Constants.MENU_ERROR_TEXT);
                }

            } catch (NumberFormatException e) {
                System.out.println(Constants.MENU_ERROR_TEXT);
            } catch (IOException e) {
                System.out.println(Constants.IO_ERROR_TEXT);
            }
        } while (menuNumberInput != 3);
    }

    private static void drawMainMenu(){
        for (String s : Constants.menuText)
            System.out.println(s);
    }
}