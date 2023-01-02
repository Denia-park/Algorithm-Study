package CodingTest.Programers;

class Solution {
    public int[] solution(int arrowNum, int[] info) {
        int[] answer = {};
        //완탐을 돌려야 할 것 같다.
        //10점부터 비교해서 넣어보고 점수 비교
        //다음 점수 비교해서 넣어보고 점수 비교 ... 이렇게 쭉쭉


        int maxDiff = Integer.MIN_VALUE;
        int[] liHitNums = {};
        for (int i = 0; i < 11; i++) {
            int tempArrowNum = arrowNum;
            liHitNums = new int[11];

            for (int j = i; j < 11; j++) {
                if (tempArrowNum - (info[i] + 1) >= 0) {
                    tempArrowNum -= (info[i] + 1);
                    liHitNums[i] = tempArrowNum;
                }
            }

            int tempMaxDiff = calculateScoreDiff(info, liHitNums);
            if (tempMaxDiff > 0 && tempMaxDiff >= maxDiff) {
                maxDiff = tempMaxDiff;
                if (answer.length == 0) {
                    answer = liHitNums;
                } else {
                    answer = getMoreSmallValueArr(answer, liHitNums);
                }
            }
        }

        if (maxDiff == Integer.MIN_VALUE) {
            return new int[]{-1};
        }

        return answer;
    }

    int calculateScoreDiff(int[] appScores, int[] liScores) {
        int appTotalScore = 0;
        int liTotalScore = 0;
        for (int idx = 0; idx < 11; idx++) {
            int curScore = (10 - idx);

            if (appScores[idx] >= liScores[idx]) {
                appTotalScore += curScore;
            } else {
                liTotalScore += curScore;
            }
        }

        return liTotalScore - appTotalScore;
    }

    int[] getMoreSmallValueArr(int[] origin, int[] newArr) {
        for (int i = origin.length - 1; i >= 0; i--) {
            int aVal = origin[i];
            int bVal = newArr[i];

            if (aVal > bVal) {
                return origin;
            } else if (aVal < bVal) {
                return newArr;
            }
        }
        return origin;
    }
}
