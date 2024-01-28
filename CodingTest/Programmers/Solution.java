package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(final String skill, final String[] skill_trees) {
        int answer = 0;

        //모든 스킬 트리에 대해서 해당 스킬이 올바른지 검사
        for (final String skillTree : skill_trees) {
            //순서가 정해진 스킬들에 대해서 몇번째로 배웠는지 기록할 array 추가
            final int[] skilIdxArray = new int[skill.length()];
            //초기화 -> 배우지 않았음을 의미
            Arrays.fill(skilIdxArray, -1);

            //스킬들을 몇번째로 배웠는지 계산
            for (int skillIdx = 0; skillIdx < skill.length(); skillIdx++) {
                skilIdxArray[skillIdx] = skillTree.indexOf(skill.charAt(skillIdx));
            }

            //제대로 배웠는지 판단할 변수
            boolean isOkay = true;

            //현재 스킬을 기준으로해서, 이전 스킬들을 확인하면서 이전 스킬들을 안 배웠는데 현재 스킬을 배운 경우나, 순서가 잘못된 경우를 검사
            for (int curIdx = 1; curIdx < skill.length(); curIdx++) {
                //현재 스킬이 안 배운 스킬이면 스킵
                if (skilIdxArray[curIdx] == -1) {
                    continue;
                }

                //현재 스킬 이전의 스킬들을 제대로 배웠는지 검사
                for (int startIdx = 0; startIdx < curIdx; startIdx++) {
                    //이전 스킬들을 안배우고 넘어오면 잘못된 스킬트리
                    //이전 스킬보다 현재 스킬을 먼저 배우면 잘못된 스킬트리
                    if (skilIdxArray[startIdx] == -1 || skilIdxArray[curIdx] < skilIdxArray[startIdx]) {
                        isOkay = false;
                        break;
                    }
                }
            }

            //제대로 된 경우만 카운트
            if (isOkay) {
                answer++;
            }
        }


        return answer;
    }
}
