package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.numberOfWays("SSPPSPS") == 3);
        System.out.println(solution.numberOfWays("PPSPSP") == 1);
        System.out.println(solution.numberOfWays("S") == 0);
        System.out.println(solution.numberOfWays("P") == 0);
        System.out.println(solution.numberOfWays("SPPSSSSPPS") == 1);
    }
}

class Solution {
    private final int MOD = 1_000_000_000 + 7;

    public int numberOfWays(final String corridor) {
        final List<Integer> seatIndexes = new ArrayList<>();

        final char[] charArray = corridor.toCharArray();
        final int corridorLength = charArray.length;
        for (int index = 0; index < corridorLength; index++) {
            final char ch = charArray[index];
            if (ch == 'S') {
                seatIndexes.add(index);
            }
        }

        final int seatTotalCount = seatIndexes.size();
        //0 혹은 홀수면 못 나누므로, 0
        if (seatTotalCount == 0 || seatTotalCount % 2 == 1) {
            return 0;
        }

        //앉는 자리가 2개면, 1
        if (seatTotalCount == 2) {
            return 1;
        }


        long divideCount = 1;
        int multiplesOf3Index = 2;

        while (multiplesOf3Index < seatTotalCount) {
            final int seatIndex = seatIndexes.get(multiplesOf3Index);
            final int preSeatIndex = seatIndexes.get(multiplesOf3Index - 1);

            divideCount = (divideCount * (seatIndex - preSeatIndex)) % MOD;

            multiplesOf3Index += 2;
        }

        return (int) divideCount;
    }
}
