package Zadanie_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Zad_3 {
    private static int size;
    private static List<Integer> lista = new ArrayList<>(size);
    private static int start;
    private static int end;

    public static void main(String[] args) {
        get();
        fillList();
        getBound();
        print();
        sum(start, end);

    }

    private static void print() {
        System.out.println("Wylosowane liczby: ");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i) + "' ");
        }
    }

    private static void sum(int start, int end) {
        int sum = 0;
        System.out.println("\nWybrany przedział");
        for (int i = start; i < end; i++) {
            System.out.print(lista.get(i) + ", ");
            sum += lista.get(i);
        }
        System.out.println("\nSuma wartości: " + sum);
    }

    private static void getBound() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Podaj początek przedziału ");
        start = scan.nextInt();
        while (start > lista.size() || start <= 0) {
            System.err.println("Błąd, podaj liczbę naturalną, większą od zera");
            start = scan.nextInt();
        }
        System.out.println("Podaj koniec przedziału");
        end = scan.nextInt();
        CheckNumbers(scan);
    }

    private static void CheckNumbers(Scanner scan) {
        while (end > lista.size() || end <= 0) {
            System.err.println("Błąd, wyszedłeś poza zakres");
            end = scan.nextInt();
        }
        while (start > end) {
            System.err.println("Błąd, koniec przedziału nie może być mniejszy niż początek");
            end = scan.nextInt();
        }
    }

    private static void fillList() {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            lista.add(random.nextInt(10));
        }
    }

    private static void get() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj rozmiar listy");
        size = scan.nextInt();
        while (size <= 0) {
            System.err.print("Błąd, wprowadź liczbę naturalną\n");
            size = scan.nextInt();
        }
    }
}
