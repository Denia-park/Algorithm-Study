package CodingTest.Programmers;

class Solution {
    public int solution(final int n, final int[][] results) {
        int answer = 0;
        final int totalNumber = n;

        //배열 초기화
        final boolean[][] wins = new boolean[totalNumber][totalNumber];
        final boolean[][] loses = new boolean[totalNumber][totalNumber];

        //결과를 순회하면서 이긴 경우, 진 경우 true로 변경
        for (final int[] result : results) {
            final int winNum = result[0] - 1;
            final int loseNum = result[1] - 1;

            wins[winNum][loseNum] = true;
            loses[loseNum][winNum] = true;
        }

        //플로이드 와샬 알고리즘을 이용하여 이긴 경우, 진 경우를 true로 변경
        for (int mid = 0; mid < totalNumber; mid++) {
            for (int start = 0; start < totalNumber; start++) {
                for (int end = 0; end < totalNumber; end++) {
                    //나한테 진 사람이 다른 사람을 이긴 경우
                    if (wins[start][mid] && wins[mid][end]) {
                        wins[start][end] = true;
                        loses[end][start] = true;
                    }

                    //나한테 이긴 사람이 다른 사람에게 진 경우
                    if (loses[start][mid] && loses[mid][end]) {
                        wins[end][start] = true;
                        loses[start][end] = true;
                    }
                }
            }
        }

        //순회하면서 이긴 경우, 진 경우의 합이 n-1인 경우 answer++
        for (int start = 0; start < totalNumber; start++) {
            int matchCount = 0;

            for (int end = 0; end < totalNumber; end++) {
                //start가 end에게 이긴 경우, start가 end에게 진 경우
                //존재하면 승부 결과를 matchCount++
                if (wins[start][end] || loses[start][end]) {
                    matchCount++;
                }
            }

            //나를 제외한 (n-1)명의 선수와 승부를 했으면 answer++
            if (matchCount == (totalNumber - 1)) {
                answer++;
            }
        }

        return answer;
    }
}
