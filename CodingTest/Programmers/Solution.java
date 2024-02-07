package CodingTest.Programmers;

class Solution {
    public int solution(final int n, final int k) {
        int answer = 0;

        //k진수에 맞춰서 n을 변환
        final String convert = Integer.toUnsignedString(n, k);

        //0으로 split
        final String[] split = convert.split("0");

        //해당 값이 소수인지 판단
        for (final String s : split) {
            if (isPrimeNum(s)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrimeNum(final String s) {
        if (s.isBlank()) return false;

        final int val = Integer.parseInt(s);

        if (val <= 1) return false;

        final int root = (int) Math.sqrt(val);
        for (int i = 2; i <= root; i++) {
            if (val % i == 0) {
                return false;
            }
        }

        return true;
    }
}
