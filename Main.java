package com.company;

import java.util.Arrays;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

//        String[] quizArr1_a = {"AN", "CF", "MJ", "RT", "NA"};
//        int[] quizArr1_b = {6, 10, 2};
//        String[] quizArr2_a = {"TR", "RT", "TR"};
//        int[] quizArr2_b = {3, 30, 34, 5, 9};
        int[][] map1 =
                {
                    {1, 0, 1, 1, 1},
                    {1, 0, 1, 0, 1},
                    {1, 0, 1, 1, 1},
                    {1, 1, 1, 0, 1},
                    {0, 0, 0, 0, 1}
                };

        int[][] map2 =
                {
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1}
                };


        System.out.println(testSolution.solution(map1));
        System.out.println(testSolution.solution(map2));

    }
}
