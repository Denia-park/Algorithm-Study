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

            //라이언이 지거나, 더 많은 격차를 내지 못하면 업데이트를 하지 않는다.
            if (tempScoreDiff == 0 || tempScoreDiff < maxScoreDiff) {
                return;
            }

            //새로운 점수 격차를 내면 업데이트
            if (tempScoreDiff > maxScoreDiff) {
                maxScoreDiff = tempScoreDiff;
                answer = Arrays.copyOf(rionScores, rionScores.length);
                return;
            }

            //기존 점수랑 똑같을 경우 뭐가 더 우선인지 비교할 함수
            calculatePriority();
            
            return;
        }

        //마지막에는 무조건 화살을 다 털어야 하므로 여기서 나머지를 다 쏜다.
        if (curDepth == apeachScores.length - 1) {
            rionScores[curDepth] = arrowNum;
            fullScan(curDepth + 1, 0);
            rionScores[curDepth] = 0;
            return;
        }

        //모든 경우의 수를 돈다. 어피치보다 1발 더 쏴야 이기는 경우가 있으니 그 경우까지 고려해서 for문을 돈다.
        for (int count = 0; count < apeachScores[curDepth] + 2; count++) {
            //남은 화살보다 많이 쏠수는 없다
            if (count > arrowNum) continue;

            //백트래킹을 할 때 다음 경우의 수를 고려해야 하므로 사용했던 값은 원래대로 돌려놔야한다.
            rionScores[curDepth] = count;
            fullScan(curDepth + 1, arrowNum - count);
            rionScores[curDepth] = 0; // 값을 원래대로 돌려놓기
        }
    }

    //어피치랑 라이언 점수 비교
    private int calculateScoreDiff() {
        int apeachSum = 0;
        int rionSum = 0;

        //0번째 Idx가 10점이므로, 실수 하기 좋다. 조심
        for (int scoreIdx = 0; scoreIdx < rionScores.length; scoreIdx++) {
            int rionNum = rionScores[scoreIdx];
            int apeachNum = apeachScores[scoreIdx];

            //둘 다 0발이면 둘 다 점수를 먹지 못함
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

        //0점과 비교를 하게되면 음수가 나오거나 0점이 나오면 0이 return 되고 나머지는 점수 차이가 return 된다.
        return Math.max(rionSum - apeachSum, 0);
    }

    //우선 순위를 비교한다.
    private void calculatePriority() {
        //낮은 점수에서 맞춘 화살 수 부터 비교를 한다.
        for (int idx = rionScores.length - 1; idx >= 0; idx--) {
            int answerNum = answer[idx];
            int rionNum = rionScores[idx];

            //기존 정답의 화살이 더 많은 경우, 그냥 종료
            //새로운 정답의 화살이 더 많은 경우, 새로운 정답으로 업데이트 후 종료
            //동일한 경우는 그냥 지나간다.
            if (answerNum > rionNum) {
                return;
            } else if (answerNum < rionNum) {
                answer = Arrays.copyOf(rionScores, rionScores.length);
                return;
            }
        }

    }
}
