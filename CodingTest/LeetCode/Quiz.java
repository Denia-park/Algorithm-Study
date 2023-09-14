package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(solution.removeElement(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(solution.removeElement(new int[]{2}, 3));
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        //퀵소트 처럼 왼쪽 오른쪽 비교하면서 바꿔주면 되지 않을까?
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            while (end > -1 && nums[end] == val) {
                end--;
            }

            while (start < nums.length && nums[start] != val) {
                start++;
            }

            if (start >= end) {
                break;
            }

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        return start;
    }
}
