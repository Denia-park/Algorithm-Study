package CodingTest.Programmers;

class Solution {
    private static final int PIZZA_SLICE = 6;

    public int solution(int n) {
        return getLcm(PIZZA_SLICE, n) / PIZZA_SLICE;
    }

    private int getLcm(int a, int b) {
        return (a * b) / getGcd(a, b);
    }

    private int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGcd(b, a % b);
        }
    }
}
