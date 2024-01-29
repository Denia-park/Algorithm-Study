package CodingTest.Programmers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer, int[]> coordiMap;
    private String myHand;

    public String solution(final int[] numbers, final String hand) {
        final StringBuilder sb = new StringBuilder();
        myHand = hand;
        coordiMap = new HashMap<>();
        init(coordiMap);

        final List<Integer> leftNums = List.of(1, 4, 7);
        final List<Integer> middleNums = List.of(2, 5, 8, 0);
        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};

        for (final int number : numbers) {
            if (middleNums.contains(number)) {
                final String value = check(number, left, right);
                if (value.equals("L")) {
                    left = coordiMap.get(number);
                } else {
                    right = coordiMap.get(number);
                }
                sb.append(value);
            } else if (leftNums.contains(number)) {
                sb.append("L");
                left = coordiMap.get(number);
            } else {
                sb.append("R");
                right = coordiMap.get(number);
            }
        }

        return sb.toString();
    }

    private void init(final Map<Integer, int[]> coordiMap) {
        coordiMap.put(1, new int[]{0, 0});
        coordiMap.put(2, new int[]{0, 1});
        coordiMap.put(3, new int[]{0, 2});
        coordiMap.put(4, new int[]{1, 0});
        coordiMap.put(5, new int[]{1, 1});
        coordiMap.put(6, new int[]{1, 2});
        coordiMap.put(7, new int[]{2, 0});
        coordiMap.put(8, new int[]{2, 1});
        coordiMap.put(9, new int[]{2, 2});
        coordiMap.put(0, new int[]{3, 1});
    }

    private String check(final int number, final int[] left, final int[] right) {
        final int[] numberCoordi = coordiMap.get(number);

        final int leftDistance = Math.abs(numberCoordi[0] - left[0]) + Math.abs(numberCoordi[1] - left[1]);
        final int rightDistance = Math.abs(numberCoordi[0] - right[0]) + Math.abs(numberCoordi[1] - right[1]);

        //왼쪽이 가까우면 왼손
        if (leftDistance < rightDistance) {
            return "L";
        }

        //오른손이 가까우면 오른손
        if (leftDistance > rightDistance) {
            return "R";
        }

        //같으면 myHand
        return myHand.substring(0, 1).toUpperCase();
    }
}
