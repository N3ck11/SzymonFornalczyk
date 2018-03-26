package Zadanie_5;

import java.util.Random;

public class Zad_5 {
    private static int[] result;
    private static int[][] matrix = new int[2][5];

    public static void main(String[] args) {
        fill(matrix);
        printMatrix(matrix);
        returnSum(matrix);
        printArray();
    }

    private static void printArray() {
        System.out.println("Wynik dodawania:");
        for (int i = 0; i < result.length; i++) {
            System.out.print("[ " + result[i] + " ]");
        }
        System.out.println();
    }

    private static int[][] fill(int[][] array) {
        Random generate = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = generate.nextInt(10);
            }
        }
        return array;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[ " + matrix[i][j] + " ]");
            }
            System.out.println();
        }

    }

    private static void returnSum(int[][] matrix) {
        int maxSize = getMaxSize(matrix);
        result = new int[maxSize];
        sumAllRows(matrix, maxSize);
        moveValueOften();
    }

    private static void moveValueOften() {
        for (int i = result.length - 1; i > 0; i--) {
            if (result[i] >= 10) {
                int toMove = result[i] / 10;
                result[i] = result[i] % 10;
                result[i - 1] = result[i - 1] + toMove;
            }
        }

        if (result[0] >= 10) {
            // RECURSIVE!!!!!!!
            int[] temp = new int[result.length + 1];
            for (int i = 0; i < result.length; i++) {
                temp[temp.length - i - 1] = result[result.length - 1 - i];
            }
            result = temp;
            moveValueOften();
        }

    }

    private static void sumAllRows(int[][] matrix, int maxSize) {
        for (int[] aMatrix : matrix) {
            int counter = 0;
            for (int j = aMatrix.length - 1; j >= 0; j--) {
                result[maxSize - counter - 1] += aMatrix[j];
                counter++;
            }
        }
    }

    private static int getMaxSize(int[][] matrix) {
        int maxSize = 0;
        for (int[] subArray : matrix) {
            if (subArray.length > maxSize) {
                maxSize = subArray.length;
            }
        }
        return maxSize;
    }
}
