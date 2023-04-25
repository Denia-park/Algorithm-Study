package CodingTest.Programmers;

//N개의 최소공배수

// 맨 처음 2개의 수에서 최소공배수를 구한다.
// 여기서 구한 최소공배수를 기반으로 다음 배열의 원소와 또 최소공배수를 구한다.
// 해당 계산을 배열이 끝날때까지 반복하면 된다.
class Solution {
    public int solution(int[] arr) {
        //첫번째요소 할당
        long answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            long tempVal = arr[i];

            long gcd = getGCD(tempVal, answer);

            answer = gcd * (answer / gcd * tempVal / gcd);
        }

        return (int) answer;
    }

    private long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return getGCD(b, a % b);
        }
    }
}
