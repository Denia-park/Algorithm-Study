package CodingTest.Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(final String numbers) {
        int answer = 0;

        //에라토스테네스의 체를 통해서 소수 구하기
        //1이상 7이하 수 -> 최대 7자리 수 -> 10000000까지
        final boolean[] primeNumbers = eratosthenes();

//        System.out.println(Arrays.toString(primeNumbers));

        //number로 모든 수 구하기
        final Set<Integer> allNumbers = permutation(numbers);
//        System.out.println(allNumbers);

        //몇개나 되는지 확인하기
        for (final Integer allNumber : allNumbers) {
            final int num = allNumber;

            if (primeNumbers[num]) {
                answer++;
            }
        }

        return answer;
    }

    private boolean[] eratosthenes() {
        final int MAX = 10_000_000;
        final boolean[] primeNumbers = new boolean[MAX];

        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;

        //2에서 Math.sqrt(10000000)까지 반복
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            for (int j = (2 * i); j < MAX; j += i) {
                primeNumbers[j] = false;
            }
        }

        return primeNumbers;
    }

    private Set<Integer> permutation(final String numbers) {
        final Set<Integer> set = new HashSet<>();

        final boolean[] isVisited = new boolean[numbers.length()];

        recurPermutation(set, isVisited, numbers, "");

        return set;
    }

    private void recurPermutation(final Set<Integer> set, final boolean[] isVisited, final String numbers, final String curString) {
        if (!curString.isEmpty()) {
            set.add(Integer.valueOf(curString));
        }

        if (curString.length() == numbers.length()) return;

        for (int idx = 0; idx < numbers.length(); idx++) {
            if (isVisited[idx]) continue;

            final char ch = numbers.charAt(idx);
            isVisited[idx] = true;
            recurPermutation(set, isVisited, numbers, curString + ch);
            isVisited[idx] = false;
        }
    }
}
