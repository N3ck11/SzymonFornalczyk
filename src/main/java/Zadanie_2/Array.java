package Zadanie_2;

import java.util.Random;
import java.util.Scanner;

public class Array {

    private static int[] myArray;
    private static int size;

    public static void main(String[] args) {

        getDataFromUser();
        initialize(size);
        generate(myArray);
        printOut(myArray);
        reverseArray(myArray);
        printOut(myArray);
    }

    private static void getDataFromUser() {
        Scanner cin = new Scanner(System.in);
        System.out.println("Wprowadż rozmiar tablicy");
        size = cin.nextInt();
    }

    private static void initialize(int size) {
        myArray = new int[size];
    }

    private static int[] generate(int[] tablica) {
        Random generate = new Random();
        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = generate.nextInt(50);
        }
        return tablica;
    }

    private static void printOut(int[] tab) {
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + ", ");
        }
        System.out.println();
    }

    private static int[] reverseArray(int[] tablica) {
        int tmp;
        int l = tablica.length-1;
        for (int i = 0; i < tablica.length/2 ; i++) {
            tmp = tablica[i];
            tablica[i] = tablica[l - i];
            tablica[l - i] = tmp;
        }
        return tablica;
    }


}
