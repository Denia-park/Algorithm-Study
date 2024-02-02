package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println((solution.sequentialDigits(100, 300)));
        System.out.println((solution.sequentialDigits(1000, 13000)));
    }
}

class Solution {
    public List<Integer> sequentialDigits(final int low, final int high) {
        final List<Integer> answer = new ArrayList<>();
        // 가능한 숫자는 12 ~~~
        // 앞자리 바꿔가면서, 뒷자리를 계속 추가하면서 High랑 비교하자.

        for (int start = 1; start <= 8; start++) {
            int last = start + 1;
            String temp = start + "" + (last);

            while (last < 10
                    && temp.length() < 10
                    && Integer.valueOf(temp) <= high) {
                if (Integer.valueOf(temp) >= low) {
                    answer.add(Integer.valueOf(temp));
                }

                last += 1;
                temp += ("" + last);
            }
        }

        answer.sort(null);

        return answer;
    }
}
