package CodingTest.Programmers;

//유사 칸토어 비트열
//정답 참고
//https://americanoisice.tistory.com/202

class Solution {
    public int solution(int n, long left, long right) {
        int answer = 0;

        //f(n) = f(n-1)f(n-1)000..f(n-1)f(n-1)
        answer = (int) (countOne(n, right) - countOne(n, left - 1));

        return answer;
    }

    private long countOne(int n, long pos) {
        if (n == 1) {
            int[] countArr = new int[]{0, 1, 2, 2, 3, 4};
            return countArr[(int) pos];
        }

        long div = (long) (pos / Math.pow(5, n - 1));
        long mod = (long) (pos % Math.pow(5, n - 1));

        long oneCountNum = (long) Math.pow(4, n - 1);

        if (div <= 1) {
            return (oneCountNum * div) + countOne(n - 1, mod);
        } else if (div == 2) {
            return oneCountNum * 2;
        } else {
            return (oneCountNum * (div - 1)) + countOne(n - 1, mod);
        }
    }
}
