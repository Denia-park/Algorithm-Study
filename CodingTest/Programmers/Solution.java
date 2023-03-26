package CodingTest.Programmers;

import java.util.List;

class Solution {
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        double size = arr.size();

        double plus = 0;
        double minus = 0;
        double zero = 0;

        for (Integer i : arr) {
            if (i == 0) {
                zero++;
            } else if (i > 0) {
                plus++;
            } else {
                minus++;
            }
        }

        System.out.printf("%.6f%n", plus / size);
        System.out.printf("%.6f%n", minus / size);
        System.out.printf("%.6f%n", zero / size);
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
