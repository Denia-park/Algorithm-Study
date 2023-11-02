package CodingTest.LeetCode;

public class Quiz {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        //좌우에 포인터를 두고 줄여가면서 값을 계산한다.
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            //물을 담을 수 있는 최대 높이 계산 (두개의 벽중에 높이가 낮은 벽 선택)
            int curHeight = Math.min(height[start], height[end]);
            //두개의 인덱스 차이가 너비
            int curWidth = end - start;
            
            max = Math.max(max, curHeight * curWidth);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }
}
