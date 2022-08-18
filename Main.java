package com.company;

public class Main {
    static public void main(String[] args) {
        Solution testSolution = new Solution();

        System.out.println(testSolution.solution("()()"));
        System.out.println(testSolution.solution("(())()"));
        System.out.println(testSolution.solution(")()("));
        System.out.println(testSolution.solution("(()("));
    }
}
