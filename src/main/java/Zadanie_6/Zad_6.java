package Zadanie_6;

import java.util.Scanner;

public class Zad_6 {
    private static String[] letters;
    private static String UserInput;
    private static String result = "";

    public static void main(String[] args) {
        getStringFromUser();
        rle(UserInput);
        printRle();
    }

    private static void printRle() {
        System.out.println(result);
    }

    private static void getStringFromUser() {
        Scanner cin = new Scanner(System.in);
        System.out.println("Wprowadż ciąg znaków");
        UserInput = cin.next();
    }

    private static void rle(String input) {

        if (input == null || input.isEmpty()) {
            input = "";
        }
        letters = input.split("");

        StringBuilder part = new StringBuilder(letters[0]);
        String previousLetter = letters[0];
        int count = 1;

        for (int i = 1; i < letters.length; i++) {
            String currentLetter = letters[i];
            if (currentLetter.equals(previousLetter)) {
                count++;
            } else {
                if (count == 1) {
                    part.append(";").append(count).append(";").append(currentLetter);
                } else {
                    result += part + ";" + count + ";";
                    part = new StringBuilder(currentLetter);
                    count = 1;
                }
            }
            previousLetter = currentLetter;
        }
        result = result + part + ";" + count + ";";
    }
}
