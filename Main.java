package com.company;

import java.util.Arrays;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

//        String[] quizArr1_a = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] quizArr1_b = {2,3,4};
//        String[][] quizArr2_a = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        String number1 = "1924";
        int k1 = 2;
        String number2 = "1231234";
        int k2 = 3;
        String number3 = "4177252841";
        int k3 = 3;


//        System.out.println(Arrays.toString(testSolution.solution(quizArr1_a, quizArr1_b)));

//        System.out.println(testSolution.solution(quizArr3_a));
        System.out.println(testSolution.solution(number1,k1));
//        System.out.println(testSolution.solution(number2,k2));
//        System.out.println(testSolution.solution(number3,k3));
    }
}
