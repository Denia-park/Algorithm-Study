package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    int[] apeachInfo;
    int maxDiff = 0;
    int[] answer;

    public int[] solution(final int leftArrowCount, final int[] info) {
        apeachInfo = info;
        answer = null;

        //이기고, 지고 의 모든 경우를 구한다.
        final int curIdx = 0;
        final int[] rionInfo = new int[11];
        sol(leftArrowCount, rionInfo, curIdx);

        //answer에서 가장 낮은 점수를 많이 받은 점수 return하기
        return answer == null ? new int[]{-1} : answer;
    }

    private void sol(final int leftArrowCount, final int[] rionInfo, final int curIdx) {
        if (curIdx >= apeachInfo.length) {
            //몇점 차로 이겼는지 계산하기
            final int diff = calculateScore(rionInfo);

            //점수 차이가 maxDiff 넘었는지 체크
            //같아도 낮은 점수가 더 많은게 좋으니까 체크한다.
            if (diff > maxDiff) {
                maxDiff = diff;
                answer = Arrays.copyOf(rionInfo, rionInfo.length);
            } else if (diff > 0 && diff == maxDiff) {
                if (isBetter(rionInfo)) {
                    answer = Arrays.copyOf(rionInfo, rionInfo.length);
                }
            }

            return;
        }

        //1점을 쏴야하는 경우에는 모든 화살을 다 털어야 한다. (=> 낮은 점수가 많은 사람이 이김)
        if (curIdx == apeachInfo.length - 1) {
            rionInfo[curIdx] = leftArrowCount;
            sol(0, rionInfo, curIdx + 1);
            return;
        }

        //이기면 한발만 더 쏴서 이기고, 질꺼면 하나도 안 쏜다.
        //이긴 경우
        final int shoot = apeachInfo[curIdx] + 1;
        if (leftArrowCount - shoot >= 0) {
            rionInfo[curIdx] = shoot;
            sol(leftArrowCount - shoot, rionInfo, curIdx + 1);
        }

        //진 경우
        rionInfo[curIdx] = 0;
        sol(leftArrowCount, rionInfo, curIdx + 1);
    }

    private boolean isBetter(final int[] rionInfo) {
        for (int i = rionInfo.length - 1; i >= 0; i--) {
            final int rionVal = rionInfo[i];
            final int defaultVal = answer[i];

            if (rionVal > defaultVal) {
                return true;
            } else if (rionVal < defaultVal) {
                return false;
            }
        }

        return false;
    }

    private int calculateScore(final int[] rionInfo) {
        int aS = 0;
        int rS = 0;

        for (int i = 0; i < apeachInfo.length; i++) {
            final int score = 10 - i;

            final int aTemp = apeachInfo[i];
            final int rTemp = rionInfo[i];

            if (aTemp == 0 && rTemp == 0) continue;

            if (aTemp < rTemp) {
                rS += score;
            } else {
                aS += score;
            }
        }

        return rS - aS;
    }
}
