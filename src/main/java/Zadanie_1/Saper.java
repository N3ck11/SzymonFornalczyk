package Zadanie_1;

import java.util.Random;
import java.util.Scanner;

public class Saper {
    private static boolean[][] bombTable;
    private static String[][] bombFoundTable;
    private static int row;
    private static int column;


    public static void main(String[] args) {

        getDataFromUser();
        initilizeTable();
        fillBombTable();
        fillWithBombs();
        show();
        check();
        rewrite();
    }

    private static void rewrite() {
        for (int i = 0; i < bombFoundTable.length; i++) {
            for (int j = 0; j < bombFoundTable[0].length; j++) {
                System.out.print("[ " + bombFoundTable[i][j] + " ]");
            }
            System.out.println();
        }
    }

    private static void show() {
        for (int i = 0; i < bombTable.length; i++) {
            for (int j = 0; j < bombTable[0].length; j++) {
                System.out.print("[ " + bombTable[i][j] + " ]");
            }
            System.out.println();
        }
    }

    private static void check() {
        bombFoundTable = new String[row][column];
        for (int i = 0; i < bombTable.length; i++) {
            for (int j = 0; j < bombTable[i].length; j++) {
                FindBomb(i, j);
            }
        }
    }

    private static void FindBomb(int i, int j) {
        int k;
        int l;
        if (bombTable[i][j] == true) {
            bombFoundTable[i][j] = "*";
        } else {
            int bombNear = 0;
            for (k = i - 1; k <= i + 1; k++) {
                for (l = j - 1; l <= j + 1; l++) {
                    try {
                        if (bombTable[k][l] == true) {
                            bombNear++;
                        }
                    } catch (IndexOutOfBoundsException e) {
                        continue;
                    }
                }
                bombFoundTable[i][j] = String.valueOf(bombNear);
            }
        }
    }

    public static void getDataFromUser() {
        Scanner scan = new Scanner(System.in);
        while(column<=0) {
            try {
                System.out.println("Podaj wielkość boku: ");
                column = scan.nextInt();
            } catch (Exception e) {
                System.err.println("Błąd wprowadzonych danych, podaj liczbę naturalną.");
                scan.nextLine();
            }
        }
        row = column;
    }

    private static void fillBombTable() {
        for (int i = 0; i < bombTable.length; i++) {
            for (int j = 0; j < bombTable[i].length; j++) {
                bombTable[i][j] = false;
            }
        }
    }

    public static void initilizeTable() {
        bombTable = new boolean[row][column];
    }

    private static void fillWithBombs() {
        Random fill = new Random();
        int a;
        int b;
        for (int i = 0; i < (row * column) / 3; i++) {
            a = fill.nextInt(row - 1);
            b = fill.nextInt(column - 1);
            bombTable[a][b] = true;
        }
    }
}