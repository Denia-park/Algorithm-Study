package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(int n) {
        boolean[] primeNumCheckArray = new boolean[101];
        Arrays.fill(primeNumCheckArray, true);

        //약수의 개수가 3개 이상인 수 -> 소수가 아닌 수
        //100까지 이므로 10도 에라토스테네스의 체로 구해야함
        for (int idx = 2; idx < 11; idx++) {
            for (int multi = idx * 2; multi < primeNumCheckArray.length; multi += idx) {
                primeNumCheckArray[multi] = false;
            }
        }

        int primeNumCount = 0;
        for (int idx = 1; idx < n + 1; idx++) {
            if (primeNumCheckArray[idx]) {
                primeNumCount++;
            }
        }

        return n - primeNumCount;
    }
}
