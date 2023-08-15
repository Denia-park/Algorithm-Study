package CodingTest.Programmers;

/*

아이디어
- 내 왼쪽, 오른쪽 모두에 나보다 작은 숫자가 있으면 개는 불가능

시간복잡도
- n번 돌면서
- 왼쪽 정렬, 오른쪽 정렬 후 나보다 작은 애가 있는지 탐색

자료구조

 */

import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        //3개보다 작으면 무조건 가능함
        if (nums.length < 3) {
            return nums.length;
        }

        //3개 이상이면 비교를 해줘야함
        int answer = 2;

        //맨 왼쪽과 , 오른쪽은 무조건 가능하다.
        for (int i = 1; i < nums.length - 1; i++) {
            int smallNumCount = 0;
            int standardNum = nums[i];

            final int[] left = Arrays.copyOfRange(nums, 0, i);
            Arrays.sort(left);
            //왼쪽 체크
            int start = 0;
            int end = left.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (left[mid] < standardNum) {
                    smallNumCount++;
                    break;
                } else {
                    end = mid - 1;
                }
            }

            final int[] right = Arrays.copyOfRange(nums, i + 1, nums.length);
            Arrays.sort(right);
            //오른쪽 체크
            start = 0;
            end = right.length - 1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (right[mid] < standardNum) {
                    smallNumCount++;
                    break;
                } else {
                    end = mid - 1;
                }
            }

            if (smallNumCount < 2) {
                answer++;
            }
        }

        return answer;
    }
}
