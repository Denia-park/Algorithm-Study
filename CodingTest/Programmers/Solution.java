package CodingTest.Programmers;

import java.util.List;

class Solution {
    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        arr.sort(null);

        long sum = 0;
        for (Integer i : arr) {
            sum += i;
        }

        int min = arr.get(0);
        int max = arr.get(arr.size() - 1);

        System.out.print(sum - max);
        System.out.println(" " + (sum - min));
    }

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
