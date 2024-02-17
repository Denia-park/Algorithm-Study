package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(
                solution.furthestBuilding(
                        new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1
                )
        );
        System.out.println(
                solution.furthestBuilding(
                        new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2
                )
        );
        System.out.println(
                solution.furthestBuilding(
                        new int[]{14, 3, 19, 3}, 17, 0
                )
        );
    }
}

//벽돌 및 사다리 중에 어떤게 더 옳은 선택인지 모르니까, 둘 다 도전해봐야 한다.
class Solution {
    int[] gHeights;
    Integer[][][] dp;

    public int furthestBuilding(final int[] heights, final int bricks, final int ladders) {
        dp = new Integer[heights.length][bricks + 1][ladders + 1];
        gHeights = heights;
        final int curIdx = 0;
        int answer = -1;

        answer = Math.max(answer, go(curIdx, bricks, ladders));

        return answer;
    }

    private int go(final int curIdx, final int bricks, final int ladders) {
        int result = curIdx;
        final int nextIdx = curIdx + 1;

        if (nextIdx >= gHeights.length) {
            return result;
        }

        if (dp[curIdx][bricks][ladders] != null) {
            return dp[curIdx][bricks][ladders];
        }

        final int curHeight = gHeights[curIdx];
        final int nextHeight = gHeights[nextIdx];

        if (curHeight >= nextHeight) {
            result = Math.max(result, go(nextIdx, bricks, ladders));
        } else {
            //벽돌 쓴 경우 (가능한 경우에만 사용 가능)
            final int diffHeight = nextHeight - curHeight;
            if (diffHeight <= bricks) {
                result = Math.max(result, go(nextIdx, bricks - diffHeight, ladders));
            }

            //사다리 쓴 경우 (가능한 경우에만 사용 가능)
            if (ladders > 0) {
                result = Math.max(result, go(nextIdx, bricks, ladders - 1));
            }
        }

        //마지막 Idx를 반환한다.
        dp[curIdx][bricks][ladders] = result;
        return result;
    }
}
