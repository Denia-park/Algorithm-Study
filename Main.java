package com.company;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

        String[] quizArr1_a = {"AN", "CF", "MJ", "RT", "NA"};
        int[] quizArr1_b = {5, 3, 2, 7, 5};
        String[] quizArr2_a = {"TR", "RT", "TR"};
        int[] quizArr2_b = {7,1,3};

        System.out.println(testSolution.solution(quizArr1_a, quizArr1_b));
        System.out.println(testSolution.solution(quizArr2_a, quizArr2_b));

    }
}
