package com.company;

public class Quiz1 {
    static public void main(String[] args) {
        String X1 = "100";
        String Y1 = "2345";
        String X2 = "100";
        String Y2 = "203045";
        String X3 = "100";
        String Y3 = "123450";
        String X4 = "12321";
        String Y4 = "42531";
        String X5 = "5525";
        String Y5 = "1255";
        String X6 = "55251232131231231231231231";
        String Y6 = "1255123123123123123123123123123123123";

        System.out.println(solution(X1, Y1).equals("-1"));
        System.out.println(solution(X2, Y2).equals("0"));
        System.out.println(solution(X3, Y3).equals("10"));
        System.out.println(solution(X4, Y4).equals("321"));
        System.out.println(solution(X5, Y5).equals("552"));
        System.out.println(solution(X6, Y6));
    }

    static public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();

        int[] xNumberArray = new int[10];
        int[] yNumberArray = new int[10];
        int[] commonNumberArray = new int[10];
        int commonNumberCount = 0;

        //String X를 분해해서 xNumberArray에 채우기
        for (int i = 0; i < X.length(); i++) {
            xNumberArray[(X.charAt(i) - '0')]++;
        }
        //String Y를 분해해서 xNumberArray에 채우기
        for (int i = 0; i < Y.length(); i++) {
            yNumberArray[(Y.charAt(i) - '0')]++;
        }
        //중복되는 요소들 확인하기
        for (int i = 0; i < 10; i++) {
            while (xNumberArray[i] != 0 && yNumberArray[i] != 0){
                commonNumberCount++;
                commonNumberArray[i]++;
                xNumberArray[i]--;
                yNumberArray[i]--;
            }
        }

        if(commonNumberCount == 0) {
            return "-1";
        }

        //배열 끝에서부터 값이 있는지 확인해서 큰 자리수 만들기
        while (commonNumberCount > 0) {
            for (int i = 9; i >= 0; i--) {
                if(commonNumberArray[i] != 0){
                    answer.append(String.valueOf(i));
                    commonNumberArray[i] --;
                    break;
                }
            }

            commonNumberCount--;
        }

        if(answer.toString().split("0").length == 0){
            return "0";
        }

        return answer.toString();
    }
}
