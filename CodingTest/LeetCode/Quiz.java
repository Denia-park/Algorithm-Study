package CodingTest.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();
        System.out.println(solution.numberOfWays("SSPPSPS"));
        System.out.println(solution.numberOfWays("PPSPSP"));
        System.out.println(solution.numberOfWays("S"));
    }
}

class Solution {
    private final int MOD = 1_000_000_000 + 7;

    public int numberOfWays(final String corridor) {
        long divideCount = 0;

        final List<Integer> seatIndexes = new ArrayList<>();

        for (int index = 0; index < corridor.toCharArray().length; index++) {
            final char ch = corridor.charAt(index);
            if (ch == 'S') {
                seatIndexes.add(index);
            }
        }

        final int seatTotalCount = seatIndexes.size();
        //홀수면 못 나누므로, 0
        if (seatTotalCount == 0 || seatTotalCount % 2 == 1) {
            return 0;
        }

        //앉는 자리가 2개 이하면, 1
        if (seatTotalCount == 2) {
            return 1;
        }

        int multiplesOf3Index = 2;

        divideCount = 1;
        while (multiplesOf3Index < seatTotalCount) {
            final int seatIndex = seatIndexes.get(multiplesOf3Index);
            final int preSeatIndex = seatIndexes.get(multiplesOf3Index - 1);

            divideCount = ((divideCount % MOD) * ((seatIndex - preSeatIndex) % MOD)) % MOD;

            multiplesOf3Index += 3;
        }

        return (int) (divideCount % MOD);
    }
}
