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

        for (int i = 1; i <= 8; i++) {
            int num = i;
            int next = i + 1;

            while (num <= high && next <= 9) {
                num = num * 10 + next;

                if (low <= num && num <= high) {
                    answer.add(num);
                }

                next += 1;
            }
        }

        answer.sort(null);

        return answer;
    }
}
