package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 5) == 2);
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 2) == 1);
        System.out.println(solution.searchInsert(new int[]{1, 3, 5, 6}, 7) == 4);
        System.out.println(solution.searchInsert(new int[]{1}, 0) == 0);
        System.out.println(solution.searchInsert(new int[]{1}, 2) == 1);
        System.out.println(solution.searchInsert(new int[]{1, 3}, 2) == 1);
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        //이분탐색
        int st = 0;
        int ed = nums.length;

        while (st < ed) {
            int mid = (st + ed) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                ed = mid;
            }
        }

        return st;
    }
}
