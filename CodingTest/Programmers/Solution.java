package CodingTest.Programmers;

//2022 KAKAO BLIND RECRUITMENT
//양궁대회

//라이언 우승자 , 어피치 도전자

//어피치에게 유리한 룰
//      1.어피치가 먼저 쏘고 라이언이 쏜다.
//      2.k점을 더 많은 화살을 k점에 맞힌 선수가 k점을 가져간다. (동일하게 맞춘 경우, 어피치가 가져간다.)
//      3.k점을 여러발 맞춰도 k점만 가져간다. 그리고 모두 0발이면 아무도 점수 획득 못 함
//      4.최종 점수가 높은 사람이 우승자 => 점수가 같아도 어피치가 우승

//현재 어피치가 다 쏘고 나서 라이언이 쏠 차례
//가장 큰 점수차로 이기기 위해 n발의 화살을 어떻게 맞춰야 하는지 계산
//n발의 화살을 어떻게 맞춰야 하는지 정수 배열에 담아 return, 라이언이 우승할 수 없는 경우는 -1을 리턴 (무조건 지거나, 비기는 경우)

//가장 큰 점수 차이가 여러개이면, 가장 낮은 점수를 더 많이 경우를 return

//N의 수가 작으니까, 백트래킹을 적용하바.

import java.util.Arrays;

class Solution {
    int maxScoreDiff;
    int[] answer;
    int[] apeachScores;
    int[] rionScores;

    public int[] solution(int arrowNum, int[] info) {
        maxScoreDiff = 0;
        answer = new int[11];
        apeachScores = info;
        rionScores = new int[11];

        //가장 큰 점수차 -> 큰 점수부터 먹는다. => 백트래킹 실행
        fullScan(0, arrowNum);

        //도저히 못 이기면 -1을 리턴한다.
        return maxScoreDiff == 0 ? new int[]{-1} : answer;
    }

    private void fullScan(int curDepth, int arrowNum) {
        if (curDepth == apeachScores.length) {
            //어피치랑 라이언 점수 비교 함수
            int tempScoreDiff = calculateScoreDiff();

            if (tempScoreDiff == 0 || tempScoreDiff < maxScoreDiff) {
                return;
            }

            if (tempScoreDiff > maxScoreDiff) {
                maxScoreDiff = tempScoreDiff;
                answer = Arrays.copyOf(rionScores, rionScores.length);
                return;
            }

            //기존 점수랑 똑같을 경우 뭐가 더 우선인지 비교할 함수
            calculatePriority();

//            System.out.println("--------------------------------------");
//            System.out.println(maxScoreDiff);
//            System.out.println(Arrays.toString(answer));
//            System.out.println(Arrays.toString(rionScores));
            return;
        }

        if (curDepth == apeachScores.length - 1) {
            rionScores[curDepth] = arrowNum;
            fullScan(curDepth + 1, 0);
            rionScores[curDepth] = 0;
            return;
        }

        for (int count = 0; count < apeachScores[curDepth] + 2; count++) {
            if (count > arrowNum) {
                continue;
            }

            rionScores[curDepth] = count;
            fullScan(curDepth + 1, arrowNum - count);
            rionScores[curDepth] = 0;
        }
    }

    //어피치랑 라이언 점수 비교
    private int calculateScoreDiff() {
        int apeachSum = 0;
        int rionSum = 0;

        for (int scoreIdx = 0; scoreIdx < rionScores.length; scoreIdx++) {
            int rionNum = rionScores[scoreIdx];
            int apeachNum = apeachScores[scoreIdx];

            if (rionNum == 0 && apeachNum == 0) {
                continue;
            }

            int score = 10 - scoreIdx;

            if (rionNum > apeachNum) {
                rionSum += score;
            } else {
                apeachSum += score;
            }
        }

        return Math.max(rionSum - apeachSum, 0);
    }

    private void calculatePriority() {
        boolean flag = true;

        for (int idx = rionScores.length - 1; idx >= 0; idx--) {
            int answerNum = answer[idx];
            int rionNum = rionScores[idx];

            if (answerNum > rionNum) {
                flag = false;
                break;
            } else if (answerNum < rionNum) {
                break;
            }
        }

        if (flag) {
            answer = Arrays.copyOf(rionScores, rionScores.length);
        }
    }
}
