package CodingTest.Programmers;

import java.util.Arrays;
import java.util.Comparator;

enum ExtractString {
    CODE("코드 번호", 0),
    DATE("제조일", 1),
    MAXIMUM("최대 수량", 2),
    REMAIN("현재 수량", 3);


    private final String description;
    private final int index;

    ExtractString(final String description, final int index) {
        this.description = description;
        this.index = index;
    }

    public static int getMatchingIdx(final String targetString) {
        return valueOf(targetString.toUpperCase()).index;
    }
}

class Solution {
    public int[][] solution(final int[][] data, final String ext, final int val_ext, final String sort_by) {
        final int matchingIdx = ExtractString.getMatchingIdx(sort_by);

        return Arrays.stream(data)
                .filter(eachData -> eachData[ExtractString.getMatchingIdx(ext)] < val_ext)
                .sorted(Comparator.comparingInt(o -> o[matchingIdx]))
                .toArray(int[][]::new);
    }
}
