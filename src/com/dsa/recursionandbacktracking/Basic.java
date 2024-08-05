package com.dsa.recursionandbacktracking;

public class Basic {
    public static void main(String[] args) {
        printName(5);
        print1ToNLinear(1, 5);
        printNTo1Linear(5);
        print1ToNLinearByBacktracking(5);
        printNTo1LinearByBackTracking(1, 5);

        //Sum of First N numbers
        int n = 5;
        findSumInParameterizedWay(5, 0);
        System.out.println(findSumInFunctionalWay(5));

        //Factorial of number
        n = 5;
        System.out.println(findFactorial(5));
    }

    private static int findFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * findFactorial(n - 1);
    }

    private static int findSumInFunctionalWay(int n) {
        if (n < 1) {
            return 0;
        }
        return n + findSumInFunctionalWay(n - 1);
    }

    private static void findSumInParameterizedWay(int n, int sum) {
        if (n < 1) {
            System.out.println(sum);
            return;
        }
        findSumInParameterizedWay(n - 1, sum + n);
    }

    private static void printNTo1LinearByBackTracking(int i, int n) {
        if (i > n) {
            return;
        }
        printNTo1LinearByBackTracking(i + 1, n);
        System.out.println(i);
    }

    private static void print1ToNLinearByBacktracking(int n) {
        if (n < 1) {
            return;
        }
        print1ToNLinearByBacktracking(n - 1);
        System.out.println(n);
    }

    private static void printNTo1Linear(int i) {
        if (i < 1) {
            return;
        }
        System.out.println(i);
        printNTo1Linear(i - 1);
    }

    private static void print1ToNLinear(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        print1ToNLinear(i + 1, n);
    }

    private static void printName(int n) {
        if (n <= 0)
            return;
        System.out.println("Dinesh");
        printName(n - 1);
    }
}
