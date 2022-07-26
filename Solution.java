package com.company;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static public void main(String[] args) {
        System.out.println(solution(2) == 1);
        System.out.println(solution(3) == 2);
        System.out.println(solution(10) == 4);
        System.out.println(solution(5) == 3);
        System.out.println(solution(11) == 5);
        System.out.println(solution(13) == 6);
        System.out.println(solution(100) == 25);
    }

    static public int solution(int n) {
        int answer = 0;

        List<Integer> primeList = new ArrayList<Integer>();

        //  for문을 돌면서 n 까지 모든 경우의 수를 확인
        for (int i = 2; i <= n; i++) {
            //1은 소수가 아니다.
            //소수를 체크하는 isPrime 메서드를 만든 후 true 가 나오면 (소수이면) answer를 1 증가한다.

            //효율성을 위해서 10보다 작은 경우에는 그냥 for문을 돌려서 소수를 판단한다.
            //소수로 판단되면 answer를 1 올리고 , primeList에 소수를 추가한다.
            if(n <= 10){
                if (isPrime(i)) {
                    answer++;
                    primeList.add(i);
                }
            }
            //primeList가 4개 정도 채워진 10 초과인 경우부터는 primeList를 사용하여 소수를 판단한다.
            //소수로 판단되면 answer를 1 올리고 , primeList에 소수를 추가한다.
            else {
                if(isPrimeWithPrimeList(i, primeList)){
                    answer++;
                    primeList.add(i);
                }
            }
        }

        //출력 크기 초과가 떠서 주석처리
//        System.out.println(primeList);
        return answer;
    }

    //프로그래머스 효율성 테스트를 위한 조언 [https://school.programmers.co.kr/questions/21359]
    // 1. 1보다 큰 모든 자연수는 소수의 곱으로 이루어져 있다. => 1보다 큰 자연수는 소수의 곱으로 이루어져 있기 때문에 소수로만 나누면 된다.
    //예를 들어 10이 소수인지 아닌지 알기 위해서는 10보다 작은 소수만을 이용하면 된다. 실제로 10보다 작은 소수는 4개, 즉 4개만 이용하면 된다.
    // 2. 어떤 자연수 n이 있을 때 , √n보다 작은 모든 소수들로 나누어 떨어지지 않으면 n은 소수
    //예를 들어 101이 소수인지 아닌지 판별하기 위해서는 우리는 √101을 구하면 되고 √101 은 10.xxx
    //10보다 작은 소수는 ? 2 3 5 7이 있다.  그런데 딱 봐도 이 4개의 소수로만 101이 나누어 떨어지지 않습니다.
    //그러므로 101소수입니다. 위의 방식을 이용하면 25개의 소수를 모두 이용해야 하지만 지금은 4개만 이용해도 쉽게 계산이 됩니다.
    private static boolean isPrimeWithPrimeList(int number, List<Integer> primeList) {
        for (int prime : primeList) {
            //√n 보다 작은 소수들로만 나눠서 비교해야한다. √n 보다 커지면 비교 할 필요가 없다.
            // 조언 2번에 √n 보다 작은 모든 소수들로 나누어 떨어지지 않으면 n은 소수입니다 를 이용함
            if(prime > Math.sqrt(number)){
                break;
            }
            // √n 보다 작은 소수로 나눴는데 딱 나눠 떨어진다 => 소수가 아니다.
            else if (number % prime == 0) {
                return false;
            }
        }
        // primeList에서 prime들로 다 나눠봤는데 안나눠진다. => 소수다
        return true;
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

