package CodingTest.Programmers;

import java.util.Arrays;

class Solution {
    public int solution(final String skill, final String[] skill_trees) {
        int answer = 0;

        for (final String skillTree : skill_trees) {
            final int[] skilIdxArray = new int[skill.length()];
            Arrays.fill(skilIdxArray, -1);

            for (int skillIdx = 0; skillIdx < skill.length(); skillIdx++) {
                skilIdxArray[skillIdx] = skillTree.indexOf(skill.charAt(skillIdx));
            }

            boolean isOkay = true;
            for (int curIdx = 1; curIdx < skill.length(); curIdx++) {
                if (skilIdxArray[curIdx] == -1) {
                    continue;
                }

                for (int startIdx = 0; startIdx < curIdx; startIdx++) {
                    if (skilIdxArray[startIdx] == -1 || skilIdxArray[curIdx] < skilIdxArray[startIdx]) {
                        isOkay = false;
                        break;
                    }
                }
            }

            if (isOkay) {
                answer++;
            }
        }


        return answer;
    }
}
