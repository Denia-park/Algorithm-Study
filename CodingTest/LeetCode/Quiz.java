package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
    }
}

//1. 모든 쓰레기들을 줍는데 걸리는 시간은 garbage 문자열 배열의 모든 문자열 길이의 합과 같다.
//2. 각 트럭은 본인 종류의 쓰레기가 위치하는 마지막 장소만 알면 트럭의 이동시간을 계산할 수 있다.
class Solution {
    private static final int METAL = 0, PAPER = 1, GARBAGE = 2;
    private final int[] lastIndex = new int[3];

    public int garbageCollection(final String[] garbage, final int[] travel) {
        int result = 0;

        //모든 쓰레기를 줍는데 걸리는 시간을 구한다.
        int homeIdx = 0;
        for (final String str : garbage) {
            result += str.length();

            //해당 하는 쓰레기를 처리하러 트럭이 어느집 까지 가야하는지 파악한다.
            for (int charIdx = 0; charIdx < str.length(); charIdx++) {
                final char curChar = str.charAt(charIdx);

                if (curChar == 'M') {
                    lastIndex[METAL] = homeIdx;
                } else if (curChar == 'P') {
                    lastIndex[PAPER] = homeIdx;
                } else if (curChar == 'G') {
                    lastIndex[GARBAGE] = homeIdx;
                }
            }

            homeIdx++;
        }

        //거리 값을 계산하기 쉽게 변경한다.
        //거리를 집끼리의 간견이 아니라 해당 하는 집까지 가는데 걸리는 총 시간으로 바꾼다.
        for (int i = 1; i < travel.length; i++) {
            travel[i] = travel[i] + travel[i - 1];
        }

        for (final int index : lastIndex) {
            if (index == 0) {
                continue;
            }

            result += travel[index - 1];
        }

        return result;
    }
}
