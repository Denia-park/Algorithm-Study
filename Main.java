package com.company;

import java.util.Arrays;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

//        String[] quizArr1_a = {"AN", "CF", "MJ", "RT", "NA"};
//        int[] quizArr1_b = {6, 10, 2};
//        String[] quizArr2_a = {"TR", "RT", "TR"};
//        int[] quizArr2_b = {3, 30, 34, 5, 9};
        String[][] places =
                {
                        {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                };


        System.out.println(Arrays.toString(testSolution.solution(places)));

    }
}
