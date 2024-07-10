package com.leetcode.hard;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        int m = arr.length;
        int[] arr1 = {3, 4};
        int n = arr1.length;
        System.out.println(findMedian(arr, arr1));
        System.out.println(findMedianUsingBinarySearch(arr, arr1));

    }

    private static double findMedianUsingBinarySearch(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2)
            return findMedianUsingBinarySearch(nums2, nums1);
        int low = 0, high = n1;
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 - 1 >= 0)
                l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = nums2[mid2 - 1];
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    private static double findMedian(int[] nums1, int[] nums2) {
        int i = nums1.length - 1, j = nums2.length - 1;
        nums1 = Arrays.copyOf(nums1, nums1.length + nums2.length);
        int k = nums1.length - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        double result = 0.0;
        if (nums1.length % 2 != 0) {
            int idx = nums1.length / 2;
            result = Double.valueOf(nums1[idx]);
        } else {
            int idx = nums1.length / 2;
            result = (Double.valueOf(nums1[idx] + nums1[idx - 1])) / 2;
        }
//        printArray(nums1);
        return result;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
