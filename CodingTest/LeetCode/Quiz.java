package CodingTest.LeetCode;

import java.util.HashMap;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(solution.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }
}

class Solution {
    public int numSubarraysWithSum(final int[] nums, final int goal) {
        int sum = 0, count = 0;
        final HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 누적 합이 0인 경우를 위해 초기화

        for (final int num : nums) {
            sum += num; // 누적 합 계산
            count += map.getOrDefault(sum - goal, 0); // 목표 합을 만족하는 경우 찾기
            map.put(sum, map.getOrDefault(sum, 0) + 1); // 누적 합 업데이트
        }

        return count;
    }
}
