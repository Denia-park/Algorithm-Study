package com.company;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        Integer[] numbersInt = new Integer[numbers.length];

        Arrays.setAll(numbersInt , index -> numbers[index]);

        Arrays.sort(numbersInt, new MyComparator());

        for (Integer i : numbersInt) {
            answer.append(i);
        }
        return answer.toString();
    }

    //앞자리 수가 큰게 맨 앞으로 와야함
    //총 자리수가 작은게 먼저 앞으로 와야함
    class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b) {
            char[] aChars = a.toString().toCharArray();
            char[] bChars = b.toString().toCharArray();

            int aIndex = 0;
            int bIndex = 0;
            for (int i = 0; i < Math.max(aChars.length, bChars.length); i++) {
                if(aChars[aIndex] > bChars[bIndex]) return -1;
                else if(aChars[aIndex] < bChars[bIndex])return 1;

                //Index 이므로 -1까지만 증가를 해야함
                if(aIndex < aChars.length -1) aIndex++;
                if(bIndex < bChars.length -1) bIndex++;
            }
            return 0;
        }
    }
}
