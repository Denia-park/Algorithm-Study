package com.company;

import java.util.Arrays;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

//        String[] quizArr1_a = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] quizArr1_b = {2,3,4};
//        String[][] quizArr2_a = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] quizArr3_a =
                {
                        {"100", "ryan", "music", "2"},
                        {"200", "apeach", "math", "2"},
                        {"300", "tube", "computer", "3"},
                        {"400", "con", "computer", "4"},
                        {"500", "muzi", "music", "3"},
                        {"600", "apeach", "music", "2"}
                };
        String[][] quizArr4_a =
                {
                        {"a", "1", "aaa", "c", "ng"},
                        {"b", "1", "bbb", "c", "g"},
                        {"c", "1", "aaa", "d", "ng"},
                        {"d", "2", "bbb", "d", "ng"}
                };
        String[][] quizArr5_a =
                {
                        {"a","1","aaa","c","ng"},
                        {"a","1","bbb","e","g"},
                        {"c","1","aaa","d","ng"},
                        {"d","2","bbb","d","ng"}
                };
        String[][] quizArr6_a =
                {
                        {"a", "1", "4"},
                        {"2", "1", "5"},
                        {"a", "2", "4"},
                };


//        System.out.println(Arrays.toString(testSolution.solution(quizArr1_a, quizArr1_b)));

//        System.out.println(testSolution.solution(quizArr3_a));
        System.out.println(testSolution.solution(quizArr4_a));
        System.out.println(testSolution.solution(quizArr5_a));
        System.out.println(testSolution.solution(quizArr6_a));
    }
}
