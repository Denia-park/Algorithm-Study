package com.company;

import java.util.HashMap;
import java.util.Map;

public class Quiz2 {

    static public void main(String[] args) {
        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] topping2 = {1, 2, 3, 1, 4};

        System.out.println(solution(topping1) == 2);
        System.out.println(solution(topping2) == 0);
    }

    //https://congsoony.tistory.com/283?category=961402 참고
    static public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> answerMap1 = new HashMap<>();
        Map<Integer,Integer> answerMap2 = new HashMap<>();

        //전체의 종류를 구하기.
        for (int topp : topping) {
            answerMap1.put(topp, answerMap1.getOrDefault(topp, 0) + 1);
        }

        //1개씩 다른 Map 으로 옮기면서 (answerMap1 -> answerMap2) 사이즈를 비교하고 같으면 answer 를 ++ 시키자.
        for (int topp : topping) {
            if(answerMap1.getOrDefault(topp,0) != 0){
                int tempValue = answerMap1.get(topp);
                if(tempValue - 1 == 0)
                    answerMap1.remove(topp);
                else
                    answerMap1.put(topp, tempValue - 1);
            }

            answerMap2.put(topp, answerMap2.getOrDefault(topp, 0) + 1);

            if(answerMap1.size() == answerMap2.size()){
                answer++;
            }
        }

        return answer;
    }
}


