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
                //가능한 최대 인원 구하기
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
            if (stone - m < 0) { //못 밟는거
                count++;
            } else { //밟을 수 있는거
                count = 0;
            }

            //못 밟는게 일정 수를 넘어가면, 해당 인원으로 못 건너감
            if (count >= limit) {
                return false;
            }
        }

        return true;
    }
}
