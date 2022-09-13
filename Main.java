package com.company;

import java.util.Arrays;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

//        String[] quizArr1_a = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] quizArr1_b = {2,3,4};
//        String[][] quizArr2_a = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

//        System.out.println(Arrays.toString(testSolution.solution(quizArr1_a, quizArr1_b)));

//        System.out.println(testSolution.solution(quizArr3_a));
//        System.out.println((testSolution.solution(3,3,new String[]{"ABC", "DEF", "GHI"})));
//        System.out.println((testSolution.solution(new int[]{70, 50, 80, 50}, 100)));
//        System.out.println((testSolution.solution(new int[]{70, 80, 50}, 100)));
//        System.out.println((testSolution.solution(new int[]{10, 30, 50,100,100,100, 90}, 100))); //5


        System.out.println((testSolution.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}))); //5
//        System.out.println((testSolution.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}))); //5
//        System.out.println((testSolution.solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}))); //5
    }
}
