package com.company;

import java.util.Arrays;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

        String[] quizArr1_a = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] quizArr1_b = {2,3,4};
        String[] quizArr2_a = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] quizArr2_b = {2,3,5};
        String[] quizArr3_a = {"XYZ", "XWY", "WXA"};
        int[] quizArr3_b = {2, 3, 4};

        System.out.println(Arrays.toString(testSolution.solution(quizArr1_a, quizArr1_b)));
        System.out.println(Arrays.toString(testSolution.solution(quizArr2_a, quizArr2_b)));
        System.out.println(Arrays.toString(testSolution.solution(quizArr3_a, quizArr3_b)));

    }
}
