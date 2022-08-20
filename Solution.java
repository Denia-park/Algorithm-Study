package com.company;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        //문자열을 합치기 위해서 StringBuilder 생성
        StringBuilder answer = new StringBuilder();

        //정렬을 위해서 Integer Array 만듬
        Integer[] numbersInt = new Integer[numbers.length];

        //numbers 원소들을 numbersInt 배열로 옮김
        Arrays.setAll(numbersInt , index -> numbers[index]);

        //정렬
        Arrays.sort(numbersInt, new MyComparator());

        //정렬된 값들을 StringBuilder를 통해서 합침
        for (Integer i : numbersInt) {
            answer.append(i);
        }

        //"0000" 이 나온 경우 "0" 으로 return ,앞자리가 0이 아니면 그냥 숫자 return
        return answer.toString().charAt(0) == '0' ? "0" : answer.toString() ;
    }

    class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer a, Integer b) {
            //a , b, 문자열로 만듬
            String aStr = a.toString();
            String bStr = b.toString();

            //둘 중에 길이가 긴 문자열의 길이를 구하고 2를 곱한다 (2를 곱하는 이유 : 비교할 때 사용하기 위해서)
            int maxLength = Math.max(aStr.length(), bStr.length()) * 2;
            //maxLength 길이가 될 수 있도록 문자열을 늘린다.
            while ((aStr.length() < maxLength) || (bStr.length() < maxLength)) {
                aStr += aStr;
                bStr += bStr;
            }
            char[] aChars = aStr.toCharArray();
            char[] bChars = bStr.toCharArray();

            //maxLength 길이만큼 for문을 돌면서 문자열의 각 숫자들을 비교한다.
            for (int i = 0; i < maxLength; i++) {
                if(aChars[i] > bChars[i]) return -1;
                else if(aChars[i] < bChars[i])return 1;
            }

            return 0;
        }
    }
}
