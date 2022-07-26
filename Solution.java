package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static public void main(String[] args) {
        System.out.println(solution(2) == 1);
        System.out.println(solution(3) == 2);
        System.out.println(solution(10) == 4);
        System.out.println(solution(5) == 3);
    }

    //프로그래머스 효율성 테스트를 위한 조언
    // 1. 1보다 큰 모든 자연수는 소수의 곱으로 이루어져 있다. => 1보다 큰 자연수는 소수의 곱으로 이루어져 있기 때문에 소수로만 나누면 된다.
    //예를 들어 10이 소수인지 아닌지 알기 위해서는 10보다 작은 소수만을 이용하면 된다. 실제로 10보다 작은 소수는 4개, 즉 4개만 이용하면 된다.
    // 2. 어떤 자연수 n이 있을 때 , √n보다 작은 모든 소수들로 나누어 떨어지지 않으면 n은 소수
    //예를 들어 101이 소수인지 아닌지 판별하기 위해서는 우리는 √101을 구하면 되고 √101 은 10.xxx
    //10보다 작은 소수는 ? 2 3 5 7이 있다.  그런데 딱 봐도 이 4개의 소수로만 101이 나누어 떨어지지 않습니다.
    //그러므로 101소수입니다. 위의 방식을 이용하면 25개의 소수를 모두 이용해야 하지만 지금은 4개만 이용해도 쉽게 계산이 됩니다.

    static public int solution(int n) {
        int answer = 0;
        
        //  for문을 돌면서 n 까지 모든 경우의 수를 확인
        for (int i = 2; i <= n; i++) {
            //1은 소수가 아니다.
            //소수를 체크하는 isPrime 메서드를 만든 후 true 가 나오면 (소수이면) answer를 1 증가한다.
            if (isPrime(i)) {
                answer++;
            }
        }


        return answer;
    }

    //소수를 체크하는 메서드
    static boolean isPrime(int num) {
        if(num == 2){
            return true;
        }
        //1은 무조건 나눠지므로 1 제외하고 2부터 for문을 시작한다
        for (int i = 2; i < num; i++) {
            //for문을 돌다가 나머지가 0이 나오는 경우는 해당 i 로 나눠지므로 소수가 아니다.
            //return false를 한다.
            if (num % i == 0) {
                return false;
            }
        }

        //for문을 다 돌아도 false가 나오지 않으면 소수 이므로 true를 반환
        return true;
    }
}

