package com.company;

import java.util.Arrays;

class Solution {
    static public void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4,4,4,4,4})));
        System.out.println(Arrays.toString(solution(3, new int[]{1,1,2,1})));
    }

    static public int[] solution(int totalStageNum, int[] stages) {
        int[] answer = new int[totalStageNum]; //answerArr 의 길이는 총 스테이지의 수만큼 나온다. . Stage 길이는 1이상 20만 이하, 가능한 플레이어의 수가 20만까지
        //총 스테이지의 수 + 1 만큼 크기를 가진 카운팅 배열을 만들어두면 안에 들어가는 플레이어의 수가 1~20만명이다.
        //해당 배열에는 해당 스테이지를 클리어 하지 못한 플레이어의 수가 들어간다.
        //Stage를 모두 담기 위해서는 totalStageNum + 1 이고 stages 에는 N+1 이하의 자연수가 담기므로 결국은 totalStageNum + 2 가 countingArr의 크기
        int[] countingArray = new int[totalStageNum + 2];
        float[] failureRateByStageNum = new float[totalStageNum]; //Stage 별로 저장된 실패율

        //countingArray[stage]의 값은 해당 stage를 클리어 하지 못한 플레이어의 수
        for (int stage : stages) {
            countingArray[stage]++;
        }

        //전체 플레이어 수는 stages의 길이
        int totalPlayerNum = stages.length;
        //해당 스테이지에 도달하지 못한 플레이어 수를 처음에 0으로 설정
        int notReachPlayerNum = 0;

        //실패율 구하기
        //실패율은 다음과 같이 정의한다.
        //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        //첫번째 예제에서 실패율을 구해보면
        // 0 1 2 3 4 [Index]                      =>    1 2 3 4 5 [Stage]
        // 1 3 2 1 0 [클리어 못한 플레이어 수]           1 3 2 1 0 [클리어 못한 플레이어 수]
        // 오름차순이기 때문에 1 스테이지에는 모두 도달했고 1명만 클리어 못했음 => 1 / 8
        // 2 스테이지에는 1 스테이지에서 못 벗어난 1명 빼고 8 - 1 = 7명이 도달했고 3명이 못 깻음 => 3 / 7
        // ... 이걸 반복해서 구한다.
        for (int i = 0; i < totalStageNum; i++) {
            //i = 0 일때 stage 1 의 실패율 이므로 i + 1 이 들어간다. , 앞 스테이지에서 못 벗어난 인원은 뺀다
            // (totalPlayerNum - notReachPlayerNum) = 0 이 되면 NaN이 되므로 if문이 필요함 주의.
            if((totalPlayerNum - notReachPlayerNum) != 0)
                failureRateByStageNum[i] = (float) countingArray[i + 1] / (totalPlayerNum - notReachPlayerNum);
            else
                failureRateByStageNum[i] = 0;
            //해당 스테이지에서 못 벗어난 인원을 계속해서 더해준다.
            notReachPlayerNum += countingArray[i + 1];
        }

        //실패율 Arr 를 오름차순으로 변경하는 절차
        //먼저 배열을 복사 후 sorting 진행
        float[] arrDescByFailureRate = Arrays.copyOfRange(failureRateByStageNum, 0, failureRateByStageNum.length);
        Arrays.sort(arrDescByFailureRate);

        //answerArr의 index를 위한 변수
        int answerIndex = 0;

        //오름차순을 맨 뒤에서부터 읽으면 내림차순
        for (int i = arrDescByFailureRate.length - 1; i >= 0; i--) {
            //앞에서부터 실패율을 비교해야 동일한 실패율이더라도 스테이지 번호는 오름차순이 된다.
            for (int j = 0; j < failureRateByStageNum.length; j++) {
                //실패율을 내림차순으로 값을 확인하면서 동일한 실패율을 가지는 해당하는 Stage를 찾아서 answer Array에 추가
                if(arrDescByFailureRate[i] == failureRateByStageNum[j]){
                    answer[answerIndex] = j + 1; //index랑 stage 는 1차이 난다.
                    answerIndex++; //answer Arr의 Index 값을 1 올려준다
                    failureRateByStageNum[j] = -1f; // 사용된 값이므로 중복되서 처리되지 않게 값을 변경시킨다.
                    break;
                }
            }
        }

        return answer;
    }
}

