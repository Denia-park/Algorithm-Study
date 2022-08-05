package com.company;

public class Quiz1 {
    static public void main(String[] args) {
        int[] X1 = {-2, 3, 0, 2, -5};
        int[] X2 = {-3, -2, -1, 0, 1, 2, 3};
        int[] X3 = {-1, 1, -1, 1};

        System.out.println(solution(X1) == 2);
        System.out.println(solution(X2) == 5);
        System.out.println(solution(X3) == 0);
    }

    static     public int solution(int[] number) {
        int answer = 0;

        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if((number[i] + number[j] + number[k]) == 0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
