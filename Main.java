package com.company;

import java.util.Arrays;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

//        String[] quizArr1_a = {"AN", "CF", "MJ", "RT", "NA"};
//        int[] quizArr1_b = {6, 10, 2};
//        String[] quizArr2_a = {"TR", "RT", "TR"};
//        int[] quizArr2_b = {3, 30, 34, 5, 9};

        String [] quizArr1_a = {"SL","LR"};
        String [] quizArr2_a = {"S"};
        String [] quizArr3_a = {"R","R"};


//        System.out.println(Arrays.toString(testSolution.solution(quizArr1_a)));
        System.out.println(Arrays.toString(testSolution.solution(quizArr2_a)));
//        System.out.println(Arrays.toString(testSolution.solution(quizArr3_a)));

    }
}
