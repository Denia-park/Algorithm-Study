package com.company;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

//        String[] quizArr1_a = {"AN", "CF", "MJ", "RT", "NA"};
        int[] quizArr1_b = {6, 10, 2};
//        String[] quizArr2_a = {"TR", "RT", "TR"};
        int[] quizArr2_b = {3, 30, 34, 5, 9};
        int[] quizArr3_b = {3, 30, 34};

//        System.out.println(testSolution.solution(quizArr1_b).equals("6210"));
//        System.out.println(testSolution.solution(quizArr2_b).equals("9534330"));
//        System.out.println(testSolution.solution(quizArr1_b));
//        System.out.println(testSolution.solution(quizArr2_b));
//        System.out.println(testSolution.solution(new int[]{1,10 ,11, 110, 1110,0}));
//        System.out.println(testSolution.solution(new int[]{101, 10, 232, 23}));
//        System.out.println(testSolution.solution(new int[]{978, 97}));
        System.out.println(testSolution.solution(new int[]{98, 991, 990, 989, 988, 987}));

    }
}
