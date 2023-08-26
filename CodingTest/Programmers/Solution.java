package CodingTest.Programmers;

import java.util.Arrays;

/*
1. 라이언 우승자, 어피치 도전자
어피치가 유리한 게임
어피치가 n발을 쏘고, 라이언이 n발을 쏨 [n은 1~10발]
0~10점까지 있음
a=b발 같으면 어피치가 k점 가져감, a=b=0 이면 모두 0점, 맞춘 점수만 가져감
최종 점수 높은 사람이 우승자 (점수가 같으면 어피치 우승)
라이언은 어피치를 이겨야 하는데, 가장 큰 점수 차로 이기고 싶음
n발의 화살을 어떻게 점수에 박아넣어야 이기는지 10점~0점까지 정수 배열 (info의 길이 = 11) 에 담아 return
라이언이 비기거나, 지는 경우 [-1]을 return

여러 방법으로 이길 수 있으면, 가장 낮은 점수를 많이 맞힌 경우의 값을 return.

아이디어
- 보통 1~10 사이의 값, 재귀함수 -> 백트래킹을 많이 쓴다.
- 내가 최대한의 점수 차로 이길 수 있는 모든 경우의 수를 구한다.
- 여러 값이 있으면 가장 낮은 점수로 이긴 경우를 고르고 반환.

- 라이언은 이기기 위해서 무조건 1발을 더 써야한다.
- 이기지 못 할 꺼면 한발이라도 안쓰는게 낫다.
- 나올 수 있는 경우의 수가 엄청 많을 것 같다 => 백트래킹을 써서 완전탐색 (모든 경우의 수를 확인)

시간복잡도
- 완전 탐색 (백트래킹) -> O(n ^ n)
- dfs를 사용하자

자료구조
- 사용하는 값들이 모두 작으니 int를 쓰자.
 */


class Solution {
    private int[] answer;
    private int[] apeachScores;
    private int curMaxDiff;
    private int LAST_INDEX = 10;

    public int[] solution(int maxArrowCnt, int[] info) {
        //재귀를 돌면서 모든 경우의 수를 구한다.
        answer = new int[]{-1};

        apeachScores = info;
        curMaxDiff = 0;

        int curIndex = 0;
        int[] rionInfo = new int[info.length];
        backTracking(curIndex, rionInfo, maxArrowCnt);

        return curMaxDiff == 0 ? new int[]{-1} : answer;
    }

    private void backTracking(final int curIndex, final int[] rionInfo, final int curArrowCnt) {
        if (curIndex == LAST_INDEX) { //화살이 남았는데 마지막 Index에 도달한 경우
            if (curArrowCnt > 0) {
                rionInfo[curIndex] = curArrowCnt;
            }

            //점수 계산을 해서 curMaxScore 크면 answers에 저장.
            final int curDiff = calculateScoreDiff(rionInfo);

            if (curDiff == 0) {
                rionInfo[curIndex] = 0;
                return;
            }

            if (curDiff > curMaxDiff) {
                curMaxDiff = curDiff;
                answer = Arrays.copyOf(rionInfo, rionInfo.length);
            } else if (curDiff == curMaxDiff) {
                //answer가 업데이트 됐으면 우선순위 비교
                answer = calculatePriority(answer, rionInfo);
            }

            rionInfo[curIndex] = 0;
            return;
        }

        //이기고, 지고의 모든 경우의 수를 구하자.
        for (int idx = 0; idx < 2; idx++) {
            if (idx == 0) { // 이기는 경우
                final int apeachShootArrowCnt = apeachScores[curIndex];

                //이기려면 어피치보다 1개 더 쏴야함
                //화살 수가 적으면 못 쏨
                final int rionShootArrowCnt = apeachShootArrowCnt + 1;
                if (curArrowCnt >= rionShootArrowCnt) {
                    rionInfo[curIndex] = rionShootArrowCnt;

                    //다음 라운드 진행
                    backTracking(curIndex + 1, rionInfo, curArrowCnt - rionShootArrowCnt);

                    //백트래킹은 경우 확인했으면 원래대로 돌려놔야함
                    rionInfo[curIndex] = 0;

                    continue;
                }
            }

            //지는 경우 (화살이 부족한 경우에도 지는 걸로 친다.)
            backTracking(curIndex + 1, rionInfo, curArrowCnt);
        }
    }

    private int[] calculatePriority(final int[] oldArr, final int[] newArr) {
        for (int i = oldArr.length - 1; i >= 0; i--) {
            if (newArr[i] > oldArr[i]) {
                return Arrays.copyOf(newArr, newArr.length);
            } else if (newArr[i] < oldArr[i]) {
                return oldArr;
            }
        }

        return oldArr;
    }

    private int calculateScoreDiff(final int[] rionScores) {
        int apeachTotalScore = 0;
        int rionTotalScore = 0;

        //10점에서부터 비교하면서 크면 점수 추가
        for (int scoreIdx = 0; scoreIdx < rionScores.length; scoreIdx++) {
            final int apeachCurrentIndexArrowCount = apeachScores[scoreIdx];
            final int rionCurrentIndexArrowCount = rionScores[scoreIdx];

            if (apeachCurrentIndexArrowCount == 0 && rionCurrentIndexArrowCount == 0) {
                continue;
            }

            final int curScore = 10 - scoreIdx;

            if (rionCurrentIndexArrowCount > apeachCurrentIndexArrowCount) {
                rionTotalScore += curScore;
                continue;
            }

            apeachTotalScore += curScore;
        }

        return Math.max(rionTotalScore - apeachTotalScore, 0);
    }
}
