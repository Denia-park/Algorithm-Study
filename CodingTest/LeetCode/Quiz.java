package CodingTest.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.countNicePairs(new int[]{42, 11, 1, 97}));
        System.out.println(solution.countNicePairs(new int[]{432835222, 112141211, 5408045, 456281503, 283322436, 414281561, 37773, 286505682}));
    }
}

class Solution {
    private final int MOD = (int) (Math.pow(10, 9) + 7);

    public int countNicePairs(final int[] nums) {
        int answer = 0;

        //x + rev(y) == y + rev(x) -> x - rev(x) == y - rev(y) -> x - rev(x)가 같은 값 끼리 연산을 해야함
        final int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[i] - rev(nums[i]);
        }

        final Map<Integer, Integer> map = new HashMap<>();
        for (final int value : newArr) {
            final Integer preValue = map.getOrDefault(value, 0);

            answer = (answer % MOD + preValue % MOD) % MOD;

            map.put(value, preValue + 1);
        }

        return answer;
    }

    private int rev(final int num) {
        return Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());
    }
}
