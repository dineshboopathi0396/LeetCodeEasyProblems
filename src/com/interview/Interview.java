package com.interview;

import java.util.*;

public class Interview {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(9, 4, 20, 3, 10, 0, 11, 0));
//        System.out.println(longestConsecutive(list));
        System.out.println(solve(list, 33));



    }

    public static int solve(ArrayList<Integer> A, int B) {
        int pSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for(int i = 0; i < A.size(); i++){
            pSum += A.get(i);
            if(map.containsKey(pSum - B)){
                count += map.get(pSum - B);
            }
            map.put(pSum, map.getOrDefault(pSum, 0) + 1);
        }
        return count;
    }

    public static int longestConsecutive(final List<Integer> A) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < A.size(); i++){
            map.put(A.get(i), true);
        }

        for(int i = 0; i < A.size(); i++){
            if(map.containsKey(A.get(i) - 1)){
                map.put(A.get(i), false);
            }
        }
        int maxlen = 1;
        for(int i = 0; i < A.size(); i++){
            if(map.get(A.get(i))){
                int currLen = 0;
                int val = A.get(i);
                while(map.containsKey(val + 1)){
                    currLen++;
                    val++;
                }
                maxlen = Math.max(maxlen, currLen);
            }

        }
        return maxlen;
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> stInt = new Stack();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            result.add(-1);
        }
        for (int i = 0; i < 2 * A.size(); i++) {
            int idx = i % A.size();
            while (!stInt.isEmpty() && A.get(idx) > A.get(stInt.peek())) {
                result.set(stInt.peek(), A.get(idx));
                stInt.pop();
            }
            stInt.push(idx);
        }
        return result;
    }

}
