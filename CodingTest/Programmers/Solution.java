package CodingTest.Programmers;

class Solution {

    private int answer, balls, share;

    public int solution(int balls, int share) {
        answer = 0;
        this.balls = balls;
        this.share = share;

        for (int i = 0; i < balls; i++) {
            combination(i, 1);
        }

        return answer;
    }

    private void combination(int curIdx, int curCount) {
        if (curCount == share) {
            answer++;
            return;
        }

        for (int i = curIdx + 1; i < balls; i++) {
            combination(i, curCount + 1);
        }
    }
}
