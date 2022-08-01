package com.company;

import java.util.HashMap;

public class Quiz2 {

    static public void main(String[] args) {
        String[] quizWant1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] quizNum1 = {3, 2, 2, 2, 1};
        String[] quizDiscount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        String[] quizWant2 = {"apple"};
        int[] quizNum2 = {10};
        String[] quizDiscount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

        System.out.println(solution(quizWant1, quizNum1, quizDiscount1) == 3);
        System.out.println(solution(quizWant2, quizNum2, quizDiscount2) == 0);
    }


    static public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        //HashMap 생성
        HashMap<String, Integer> wantHashMap = new HashMap<String, Integer>();

        //hashMap에 필요한 물품의 수량을 저장
        for (int i = 0; i < want.length; i++) {
            wantHashMap.put(want[i], number[i]);
        }

        //discount 를 for문으로 10개씩만 돌면서 내가 원하는 수량만큼 있는지 비교하기.
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> discountHashMap = new HashMap<String, Integer>();
            int tempCount = 0;

            for (int j = i; j < i + 10; j++) {
                discountHashMap.put(discount[j], discountHashMap.getOrDefault(discount[j], 0) + 1);
            }

            for (String st : want ) {
                if(wantHashMap.get(st) == discountHashMap.get(st)){
                    tempCount++;
                }else{
                    break;
                }
            }

            if (tempCount == want.length)
                answer++;
        }

        return answer;
    }
}


