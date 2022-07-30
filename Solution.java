package com.company;

import java.util.HashMap;

public class Solution {
    static public void main(String[] args) {
        System.out.println(solution(1).equals("1") );
        System.out.println(solution(2).equals("2") );
        System.out.println(solution(3).equals("4") );
        System.out.println(solution(4).equals("11") );
        System.out.println(solution(5).equals("12") );
        System.out.println(solution(6).equals("14") );
        System.out.println(solution(7).equals("21") );
        System.out.println(solution(8).equals("22") );
        System.out.println(solution(9).equals("24") );
        System.out.println(solution(10).equals("41") );
    }

    //124의 나라는 숫자 3개만 쓰므로 3진법이라 생각을 하고 DIV_VALUE 를 3으로 둔다.
    static int DIV_VALUE = 3;

    static public String solution(int n) {
        String answer = "";

        answer = solveWithRecursive(n);

        return answer;
    }

    static public String solveWithRecursive(int n) {
        // n이 0인 경우 나눌게 없으므로 ""을 return 한다.
        if(n == 0)
            return "";

        // 1 2 4 의 나라에 맞게 Array 를 정렬 , 3으로 나눴을때 0이 나오면 숫자 4가 들어가므로 0번쨰 인자가 "4"이다
        int[] strangeCounturyNumberArray = {4,1,2};

        //몫을 구한다.
        int div = n / DIV_VALUE;
        //나머지를 구한다.
        int mod = n % DIV_VALUE;

        //몫이 없는 경우 앞에 붙일 숫자가 없으므로 바로 1 2 4 중 하나의 값을 String 으로 만들어 Return
        if (div == 0) {
            return String.valueOf(strangeCounturyNumberArray[mod]);
        }
        //몫이 있는 경우 앞에 붙여야 하는 숫자가 있으므로 재귀함수를 한번 더 탄다.
        else {
            //3의 배수인 경우 몫을 1만큼 빼줘야 정상적으로 값이 나온다.
            if(mod == 0)
                div -= 1;
            return solveWithRecursive(div) + strangeCounturyNumberArray[mod];
        }
    }
}
