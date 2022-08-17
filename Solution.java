package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

        String[] quizArr1 = {"119", "97674223", "1195524421"};
        String[] quizArr2 = {"123", "456", "789"};
        String[] quizArr3 = {"12", "123", "1235", "567", "88"};

        System.out.println(testSolution.solution(quizArr1));
        System.out.println(testSolution.solution(quizArr2));
        System.out.println(testSolution.solution(quizArr3));

    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        //정렬
        Arrays.sort(phone_book,new MyComparator());

//        System.out.println(Arrays.toString(phone_book));

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                if(phone_book[j].contains(phone_book[i])) return false;
            }
        }

        return answer;
    }
}

class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() < o2.length()) {
            return -1;
        }
        return 1;
    }
}
