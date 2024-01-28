package CodingTest.Programmers;

class Solution {
    public int solution(final String skill, final String[] skill_trees) {
        int answer = 0;

        for (final String skillTree : skill_trees) {
            final int[] skilIdxArray = new int[skill.length()];

            for (int skillIdx = 0; skillIdx < skill.length(); skillIdx++) {
                skilIdxArray[skillIdx] = skillTree.indexOf(skill.charAt(skillIdx));
            }

            boolean isOkay = true;
            for (int i = 1; i < skill.length(); i++) {
                if (skilIdxArray[i] < skilIdxArray[i - 1]) {
                    isOkay = false;
                    break;
                }
            }

            if (isOkay) {
                answer++;
            }
        }


        return answer;
    }
}
