package CodingTest.LeetCode;

public class Quiz {
    public static void main(final String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
    }
}

//순서대로
//모든 집을 들를 필요는 없다.
//한번에 하나의 트럭만 이동이 가능하다.
class Solution {
    private final String[] garbageType = new String[]{"M", "P", "G"};
    private int[] gTravel;
    private String[] gGarbage;

    public int garbageCollection(final String[] garbage, final int[] travel) {
        gTravel = travel;
        gGarbage = garbage;
        int result = 0;

        //쓰레기 종류 별로 차가 순회한다.
        for (final String curType : garbageType) {
            result += collectGarbage(curType);
        }

        return result;
    }

    private int collectGarbage(final String curType) {
        int result = 0;

        int tempDistance = 0;

        for (int homeIdx = 0; homeIdx < gGarbage.length; homeIdx++) {
            final String curHome = gGarbage[homeIdx];
            int garbageCount = 0;

            int index = curHome.indexOf(curType);
            while (index != -1) {
                garbageCount++;
                index = curHome.indexOf(curType, index + 1);
            }

            if (garbageCount > 0) {
                //거리 더하기.
                result += tempDistance;
                tempDistance = 0;
            }

            result += garbageCount;

            if (homeIdx < gGarbage.length - 1) {
                //거리 더해주기 - 쓰레기가 존재하는지 안하는지 모르므로 일단 저장만 해둔다.
                tempDistance += gTravel[homeIdx];
            }
        }

        return result;
    }
}
