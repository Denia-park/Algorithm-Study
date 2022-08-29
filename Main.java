package com.company;

import java.util.Arrays;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

//        String[] quizArr1_a = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] quizArr1_b = {2,3,4};
//        String[][] quizArr2_a = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        String[][] quizArr3_a = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};


//        System.out.println(Arrays.toString(testSolution.solution(quizArr1_a, quizArr1_b)));
        System.out.println(testSolution.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(testSolution.solution(100, 100, new int[]{10}));
        System.out.println(testSolution.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));

    }
}
