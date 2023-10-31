package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) == 4);
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) == -1);
        System.out.println(solution.search(new int[]{7, 0, 1, 2, 4, 5, 6}, 3) == -1);
        System.out.println(solution.search(new int[]{1}, 0) == -1);
    }
}

class Solution {
    public int search(int[] nums, int target) {
        //rotate 된 부분을 찾는다
        final int rotateIndex = getRotateIndex(nums);

        final int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);

        //rotate된 부분을 떼어내서 정상적인 arr를 만든다
        if (rotateIndex != -1) {
            System.arraycopy(nums, rotateIndex + 1, newNums, 0, nums.length - (rotateIndex + 1));
            System.arraycopy(nums, 0, newNums, nums.length - (rotateIndex + 1), rotateIndex + 1);
        }

        //이진 검색을 통해 target을 찾는다.
        return getTarget(newNums, target);
    }

    private int getTarget(final int[] newNums, final int target) {

        int start = 0;
        int end = newNums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            final int midVal = newNums[mid];

            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    private int getRotateIndex(final int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        int startVal = nums[0];

        boolean rightDirection = false;

        int mid = start + (end - start) / 2;
        if (startVal < nums[mid]) {
            rightDirection = true;
        }

        while (start <= end) {
            mid = start + (end - start) / 2;

            //rotate 못 찾음
            if (mid != nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                if (rightDirection) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}

