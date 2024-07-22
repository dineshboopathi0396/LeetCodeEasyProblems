package com.dsa.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    public MedianFinder() {
        pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq2 = new PriorityQueue<>();
    }

    void add(int val) {
        if (pq2.size() == 0 && pq1.size() == 0) {
            pq1.add(val);
        } else {
            if (val > pq1.peek()) {
                pq2.add(val);
            } else {
                pq1.add(val);
            }
        }
        int diff = Math.abs(pq1.size() - pq2.size());
        if (diff > 1) {
            if (pq1.size() > pq2.size()) {
                pq2.add(pq1.remove());
            } else {
                pq1.add(pq2.remove());
            }
        }
    }

    int findMedian() {
        if (pq1.peek() >= pq2.size())
            return pq1.peek();
        else
            return pq2.peek();
    }

    int remove() {
        if (pq1.peek() >= pq2.size())
            return pq1.remove();
        else
            return pq2.remove();
    }

    public void printOptions() {
        System.out.println("Please select a option");
        System.out.println("0. Exit");
        System.out.println("1. Add");
        System.out.println("2. Find Median");
        System.out.println("3. Remove");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = -1;
        MedianFinder mf = new MedianFinder();
        while (option != 0) {
            mf.printOptions();
            option = sc.nextInt();
            if (option == 1) {
                System.out.println("Enter val to add: ");
                int val = sc.nextInt();
                mf.add(val);
            } else if (option == 2) {
                System.out.println(mf.findMedian());
            } else if (option == 3) {
                System.out.println(mf.remove());
            } else {
                System.out.println("Please enter a valid option:");
            }
        }
    }

}
