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
        //오름차순을 Rotate했기 때문에 내가 현재 Rotate 기준 왼쪽에 있는지 오른쪽에 있는지 판단해야함
        // -> 범위내에 꺾인 부분이 존재하는 한 내가 어느쪽에 존재하는 지 판단 해야함

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2); //이렇게 코드를 짜면 오버플로우가 발생하지 않음
            int midVal = nums[mid];

            //값을 찾았다.
            if (midVal == target) {
                return mid;
            }

            //왼쪽, 오른쪽 판단 => start, end를 옮기면서 꺾이지 않은 선으로 진입하면 계산은 간단해짐 -> 이진 탐색

            int startVal = nums[start];
            int endVal = nums[end];

            if (isLeftLine(startVal, midVal)) {
                if (startVal <= target && target < midVal) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (midVal < target && target <= endVal) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    private boolean isLeftLine(final int startVal, final int midVal) {
        return startVal < midVal;
    }
}

