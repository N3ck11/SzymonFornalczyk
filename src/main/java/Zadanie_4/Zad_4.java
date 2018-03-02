package Zadanie_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zad_4 {
    private static int[] tablica;
    private static int number;
    private static int ArraySize = 10;
    private static int indexNumber;

    public static void main(String[] args) {

        create();
        fill();
        sort(tablica);
        print();
        getDataFromUsers();
        getInfo(tablica, number);
        showIndex(indexNumber);
    }

    private static void showIndex(int indexNumber) {
        System.out.println("Wstawiono pod indeksem: " + indexNumber);
    }

    private static int getInfo(int[] tablica, int number) {
        if (tablica.length == 0) {
            indexNumber = 0;
        }

        for (int i = 0; i < tablica.length; i++) {
            if (number > tablica[i]) {
                indexNumber = tablica.length + 1;
            }
            if (number > tablica[i] && number <= tablica[i + 1]) {
                indexNumber = i + 1;
            }
        }
        return indexNumber;
    }

    private static void sort(int[] tablica) {
        Arrays.sort(tablica);
    }

    private static void getDataFromUsers() {
        System.out.println();
        System.out.println("Podaj liczbę");
        Scanner scan = new Scanner(System.in);
        number = scan.nextInt();
    }

    private static void print() {
        for (int i = 0; i < tablica.length; i++) {
            System.out.print(tablica[i] + ", ");
        }
    }

    private static int[] fill() {
        Random generate = new Random();
        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = generate.nextInt(20);
        }
        return tablica;
    }

    private static void create() {
        tablica = new int[ArraySize];
    }
}
