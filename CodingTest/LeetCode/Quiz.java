package CodingTest.LeetCode;

import java.util.Arrays;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1) == 2);
        System.out.println(solution.threeSumClosest(new int[]{0, 0, 0}, 1) == 0);
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int answer = 10_000_000;

        Arrays.sort(nums);

        for (int origin = 0; origin < nums.length - 2; origin++) {
            int start = origin + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[origin] + nums[start] + nums[end];

                //값 비교 - 더 작은 걸 사용해야 함
                answer = Math.abs(sum - target) < Math.abs(answer - target) ? sum : answer;

                //남은 투포인터를 옮기면서 값 비교 (start, end)
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return sum;
                }
            }
        }

        return answer;
    }
}
