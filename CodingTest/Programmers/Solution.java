package CodingTest.Programmers;

class Solution {
    public int solution(int totalSectionNum, int rollerLength, int[] sectionsToPaint) {
        int answer = 0;

        int firstSection = sectionsToPaint[0];
        int paintRollerLength = firstSection + rollerLength - 1;
        answer++;

        for (int idx = 1; idx < sectionsToPaint.length; idx++) {
            int nextSection = sectionsToPaint[idx];

            if (nextSection > paintRollerLength) {
                paintRollerLength = nextSection + rollerLength - 1;
                answer++;
            }
        }

        return answer;
    }
}
