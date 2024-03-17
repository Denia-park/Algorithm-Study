package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }
}

class Solution {
    public int minEatingSpeed(final int[] piles, final int h) {
        //먹을 수 있는 값 중에 제일 작은 값이니까, 맥스로 값을 설정한다.
        int answer = Integer.MAX_VALUE;

        int left = 1;
        int right = 1_000_000_000;

        //max값을 최대 바나나 개수로 두고, 이진 탐색을 통해 개수를 바꿔가면서
        //다 먹을 수 있는 개수를 찾는다.
        while (left <= right) {
            final int mid = left + ((right - left) / 2);

            if (isAble(piles, h, mid)) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean isAble(final int[] piles, final int h, final int mid) {
        long tempHour = 0L;

        for (final int pile : piles) {
            final int divideHour = pile / mid;

            if (pile % mid == 0) {
                tempHour += divideHour;
            } else {
                tempHour += (divideHour + 1);
            }
        }

        return tempHour <= h;
    }
}
