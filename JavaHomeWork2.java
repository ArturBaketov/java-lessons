package org.example.hw2;

import java.util.Scanner;

/**
 * 1) Дана последовательность N целых чисел. Найти сумму простых чисел.
 */
public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("sum = " + sumSimpleSequence(n));
    }

    /**
     *
     * @param n длина последовательности
     * @return сумма простых чисел
     */
    public static int sumSimpleSequence(int n){
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (isSimple(a)) sum += a;
        }
        return sum;
    }
    /**
     *
     * @param a проверяемое число
     * @return является ли число простым
     */
    public static boolean isSimple(int a) {
        Double sq = Math.sqrt(a);
        for (int i = 2; i <= sq.intValue(); i++) {
            if (a % i == 0) return false;
        }
        return true;

    }
}

package org.example.hw2;

import java.util.Scanner;

/**
 * 2) Дана последовательность из N целых чисел. Верно ли, что последовательность является возрастающей.
 */
public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("grows: " + isGrowingSecuence(n));

    }

    /**
     *
     * @param n дина последовательности
     * @return является ли последовательность возрастающей
     */
    private static boolean isGrowingSecuence(int n) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b;
        for (int i = 1; i < n; i++) {
            b = sc.nextInt();
            if (b <= a) return false;
            a = b;
        }
        return true;

    }


}

package org.example.hw2;

/**
 * 3) Дан массив целых чисел. Заменить отрицательные элементы на сумму индексов двузначных элементов массива.
 */
public class Ex3 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, -3, -4, 5, 6, -7, 8, 9, 10};
        printArray(array);
        replaceNegative(array);
        printArray(array);
    }

    private static void printArray(int[] array) {
        String res = "[";
        for (int i = 0; i < array.length; i++) {
            res += array[i] + (i == array.length - 1 ? "]" : ",");
        }
        System.out.println(res);
    }

    private static void replaceNegative(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if ((10 <= array[i] && array[i] <= 99) || (-99 <= array[i] && array[i] <= -10)) {
                sum += i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) array[i] = sum;
        }

    }
}
