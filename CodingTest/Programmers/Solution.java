package CodingTest.Programmers;

//이분 탐색으로 풀어보기
class Solution {
    public int solution(final int[] stones, final int k) {
        int answer = 1;

        int s = 1; //최소 인원
        int e = 200_000_000; //최대 인원

        while (s <= e) {
            final int m = s + ((e - s) / 2);

            //m명의 인원이면 해당 징검다리를 통과할 수 있나?
            if (isPossible(stones, m, k)) {
                answer = Math.max(answer, m);

                //가능하면 최소 인원 늘리기
                s = m + 1;
            } else {
                //불가능하면 최대 인원 줄이기
                e = m - 1;
            }
        }

        return answer;
    }

    private boolean isPossible(final int[] stones, final int m, final int limit) {
        int count = 0;

        for (final int stone : stones) {
            if (stone - m <= 0) {
                count++;
            } else {
                count = 0;
            }

            if (count > limit) {
                return false;
            }
        }

        return true;
    }
}
